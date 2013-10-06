package floptower.fizzlecraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIngotMagnesium extends Item {
	public ItemIngotMagnesium(int id) {
		super(id);
		
		setTextureName("fizzlecraft:ingot_magnesium");
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("ingotMagnesium");
	}
}
