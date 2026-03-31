package com.thxlotl.cavernouslite.worldgen.features;

import com.thxlotl.cavernouslite.CavernousLite;
import com.thxlotl.cavernouslite.util.OrePlacedFeatureTypes;
import com.thxlotl.cavernouslite.worldgen.features.config.IcyCavesConfiguredFeatures;
import com.thxlotl.cavernouslite.worldgen.features.placed.*;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    // Register Features
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        FungalCavesPlacedFeatures.bootstrap(context, configuredFeatures);
        VolcanicCavesPlacedFeatures.bootstrap(context, configuredFeatures);
        CrystalCavesPlacedFeatures.bootstrap(context, configuredFeatures);
        AridCavesPlacedFeatures.bootstrap(context, configuredFeatures);
        IcyCavesPlacedFeatures.bootstrap(context, configuredFeatures);
        BuriedJunglePlacedFeatures.bootstrap(context, configuredFeatures);
        OrePlacedFeatures.bootstrap(context, configuredFeatures);
    }


    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return  ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(CavernousLite.MODID, name));
    }
    public static void register (BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    public static ResourceKey<PlacedFeature> oreKey(String prefix, OrePlacedFeatureTypes oreType)
    {
        String suffix = oreType.toString().toLowerCase();
        return registerKey(prefix + "_ore_" + suffix);
    }
}
