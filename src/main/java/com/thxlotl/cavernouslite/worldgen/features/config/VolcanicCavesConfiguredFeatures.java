package com.thxlotl.cavernouslite.worldgen.features.config;

import com.thxlotl.cavernouslite.tag.ModBlockTags;
import com.thxlotl.cavernouslite.worldgen.features.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class VolcanicCavesConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> LAVA_POOL = ModConfiguredFeatures.registerKey("lava_pool");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIAMOND_EXTRA = ModConfiguredFeatures.registerKey("diamond_extra");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCORCHED_TREE = ModConfiguredFeatures.registerKey("scorched_tree");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {


        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);

        FeatureUtils.register(context, LAVA_POOL, Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(
                blocks.getOrThrow(ModBlockTags.MAGMA),
                SimpleStateProvider.simple(Blocks.MAGMA_BLOCK),
                PlacementUtils.inlinePlaced(
                        Holder.direct(new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(Blocks.LAVA))))
                ),
                CaveSurface.FLOOR,
                ConstantInt.of(1),
                0,
                5,
                1f,
                UniformInt.of(2, 6),
                0.35f
        ));

        FeatureUtils.register(context, DIAMOND_EXTRA, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new TagMatchTest(ModBlockTags.STONE_ORE_REPLACEABLE_UNDERGROUND), Blocks.DIAMOND_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(ModBlockTags.DEEPSLATE_ORE_REPLACEABLE_UNDERGROUND), Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())
                ),
                4,
                0.1f
        ));

        FeatureUtils.register(context, SCORCHED_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                SimpleStateProvider.simple(Blocks.BASALT),
                new ForkingTrunkPlacer(4, 1, 1),
                SimpleStateProvider.simple(Blocks.AIR),
                new RandomSpreadFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), ConstantInt.of(1), 0),
                new TwoLayersFeatureSize(0, 0, 0),
                SimpleStateProvider.simple(Blocks.BASALT)
            ).belowTrunkProvider(BlockStateProvider.simple(Blocks.BASALT)).ignoreVines().build()
        );

    }

}
