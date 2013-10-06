package floptower.fizzlecraft.generators;

import cpw.mods.fml.common.IWorldGenerator;
import floptower.fizzlecraft.Fizzlecraft;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class WorldGenMercury implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId == 0) {
            generateLake(world, random, chunkX * 16, chunkZ * 16);
        }
	}

    private void generateLake(World world, Random random, int i, int j) {
        int radius = random.nextInt(3)+2; // Radius is between 2 and 5 (4x4 and 10x10)
        int centreX = random.nextInt(15 - radius * 2)+radius; // x and z center are inside chunk
        int centreZ = random.nextInt(15-radius*2)+radius;
        int y = random.nextInt(26)+4; // Between 4 and 30

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                // (radius-0.5) decreases the diameter by one block, which makes it look better
                double dist = Math.sqrt((x-centreX)*(x-centreX)+(z-centreZ)*(z-centreZ)) - radius-0.5;
                if (dist <= 0) {
                    world.setBlock(x+i, y, z+j, Fizzlecraft.mercuryFlowing.blockID);
                    world.setBlock(x+i, y-1, z+j, Fizzlecraft.mercuryFlowing.blockID);
                    world.setBlock(x+i, y-2, z+j, Block.stone.blockID);
                } else if (dist <= 1) {
                    world.setBlock(x+i, y, z+j, Block.stone.blockID);
                    world.setBlock(x+i, y-1, z+j, Block.stone.blockID);
                    world.setBlock(x+i, y-2, z+j, Block.stone.blockID);
                }
            }
        }
    }
}
