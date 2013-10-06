package floptower.fizzlecraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIngotOsmium extends Item {
	public ItemIngotOsmium(int id) {
		super(id);
		
		setTextureName("floptower.fizzlecraft:ingot_osmium");
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("ingotOsmium");
	}
}
