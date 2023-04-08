package net.mcreator.thepizzatowermod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thepizzatowermod.network.ThePizzaTowerModModVariables;

public class ScoreRelayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("#####").format((entity.getCapability(ThePizzaTowerModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ThePizzaTowerModModVariables.PlayerVariables())).Score);
	}
}
