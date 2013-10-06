package floptower.fizzlecraft.blocks;

import java.util.Random;

import floptower.fizzlecraft.Fizzlecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockZirconiaOre extends Block {

	public BlockZirconiaOre(int id, Material material) {
		super(id, material);

		setHardness(2.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("oreZirconia");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName("floptower.fizzlecraft:zirconia_ore");
	}

	public int idDropped(int par1, Random random, int zero) {
		return Fizzlecraft.gemZirconia.itemID;
	}
	
	public int quantityDropped(Random random) {
		return random.nextInt(3)+1;
	}

}