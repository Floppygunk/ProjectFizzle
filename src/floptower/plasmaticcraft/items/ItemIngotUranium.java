package floptower.plasmaticcraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIngotUranium extends Item {
	public ItemIngotUranium(int id) {
		super(id);
		
		setTextureName("plasmaticraft:ingot_uranium");
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("ingotUranium");
	}
}
