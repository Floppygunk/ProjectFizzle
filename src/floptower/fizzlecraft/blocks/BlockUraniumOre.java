package floptower.fizzlecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockUraniumOre extends Block {

	public BlockUraniumOre(int id, Material material) {
		super(id, material);
		
		setHardness(2.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("oreUranium");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("fizzlecraft:uranium_ore");
	}

}