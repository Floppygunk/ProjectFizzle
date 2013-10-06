package floptower.fizzlecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMagnesiumBlock extends Block {

	public BlockMagnesiumBlock(int id, Material material) {
		super(id, material);
		
		setHardness(3.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("blockMagnesium");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("fizzlecraft:magnesium_block");
	}

}