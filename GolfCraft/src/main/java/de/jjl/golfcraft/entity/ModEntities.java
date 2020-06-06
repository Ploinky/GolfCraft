package de.jjl.golfcraft.entity;

import de.jjl.golfcraft.GolfCraft;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities extends DeferredRegister<EntityType<?>>
{
	public static final ModEntities INSTANCE = new ModEntities();

	private ModEntities()
	{
		super(ForgeRegistries.ENTITIES, GolfCraft.MOD_ID);
	}
	
	public static void init()
	{
		INSTANCE.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static final RegistryObject<EntityType<Golfball>> GOLFBALL = INSTANCE.register(EntityNames.GOLFBALL,
			() -> EntityType.Builder.<Golfball>create(Golfball::new, EntityClassification.CREATURE)
			.size(0.3f, 0.3f)
			.build(new ResourceLocation(GolfCraft.MOD_ID, EntityNames.GOLFBALL).toString()));
	
	public static final RegistryObject<EntityType<GolfballSpawnEgg>> GOLFBALL_EGG = INSTANCE.register(
			EntityNames.GOLFBALL_SPAWN_ENTITY,
			() -> EntityType.Builder.<GolfballSpawnEgg>create(GolfballSpawnEgg::new, EntityClassification.MISC)
			.size(0.25F, 0.25F)
			.build(new ResourceLocation(GolfCraft.MOD_ID, EntityNames.GOLFBALL_SPAWN_ENTITY).toString()));

}
