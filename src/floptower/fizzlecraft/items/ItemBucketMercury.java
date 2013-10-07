package floptower.fizzlecraft.items;

import floptower.fizzlecraft.Fizzlecraft;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.ItemFluidContainer;


public class ItemBucketMercury extends ItemFluidContainer {

	public ItemBucketMercury(int id) {
		super(id);

		setTextureName("fizzlecraft:bucket_mercury");
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("bucketMercury");
	}

	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

		if (movingobjectposition == null) {
			return item;
		} else {
			FillBucketEvent event = new FillBucketEvent(player, item, world, movingobjectposition);
			if (MinecraftForge.EVENT_BUS.post(event)) {
				return item;
			}

			if (event.getResult() == Event.Result.ALLOW) {
				if (player.capabilities.isCreativeMode) {
					return item;
				}

				if (--item.stackSize <= 0) {
					return event.result;
				}

				if (!player.inventory.addItemStackToInventory(event.result)) {
					player.dropPlayerItem(event.result);
				}

				return item;
			}

			if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
				int x = movingobjectposition.blockX;
				int y = movingobjectposition.blockY;
				int z = movingobjectposition.blockZ;

				if (!world.canMineBlock(player, x, y, z)) {
					return item;
				}


				if (movingobjectposition.sideHit == 0) { --y; }
				if (movingobjectposition.sideHit == 1) { ++y; }
				if (movingobjectposition.sideHit == 2) { --z; }
				if (movingobjectposition.sideHit == 3) { ++z; }
				if (movingobjectposition.sideHit == 4) { --x; }
				if (movingobjectposition.sideHit == 5) { ++x; }

				if (!player.canPlayerEdit(x, y, z, movingobjectposition.sideHit, item)) {
					return item;
				}

				if (this.tryPlaceContainedLiquid(world, x, y, z) && !player.capabilities.isCreativeMode) {
					return new ItemStack(Item.bucketEmpty);
				}

			}

			return item;
		}
	}

	public boolean tryPlaceContainedLiquid(World par1World, int par2, int par3, int par4) {
		Material material = par1World.getBlockMaterial(par2, par3, par4);
		boolean flag = !material.isSolid();

		if (!par1World.isAirBlock(par2, par3, par4) && !flag) {
			return false;
		} else {

			if (!par1World.isRemote && flag && !material.isLiquid()) {
				par1World.destroyBlock(par2, par3, par4, true);
			}
			par1World.setBlock(par2, par3, par4, Fizzlecraft.liquidMercury.blockID, 0, 3);

			return true;
		}
	}
}
