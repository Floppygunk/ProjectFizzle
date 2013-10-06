package floptower.fizzlecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCopperBlock extends Block {

	public BlockCopperBlock(int id, Material material) {
		super(id, material);
		
		setHardness(3.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("blockCopper");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("fizzlecraft:copper_block");
	}

}