package com.thxlotl.cavernouslite.worldgen.features.config;

import com.thxlotl.cavernouslite.tag.ModBlockTags;
import com.thxlotl.cavernouslite.util.CFeatureUtil;
import com.thxlotl.cavernouslite.util.WeightedBlockState;
import com.thxlotl.cavernouslite.worldgen.features.ModConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class CrystalCavesConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUD_UP = ModConfiguredFeatures.registerKey("bud_up");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUD_DOWN = ModConfiguredFeatures.registerKey("bud_down");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUD_NORTH = ModConfiguredFeatures.registerKey("bud_north");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUD_EAST  = ModConfiguredFeatures.registerKey("bud_east");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUD_SOUTH = ModConfiguredFeatures.registerKey("bud_south");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUD_WEST  = ModConfiguredFeatures.registerKey("bud_west");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_GEODE  = ModConfiguredFeatures.registerKey("big_geode");

    public static final BlockState smallBud = Blocks.SMALL_AMETHYST_BUD.defaultBlockState();
    public static final BlockState medBud = Blocks.MEDIUM_AMETHYST_BUD.defaultBlockState();
    public static final BlockState largeBud = Blocks.LARGE_AMETHYST_BUD.defaultBlockState();
    public static final BlockState cluster = Blocks.AMETHYST_CLUSTER.defaultBlockState();

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        registerCrystalFeature(context, BUD_UP, Direction.UP);
        registerCrystalFeature(context, BUD_DOWN, Direction.DOWN);
        registerCrystalFeature(context, BUD_NORTH, Direction.NORTH);
        registerCrystalFeature(context, BUD_EAST, Direction.EAST);
        registerCrystalFeature(context, BUD_SOUTH, Direction.SOUTH);
        registerCrystalFeature(context, BUD_WEST, Direction.WEST);

        FeatureUtils.register(context, BIG_GEODE, Feature.GEODE, new GeodeConfiguration(
                new GeodeBlockSettings(
                        SimpleStateProvider.simple(Blocks.AIR),
                        SimpleStateProvider.simple(Blocks.AMETHYST_BLOCK),
                        SimpleStateProvider.simple(Blocks.BUDDING_AMETHYST),
                        SimpleStateProvider.simple(Blocks.CALCITE),
                        SimpleStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(
                                smallBud,
                                medBud,
                                largeBud,
                                cluster
                        ),
                        BlockTags.FEATURES_CANNOT_REPLACE,
                        BlockTags.GEODE_INVALID_BLOCKS
                ),
                new GeodeLayerSettings(2.55, 3.3, 4.8, 6.3),
                new GeodeCrackSettings(0.95, 3, 2),
                0.4f,
                0.09f,
                true,
                UniformInt.of(5, 6),
                UniformInt.of(3, 4),
                UniformInt.of(1, 2),
                -16,
                16,
                0.05,
                1
        ));

    }

    private static void registerCrystalFeature(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, Direction direction) {

        BlockPos pos = BlockPos.ZERO.relative(direction.getOpposite());
        Vec3i amethystPos = new Vec3i(pos.getX(), pos.getY(), pos.getZ());

        FeatureUtils.register(context, key, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                50,
                8,
                3,
                PlacementUtils.inlinePlaced(Holder.direct(new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, CFeatureUtil.createWeightedState(
                                new WeightedBlockState(smallBud.setValue(BlockStateProperties.FACING, direction), 5),
                                new WeightedBlockState(medBud.setValue(BlockStateProperties.FACING, direction), 4),
                                new WeightedBlockState(largeBud.setValue(BlockStateProperties.FACING, direction), 3),
                                new WeightedBlockState(cluster.setValue(BlockStateProperties.FACING, direction), 2)
                        ))),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                                BlockPredicate.wouldSurvive(cluster.setValue(BlockStateProperties.FACING, direction), Vec3i.ZERO),
                                BlockPredicate.matchesBlocks(Blocks.AIR),
                                BlockPredicate.matchesTag(amethystPos, ModBlockTags.AMETHYST)
                        ))
        )));
    }

}
