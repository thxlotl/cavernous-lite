package com.thxlotl.cavernouslite.datagen;

import com.thxlotl.cavernouslite.CavernousLite;
import com.thxlotl.cavernouslite.tag.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, CavernousLite.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModBlockTags.MOSS_BLOCK).add(Blocks.MOSS_BLOCK);
        tag(ModBlockTags.MYCELIUM).add(Blocks.MYCELIUM);
        tag(ModBlockTags.MAGMA).add(Blocks.MAGMA_BLOCK);
        tag(ModBlockTags.AMETHYST).add(Blocks.AMETHYST_BLOCK, Blocks.BUDDING_AMETHYST);

        tag(ModBlockTags.STONE_ORE_REPLACEABLE_UNDERGROUND).add(
                Blocks.PACKED_MUD, Blocks.MOSS_BLOCK, Blocks.MYCELIUM, Blocks.TERRACOTTA, Blocks.RED_SANDSTONE, Blocks.ORANGE_TERRACOTTA, Blocks.PACKED_ICE, Blocks.BLUE_ICE
        ).addTag(BlockTags.STONE_ORE_REPLACEABLES);

        tag(ModBlockTags.DEEPSLATE_ORE_REPLACEABLE_UNDERGROUND).add(
                Blocks.BASALT, Blocks.BLACKSTONE
        ).addTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES).add(
            Blocks.MOSS_BLOCK, Blocks.MYCELIUM, Blocks.PACKED_MUD, Blocks.BLACKSTONE, Blocks.BASALT, Blocks.SMOOTH_BASALT, Blocks.MAGMA_BLOCK, Blocks.AMETHYST_BLOCK, Blocks.CALCITE, Blocks.TERRACOTTA, Blocks.RED_SANDSTONE, Blocks.ORANGE_TERRACOTTA,
                Blocks.PACKED_ICE, Blocks.BLUE_ICE
        );

    }
}
