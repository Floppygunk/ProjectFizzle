package floptower.fizzlecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockZirconiaBlock extends Block {

	public BlockZirconiaBlock(int id, Material material) {
		super(id, material);
		
		setHardness(3.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("blockZirconia");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("fizzlecraft:zirconia_block");
	}

}