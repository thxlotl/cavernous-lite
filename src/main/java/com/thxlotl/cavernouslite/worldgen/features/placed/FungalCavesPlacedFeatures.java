package com.thxlotl.cavernouslite.worldgen.features.placed;

import com.thxlotl.cavernouslite.util.PFeatureUtil;
import com.thxlotl.cavernouslite.worldgen.features.ModPlacedFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.FungalCavesConfiguredFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

public class FungalCavesPlacedFeatures {


    public static final ResourceKey<PlacedFeature> MOSS_PATCH = ModPlacedFeatures.registerKey("fungal_moss_patch");
    public static final ResourceKey<PlacedFeature> MYCELIUM_PATCH = ModPlacedFeatures.registerKey("fungal_mycelium_patch");

    public static void bootstrap(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {

        ModPlacedFeatures.register(context,
                MOSS_PATCH,
                configuredFeatures.getOrThrow(FungalCavesConfiguredFeatures.MOSS_PATCH),
                PFeatureUtil.cavePlacementModifers(200));
        ModPlacedFeatures.register(context,
                MYCELIUM_PATCH,
                configuredFeatures.getOrThrow(FungalCavesConfiguredFeatures.MYCELIUM_PATCH),
                PFeatureUtil.cavePlacementModifers(125));

    }
}