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
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;

import java.util.List;

public class FungalCavesConfiguredFeatures {

    // Static block state references
    private static final BlockState mossCarpet = Blocks.MOSS_CARPET.defaultBlockState();
    private static final BlockState shortGrass = Blocks.SHORT_GRASS.defaultBlockState();
    private static final BlockState shortFern = Blocks.FERN.defaultBlockState();
    private static final BlockState brownMushroom = Blocks.BROWN_MUSHROOM.defaultBlockState();
    private static final BlockState redMushroom = Blocks.RED_MUSHROOM.defaultBlockState();
    private static final BlockState crimsonFungus = Blocks.CRIMSON_FUNGUS.defaultBlockState();
    private static final BlockState crimsonRoots = Blocks.CRIMSON_ROOTS.defaultBlockState();
    private static final BlockState warpedRoots = Blocks.WARPED_ROOTS.defaultBlockState();

    // Features
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOSS_VEGETATION = ModConfiguredFeatures.registerKey("fungal_moss_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOSS_PATCH = ModConfiguredFeatures.registerKey("fungal_moss_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MYCELIUM_VEGETATION = ModConfiguredFeatures.registerKey("fungal_mycelium_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MYCELIUM_PATCH = ModConfiguredFeatures.registerKey("fungal_mycelium_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_1 = ModConfiguredFeatures.registerKey("fungal_tree_brown_1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_1 = ModConfiguredFeatures.registerKey("fungal_tree_red_1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_2 = ModConfiguredFeatures.registerKey("fungal_tree_brown_2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_2 = ModConfiguredFeatures.registerKey("fungal_tree_red_2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWSHROOM = ModConfiguredFeatures.registerKey("glowshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLIPPED_SHROOM_CAP = ModConfiguredFeatures.registerKey("flipped_shroom_cap");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLIPPED_SHROOM_STEM = ModConfiguredFeatures.registerKey("flipped_shroom_stem");

    // Register features here
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                 HolderGetter<ConfiguredFeature<?, ?>> holdergetter) {

        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);

        // Moss Stuff
        FeatureUtils.register(context, MOSS_VEGETATION, Feature.SIMPLE_BLOCK, CFeatureUtil.createWeightedState(
                new WeightedBlockState(mossCarpet, 2),
                new WeightedBlockState(shortFern, 2),
                new WeightedBlockState(shortGrass, 12),
                new WeightedBlockState(redMushroom, 2),
                new WeightedBlockState(brownMushroom, 2)
        ));

        FeatureUtils.register(context, MOSS_PATCH, Feature.VEGETATION_PATCH, CFeatureUtil.createSurfaceVegetationPatch(
                holdergetter,
                blocks.getOrThrow(ModBlockTags.MOSS_BLOCK),
                Blocks.MOSS_BLOCK,
                MOSS_VEGETATION,
                0.5f,
                2, 3
        ));

        // Mycelium Stuff
        FeatureUtils.register(context, MYCELIUM_VEGETATION, Feature.SIMPLE_BLOCK, CFeatureUtil.createWeightedState(
                new WeightedBlockState(warpedRoots, 3),
                new WeightedBlockState(crimsonFungus, 3),
                new WeightedBlockState(crimsonRoots, 20)
        ));

        FeatureUtils.register(context, MYCELIUM_PATCH, Feature.VEGETATION_PATCH, CFeatureUtil.createSurfaceVegetationPatch(
                holdergetter,
                blocks.getOrThrow(ModBlockTags.MYCELIUM),
                Blocks.MYCELIUM,
                MYCELIUM_VEGETATION,
                0.1f,
                2, 4
        ));

        // Giant Mushrooms
        FeatureUtils.register(context, BROWN_1, Feature.TREE, CFeatureUtil.createForkingMushroom(Blocks.BROWN_MUSHROOM_BLOCK));
        FeatureUtils.register(context, RED_1, Feature.TREE, CFeatureUtil.createForkingMushroom(Blocks.RED_MUSHROOM_BLOCK));
        FeatureUtils.register(context, BROWN_2, Feature.TREE, CFeatureUtil.createCherryTrunkMushroom(Blocks.BROWN_MUSHROOM_BLOCK));
        FeatureUtils.register(context, RED_2, Feature.TREE, CFeatureUtil.createCherryTrunkMushroom(Blocks.RED_MUSHROOM_BLOCK));
        FeatureUtils.register(context, GLOWSHROOM, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                SimpleStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState()),
                new StraightTrunkPlacer(4, 1, 4),
                SimpleStateProvider.simple(Blocks.SHROOMLIGHT.defaultBlockState()),
                new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                new TwoLayersFeatureSize(0, 0, 0),
                SimpleStateProvider.simple(Blocks.MOSS_BLOCK.defaultBlockState())
                ).ignoreVines().build()
        );

        FeatureUtils.register(context, FLIPPED_SHROOM_CAP, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(Blocks.BROWN_MUSHROOM_BLOCK)));
//        FeatureUtils.register(context, FLIPPED_SHROOM_CAP, Feature.RANDOM_PATCH, new RandomPatchConfiguration(200, 2, 1, PlacementUtils.inlinePlaced(
//                Holder.direct(new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(Blocks.BROWN_MUSHROOM_BLOCK)))),
//                BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
//                        BlockPredicate.matchesBlocks(Vec3i.ZERO, Blocks.AIR),
//                        BlockPredicate.anyOf(
//                                BlockPredicate.matchesBlocks(new Vec3i(-1, 0, 2), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(0, 0, 2), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(1, 0, 2), Blocks.RED_CONCRETE),
//
//                                BlockPredicate.matchesBlocks(new Vec3i(-2, 0, 1), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(-1, 0, 1), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(0, 0, 1), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(1, 0, 1), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(2, 0, 1), Blocks.RED_CONCRETE),
//
//                                BlockPredicate.matchesBlocks(new Vec3i(-2, 0, 0), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(-1, 0, 0), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(1, 0, 0), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(2, 0, 0), Blocks.RED_CONCRETE),
//
//                                BlockPredicate.matchesBlocks(new Vec3i(-2, 0, -1), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(-1, 0, -1), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(0, 0, -1), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(1, 0, -1), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(2, 0, -1), Blocks.RED_CONCRETE),
//
//                                BlockPredicate.matchesBlocks(new Vec3i(-1, 0, -2), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(0, 0, -2), Blocks.RED_CONCRETE),
//                                BlockPredicate.matchesBlocks(new Vec3i(1, 0, -2), Blocks.RED_CONCRETE)
//                        )
//                ))
//        )));
        FeatureUtils.register(context, FLIPPED_SHROOM_STEM, Feature.BLOCK_COLUMN, new BlockColumnConfiguration(
                List.of(
                        new BlockColumnConfiguration.Layer(UniformInt.of(4, 10), SimpleStateProvider.simple(Blocks.MUSHROOM_STEM)),
                        new BlockColumnConfiguration.Layer(ConstantInt.of(1), SimpleStateProvider.simple(Blocks.CONCRETE.red()))
                ),
                Direction.DOWN,
                BlockPredicate.allOf(
                        BlockPredicate.matchesBlocks(new Vec3i(0, 0, 0), Blocks.AIR),
                        BlockPredicate.matchesBlocks(new Vec3i(-1, -2, -1), Blocks.AIR),
                        BlockPredicate.matchesBlocks(new Vec3i(-1, -2, 1), Blocks.AIR),
                        BlockPredicate.matchesBlocks(new Vec3i(1, -2, 1), Blocks.AIR),
                        BlockPredicate.matchesBlocks(new Vec3i(1, -2, -1), Blocks.AIR)
                ),
                true
        ));
    }

}
