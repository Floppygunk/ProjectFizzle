package floptower.fizzlecraft.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidMercury extends Fluid {
	public FluidMercury() {
		super("mercury");

		setDensity(20);
		setViscosity(500);

		// Required
		FluidRegistry.registerFluid(this);
	}
}
