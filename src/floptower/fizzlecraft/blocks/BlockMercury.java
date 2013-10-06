package floptower.fizzlecraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import floptower.fizzlecraft.Fizzlecraft;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockMercury extends BlockFluidClassic {

	protected Icon[] theIcon;

	public BlockMercury(int id) {
		super(id, Fizzlecraft.fluidMercury, Material.water);
		Fizzlecraft.fluidMercury.setBlockID(id);

		setUnlocalizedName("mercury");
		setCreativeTab(CreativeTabs.tabMisc);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.theIcon = new Icon[] {
				iconRegister.registerIcon("fizzlecraft:mercury_still"),
				iconRegister.registerIcon("fizzlecraft:mercury_flowing") };
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return side != 0 && side != 1 ? this.theIcon[1] : this.theIcon[0];
	}
}
