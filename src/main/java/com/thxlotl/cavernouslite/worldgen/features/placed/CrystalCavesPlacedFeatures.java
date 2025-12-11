package com.thxlotl.cavernouslite.worldgen.features.placed;

import com.thxlotl.cavernouslite.util.PFeatureUtil;
import com.thxlotl.cavernouslite.worldgen.features.ModPlacedFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.CrystalCavesConfiguredFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.VolcanicCavesConfiguredFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class CrystalCavesPlacedFeatures {

    public static final ResourceKey<PlacedFeature> BUD_UP    = ModPlacedFeatures.registerKey("bud_up");
    public static final ResourceKey<PlacedFeature> BUD_DOWN  = ModPlacedFeatures.registerKey("bud_down");
    public static final ResourceKey<PlacedFeature> BUD_NORTH = ModPlacedFeatures.registerKey("bud_north");
    public static final ResourceKey<PlacedFeature> BUD_SOUTH = ModPlacedFeatures.registerKey("bud_south");
    public static final ResourceKey<PlacedFeature> BUD_EAST  = ModPlacedFeatures.registerKey("bud_east");
    public static final ResourceKey<PlacedFeature> BUD_WEST  = ModPlacedFeatures.registerKey("bud_west");
    public static final ResourceKey<PlacedFeature> BIG_GEODE  = ModPlacedFeatures.registerKey("big_geode");


    public static void bootstrap(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {

        ModPlacedFeatures.register(context, BUD_UP, configuredFeatures.getOrThrow(CrystalCavesConfiguredFeatures.BUD_UP), PFeatureUtil.cavePlacementModifers(200, Direction.DOWN));
        ModPlacedFeatures.register(context, BUD_DOWN, configuredFeatures.getOrThrow(CrystalCavesConfiguredFeatures.BUD_DOWN), PFeatureUtil.cavePlacementModifers(200, Direction.UP));
        ModPlacedFeatures.register(context, BUD_NORTH, configuredFeatures.getOrThrow(CrystalCavesConfiguredFeatures.BUD_NORTH), PFeatureUtil.cavePlacementModifersNoScan(250));
        ModPlacedFeatures.register(context, BUD_EAST, configuredFeatures.getOrThrow(CrystalCavesConfiguredFeatures.BUD_EAST), PFeatureUtil.cavePlacementModifersNoScan(250));
        ModPlacedFeatures.register(context, BUD_SOUTH, configuredFeatures.getOrThrow(CrystalCavesConfiguredFeatures.BUD_SOUTH), PFeatureUtil.cavePlacementModifersNoScan(250));
        ModPlacedFeatures.register(context, BUD_WEST, configuredFeatures.getOrThrow(CrystalCavesConfiguredFeatures.BUD_WEST), PFeatureUtil.cavePlacementModifersNoScan(250));

        ModPlacedFeatures.register(context, BIG_GEODE, configuredFeatures.getOrThrow(CrystalCavesConfiguredFeatures.BIG_GEODE), List.of(
                RarityFilter.onAverageOnceEvery(38),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(20)),
                BiomeFilter.biome()
        ));
    }

}
