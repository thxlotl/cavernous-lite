package com.thxlotl.cavernouslite.worldgen.biome.terrablender;

import com.thxlotl.cavernouslite.worldgen.biome.BiomeSurfaceRules;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class SurfaceRuleData {

    public static SurfaceRules.RuleSource overworld(HolderGetter<Biome> biomes) {

        SurfaceRules.RuleSource rules = createOverworldSurfaceRules(biomes);

        return rules;
    }

    private static SurfaceRules.RuleSource createOverworldSurfaceRules(HolderGetter<Biome> biomes) {

        return SurfaceRules.sequence(
                BiomeSurfaceRules.fungalRules(biomes),
                BiomeSurfaceRules.crystalRules(biomes),
                BiomeSurfaceRules.aridRules(biomes),
                BiomeSurfaceRules.jungleRules(biomes),
                BiomeSurfaceRules.marbledRules(biomes),
                BiomeSurfaceRules.volcanicRules(biomes),
                BiomeSurfaceRules.icyRules(biomes)
        );
    }
}
