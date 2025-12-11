package com.thxlotl.cavernouslite.worldgen.biome;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class BiolithBiomePlacement {

    static ResourceLocation overworldRules = ResourceLocation.fromNamespaceAndPath("minecraft", "rules/overworld");

    public static void createBiomePlacementsAndSurfaceRules() {

        BiomePlacement.addOverworld(ModBiomes.ARID_CAVES, ClimateParameters.ARID_CAVES);
        addSurfaceRule(BiomeSurfaceRules.aridRules());

        BiomePlacement.addOverworld(ModBiomes.FUNGAL_CAVES, ClimateParameters.FUNGAL_CAVES);
        addSurfaceRule(BiomeSurfaceRules.fungalRules());

        BiomePlacement.addOverworld(ModBiomes.VOLCANIC_CAVES, ClimateParameters.VOLCANIC_CAVES);
        addSurfaceRule(BiomeSurfaceRules.volcanicRules());

        BiomePlacement.addOverworld(ModBiomes.CRYSTAL_CAVES, ClimateParameters.CRYSTAL_CAVES);
        addSurfaceRule(BiomeSurfaceRules.crystalRules());

        BiomePlacement.addOverworld(ModBiomes.LUSH_DRIPSTONE_CAVES, ClimateParameters.LUSH_DRIPSTONE_CAVES);

        BiomePlacement.addOverworld(ModBiomes.MARBLED_CAVES, ClimateParameters.MARBLED_CAVES);
        addSurfaceRule(BiomeSurfaceRules.marbledRules());

        BiomePlacement.addOverworld(ModBiomes.ICY_CAVES, ClimateParameters.ICY_CAVES);
        addSurfaceRule(BiomeSurfaceRules.icyRules());

    }

    private static void addSurfaceRule(SurfaceRules.RuleSource ruleSource) {
        SurfaceGeneration.addOverworldSurfaceRules(overworldRules, ruleSource);
    }
}
