package com.thxlotl.cavernouslite.worldgen.features.placed;

import com.thxlotl.cavernouslite.util.PFeatureUtil;
import com.thxlotl.cavernouslite.worldgen.features.ModPlacedFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.FungalCavesConfiguredFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.VolcanicCavesConfiguredFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class VolcanicCavesPlacedFeatures {

    public static final ResourceKey<PlacedFeature> LAVA_POOL = ModPlacedFeatures.registerKey("lava_pool");
    public static final ResourceKey<PlacedFeature> DIAMOND_EXTRA = ModPlacedFeatures.registerKey("diamond_extra");
    public static final ResourceKey<PlacedFeature> SCORCHED_TREE = ModPlacedFeatures.registerKey("scorched_tree");

    public static void bootstrap(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {

        ModPlacedFeatures.register(context,
                LAVA_POOL,
                configuredFeatures.getOrThrow(VolcanicCavesConfiguredFeatures.LAVA_POOL),
                    PFeatureUtil.cavePlacementModifers(200)
        );

        ModPlacedFeatures.register(context,
                DIAMOND_EXTRA,
                configuredFeatures.getOrThrow(VolcanicCavesConfiguredFeatures.DIAMOND_EXTRA),
                List.of(
                        CountPlacement.of(7),
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(
                                BiasedToBottomHeight.of(VerticalAnchor.aboveBottom(4), VerticalAnchor.absolute(0), 1)
                        ),
                        BiomeFilter.biome()
                )
        );

        ModPlacedFeatures.register(context, SCORCHED_TREE, configuredFeatures.getOrThrow(VolcanicCavesConfiguredFeatures.SCORCHED_TREE), PFeatureUtil.caveTreePlacementModifiers(8, Blocks.TORCH));

    }

}
