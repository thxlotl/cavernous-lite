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
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
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

public class AridCavesConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH = ModConfiguredFeatures.registerKey("arid_vegetation_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOODOO_1 = ModConfiguredFeatures.registerKey("hoodoo_1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOODOO_2 = ModConfiguredFeatures.registerKey("hoodoo_2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_DEAD_BUSH = ModConfiguredFeatures.registerKey("giant_dead_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLD_EXTRA = ModConfiguredFeatures.registerKey("gold_extra");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        FeatureUtils.register(context, GOLD_EXTRA, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new TagMatchTest(ModBlockTags.STONE_ORE_REPLACEABLE_UNDERGROUND), Blocks.GOLD_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(ModBlockTags.DEEPSLATE_ORE_REPLACEABLE_UNDERGROUND), Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState())
                ),
                9,
                0f
        ));

        FeatureUtils.register(context, PATCH, Feature.SIMPLE_BLOCK, CFeatureUtil.createWeightedState(
                new WeightedBlockState(Blocks.SHORT_DRY_GRASS.defaultBlockState(), 20),
                new WeightedBlockState(Blocks.TALL_DRY_GRASS.defaultBlockState(), 5),
                new WeightedBlockState(Blocks.DEAD_BUSH.defaultBlockState(), 1)
        ));

        FeatureUtils.register(context, HOODOO_1, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        SimpleStateProvider.simple(Blocks.TERRACOTTA),
                        new GiantTrunkPlacer(2, 4, 0),
                        SimpleStateProvider.simple(Blocks.RED_SANDSTONE),
                        new FancyFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0), 1),
                        new TwoLayersFeatureSize(0, 0, 0),
                    SimpleStateProvider.simple(Blocks.TERRACOTTA)
                )
                .belowTrunkProvider(BlockStateProvider.simple(Blocks.TERRACOTTA))
                .decorators(
                        List.of(
                                new AttachedToLeavesDecorator(
                                        1,
                                        0,
                                        0,
                                        BlockStateProvider.simple(Blocks.SAND),
                                        1,
                                        List.of(
                                                Direction.UP
                                        )
                                )
                        )
                )
                .ignoreVines()
                .build()
        );

        FeatureUtils.register(context, HOODOO_2, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        SimpleStateProvider.simple(Blocks.TERRACOTTA),
                        new StraightTrunkPlacer(2, 3, 0),
                        SimpleStateProvider.simple(Blocks.RED_SANDSTONE),
                        new RandomSpreadFoliagePlacer(
                                ConstantInt.of(1),
                                ConstantInt.of(0),
                                UniformInt.of(1, 2),
                                256),
                        new TwoLayersFeatureSize(0, 0, 0),
                SimpleStateProvider.simple(Blocks.TERRACOTTA)
                )
                .belowTrunkProvider(BlockStateProvider.simple(Blocks.TERRACOTTA))
                        .decorators(
                                List.of(
                                        new AttachedToLeavesDecorator(
                                                1,
                                                0,
                                                0,
                                                BlockStateProvider.simple(Blocks.SAND),
                                                1,
                                                List.of(
                                                        Direction.UP
                                                )
                                        )
                                )
                        )
                        .ignoreVines().build()
        );

        HolderGetter<Block> holdergetter = context.lookup(Registries.BLOCK);

        FeatureUtils.register(context, GIANT_DEAD_BUSH, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        SimpleStateProvider.simple(Blocks.OAK_WOOD),
                        new UpwardsBranchingTrunkPlacer(
                                5,
                                3,
                                0,
                                UniformInt.of(3, 4),
                                0.5f,
                                UniformInt.of(3, 4),
                                holdergetter.getOrThrow(BlockTags.AIR)
                        ),
                        SimpleStateProvider.simple(Blocks.AIR),
                        new AcaciaFoliagePlacer(
                                ConstantInt.of(0), ConstantInt.of(0)
                        ),
                        new TwoLayersFeatureSize(0, 0, 0),
                        SimpleStateProvider.simple(Blocks.SAND)
                )
                .ignoreVines()
                .build()
        );


    }

}
