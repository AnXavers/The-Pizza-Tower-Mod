package net.mcreator.thepizzatowermod.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.scores.Score;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.thepizzatowermod.ThePizzaTowerModMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThePizzaTowerModModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ThePizzaTowerModMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		ThePizzaTowerModMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.WhichToppin = original.WhichToppin;
			clone.TotalScore = original.TotalScore;
			clone.WhichTaunt = original.WhichTaunt;
			clone.HighestCombo = original.HighestCombo;
			clone.HighestScore = original.HighestScore;
			clone.SecretsTotal = original.SecretsTotal;
			clone.LapNum = original.LapNum;
			if (!event.isWasDeath()) {
				clone.MachLevel = original.MachLevel;
				clone.Score = original.Score;
				clone.Combo = original.Combo;
				clone.WhichSecret = original.WhichSecret;
				clone.Score1 = original.Score1;
				clone.Score2 = original.Score2;
				clone.Score3 = original.Score3;
				clone.Score4 = original.Score4;
				clone.Score5 = original.Score5;
				clone.ScoreRelay = original.ScoreRelay;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					ThePizzaTowerModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					ThePizzaTowerModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					ThePizzaTowerModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "the_pizza_tower_mod_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				ThePizzaTowerModMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "the_pizza_tower_mod_mapvars";
		public boolean IsPizzaTime = false;
		public double PizzaTimeCountdown = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			IsPizzaTime = nbt.getBoolean("IsPizzaTime");
			PizzaTimeCountdown = nbt.getDouble("PizzaTimeCountdown");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("IsPizzaTime", IsPizzaTime);
			nbt.putDouble("PizzaTimeCountdown", PizzaTimeCountdown);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				ThePizzaTowerModMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("the_pizza_tower_mod", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double WhichToppin = 0.0;
		public double MachLevel = 0;
		public double Score = 0;
		public double TotalScore = 0;
		public double WhichTaunt = 0;
		public double Combo = 0;
		public double HighestCombo = 0;
		public double HighestScore = 0;
		public double SecretsTotal = 0;
		public double WhichSecret = 0;
		public double Score1 = 0;
		public double Score2 = 0;
		public double Score3 = 0;
		public double Score4 = 0;
		public double Score5 = 0;
		public double LapNum = 0;
		public String ScoreRelay = "\"\"";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				ThePizzaTowerModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("WhichToppin", WhichToppin);
			nbt.putDouble("MachLevel", MachLevel);
			nbt.putDouble("Score", Score);
			nbt.putDouble("TotalScore", TotalScore);
			nbt.putDouble("WhichTaunt", WhichTaunt);
			nbt.putDouble("Combo", Combo);
			nbt.putDouble("HighestCombo", HighestCombo);
			nbt.putDouble("HighestScore", HighestScore);
			nbt.putDouble("SecretsTotal", SecretsTotal);
			nbt.putDouble("WhichSecret", WhichSecret);
			nbt.putDouble("Score1", Score1);
			nbt.putDouble("Score2", Score2);
			nbt.putDouble("Score3", Score3);
			nbt.putDouble("Score4", Score4);
			nbt.putDouble("Score5", Score5);
			nbt.putDouble("LapNum", LapNum);
			nbt.putString("ScoreRelay", ScoreRelay);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			WhichToppin = nbt.getDouble("WhichToppin");
			MachLevel = nbt.getDouble("MachLevel");
			Score = nbt.getDouble("Score");
			TotalScore = nbt.getDouble("TotalScore");
			WhichTaunt = nbt.getDouble("WhichTaunt");
			Combo = nbt.getDouble("Combo");
			HighestCombo = nbt.getDouble("HighestCombo");
			HighestScore = nbt.getDouble("HighestScore");
			SecretsTotal = nbt.getDouble("SecretsTotal");
			WhichSecret = nbt.getDouble("WhichSecret");
			Score1 = nbt.getDouble("Score1");
			Score2 = nbt.getDouble("Score2");
			Score3 = nbt.getDouble("Score3");
			Score4 = nbt.getDouble("Score4");
			Score5 = nbt.getDouble("Score5");
			LapNum = nbt.getDouble("LapNum");
			ScoreRelay = nbt.getString("ScoreRelay");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.WhichToppin = message.data.WhichToppin;
					variables.MachLevel = message.data.MachLevel;
					variables.Score = message.data.Score;
					variables.TotalScore = message.data.TotalScore;
					variables.WhichTaunt = message.data.WhichTaunt;
					variables.Combo = message.data.Combo;
					variables.HighestCombo = message.data.HighestCombo;
					variables.HighestScore = message.data.HighestScore;
					variables.SecretsTotal = message.data.SecretsTotal;
					variables.WhichSecret = message.data.WhichSecret;
					variables.Score1 = message.data.Score1;
					variables.Score2 = message.data.Score2;
					variables.Score3 = message.data.Score3;
					variables.Score4 = message.data.Score4;
					variables.Score5 = message.data.Score5;
					variables.LapNum = message.data.LapNum;
					variables.ScoreRelay = message.data.ScoreRelay;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
