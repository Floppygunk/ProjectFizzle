package floptower.fizzlecraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIngotUranium extends Item {
	public ItemIngotUranium(int id) {
		super(id);
		
		setTextureName("fizzlecraft:ingot_uranium");
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("ingotUranium");
	}
}
