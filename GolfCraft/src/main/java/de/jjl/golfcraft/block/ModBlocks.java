package de.jjl.golfcraft.block;

import de.jjl.golfcraft.GolfCraft;
import de.jjl.golfcraft.block.marker.FiftyMarker;
import de.jjl.golfcraft.block.marker.Hazard;
import de.jjl.golfcraft.block.marker.LateralHazard;
import de.jjl.golfcraft.block.marker.OneHundredMarker;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks
{
	public static final DeferredRegister<Block> INSTANCE = DeferredRegister.create(ForgeRegistries.BLOCKS, GolfCraft.MOD_ID);;
	
	
	private ModBlocks()
	{
	}

	public static void init()
	{
		INSTANCE.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	public static final RegistryObject<Block> GREEN_BLOCK = INSTANCE.register(BlockNames.GREEN_BLOCK, GreenBlock::new);
	public static final RegistryObject<Block> HOLE_BLOCK = INSTANCE.register(BlockNames.HOLE_BLOCK, HoleBlock::new);
	public static final RegistryObject<Block> FAIRWAY_BLOCK = INSTANCE.register(BlockNames.FAIRWAY_BLOCK, FairwayBlock::new);
	public static final RegistryObject<Block> HAZARD = INSTANCE.register(BlockNames.HAZARD, Hazard::new);
	public static final RegistryObject<Block> LATERAL_HAZARD = INSTANCE.register(BlockNames.LATERAL_HAZARD, LateralHazard::new);
	public static final RegistryObject<Block> OUT_OF_BOUNDS = INSTANCE.register(BlockNames.OUT_OF_BOUNDS, OutOfBounds::new);
	public static final RegistryObject<Block> FIFTY_MARKER = INSTANCE.register(BlockNames.FIFTY_MARKER, FiftyMarker::new);
	public static final RegistryObject<Block> ONE_HUNDRED_MARKER = INSTANCE.register(BlockNames.ONE_HUNDRED_MARKER, OneHundredMarker::new);

}
