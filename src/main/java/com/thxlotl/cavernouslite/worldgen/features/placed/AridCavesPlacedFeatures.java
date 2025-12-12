package com.thxlotl.cavernouslite.worldgen.features.placed;

import com.thxlotl.cavernouslite.util.PFeatureUtil;
import com.thxlotl.cavernouslite.worldgen.features.ModPlacedFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.AridCavesConfiguredFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.IcyCavesConfiguredFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.VolcanicCavesConfiguredFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AridCavesPlacedFeatures {

    public static final ResourceKey<PlacedFeature> PATCH = ModPlacedFeatures.registerKey("arid_vegetation_patch");
    public static final ResourceKey<PlacedFeature> HOODOO_1 = ModPlacedFeatures.registerKey("hoodoo_1");
    public static final ResourceKey<PlacedFeature> HOODOO_2 = ModPlacedFeatures.registerKey("hoodoo_2");
    public static final ResourceKey<PlacedFeature> GIANT_DEAD_BUSH = ModPlacedFeatures.registerKey("giant_dead_bush");
    public static final ResourceKey<PlacedFeature> GOLD_EXTRA = ModPlacedFeatures.registerKey("gold_extra");

    public static void bootstrap(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {

        ModPlacedFeatures.register(context,
                PATCH,
                configuredFeatures.getOrThrow(AridCavesConfiguredFeatures.PATCH),
                PFeatureUtil.cavePlacementModifers(100)
        );

        ModPlacedFeatures.register(context,
                HOODOO_1,
                configuredFeatures.getOrThrow(AridCavesConfiguredFeatures.HOODOO_1),
                PFeatureUtil.caveTreePlacementModifiers(6, Blocks.TORCH)
        );

        ModPlacedFeatures.register(context,
                HOODOO_2,
                configuredFeatures.getOrThrow(AridCavesConfiguredFeatures.HOODOO_2),
                PFeatureUtil.caveTreePlacementModifiers(15, Blocks.TORCH)
        );

        ModPlacedFeatures.register(context,
                GIANT_DEAD_BUSH,
                configuredFeatures.getOrThrow(AridCavesConfiguredFeatures.GIANT_DEAD_BUSH),
                PFeatureUtil.caveTreePlacementModifiers(5, Blocks.DEAD_BUSH)
        );

        ModPlacedFeatures.register(context,
                GOLD_EXTRA,
                configuredFeatures.getOrThrow(AridCavesConfiguredFeatures.GOLD_EXTRA),
                List.of(
                        CountPlacement.of(50),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(
                                BiasedToBottomHeight.of(VerticalAnchor.aboveBottom(4), VerticalAnchor.absolute(100), 1)
                        ),
                        BiomeFilter.biome()
                )
        );
    }

}
