package com.thxlotl.cavernouslite.worldgen.biome;

import com.thxlotl.cavernouslite.worldgen.ModNoises;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class BiomeSurfaceRules {

    private static BlockState getBlockState(Block block) {
        return block.defaultBlockState();
    }

    private static final BlockState moss = getBlockState(Blocks.MOSS_BLOCK);
    private static final BlockState mycelium = getBlockState(Blocks.MYCELIUM);
    private static final BlockState dirt = getBlockState(Blocks.DIRT);
    private static final BlockState packedMud = getBlockState(Blocks.PACKED_MUD);

    public static SurfaceRules.RuleSource fungalRules()
    {
        SurfaceRules.RuleSource fungalCaves =
                SurfaceRules.sequence(

                        SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(ModNoises.FUNGAL_SURFACE, -0.13, 0.15),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR),
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.noiseCondition(ModNoises.FUNGAL_SURFACE, -0.13, 0.15),
                                                        SurfaceRules.state(mycelium))
                                        ),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.stoneDepthCheck(0, true, CaveSurface.FLOOR),
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.noiseCondition(ModNoises.FUNGAL_SURFACE, -0.13, 0.15),
                                                        SurfaceRules.state(dirt))
                                        )
                                )
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(ModNoises.FUNGAL_SURFACE, -0.23, 0.25),
                                        SurfaceRules.state(packedMud))
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR),
                                SurfaceRules.state(moss)
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.stoneDepthCheck(0, true, 1, CaveSurface.FLOOR),
                                SurfaceRules.state(packedMud)
                        )
                );

        return SurfaceRules.ifTrue(
                SurfaceRules.isBiome(ModBiomes.FUNGAL_CAVES),
                SurfaceRules.ifTrue(
                        SurfaceRules.not(SurfaceRules.abovePreliminarySurface()),
                        fungalCaves
                ));
    }

}
