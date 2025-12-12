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

    public static SurfaceRules.RuleSource volcanicRules()
    {
        SurfaceRules.RuleSource volcanicCaves =
                SurfaceRules.sequence(
//                        SurfaceRules.ifTrue(
//                                SurfaceRules.noiseCondition(ModNoises.VOLCANIC, -0.03f, 0.03f),
//                                SurfaceRules.ifTrue(
//                                        SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR),
//                                        SurfaceRules.state(Blocks.LAVA.defaultBlockState())
//                                )
//                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.stoneDepthCheck(0, true, 3, CaveSurface.FLOOR),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition(ModNoises.VOLCANIC, -0.1f, 0.1f),
                                                SurfaceRules.state(Blocks.MAGMA_BLOCK.defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition(ModNoises.VOLCANIC, -0.2f, 0.2f),
                                                SurfaceRules.state(Blocks.BASALT.defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition(ModNoises.VOLCANIC, -0.25f, 0.25f),
                                                SurfaceRules.state(Blocks.SMOOTH_BASALT.defaultBlockState())
                                        )
                                )
                        ),
                        SurfaceRules.state(Blocks.BLACKSTONE.defaultBlockState())
                );

        return SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.VOLCANIC_CAVES), volcanicCaves);
    }

    public static SurfaceRules.RuleSource crystalRules()
    {
        SurfaceRules.RuleSource rule =
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(ModNoises.STRIPEY, -0.1f, 0.1f),
                                SurfaceRules.state(Blocks.AMETHYST_BLOCK.defaultBlockState())
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(ModNoises.STRIPEY, -0.14f, 0.14f),
                                SurfaceRules.state(Blocks.CALCITE.defaultBlockState())
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(ModNoises.STRIPEY, -0.18f, 0.18f),
                                SurfaceRules.state(Blocks.SMOOTH_BASALT.defaultBlockState())
                        )
                );

        return SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.CRYSTAL_CAVES), rule);
    }

    public static SurfaceRules.RuleSource marbledRules()
    {
        SurfaceRules.RuleSource rule =
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(ModNoises.STRIPEY, -0.085f, 0.075f),
                                SurfaceRules.state(Blocks.CALCITE.defaultBlockState())
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(ModNoises.SCATTERED, -0.1f, 0.1f),
                                SurfaceRules.state(Blocks.CALCITE.defaultBlockState())
                        ),
                        SurfaceRules.state(Blocks.DIORITE.defaultBlockState())
                );

        return SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.MARBLED_CAVES), rule);
    }

    public static SurfaceRules.RuleSource aridRules()
    {
        SurfaceRules.RuleSource rule = SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(ModNoises.STRIPEY, -0.08, 0.08),
                                        SurfaceRules.state(Blocks.RED_SAND.defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(ModNoises.STRIPEY, 0.5, 0.55),
                                        SurfaceRules.state(Blocks.RED_SAND.defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(ModNoises.STRIPEY, -0.55, -0.5),
                                        SurfaceRules.state(Blocks.RED_SAND.defaultBlockState())
                                ),
                                SurfaceRules.state(Blocks.SAND.defaultBlockState())
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.noiseCondition(ModNoises.STRIPEY, -0.1, 0.1),
                        SurfaceRules.state(Blocks.RED_SANDSTONE.defaultBlockState())
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.noiseCondition(ModNoises.STRIPEY, 0.5, 0.6),
                        SurfaceRules.state(Blocks.ORANGE_TERRACOTTA.defaultBlockState())
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.noiseCondition(ModNoises.STRIPEY, -0.6, -0.5),
                        SurfaceRules.state(Blocks.ORANGE_TERRACOTTA.defaultBlockState())
                ),
                SurfaceRules.state(Blocks.TERRACOTTA.defaultBlockState())
        );

        return SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.ARID_CAVES), rule);
    }

    public static SurfaceRules.RuleSource icyRules()
    {
        SurfaceRules.RuleSource rule =
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(
                                SurfaceRules.stoneDepthCheck(0, true, 2, CaveSurface.FLOOR),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition(ModNoises.STRIPEY, -0.008, 0.008),
                                                SurfaceRules.state(Blocks.POWDER_SNOW.defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition(ModNoises.STRIPEY, -0.085, 0.085),
                                                SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState())
                                        )
                                )
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR),
                                SurfaceRules.state(Blocks.ICE.defaultBlockState())
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(ModNoises.SCATTERED, -0.05, 0.05),
                                SurfaceRules.state(Blocks.CALCITE.defaultBlockState())
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(ModNoises.SCATTERED, 0.4, 0.45),
                                SurfaceRules.state(Blocks.CALCITE.defaultBlockState())
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(ModNoises.SCATTERED, -0.45, -0.4),
                                SurfaceRules.state(Blocks.CALCITE.defaultBlockState())
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(ModNoises.STRIPEY, -0.5, -0.4),
                                SurfaceRules.state(Blocks.PACKED_ICE.defaultBlockState())
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(ModNoises.STRIPEY, 0.4, 0.5),
                                SurfaceRules.state(Blocks.PACKED_ICE.defaultBlockState())
                        ),
                        SurfaceRules.state(Blocks.BLUE_ICE.defaultBlockState())
                );

        return SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.ICY_CAVES), rule);
    }

    public static SurfaceRules.RuleSource jungleRules()
    {
        SurfaceRules.RuleSource rule = SurfaceRules.sequence(
            SurfaceRules.ifTrue(
                    SurfaceRules.waterBlockCheck(0, 0),
                    SurfaceRules.ifTrue(
                            SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR),
                            SurfaceRules.sequence(
                                    SurfaceRules.ifTrue(
                                            SurfaceRules.noiseCondition(ModNoises.STRIPEY_SMALL, -0.18, 0.18),
                                            SurfaceRules.state(Blocks.MUD.defaultBlockState())
                                    ),
                                    SurfaceRules.ifTrue(
                                            SurfaceRules.noiseCondition(ModNoises.STRIPEY, -1000, -0.15),
                                            SurfaceRules.state(Blocks.MOSS_BLOCK.defaultBlockState())
                                    ),
                                    SurfaceRules.ifTrue(
                                            SurfaceRules.noiseCondition(ModNoises.STRIPEY, 0.15, 1000),
                                            SurfaceRules.state(Blocks.MOSS_BLOCK.defaultBlockState())
                                    )
                            )
                    )
            ),
            SurfaceRules.ifTrue(
                    SurfaceRules.stoneDepthCheck(0, true, 2, CaveSurface.FLOOR),
                    SurfaceRules.state(Blocks.MUD.defaultBlockState())
            )
        );

        return SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.BURIED_JUNGLE), rule);
    }
}
