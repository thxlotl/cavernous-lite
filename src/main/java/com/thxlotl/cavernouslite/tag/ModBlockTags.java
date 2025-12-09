package com.thxlotl.cavernouslite.tag;

import com.thxlotl.cavernouslite.CavernousLite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {

    public static final TagKey<Block> MOSS_BLOCK = createTag("moss_block");
    public static final TagKey<Block> MYCELIUM = createTag("mycelium");

    private static TagKey<net.minecraft.world.level.block.Block> createTag(String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CavernousLite.MODID, name));
    }
}
