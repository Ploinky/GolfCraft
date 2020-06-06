package de.jjl.golfcraft;

import de.jjl.golfcraft.block.ModBlocks;
import de.jjl.golfcraft.entity.ModEntities;
import de.jjl.golfcraft.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("golfcraft")
@Mod.EventBusSubscriber(modid = GolfCraft.MOD_ID, bus = Bus.MOD)
public class GolfCraft
{
//	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "golfcraft";
	public static final String MOD_NAME = "GolfCraft";

	public GolfCraft()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		
		ModEntities.init();
		ModBlocks.init();
		ModItems.init();

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event)
	{
	}

	private void doClientStuff(final FMLClientSetupEvent event)
	{
	}
	
	public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID)
	{
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(ModItems.SEVEN_IRON.get());
		}
	};
}
