package net.mcreator.thepizzatowermod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Registry;

import net.mcreator.thepizzatowermod.init.ThePizzaTowerModModParticleTypes;
import net.mcreator.thepizzatowermod.entity.MushroomToppinEntity;
import net.mcreator.thepizzatowermod.entity.CheeseToppinEntity;

import java.util.Comparator;

public class ToppinOnSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.addParticle((SimpleParticleType) (ThePizzaTowerModModParticleTypes.TAUNT.get()), x, y, z, 0, 0, 0);
		if (entity instanceof TamableAnimal _toTame && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Player _owner)
			_toTame.tame(_owner);
		if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("the_pizza_tower_mod:cheese_toppin")))) {
			if (entity instanceof CheeseToppinEntity) {
				((CheeseToppinEntity) entity).setAnimation("freed");
			}
		} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("the_pizza_tower_mod:mushroom_toppin")))) {
			if (entity instanceof MushroomToppinEntity) {
				((MushroomToppinEntity) entity).setAnimation("freed");
			}
		}
	}
}
