package floptower.fizzlecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockUraniumBlock extends Block {

	public BlockUraniumBlock(int id, Material material) {
		super(id, material);
		
		setHardness(3.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("blockUranium");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("fizzlecraft:uranium_block");
	}

}