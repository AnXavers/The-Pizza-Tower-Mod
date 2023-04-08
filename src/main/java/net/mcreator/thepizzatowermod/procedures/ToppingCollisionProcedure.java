package net.mcreator.thepizzatowermod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thepizzatowermod.network.ThePizzaTowerModModVariables;

public class ToppingCollisionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			world.destroyBlock(new BlockPos(x, y, z), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_pizza_tower_mod:topping_collect")), SoundSource.PLAYERS, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_pizza_tower_mod:topping_collect")), SoundSource.PLAYERS, (float) 0.5, 1, false);
				}
			}
			{
				double _setval = (entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ThePizzaTowerModModVariables.PlayerVariables())).Score + 10;
				entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Score = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ThePizzaTowerModModVariables.PlayerVariables())).TotalScore + 10;
				entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TotalScore = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
