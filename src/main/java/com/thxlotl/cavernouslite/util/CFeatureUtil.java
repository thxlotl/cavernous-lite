package com.thxlotl.cavernouslite.util;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class CFeatureUtil {

    public static SimpleBlockConfiguration createWeightedState(WeightedBlockState... weightedBlockStates){

        WeightedList.Builder<BlockState> listBuilder = WeightedList.builder();
        for (WeightedBlockState wbs : weightedBlockStates) {
            listBuilder.add(wbs.state, wbs.weight);
        }
        return new SimpleBlockConfiguration(new WeightedStateProvider(listBuilder), true);

    }

    public static VegetationPatchConfiguration createSurfaceVegetationPatch(HolderGetter<ConfiguredFeature<?, ?>> holdergetter,
                                                                            TagKey<Block> tag,
                                                                            Block block,
                                                                            ResourceKey<ConfiguredFeature<?, ?>> featureKey,
                                                                            float vegChance,
                                                                            int rMin, int rMax) {
        return new VegetationPatchConfiguration(
                tag,
                BlockStateProvider.simple(block),
                PlacementUtils.inlinePlaced(holdergetter.getOrThrow(featureKey),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.SHORT_GRASS.defaultBlockState(), Vec3i.ZERO)),
                        BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Blocks.AIR)
                        )),
                CaveSurface.FLOOR,
                ConstantInt.of(1),
                0f,
                6,
                vegChance,
                UniformInt.of(rMin, rMax),
                0.75f);
    }

}
