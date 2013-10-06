package floptower.fizzlecraft.blocks;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockMercuryStill extends BlockStationary {

	public BlockMercuryStill(int id, Material material) {
		super(id, material);
		setHardness(100F);
		setLightOpacity(1);
		disableStats();
		setUnlocalizedName("mercury");
		// setCreativeTab(CreativeTabs.tabMisc);
	}

	public void registerIcons(IconRegister iconRegister) {
		this.theIcon = new Icon[] {
				iconRegister.registerIcon("fizzlecraft:mercury_still"),
				iconRegister.registerIcon("fizzlecraft:mercury_flowing") };
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.motionY += 0.03;
		if (entity instanceof EntityLivingBase) {
			((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.getId(), 50));
		}
	}

}
