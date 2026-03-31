package com.thxlotl.cavernouslite.worldgen.features.placed;

import com.thxlotl.cavernouslite.util.PFeatureUtil;
import com.thxlotl.cavernouslite.worldgen.features.ModPlacedFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.BuriedJungleConfiguredFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

public class BuriedJunglePlacedFeatures {

    public static final ResourceKey<PlacedFeature> MUD_POOL = ModPlacedFeatures.registerKey("mud_pool");
    public static final ResourceKey<PlacedFeature> TREE = ModPlacedFeatures.registerKey("jungle_tree");
    public static final ResourceKey<PlacedFeature> RED_TREE = ModPlacedFeatures.registerKey("jungle_tree_red");
    public static final ResourceKey<PlacedFeature> PATCH = ModPlacedFeatures.registerKey("jungle_vegetation_patch");
    public static final ResourceKey<PlacedFeature> COARSE_DIRT_PATCH = ModPlacedFeatures.registerKey("coarse_dirt_patch");

    public static void bootstrap(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {

        ModPlacedFeatures.register(context, MUD_POOL, configuredFeatures.getOrThrow(BuriedJungleConfiguredFeatures.MUD_POOL), PFeatureUtil.cavePlacementModifers(100));
        ModPlacedFeatures.register(context, TREE, configuredFeatures.getOrThrow(BuriedJungleConfiguredFeatures.TREE), PFeatureUtil.caveTreePlacementModifiers(25, Blocks.MANGROVE_PROPAGULE));
        ModPlacedFeatures.register(context, RED_TREE, configuredFeatures.getOrThrow(BuriedJungleConfiguredFeatures.RED_TREE), PFeatureUtil.caveTreePlacementModifiers(20, Blocks.MANGROVE_PROPAGULE));
        ModPlacedFeatures.register(context, PATCH, configuredFeatures.getOrThrow(BuriedJungleConfiguredFeatures.PATCH), PFeatureUtil.cavePatchPlacementModifers(1200, Blocks.SHORT_GRASS));
        ModPlacedFeatures.register(context, COARSE_DIRT_PATCH, configuredFeatures.getOrThrow(BuriedJungleConfiguredFeatures.COARSE_DIRT_PATCH), PFeatureUtil.cavePlacementModifers(40));

    }

}
