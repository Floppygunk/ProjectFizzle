package floptower.fizzlecraft.fluids;

import net.minecraft.item.EnumRarity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidMercury extends Fluid {
	public FluidMercury() {
		super("mercury");

		setDensity(20);
		setViscosity(2);
		setRarity(EnumRarity.rare);

		// Required
		FluidRegistry.registerFluid(this);
	}
}
