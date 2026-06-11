package com.thxlotl.cavernouslite.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeTags {

    public static final TagKey<Biome> CAVES = createTag("caves");
    public static final TagKey<Biome> COLD_CAVES = createTag("cold_caves");
    public static final TagKey<Biome> TEMPERATE_CAVES = createTag("temperate_caves");
    public static final TagKey<Biome> HOT_CAVES = createTag("hot_caves");


    private static TagKey<Biome> createTag(String name) {
        return TagKey.create(Registries.BIOME, Identifier.withDefaultNamespace(name));
    }
}
