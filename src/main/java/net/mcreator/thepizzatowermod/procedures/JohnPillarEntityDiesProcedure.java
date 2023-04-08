package net.mcreator.thepizzatowermod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thepizzatowermod.network.ThePizzaTowerModModVariables;

public class JohnPillarEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_pizza_tower_mod:pizza_time_global")), SoundSource.MUSIC, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_pizza_tower_mod:pizza_time_global")), SoundSource.MUSIC, 1, 1, false);
			}
		}
		ThePizzaTowerModModVariables.MapVariables.get(world).IsPizzaTime = true;
		ThePizzaTowerModModVariables.MapVariables.get(world).syncData(world);
	}
}
