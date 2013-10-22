package floptower.plasmaticcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBauxiteOre extends Block {

	public BlockBauxiteOre(int id, Material material) {
		super(id, material);
		
		setHardness(2.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("oreBauxite");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("plasmaticraft:bauxite_ore");
	}

}