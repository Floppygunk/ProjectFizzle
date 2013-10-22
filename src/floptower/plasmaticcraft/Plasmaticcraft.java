package floptower.plasmaticcraft;

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
import floptower.plasmaticcraft.blocks.*;
import floptower.plasmaticcraft.generators.WorldGenMineable;
import floptower.plasmaticcraft.items.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

@Mod(modid = "floptower/plasmaticcraft", name = "PlasmaticCraft", version = "0.0.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Plasmaticcraft {


	public static final Block oreUranium = new BlockUraniumOre(1200, Material.rock);
	public static final Block oreCopper = new BlockCopperOre(1201, Material.rock);
	public static final Block oreBauxite = new BlockBauxiteOre(1202, Material.rock);
	public static final Block blockUranium = new BlockUraniumBlock(1203, Material.rock);
	public static final Block blockCopper = new BlockCopperBlock(1204, Material.rock);
	
	public static final Item ingotUranium = new ItemIngotUranium(12200);
	public static final Item ingotCopper = new ItemIngotCopper(12201);
	
	@Instance("PlasmaticCraft")
	public static Plasmaticcraft instance;

	@SidedProxy(clientSide = "floptower.plasmaticcraft.client.ClientProxy", serverSide = "floptower.fizzlecraft.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		GameRegistry.registerBlock(oreUranium, "oreUranium");
		GameRegistry.registerBlock(blockUranium, "blockUranium");
		GameRegistry.registerBlock(blockCopper, "blockCopper");
		GameRegistry.registerBlock(oreCopper, "oreCopper");
		GameRegistry.registerBlock(oreBauxite, "oreBauxite");
		
		LanguageRegistry.addName(oreUranium, "Uranium Ore");
		LanguageRegistry.addName(ingotUranium, "Uranium Ingot");
		LanguageRegistry.addName(blockUranium, "Block of Uranium");
		LanguageRegistry.addName(ingotCopper, "Copper Ingot");
		LanguageRegistry.addName(blockCopper, "Block of Copper");
		LanguageRegistry.addName(oreCopper, "Copper Ore");
		LanguageRegistry.addName(oreBauxite, "Bauxite Ore");

		MinecraftForge.setBlockHarvestLevel(oreUranium, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(blockUranium, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(blockCopper, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreCopper, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreBauxite, "pickaxe", 1);
		
		GameRegistry.addSmelting(oreUranium.blockID, new ItemStack(ingotUranium), 0.6f);
		GameRegistry.addSmelting(oreCopper.blockID, new ItemStack(ingotCopper), 0.4f);
		GameRegistry.registerWorldGenerator(new WorldGenMineable());

		GameRegistry.addRecipe(new ItemStack(blockUranium),"ooo","ooo","ooo",'o',new ItemStack(ingotUranium));
		GameRegistry.addRecipe(new ItemStack(blockCopper),"ooo","ooo","ooo",'o',new ItemStack(ingotCopper));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ingotUranium, 9), new ItemStack(blockUranium));
		GameRegistry.addShapelessRecipe(new ItemStack(ingotCopper, 9), new ItemStack(blockCopper));
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

}