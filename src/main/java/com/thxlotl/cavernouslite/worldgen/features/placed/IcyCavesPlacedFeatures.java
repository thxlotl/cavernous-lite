package com.thxlotl.cavernouslite.worldgen.features.placed;

import com.thxlotl.cavernouslite.util.PFeatureUtil;
import com.thxlotl.cavernouslite.worldgen.features.ModPlacedFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.AridCavesConfiguredFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.IcyCavesConfiguredFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.VolcanicCavesConfiguredFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class IcyCavesPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ICE_PILLAR = ModPlacedFeatures.registerKey("ice_pillar");
    public static final ResourceKey<PlacedFeature> DIAMOND_EXTRA = ModPlacedFeatures.registerKey("diamond_extra_icy");

    public static void bootstrap(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {

        ModPlacedFeatures.register(context,
                ICE_PILLAR,
                configuredFeatures.getOrThrow(IcyCavesConfiguredFeatures.ICE_PILLAR),
                List.of(
                        CountPlacement.of(30),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(256)),
                        EnvironmentScanPlacement.scanningFor(
                                Direction.UP,
                                BlockPredicate.matchesBlocks(Blocks.BLUE_ICE),
                                24
                        ),
                        BiomeFilter.biome()
                )
        );

        ModPlacedFeatures.register(context,
                DIAMOND_EXTRA,
                configuredFeatures.getOrThrow(VolcanicCavesConfiguredFeatures.DIAMOND_EXTRA),
                List.of(
                        CountPlacement.of(5),
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(
                                BiasedToBottomHeight.of(VerticalAnchor.aboveBottom(4), VerticalAnchor.absolute(10), 1)
                        ),
                        BiomeFilter.biome()
                )
        );
    }

}
