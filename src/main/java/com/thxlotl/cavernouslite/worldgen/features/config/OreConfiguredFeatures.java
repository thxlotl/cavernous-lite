package com.thxlotl.cavernouslite.worldgen.features.config;

import com.thxlotl.cavernouslite.tag.ModBlockTags;
import com.thxlotl.cavernouslite.util.OreFeatureTypes;
import com.thxlotl.cavernouslite.worldgen.features.ModConfiguredFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class OreConfiguredFeatures {

    private static final String pre = "underground";

    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_COAL = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.COAL);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_COAL_BURIED = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.COAL_BURIED);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_COPPER_LARGE = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.COPPER_LARGE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_COPPER_SMALL = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.COPPER_SMALL);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_IRON = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.IRON);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_IRON_SMALL = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.IRON_SMALL);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_GOLD = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.GOLD);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_GOLD_BURIED = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.GOLD_BURIED);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_REDSTONE = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.REDSTONE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_LAPIS = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.LAPIS);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_LAPIS_BURIED = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.LAPIS_BURIED);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_DIAMOND_BURIED = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.DIAMOND_BURIED);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_DIAMOND_LARGE = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.DIAMOND_LARGE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_DIAMOND_MEDIUM = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.DIAMOND_MEDIUM);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_DIAMOND_SMALL = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.DIAMOND_SMALL);
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_ORE_EMERALD = ModConfiguredFeatures.oreKey(pre, OreFeatureTypes.EMERALD);

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
        TagKey<Block> stone = ModBlockTags.STONE_ORE_REPLACEABLE_UNDERGROUND;
        TagKey<Block> deepslate = ModBlockTags.DEEPSLATE_ORE_REPLACEABLE_UNDERGROUND;

        List<OreConfiguration.TargetBlockState> coal = List.of(
                OreConfiguration.target(new TagMatchTest(stone), Blocks.COAL_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(deepslate), Blocks.DEEPSLATE_COAL_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> copper = List.of(
                OreConfiguration.target(new TagMatchTest(stone), Blocks.COPPER_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(deepslate), Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> iron = List.of(
                OreConfiguration.target(new TagMatchTest(stone), Blocks.IRON_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(deepslate), Blocks.DEEPSLATE_IRON_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> gold = List.of(
                OreConfiguration.target(new TagMatchTest(stone), Blocks.GOLD_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(deepslate), Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> redstone = List.of(
                OreConfiguration.target(new TagMatchTest(stone), Blocks.REDSTONE_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(deepslate), Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> lapis = List.of(
                OreConfiguration.target(new TagMatchTest(stone), Blocks.LAPIS_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(deepslate), Blocks.DEEPSLATE_LAPIS_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> diamond = List.of(
                OreConfiguration.target(new TagMatchTest(stone), Blocks.DIAMOND_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(deepslate), Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> emerald = List.of(
                OreConfiguration.target(new TagMatchTest(stone), Blocks.EMERALD_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(deepslate), Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState())
        );

        OreConfiguration coalConfig = new OreConfiguration(
                coal,
                17,
                0.0f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_COAL, Feature.ORE, coalConfig);

        OreConfiguration coalBuriedConfig = new OreConfiguration(
                coal,
                17,
                0.5f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_COAL_BURIED, Feature.ORE, coalBuriedConfig);

        OreConfiguration copperLargeConfig = new OreConfiguration(
                copper,
                20,
                0.0f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_COPPER_LARGE, Feature.ORE, copperLargeConfig);

        OreConfiguration copperSmallConfig = new OreConfiguration(
                copper,
                10,
                0.0f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_COPPER_SMALL, Feature.ORE, copperSmallConfig);

        OreConfiguration ironConfig = new OreConfiguration(
                iron,
                9,
                0.0f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_IRON, Feature.ORE, ironConfig);

        OreConfiguration ironSmallConfig = new OreConfiguration(
                iron,
                4,
                0.0f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_IRON_SMALL, Feature.ORE, ironSmallConfig);

        OreConfiguration goldConfig = new OreConfiguration(
                gold,
                9,
                0.0f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_GOLD, Feature.ORE, goldConfig);

        OreConfiguration goldBuriedConfig = new OreConfiguration(
                gold,
                9,
                0.5f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_GOLD_BURIED, Feature.ORE, goldBuriedConfig);

        OreConfiguration redstoneConfig = new OreConfiguration(
                redstone,
                8,
                0.0f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_REDSTONE, Feature.ORE, redstoneConfig);

        OreConfiguration lapisConfig = new OreConfiguration(
                lapis,
                7,
                0.0f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_LAPIS, Feature.ORE, lapisConfig);

        OreConfiguration lapisBuriedConfig = new OreConfiguration(
                lapis,
                7,
                1.0f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_LAPIS_BURIED, Feature.ORE, lapisBuriedConfig);

        OreConfiguration diamondBuriedConfig = new OreConfiguration(
                diamond,
                8,
                1.0f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_DIAMOND_BURIED, Feature.ORE, diamondBuriedConfig);

        OreConfiguration diamondLargeConfig = new OreConfiguration(
                diamond,
                12,
                0.7f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_DIAMOND_LARGE, Feature.ORE, diamondLargeConfig);

        OreConfiguration diamondMediumConfig = new OreConfiguration(
                diamond,
                8,
                0.5f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_DIAMOND_MEDIUM, Feature.ORE, diamondMediumConfig);

        OreConfiguration diamondSmallConfig = new OreConfiguration(
                diamond,
                4,
                0.5f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_DIAMOND_SMALL, Feature.ORE, diamondSmallConfig);

        OreConfiguration emeraldConfig = new OreConfiguration(
                emerald,
                3,
                0.0f
        );
        FeatureUtils.register(context, UNDERGROUND_ORE_EMERALD, Feature.ORE, emeraldConfig);
    }


}