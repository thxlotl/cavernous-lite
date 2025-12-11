package com.thxlotl.cavernouslite.worldgen.features.placed;

import com.thxlotl.cavernouslite.util.OrePlacedFeatureTypes;
import com.thxlotl.cavernouslite.worldgen.features.ModPlacedFeatures;
import com.thxlotl.cavernouslite.worldgen.features.config.OreConfiguredFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.TrapezoidHeight;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class OrePlacedFeatures {

    private static final String pre = "underground";

    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_COAL_LOWER = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.COAL_LOWER);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_COAL_UPPER = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.COAL_UPPER);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_COPPER = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.COPPER);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_COPPER_LARGE = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.COPPER_LARGE);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_IRON_MIDDLE = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.IRON_MIDDLE);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_IRON_SMALL = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.IRON_SMALL);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_IRON_UPPER = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.IRON_UPPER);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_GOLD = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.GOLD);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_GOLD_LOWER = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.GOLD_LOWER);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_REDSTONE = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.REDSTONE);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_REDSTONE_LOWER = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.REDSTONE_LOWER);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_LAPIS = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.LAPIS);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_LAPIS_BURIED = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.LAPIS_BURIED);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_DIAMOND = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.DIAMOND);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_DIAMOND_BURIED = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.DIAMOND_BURIED);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_DIAMOND_LARGE = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.DIAMOND_LARGE);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_DIAMOND_MEDIUM = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.DIAMOND_MEDIUM);
    public static final ResourceKey<PlacedFeature> UNDERGROUND_ORE_EMERALD = ModPlacedFeatures.oreKey(pre, OrePlacedFeatureTypes.EMERALD);

    public static void bootstrap(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {

        ModPlacedFeatures.register(context, UNDERGROUND_ORE_COAL_LOWER, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_COAL),
                List.of(
                        CountPlacement.of(20),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_COAL_UPPER, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_COAL),
                List.of(
                        CountPlacement.of(30),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(136), VerticalAnchor.belowTop(0))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_COPPER, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_COPPER_SMALL),
                List.of(
                        CountPlacement.of(16),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_COPPER_LARGE, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_COPPER_LARGE),
                List.of(
                        CountPlacement.of(16),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_IRON_MIDDLE, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_IRON),
                List.of(
                        CountPlacement.of(10),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_IRON_SMALL, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_IRON_SMALL),
                List.of(
                        CountPlacement.of(10),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(72))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_IRON_UPPER, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_IRON),
                List.of(
                        CountPlacement.of(90),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_GOLD, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_GOLD_BURIED),
                List.of(
                        CountPlacement.of(4),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_GOLD_LOWER, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_GOLD_BURIED),
                List.of(
                        CountPlacement.of(UniformInt.of(0, 1)),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_REDSTONE, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_REDSTONE),
                List.of(
                        CountPlacement.of(4),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(15))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_REDSTONE_LOWER, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_REDSTONE),
                List.of(
                        CountPlacement.of(8),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_LAPIS, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_LAPIS),
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_LAPIS_BURIED, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_LAPIS_BURIED),
                List.of(
                        CountPlacement.of(4),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(64))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_DIAMOND, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_DIAMOND_SMALL),
                List.of(
                        CountPlacement.of(7),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_DIAMOND_BURIED, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_DIAMOND_BURIED),
                List.of(
                        CountPlacement.of(4),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_DIAMOND_LARGE, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_DIAMOND_LARGE),
                List.of(
                        RarityFilter.onAverageOnceEvery(9),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_DIAMOND_MEDIUM, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_DIAMOND_MEDIUM),
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4))),
                        BiomeFilter.biome()
                ));
        ModPlacedFeatures.register(context, UNDERGROUND_ORE_EMERALD, configuredFeatures.getOrThrow(OreConfiguredFeatures.UNDERGROUND_ORE_EMERALD),
                List.of(
                        CountPlacement.of(100),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))),
                        BiomeFilter.biome()
                ));
    }

}
