package com.thxlotl.cavernouslite.datagen;

import com.thxlotl.cavernouslite.tag.ModBiomeTags;
import com.thxlotl.cavernouslite.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagsProvider extends BiomeTagsProvider {
    public ModBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        // Cavernous Tags
        tag(ModBiomeTags.CAVES).add(
                ModBiomes.BURIED_JUNGLE,
                ModBiomes.ARID_CAVES,
                ModBiomes.MARBLED_CAVES,
                ModBiomes.CRYSTAL_CAVES,
                ModBiomes.FUNGAL_CAVES,
                ModBiomes.ICY_CAVES,
                ModBiomes.LUSH_DRIPSTONE_CAVES,
                ModBiomes.VOLCANIC_CAVES
        );
        tag(ModBiomeTags.COLD_CAVES).add(
                ModBiomes.ICY_CAVES
        );
        tag(ModBiomeTags.TEMPERATE_CAVES).add(
                ModBiomes.MARBLED_CAVES,
                ModBiomes.CRYSTAL_CAVES,
                ModBiomes.FUNGAL_CAVES,
                ModBiomes.LUSH_DRIPSTONE_CAVES
        );
        tag(ModBiomeTags.HOT_CAVES).add(
                ModBiomes.BURIED_JUNGLE,
                ModBiomes.ARID_CAVES,
                ModBiomes.VOLCANIC_CAVES
        );

        // Minecraft Tags
        tag(BiomeTags.IS_OVERWORLD).addTag(ModBiomeTags.CAVES);
        tag(BiomeTags.ALLOWS_TROPICAL_FISH_SPAWNS_AT_ANY_HEIGHT).add(ModBiomes.LUSH_DRIPSTONE_CAVES);
        tag(BiomeTags.HAS_MINESHAFT).add(
                ModBiomes.LUSH_DRIPSTONE_CAVES,
                ModBiomes.FUNGAL_CAVES,
                ModBiomes.ICY_CAVES,
                ModBiomes.BURIED_JUNGLE,
                ModBiomes.MARBLED_CAVES
                );
        tag(BiomeTags.HAS_MINESHAFT_MESA).add(ModBiomes.ARID_CAVES);
        tag(BiomeTags.HAS_STRONGHOLD).addTag(ModBiomeTags.CAVES);
        tag(BiomeTags.HAS_TRIAL_CHAMBERS).addTag(ModBiomeTags.CAVES);
        tag(BiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS).addTag(ModBiomeTags.COLD_CAVES);
        tag(BiomeTags.SPAWNS_COLD_VARIANT_FROGS).addTag(ModBiomeTags.COLD_CAVES);
        tag(BiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS).addTag(ModBiomeTags.HOT_CAVES);
        tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).addTag(ModBiomeTags.HOT_CAVES);


    }
}
