package com.thxlotl.cavernouslite.worldgen.features.config;

import com.thxlotl.cavernouslite.tag.ModBlockTags;
import com.thxlotl.cavernouslite.util.CFeatureUtil;
import com.thxlotl.cavernouslite.util.WeightedBlockState;
import com.thxlotl.cavernouslite.worldgen.features.ModConfiguredFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class BuriedJungleConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_POOL = ModConfiguredFeatures.registerKey("mud_pool");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_DRIPLEAF = ModConfiguredFeatures.registerKey("big_dripleaf");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_DRIPLEAF = ModConfiguredFeatures.registerKey("small_dripleaf");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE = ModConfiguredFeatures.registerKey("jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_TREE = ModConfiguredFeatures.registerKey("jungle_tree_red");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH = ModConfiguredFeatures.registerKey("jungle_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COARSE_DIRT_PATCH = ModConfiguredFeatures.registerKey("coarse_dirt_patch");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                 HolderGetter<ConfiguredFeature<?, ?>> holdergetter) {

        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);

        FeatureUtils.register(context, BIG_DRIPLEAF, Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfiguration(
                PlacementUtils.inlinePlaced(
                        Holder.direct(new ConfiguredFeature<>(Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfiguration(
                                dripleaf(Direction.NORTH),
                                dripleaf(Direction.SOUTH)
                        )))
                ),
                PlacementUtils.inlinePlaced(
                        Holder.direct(new ConfiguredFeature<>(Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfiguration(
                                dripleaf(Direction.EAST),
                                dripleaf(Direction.WEST)
                        )))
                )
        ));

        FeatureUtils.register(context, SMALL_DRIPLEAF, Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfiguration(
                PlacementUtils.inlinePlaced(
                        Holder.direct(new ConfiguredFeature<>(Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfiguration(
                                smallDripleaf(Direction.NORTH),
                                smallDripleaf(Direction.SOUTH)
                        )))
                ),
                PlacementUtils.inlinePlaced(
                        Holder.direct(new ConfiguredFeature<>(Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfiguration(
                                smallDripleaf(Direction.EAST),
                                smallDripleaf(Direction.WEST)
                        )))
                )
        ));

        FeatureUtils.register(context, MUD_POOL, Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(
                blocks.getOrThrow(ModBlockTags.MUD),
                SimpleStateProvider.simple(Blocks.MUD),
                PlacementUtils.inlinePlaced(
                        Holder.direct(new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                                List.of(
                                        new WeightedPlacedFeature(
                                                PlacementUtils.inlinePlaced(holdergetter.getOrThrow(BIG_DRIPLEAF)),
                                                0.3f
                                        )
                                ),
                                PlacementUtils.inlinePlaced(holdergetter.getOrThrow(SMALL_DRIPLEAF))
                        )))
                ),
                CaveSurface.FLOOR,
                ConstantInt.of(2),
                0.8f,
                5,
                0.35f,
                UniformInt.of(1, 2),
                0.55f
        ));



        FeatureUtils.register(context, TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                SimpleStateProvider.simple(Blocks.MANGROVE_LOG),
                new UpwardsBranchingTrunkPlacer(
                        3, 3, 6,
                        ConstantInt.of(1),
                        0,
                        ConstantInt.of(0),
                        blocks.getOrThrow(ModBlockTags.JUNGLE_BRANCH_CAN_GROW_THROUGH)
                ),
                SimpleStateProvider.simple(Blocks.AZALEA_LEAVES),
                new CherryFoliagePlacer(
                        ConstantInt.of(3),
                        ConstantInt.of(0),
                        ConstantInt.of(5),
                        0.001f,
                        0.2f,
                        0.55f,
                        0.5f
                ),
                new TwoLayersFeatureSize(0, 0, 0),
                SimpleStateProvider.simple(Blocks.MOSS_BLOCK.defaultBlockState())
        ).decorators(
                List.of(
                        new LeaveVineDecorator(0.2f),
                        new TrunkVineDecorator()
                )
        ).build());

        FeatureUtils.register(context, RED_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                SimpleStateProvider.simple(Blocks.STRIPPED_MANGROVE_LOG),
                new UpwardsBranchingTrunkPlacer(
                        4, 1, 5,
                        UniformInt.of(2, 5),
                        0.5f,
                        UniformInt.of(2, 5),
                        blocks.getOrThrow(ModBlockTags.JUNGLE_BRANCH_CAN_GROW_THROUGH)
                ),
                SimpleStateProvider.simple(Blocks.ACACIA_LEAVES),
                new CherryFoliagePlacer(
                        ConstantInt.of(2),
                        ConstantInt.of(1),
                        ConstantInt.of(4),
                        0.001f,
                        0.5f,
                        0.5f,
                        0.25f
                ),
                new TwoLayersFeatureSize(0, 0, 0),
                SimpleStateProvider.simple(Blocks.MOSS_BLOCK.defaultBlockState())
        ).build());

        FeatureUtils.register(context, PATCH, Feature.SIMPLE_BLOCK, CFeatureUtil.createWeightedState(
                new WeightedBlockState(Blocks.BUSH.defaultBlockState(), 10),
                new WeightedBlockState(Blocks.FERN.defaultBlockState(), 4)
        ));

        FeatureUtils.register(context, COARSE_DIRT_PATCH, Feature.VEGETATION_PATCH, CFeatureUtil.createSurfaceVegetationPatch(
                blocks.getOrThrow(ModBlockTags.MOSS_BLOCK),
                Blocks.COARSE_DIRT,
                2, 3
        ));
    }


    // Helper

    private static Holder<PlacedFeature> dripleaf(Direction direction) {

        BlockColumnConfiguration config = new BlockColumnConfiguration(
                List.of(
                        BlockColumnConfiguration.layer(BiasedToBottomInt.of(1, 8), SimpleStateProvider.simple(Blocks.BIG_DRIPLEAF_STEM.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, direction))),
                        BlockColumnConfiguration.layer(ConstantInt.of(1), SimpleStateProvider.simple(Blocks.BIG_DRIPLEAF.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, direction)))
                ),
                Direction.UP,
                BlockPredicate.matchesBlocks(Blocks.AIR, Blocks.WATER),
                true);

        return PlacementUtils.inlinePlaced(Holder.direct(new ConfiguredFeature<>(Feature.BLOCK_COLUMN, config)));
    }

    private static Holder<PlacedFeature> smallDripleaf(Direction direction) {

        SimpleBlockConfiguration config = new SimpleBlockConfiguration(
                SimpleStateProvider.simple(Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, direction))
        );

        return PlacementUtils.inlinePlaced(Holder.direct(new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, config)));
    }


}
