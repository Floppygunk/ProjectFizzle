package floptower.fizzlecraft.generators;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import floptower.fizzlecraft.Fizzlecraft;

public class WorldGenFizzlecraft implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {
	}

	private void generateSurface(World world, Random random, int i, int j) {
		generateVeins(world, random, i, j, Fizzlecraft.oreMagnesium.blockID, 80, 30, 4, 12);
		generateVeins(world, random, i, j, Fizzlecraft.oreUranium.blockID, 20, 0, 1, 4);
		generateVeins(world, random, i, j, Fizzlecraft.oreOsmium.blockID, 30, 0, 1, 3);
		generateVeins(world, random, i, j, Fizzlecraft.oreZirconia.blockID, 35, 0, 2, 3);
	}

	private void generateNether(World world, Random random, int i, int j) {
	}
	
	private void generateVeins(World world, Random random, int i, int j, int id, int maxLevel, int minLevel, int veinsPerChunk, int orePerVein) {
		for(int k = 0; k < veinsPerChunk; k++) {
			int x = i + random.nextInt(16);
			int y = random.nextInt(maxLevel-minLevel)+minLevel; // Generate between the min and max levels
			int z = j + random.nextInt(16);
			
			(new WorldGenMinable(id, orePerVein)).generate(world, random, x, y, z);
		}
	}

}
