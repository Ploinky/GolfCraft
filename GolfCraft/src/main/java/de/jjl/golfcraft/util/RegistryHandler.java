package de.jjl.golfcraft.util;

import de.jjl.golfcraft.GolfCraft;
import de.jjl.golfcraft.block.BlockItemBase;
import de.jjl.golfcraft.block.BlockNames;
import de.jjl.golfcraft.block.FairwayBlock;
import de.jjl.golfcraft.block.FiftyMarker;
import de.jjl.golfcraft.block.GreenBlock;
import de.jjl.golfcraft.block.Hazard;
import de.jjl.golfcraft.block.HoleBlock;
import de.jjl.golfcraft.block.LateralHazard;
import de.jjl.golfcraft.block.OneHundredMarker;
import de.jjl.golfcraft.block.OutOfBounds;
import de.jjl.golfcraft.entity.EntityNames;
import de.jjl.golfcraft.entity.Golfball;
import de.jjl.golfcraft.entity.GolfballSpawnEgg;
import de.jjl.golfcraft.item.BallMarker;
import de.jjl.golfcraft.item.GolfballItem;
import de.jjl.golfcraft.item.ItemNames;
import de.jjl.golfcraft.item.club.Driver;
import de.jjl.golfcraft.item.club.EightIron;
import de.jjl.golfcraft.item.club.FiveIron;
import de.jjl.golfcraft.item.club.FiveWood;
import de.jjl.golfcraft.item.club.FourIron;
import de.jjl.golfcraft.item.club.FourWood;
import de.jjl.golfcraft.item.club.GapWedge;
import de.jjl.golfcraft.item.club.LobWedge;
import de.jjl.golfcraft.item.club.NineIron;
import de.jjl.golfcraft.item.club.PitchingWedge;
import de.jjl.golfcraft.item.club.Putter;
import de.jjl.golfcraft.item.club.SandWedge;
import de.jjl.golfcraft.item.club.SevenIron;
import de.jjl.golfcraft.item.club.SixIron;
import de.jjl.golfcraft.item.club.ThreeIron;
import de.jjl.golfcraft.item.club.ThreeWood;
import de.jjl.golfcraft.item.club.TwoIron;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler
{
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, GolfCraft.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
			GolfCraft.MOD_ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			GolfCraft.MOD_ID);

	public static void init()
	{
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	// Entities
	public static final RegistryObject<EntityType<Golfball>> GOLFBALL = ENTITY_TYPES.register(EntityNames.GOLFBALL,
			() -> EntityType.Builder.<Golfball>create(Golfball::new, EntityClassification.CREATURE)
			.size(0.3f, 0.3f)
			.build(new ResourceLocation(GolfCraft.MOD_ID, EntityNames.GOLFBALL).toString()));
	
	public static final RegistryObject<EntityType<GolfballSpawnEgg>> GOLFBALL_EGG = ENTITY_TYPES.register(
			EntityNames.GOLFBALL_SPAWN_ENTITY,
			() -> EntityType.Builder.<GolfballSpawnEgg>create(GolfballSpawnEgg::new, EntityClassification.MISC)
			.size(0.25F, 0.25F)
			.build(new ResourceLocation(GolfCraft.MOD_ID, EntityNames.GOLFBALL_SPAWN_ENTITY).toString()));

	// Items
	public static final RegistryObject<Item> DRIVER = ITEMS.register(ItemNames.DRIVER, Driver::new);
	public static final RegistryObject<Item> THREE_WOOD = ITEMS.register(ItemNames.THREE_WOOD, ThreeWood::new);
	public static final RegistryObject<Item> FOUR_WOOD = ITEMS.register(ItemNames.FOUR_WOOD, FourWood::new);
	public static final RegistryObject<Item> FIVE_WOOD = ITEMS.register(ItemNames.FIVE_WOOD, FiveWood::new);
	public static final RegistryObject<Item> TWO_IRON = ITEMS.register(ItemNames.TWO_IRON, TwoIron::new);
	public static final RegistryObject<Item> THREE_IRON = ITEMS.register(ItemNames.THREE_IRON, ThreeIron::new);
	public static final RegistryObject<Item> FOUR_IRON = ITEMS.register(ItemNames.FOUR_IRON, FourIron::new);
	public static final RegistryObject<Item> FIVE_IRON = ITEMS.register(ItemNames.FIVE_IRON, FiveIron::new);
	public static final RegistryObject<Item> SIX_IRON = ITEMS.register(ItemNames.SIX_IRON, SixIron::new);
	public static final RegistryObject<Item> SEVEN_IRON = ITEMS.register(ItemNames.SEVEN_IRON, SevenIron::new);
	public static final RegistryObject<Item> EIGHT_IRON = ITEMS.register(ItemNames.EIGHT_IRON, EightIron::new);
	public static final RegistryObject<Item> NINE_IRON = ITEMS.register(ItemNames.NINE_IRON, NineIron::new);
	public static final RegistryObject<Item> PITCHING_WEDGE = ITEMS.register(ItemNames.PITCHING_WEDGE,
			PitchingWedge::new);
	public static final RegistryObject<Item> GAP_WEDGE = ITEMS.register(ItemNames.GAP_WEDGE, GapWedge::new);
	public static final RegistryObject<Item> SAND_WEDGE = ITEMS.register(ItemNames.SAND_WEDGE, SandWedge::new);
	public static final RegistryObject<Item> LOB_WEDGE = ITEMS.register(ItemNames.LOB_WEDGE, LobWedge::new);
	public static final RegistryObject<Item> PUTTER = ITEMS.register(ItemNames.PUTTER, Putter::new);
	
	public static final RegistryObject<Item> GOLFBALL_ITEM = ITEMS.register(ItemNames.GOLFBALL_ITEM, GolfballItem::new);
	public static final RegistryObject<Item> BALL_MARKER = ITEMS.register(ItemNames.BALL_MARKER, BallMarker::new);

	// Blocks
	public static final RegistryObject<Block> GREEN_BLOCK = BLOCKS.register(BlockNames.GREEN_BLOCK, GreenBlock::new);
	public static final RegistryObject<Block> HOLE_BLOCK = BLOCKS.register(BlockNames.HOLE_BLOCK, HoleBlock::new);
	public static final RegistryObject<Block> FAIRWAY_BLOCK = BLOCKS.register(BlockNames.FAIRWAY_BLOCK, FairwayBlock::new);
	public static final RegistryObject<Block> HAZARD = BLOCKS.register(BlockNames.HAZARD, Hazard::new);
	public static final RegistryObject<Block> LATERAL_HAZARD = BLOCKS.register(BlockNames.LATERAL_HAZARD, LateralHazard::new);
	public static final RegistryObject<Block> OUT_OF_BOUNDS = BLOCKS.register(BlockNames.OUT_OF_BOUNDS, OutOfBounds::new);
	public static final RegistryObject<Block> FIFTY_MARKER = BLOCKS.register(BlockNames.FIFTY_MARKER, FiftyMarker::new);
	public static final RegistryObject<Block> ONE_HUNDRED_MARKER = BLOCKS.register(BlockNames.ONE_HUNDRED_MARKER, OneHundredMarker::new);

	// Block Items
	public static final RegistryObject<Item> GREEN_BLOCK_ITEM = ITEMS.register(BlockNames.GREEN_BLOCK,
			() -> new BlockItemBase(GREEN_BLOCK.get()));
	public static final RegistryObject<Item> HOLE_BLOCK_ITEM = ITEMS.register(BlockNames.HOLE_BLOCK,
			() -> new BlockItemBase(HOLE_BLOCK.get()));
	public static final RegistryObject<Item> FAIRWAY_BLOCK_ITEM = ITEMS.register(BlockNames.FAIRWAY_BLOCK,
			() -> new BlockItemBase(FAIRWAY_BLOCK.get()));
	public static final RegistryObject<Item> HAZARD_ITEM = ITEMS.register(BlockNames.HAZARD,
			() -> new BlockItemBase(HAZARD.get()));
	public static final RegistryObject<Item> LATERAL_HAZARD_ITEM = ITEMS.register(BlockNames.LATERAL_HAZARD,
			() -> new BlockItemBase(LATERAL_HAZARD.get()));
	public static final RegistryObject<Item> OUT_OF_BOUNDS_ITEM = ITEMS.register(BlockNames.OUT_OF_BOUNDS,
			() -> new BlockItemBase(OUT_OF_BOUNDS.get()));
	public static final RegistryObject<Item> FIFTY_MARKER_ITEM = ITEMS.register(BlockNames.FIFTY_MARKER,
			() -> new BlockItemBase(FIFTY_MARKER.get()));
	public static final RegistryObject<Item> ONE_HUNDRED_MARKER_ITEM = ITEMS.register(BlockNames.ONE_HUNDRED_MARKER,
			() -> new BlockItemBase(ONE_HUNDRED_MARKER.get()));

}
