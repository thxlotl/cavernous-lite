package com.thxlotl.cavernouslite.worldgen.biome;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class BiolithBiomePlacement {

    static ResourceLocation overworldRules = ResourceLocation.fromNamespaceAndPath("minecraft", "rules/overworld");

    public static void createBiomePlacementsAndSurfaceRules() {

        BiomePlacement.addOverworld(ModBiomes.FUNGAL_CAVES, ClimateParameters.FUNGAL_CAVES);
        addSurfaceRule(BiomeSurfaceRules.fungalRules());

    }

    private static void addSurfaceRule(SurfaceRules.RuleSource ruleSource) {
        SurfaceGeneration.addOverworldSurfaceRules(overworldRules, ruleSource);
    }
}
