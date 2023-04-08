package net.mcreator.thepizzatowermod.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.thepizzatowermod.network.ThePizzaTowerModModVariables;

public class PizzaTimeOverlayDisplayProcedure {
	public static boolean execute(LevelAccessor world) {
		if (ThePizzaTowerModModVariables.MapVariables.get(world).IsPizzaTime == true) {
			return true;
		}
		return false;
	}
}
