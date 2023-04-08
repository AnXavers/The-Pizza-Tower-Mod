
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thepizzatowermod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.thepizzatowermod.entity.MushroomToppinEntity;
import net.mcreator.thepizzatowermod.entity.JohnPillarEntity;
import net.mcreator.thepizzatowermod.entity.CheeseToppinEntity;
import net.mcreator.thepizzatowermod.ThePizzaTowerModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThePizzaTowerModModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ThePizzaTowerModMod.MODID);
	public static final RegistryObject<EntityType<MushroomToppinEntity>> MUSHROOM_TOPPIN = register("mushroom_toppin", EntityType.Builder.<MushroomToppinEntity>of(MushroomToppinEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MushroomToppinEntity::new).fireImmune().sized(0.5f, 0.9f));
	public static final RegistryObject<EntityType<CheeseToppinEntity>> CHEESE_TOPPIN = register("cheese_toppin", EntityType.Builder.<CheeseToppinEntity>of(CheeseToppinEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CheeseToppinEntity::new).fireImmune().sized(0.5f, 0.9f));
	public static final RegistryObject<EntityType<JohnPillarEntity>> JOHN_PILLAR = register("john_pillar",
			EntityType.Builder.<JohnPillarEntity>of(JohnPillarEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(JohnPillarEntity::new).fireImmune().sized(3f, 5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MushroomToppinEntity.init();
			CheeseToppinEntity.init();
			JohnPillarEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MUSHROOM_TOPPIN.get(), MushroomToppinEntity.createAttributes().build());
		event.put(CHEESE_TOPPIN.get(), CheeseToppinEntity.createAttributes().build());
		event.put(JOHN_PILLAR.get(), JohnPillarEntity.createAttributes().build());
	}
}
