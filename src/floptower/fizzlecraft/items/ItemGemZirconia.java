package floptower.fizzlecraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGemZirconia extends Item {
	public ItemGemZirconia(int id) {
		super(id);
		
		setTextureName("floptower.fizzlecraft:gem_zirconia");
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("gemZirconia");
	}
}
