package com.thxlotl.cavernouslite.datagen;

import com.thxlotl.cavernouslite.CavernousLite;
import com.thxlotl.cavernouslite.tag.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.internal.NeoForgeBlockTagsProvider;

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
        tag(ModBlockTags.MUD).add(Blocks.MUD);
        tag(ModBlockTags.JUNGLE_BRANCH_CAN_GROW_THROUGH).add(Blocks.AZALEA_LEAVES, Blocks.AIR, Blocks.ACACIA_LEAVES);
        tag(ModBlockTags.AMETHYST).add(Blocks.AMETHYST_BLOCK, Blocks.BUDDING_AMETHYST);

        tag(ModBlockTags.STONE_ORE_REPLACEABLE_UNDERGROUND).add(
                Blocks.PACKED_MUD, Blocks.MOSS_BLOCK, Blocks.MYCELIUM, Blocks.TERRACOTTA, Blocks.RED_SANDSTONE, Blocks.DYED_TERRACOTTA.orange(), Blocks.PACKED_ICE, Blocks.BLUE_ICE
        ).addTag(BlockTags.STONE_ORE_REPLACEABLES);

        tag(ModBlockTags.DEEPSLATE_ORE_REPLACEABLE_UNDERGROUND).add(
                Blocks.BASALT, Blocks.BLACKSTONE, Blocks.MUD
        ).addTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES).add(
            Blocks.MOSS_BLOCK, Blocks.MYCELIUM, Blocks.PACKED_MUD, Blocks.BLACKSTONE, Blocks.BASALT, Blocks.SMOOTH_BASALT, Blocks.MAGMA_BLOCK, Blocks.AMETHYST_BLOCK, Blocks.CALCITE, Blocks.TERRACOTTA, Blocks.RED_SANDSTONE, Blocks.DYED_TERRACOTTA.orange(),
                Blocks.PACKED_ICE, Blocks.BLUE_ICE
        );

    }

    protected record Appender(TagAppender<Block> app) implements TagAppender<Block> {
        @Override
        public Appender add(ResourceKey<Block> element) {
            app.add(element);
            return this;
        }

        @Override
        public Appender addOptional(ResourceKey<Block> element) {
            app.addOptional(element);
            return this;
        }

        @Override
        public Appender addTag(TagKey<Block> tag) {
            app.addTag(tag);
            return this;
        }

        @Override
        public Appender addOptionalTag(TagKey<Block> tag) {
            app.addOptionalTag(tag);
            return this;
        }

        @Override
        public Appender add(TagEntry entry) {
            app.add(entry);
            return this;
        }

        @Override
        public Appender replace(boolean value) {
            app.replace(value);
            return this;
        }

        @Override
        public Appender remove(ResourceKey<Block> element) {
            app.remove(element);
            return this;
        }

        @Override
        public Appender remove(TagKey<Block> tag) {
            app.remove(tag);
            return this;
        }

        public Appender add(Block... blocks) {
            for (Block block : blocks) {
                add(BuiltInRegistries.BLOCK.wrapAsHolder(block).getKey());
            }
            return this;
        }

        public Appender addAll(Iterable<Block> blocks) {
            for (Block block : blocks) {
                add(block);
            }
            return this;
        }
    }

    @Override
    protected Appender tag(TagKey<Block> tag) {
        return new Appender(super.tag(tag));
    }

}
