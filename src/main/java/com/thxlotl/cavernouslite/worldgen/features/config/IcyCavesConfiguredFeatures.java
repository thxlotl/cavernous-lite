package com.thxlotl.cavernouslite.worldgen.features.config;

import com.thxlotl.cavernouslite.tag.ModBlockTags;
import com.thxlotl.cavernouslite.util.CFeatureUtil;
import com.thxlotl.cavernouslite.util.WeightedBlockState;
import com.thxlotl.cavernouslite.worldgen.features.ModConfiguredFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class IcyCavesConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ICE_PILLAR = ModConfiguredFeatures.registerKey("ice_pillar");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIAMOND_EXTRA = ModConfiguredFeatures.registerKey("diamond_extra_icy");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        FeatureUtils.register(context, ICE_PILLAR, Feature.BLOCK_COLUMN, new BlockColumnConfiguration(
                List.of(
                        BlockColumnConfiguration.layer(UniformInt.of(3, 5), BlockStateProvider.simple(Blocks.BLUE_ICE)),
                        BlockColumnConfiguration.layer(BiasedToBottomInt.of(2, 3), BlockStateProvider.simple(Blocks.PACKED_ICE)),
                        BlockColumnConfiguration.layer(BiasedToBottomInt.of(20, 25), BlockStateProvider.simple(Blocks.ICE))
                ),
                Direction.DOWN,
                BlockPredicate.matchesBlocks(new Vec3i(0, 0, 0), Blocks.AIR, Blocks.WATER, Blocks.ICE),
                false
        ));


        FeatureUtils.register(context, DIAMOND_EXTRA, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new TagMatchTest(ModBlockTags.STONE_ORE_REPLACEABLE_UNDERGROUND), Blocks.DIAMOND_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(ModBlockTags.DEEPSLATE_ORE_REPLACEABLE_UNDERGROUND), Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())
                ),
                5,
                1f
        ));
    }

}
