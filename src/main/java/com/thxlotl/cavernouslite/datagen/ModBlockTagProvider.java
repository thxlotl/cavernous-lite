package com.thxlotl.cavernouslite.datagen;

import com.thxlotl.cavernouslite.CavernousLite;
import com.thxlotl.cavernouslite.tag.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, CavernousLite.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModBlockTags.MOSS_BLOCK)
                .add(Blocks.MOSS_BLOCK);
        tag(ModBlockTags.MYCELIUM)
                .add(Blocks.MYCELIUM);

    }
}
