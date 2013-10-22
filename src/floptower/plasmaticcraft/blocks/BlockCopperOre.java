package floptower.plasmaticcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCopperOre extends Block {

	public BlockCopperOre(int id, Material material) {
		super(id, material);
		
		setHardness(2.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("oreCopper");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("plasmaticraft:copper_ore");
	}

}