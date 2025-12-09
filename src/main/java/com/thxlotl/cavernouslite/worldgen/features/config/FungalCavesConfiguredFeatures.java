package com.thxlotl.cavernouslite.worldgen.features.config;

import com.thxlotl.cavernouslite.tag.ModBlockTags;
import com.thxlotl.cavernouslite.util.CFeatureUtil;
import com.thxlotl.cavernouslite.util.WeightedBlockState;
import com.thxlotl.cavernouslite.worldgen.features.ModConfiguredFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;

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

    // Register features here
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                 HolderGetter<ConfiguredFeature<?, ?>> holdergetter) {

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
                ModBlockTags.MOSS_BLOCK,
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
                ModBlockTags.MYCELIUM,
                Blocks.MYCELIUM,
                MYCELIUM_VEGETATION,
                0.5f,
                2, 4
        ));

    }

}
