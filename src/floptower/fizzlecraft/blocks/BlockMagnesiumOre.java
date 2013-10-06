package floptower.fizzlecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMagnesiumOre extends Block {

	public BlockMagnesiumOre(int id, Material material) {
		super(id, material);
		
		setHardness(2.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("oreMagnesium");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("floptower.fizzlecraft:magnesium_ore");
	}

}