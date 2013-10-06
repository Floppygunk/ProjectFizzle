package floptower.fizzlecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOsmiumBlock extends Block {

	public BlockOsmiumBlock(int id, Material material) {
		super(id, material);
		
		setHardness(3.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("blockOsmium");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("fizzlecraft:osmium_block");
	}

}