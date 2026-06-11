package com.thxlotl.cavernouslite.worldgen.features.placed;

import com.mojang.datafixers.kinds.Const;
import com.thxlotl.cavernouslite.util.PFeatureUtil;
import com.thxlotl.cavernouslite.worldgen.features.ModPlacedFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.FungalCavesConfiguredFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class FungalCavesPlacedFeatures {


    public static final ResourceKey<PlacedFeature> MOSS_PATCH = ModPlacedFeatures.registerKey("fungal_moss_patch");
    public static final ResourceKey<PlacedFeature> MYCELIUM_PATCH = ModPlacedFeatures.registerKey("fungal_mycelium_patch");
    public static final ResourceKey<PlacedFeature> BROWN_1 = ModPlacedFeatures.registerKey("fungal_tree_brown_1");
    public static final ResourceKey<PlacedFeature> RED_1 = ModPlacedFeatures.registerKey("fungal_tree_red_1");
    public static final ResourceKey<PlacedFeature> BROWN_2 = ModPlacedFeatures.registerKey("fungal_tree_brown_2");
    public static final ResourceKey<PlacedFeature> RED_2 = ModPlacedFeatures.registerKey("fungal_tree_red_2");
    public static final ResourceKey<PlacedFeature> GLOWSHROOM = ModPlacedFeatures.registerKey("glowshroom");
    public static final ResourceKey<PlacedFeature> FLIP_STEP_1 = ModPlacedFeatures.registerKey("flip_step_1");
    public static final ResourceKey<PlacedFeature> FLIP_STEP_2 = ModPlacedFeatures.registerKey("flip_step_2");
    public static final ResourceKey<PlacedFeature> FLIP_STEP_3 = ModPlacedFeatures.registerKey("flip_step_3");

    public static void bootstrap(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {

        // Vegetation
        ModPlacedFeatures.register(context,
                MOSS_PATCH,
                configuredFeatures.getOrThrow(FungalCavesConfiguredFeatures.MOSS_PATCH),
                PFeatureUtil.cavePlacementModifers(200));
        ModPlacedFeatures.register(context,
                MYCELIUM_PATCH,
                configuredFeatures.getOrThrow(FungalCavesConfiguredFeatures.MYCELIUM_PATCH),
                PFeatureUtil.cavePlacementModifers(150));

        // Giant Mushroom
        ModPlacedFeatures.register(context,
                BROWN_1,
                configuredFeatures.getOrThrow(FungalCavesConfiguredFeatures.BROWN_1),
                PFeatureUtil.caveTreePlacementModifiers(8, Blocks.BROWN_MUSHROOM));
        ModPlacedFeatures.register(context,
                RED_1,
                configuredFeatures.getOrThrow(FungalCavesConfiguredFeatures.RED_1),
                PFeatureUtil.caveTreePlacementModifiers(8, Blocks.RED_MUSHROOM));
        ModPlacedFeatures.register(context,
                BROWN_2,
                configuredFeatures.getOrThrow(FungalCavesConfiguredFeatures.BROWN_2),
                PFeatureUtil.caveTreePlacementModifiers(10, Blocks.BROWN_MUSHROOM));
        ModPlacedFeatures.register(context,
                RED_2,
                configuredFeatures.getOrThrow(FungalCavesConfiguredFeatures.RED_2),
                PFeatureUtil.caveTreePlacementModifiers(10, Blocks.RED_MUSHROOM));
        ModPlacedFeatures.register(context,
                GLOWSHROOM,
                configuredFeatures.getOrThrow(FungalCavesConfiguredFeatures.GLOWSHROOM),
                PFeatureUtil.caveTreePlacementModifiers(7, Blocks.RED_MUSHROOM));

        ModPlacedFeatures.register(context,
                FLIP_STEP_1,
                configuredFeatures.getOrThrow(FungalCavesConfiguredFeatures.FLIPPED_SHROOM_STEM),
                List.of(
                        CountPlacement.of(12),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(256)),
                        EnvironmentScanPlacement.scanningFor(
                                Direction.UP,
                                BlockPredicate.solid(),
                                BlockPredicate.allOf(
                                        BlockPredicate.matchesBlocks(Blocks.AIR),
                                        BlockPredicate.not(BlockPredicate.matchesBlocks(new Vec3i(0, 1, 0), Blocks.RED_MUSHROOM_BLOCK, Blocks.BROWN_MUSHROOM_BLOCK))
                                ),
                                24
                        ),
                        RandomOffsetPlacement.of(ConstantInt.of(0), ConstantInt.of(-1)),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context,
                FLIP_STEP_2,
                configuredFeatures.getOrThrow(FungalCavesConfiguredFeatures.FLIPPED_SHROOM_CAP),
                List.of(
                        CountPlacement.of(4000),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(256)),
                        EnvironmentScanPlacement.scanningFor(
                                Direction.UP,
                                BlockPredicate.anyOf(
                                        BlockPredicate.matchesBlocks(new Vec3i(-1, 0, 2), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(0, 0, 2), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(1, 0, 2), Blocks.RED_CONCRETE),

                                        BlockPredicate.matchesBlocks(new Vec3i(-2, 0, 1), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(-1, 0, 1), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(0, 0, 1), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(1, 0, 1), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(2, 0, 1), Blocks.RED_CONCRETE),

                                        BlockPredicate.matchesBlocks(new Vec3i(-2, 0, 0), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(-1, 0, 0), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(1, 0, 0), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(2, 0, 0), Blocks.RED_CONCRETE),

                                        BlockPredicate.matchesBlocks(new Vec3i(-2, 0, -1), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(-1, 0, -1), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(0, 0, -1), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(1, 0, -1), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(2, 0, -1), Blocks.RED_CONCRETE),

                                        BlockPredicate.matchesBlocks(new Vec3i(-1, 0, -2), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(0, 0, -2), Blocks.RED_CONCRETE),
                                        BlockPredicate.matchesBlocks(new Vec3i(1, 0, -2), Blocks.RED_CONCRETE)
                                ),
                                32
                        ),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context,
                FLIP_STEP_3,
                Holder.direct(new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(Blocks.BROWN_MUSHROOM_BLOCK)))),
                List.of(
                        CountPlacement.of(170),
                        CountPlacement.of(100),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(256)),
                        EnvironmentScanPlacement.scanningFor(
                                Direction.UP,
                                BlockPredicate.matchesBlocks(new Vec3i(0, 0, 0), Blocks.RED_CONCRETE),
                                32
                        ),
                        BiomeFilter.biome()
                ));

    }
}