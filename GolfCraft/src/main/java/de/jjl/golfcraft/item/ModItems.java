package de.jjl.golfcraft.item;

import java.util.function.Supplier;

import de.jjl.golfcraft.GolfCraft;
import de.jjl.golfcraft.block.BlockItemBase;
import de.jjl.golfcraft.block.BlockNames;
import de.jjl.golfcraft.block.ModBlocks;
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
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems extends DeferredRegister<Item>
{
	public static final ModItems INSTANCE = new ModItems();
	
	private ModItems()
	{
		super(ForgeRegistries.ITEMS, GolfCraft.MOD_ID);
	}

	public static void init()
	{
		INSTANCE.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	public static RegistryObject<Item> blockItem(String blockId, Supplier<Item> block)
	{
		return INSTANCE.register(blockId, block);
	}
	
	public static final RegistryObject<Item> GREEN_BLOCK_ITEM = blockItem(BlockNames.GREEN_BLOCK, () -> new BlockItemBase(ModBlocks.GREEN_BLOCK.get()));
	public static final RegistryObject<Item> HOLE_BLOCK_ITEM = blockItem(BlockNames.HOLE_BLOCK,  () -> new BlockItemBase(ModBlocks.HOLE_BLOCK.get()));
	public static final RegistryObject<Item> FAIRWAY_BLOCK_ITEM = blockItem(BlockNames.FAIRWAY_BLOCK, () -> new BlockItemBase(ModBlocks.FAIRWAY_BLOCK.get()));
	public static final RegistryObject<Item> HAZARD_ITEM = blockItem(BlockNames.HAZARD, () -> new BlockItemBase(ModBlocks.HAZARD.get()));
	public static final RegistryObject<Item> LATERAL_HAZARD_ITEM = blockItem(BlockNames.LATERAL_HAZARD, () -> new BlockItemBase(ModBlocks.LATERAL_HAZARD.get()));
	public static final RegistryObject<Item> OUT_OF_BOUNDS_ITEM = blockItem(BlockNames.OUT_OF_BOUNDS, () -> new BlockItemBase(ModBlocks.OUT_OF_BOUNDS.get()));
	public static final RegistryObject<Item> FIFTY_MARKER_ITEM = blockItem(BlockNames.FIFTY_MARKER, () -> new BlockItemBase(ModBlocks.FIFTY_MARKER.get()));
	public static final RegistryObject<Item> ONE_HUNDRED_MARKER_ITEM = blockItem(BlockNames.ONE_HUNDRED_MARKER, () -> new BlockItemBase(ModBlocks.ONE_HUNDRED_MARKER.get()));
	
	public static final RegistryObject<Item> DRIVER = INSTANCE.register(ItemNames.DRIVER, Driver::new);
	public static final RegistryObject<Item> THREE_WOOD = INSTANCE.register(ItemNames.THREE_WOOD, ThreeWood::new);
	public static final RegistryObject<Item> FOUR_WOOD = INSTANCE.register(ItemNames.FOUR_WOOD, FourWood::new);
	public static final RegistryObject<Item> FIVE_WOOD = INSTANCE.register(ItemNames.FIVE_WOOD, FiveWood::new);
	public static final RegistryObject<Item> TWO_IRON = INSTANCE.register(ItemNames.TWO_IRON, TwoIron::new);
	public static final RegistryObject<Item> THREE_IRON = INSTANCE.register(ItemNames.THREE_IRON, ThreeIron::new);
	public static final RegistryObject<Item> FOUR_IRON = INSTANCE.register(ItemNames.FOUR_IRON, FourIron::new);
	public static final RegistryObject<Item> FIVE_IRON = INSTANCE.register(ItemNames.FIVE_IRON, FiveIron::new);
	public static final RegistryObject<Item> SIX_IRON = INSTANCE.register(ItemNames.SIX_IRON, SixIron::new);
	public static final RegistryObject<Item> SEVEN_IRON = INSTANCE.register(ItemNames.SEVEN_IRON, SevenIron::new);
	public static final RegistryObject<Item> EIGHT_IRON = INSTANCE.register(ItemNames.EIGHT_IRON, EightIron::new);
	public static final RegistryObject<Item> NINE_IRON = INSTANCE.register(ItemNames.NINE_IRON, NineIron::new);
	public static final RegistryObject<Item> PITCHING_WEDGE = INSTANCE.register(ItemNames.PITCHING_WEDGE, PitchingWedge::new);
	public static final RegistryObject<Item> GAP_WEDGE = INSTANCE.register(ItemNames.GAP_WEDGE, GapWedge::new);
	public static final RegistryObject<Item> SAND_WEDGE = INSTANCE.register(ItemNames.SAND_WEDGE, SandWedge::new);
	public static final RegistryObject<Item> LOB_WEDGE = INSTANCE.register(ItemNames.LOB_WEDGE, LobWedge::new);
	public static final RegistryObject<Item> PUTTER = INSTANCE.register(ItemNames.PUTTER, Putter::new);
	
	public static final RegistryObject<Item> GOLFBALL_ITEM = INSTANCE.register(ItemNames.GOLFBALL_ITEM, GolfballItem::new);
	public static final RegistryObject<Item> BALL_MARKER = INSTANCE.register(ItemNames.BALL_MARKER, BallMarker::new);
}
