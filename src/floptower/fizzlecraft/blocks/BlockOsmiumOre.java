package floptower.fizzlecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOsmiumOre extends Block {

	public BlockOsmiumOre(int id, Material material) {
		super(id, material);
		
		setHardness(2.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("oreOsmium");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("fizzlecraft:osmium_ore");
		
	}

}