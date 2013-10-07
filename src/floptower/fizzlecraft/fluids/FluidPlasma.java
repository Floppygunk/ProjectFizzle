package floptower.fizzlecraft.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidPlasma extends Fluid {
	public FluidPlasma() {
		super("fluidPlasma");

		setDensity(-1);
		setViscosity(5000);

		// Required
		FluidRegistry.registerFluid(this);
	}
}
