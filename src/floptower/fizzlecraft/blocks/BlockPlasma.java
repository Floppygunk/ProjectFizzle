package floptower.fizzlecraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import floptower.fizzlecraft.Fizzlecraft;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockPlasma extends BlockFluidClassic {

	protected Icon[] theIcon;

	public BlockPlasma(int id) {
		super(id, Fizzlecraft.fluidPlasma, Material.water);
		Fizzlecraft.fluidPlasma.setBlockID(id);

		setUnlocalizedName("plasma");
		setCreativeTab(CreativeTabs.tabMisc);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z,
										  Entity entity) {
		entity.motionY += -0.05;
		if (entity instanceof Entity);
		
	
			
		}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.theIcon = new Icon[] {
				iconRegister.registerIcon("fizzlecraft:plasma_still"),
				iconRegister.registerIcon("fizzlecraft:plasma_flowing") };
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return side != 0 && side != 1 ? this.theIcon[1] : this.theIcon[0];
	}
}
