package floptower.fizzlecraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import floptower.fizzlecraft.Fizzlecraft;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockMercury extends BlockFluidClassic {

	protected Icon[] theIcon;

	public BlockMercury(int id) {
		super(id, Fizzlecraft.fluidMercury, Material.water);
		Fizzlecraft.fluidMercury.setBlockID(id);

		setUnlocalizedName("mercury");
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z,
										  Entity entity) {
		if (entity instanceof EntityLivingBase) {
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(
					Potion.poison.getId(), 50));
		}
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			if (player.capabilities.isCreativeMode && player.isSneaking()) {
				return;
			}
		}
		entity.motionY += 0.03;
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
