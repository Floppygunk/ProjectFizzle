package floptower.fizzlecraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIngotCopper extends Item {
	public ItemIngotCopper(int id) {
		super(id);
		
		setTextureName("fizzlecraft:ingot_copper");
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("ingotCopper");
	}
}
