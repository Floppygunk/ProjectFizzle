package floptower.fizzlecraft;

import floptower.fizzlecraft.generators.WorldGenMercury;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import floptower.fizzlecraft.blocks.BlockMagnesiumOre;
import floptower.fizzlecraft.blocks.BlockMercuryFlowing;
import floptower.fizzlecraft.blocks.BlockMercuryStill;
import floptower.fizzlecraft.blocks.BlockOsmiumOre;
import floptower.fizzlecraft.blocks.BlockUraniumOre;
import floptower.fizzlecraft.blocks.BlockZirconiaOre;
import floptower.fizzlecraft.generators.WorldGenMineable;
import floptower.fizzlecraft.items.ItemGemZirconia;
import floptower.fizzlecraft.items.ItemIngotMagnesium;
import floptower.fizzlecraft.items.ItemIngotOsmium;
import floptower.fizzlecraft.items.ItemIngotUranium;

@Mod(modid = "floptower/fizzlecraft", name = "FizzleCraft", version = "0.0.1a")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Fizzlecraft {
	
	// Magnesium: Thermal properties
	public static final Block oreMagnesium = new BlockMagnesiumOre(1200, Material.rock);
	// Osmium: Shielding properies, heavy, extremely rare
	public static final Block oreOsmium = new BlockOsmiumOre(1201, Material.rock);
	// Uranium: Radioactive properties
	public static final Block oreUranium = new BlockUraniumOre(1202, Material.rock);
	// Zirconia: Optical properties, hardness is between iron and diamond
	public static final Block oreZirconia = new BlockZirconiaOre(1203, Material.rock);
	
	public static final Block mercuryStill = new BlockMercuryStill(1205, Material.water);
	public static final Block mercuryFlowing = new BlockMercuryFlowing(1204, Material.water);
	
	public static final Item ingotMagnesium = new ItemIngotMagnesium(12200);
	public static final Item ingotUranium = new ItemIngotUranium(12201);
	public static final Item ingotOsmium = new ItemIngotOsmium(12202);
	public static final Item gemZirconia = new ItemGemZirconia(12203);
	
	
	@Instance("FizzleCraft")
	public static Fizzlecraft instance;

	@SidedProxy(clientSide = "floptower.fizzlecraft.client.ClientProxy", serverSide = "floptower.fizzlecraft.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		
		//Herlllllo
		GameRegistry.registerBlock(oreMagnesium, "oreMagnesium");
		GameRegistry.registerBlock(oreOsmium, "oreOsmiridium");
		GameRegistry.registerBlock(oreUranium, "oreUranium");
		GameRegistry.registerBlock(oreZirconia, "oreZirconia");
		GameRegistry.registerBlock(mercuryStill, "mercuryStill");
		GameRegistry.registerBlock(mercuryFlowing, "mercuryFlowing");
		
		LanguageRegistry.addName(oreMagnesium, "Magnesium Ore");
		LanguageRegistry.addName(oreOsmium, "Osmiridium Ore");
		LanguageRegistry.addName(oreUranium, "Uranium Ore");
		LanguageRegistry.addName(oreZirconia, "Zirconia Ore");
		LanguageRegistry.addName(mercuryFlowing, "Mercury");
		LanguageRegistry.addName(ingotMagnesium, "Magnesium Ingot");
		LanguageRegistry.addName(ingotOsmium, "Osmium Ingot");
		LanguageRegistry.addName(ingotUranium, "Uranium Ingot");
		LanguageRegistry.addName(gemZirconia, "Zirconia");
		
		MinecraftForge.setBlockHarvestLevel(oreMagnesium, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreOsmium, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(oreUranium, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreZirconia, "pickaxe", 2);
		
		GameRegistry.addSmelting(oreMagnesium.blockID, new ItemStack(ingotMagnesium), 0.4f);
		GameRegistry.addSmelting(oreUranium.blockID, new ItemStack(ingotUranium), 0.6f);
		GameRegistry.addSmelting(oreOsmium.blockID, new ItemStack(ingotOsmium), 0.8f);
		GameRegistry.addSmelting(oreZirconia.blockID, new ItemStack(gemZirconia, 3), 0.8f);
		
		GameRegistry.registerWorldGenerator(new WorldGenMineable());
        GameRegistry.registerWorldGenerator(new WorldGenMercury());

		
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

}