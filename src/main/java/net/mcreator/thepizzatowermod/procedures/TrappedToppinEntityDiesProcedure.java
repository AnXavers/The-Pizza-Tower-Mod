package net.mcreator.thepizzatowermod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thepizzatowermod.network.ThePizzaTowerModModVariables;
import net.mcreator.thepizzatowermod.init.ThePizzaTowerModModParticleTypes;
import net.mcreator.thepizzatowermod.init.ThePizzaTowerModModEntities;
import net.mcreator.thepizzatowermod.entity.MushroomToppinEntity;
import net.mcreator.thepizzatowermod.entity.CheeseToppinEntity;

public class TrappedToppinEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		{
			double _setval = (entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ThePizzaTowerModModVariables.PlayerVariables())).Score + 1000;
			entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Score = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ThePizzaTowerModModParticleTypes.TOPPIN_CAGE_BROKEN.get()), x, y, z, 5, 1, 1, 1, 0.1);
		{
			double _setval = Math.random() * 5;
			entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.WhichToppin = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ThePizzaTowerModModVariables.PlayerVariables())).WhichToppin >= 0) {
			if ((entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ThePizzaTowerModModVariables.PlayerVariables())).WhichToppin >= 1) {
				if ((entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ThePizzaTowerModModVariables.PlayerVariables())).WhichToppin >= 2) {
					if ((entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ThePizzaTowerModModVariables.PlayerVariables())).WhichToppin >= 3) {
						if ((entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ThePizzaTowerModModVariables.PlayerVariables())).WhichToppin >= 4) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = new MushroomToppinEntity(ThePizzaTowerModModEntities.MUSHROOM_TOPPIN.get(), _level);
								entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
								if (entityToSpawn instanceof Mob _mobToSpawn)
									_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
								world.addFreshEntity(entityToSpawn);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new CheeseToppinEntity(ThePizzaTowerModModEntities.CHEESE_TOPPIN.get(), _level);
							entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new MushroomToppinEntity(ThePizzaTowerModModEntities.MUSHROOM_TOPPIN.get(), _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				}
			} else {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new CheeseToppinEntity(ThePizzaTowerModModEntities.CHEESE_TOPPIN.get(), _level);
					entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		} else {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new MushroomToppinEntity(ThePizzaTowerModModEntities.MUSHROOM_TOPPIN.get(), _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}
}
