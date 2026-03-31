package com.thxlotl.cavernouslite.worldgen.biome;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.SurfaceRules;

import java.util.List;

public class BiolithBiomePlacement {

    static Identifier overworldRules = Identifier.fromNamespaceAndPath("minecraft", "rules/overworld");

    public static void createBiomePlacementsAndSurfaceRules() {

        addClimateParameterList(ModBiomes.ARID_CAVES, ClimateParameters.ARID_CAVES);
        addSurfaceRule(BiomeSurfaceRules.aridRules());

        addClimateParameterList(ModBiomes.FUNGAL_CAVES, ClimateParameters.FUNGAL_CAVES);
        addSurfaceRule(BiomeSurfaceRules.fungalRules());

        addClimateParameterList(ModBiomes.VOLCANIC_CAVES, ClimateParameters.VOLCANIC_CAVES);
        addSurfaceRule(BiomeSurfaceRules.volcanicRules());

        addClimateParameterList(ModBiomes.CRYSTAL_CAVES, ClimateParameters.CRYSTAL_CAVES);
        addSurfaceRule(BiomeSurfaceRules.crystalRules());

        addClimateParameterList(ModBiomes.LUSH_DRIPSTONE_CAVES, ClimateParameters.LUSH_DRIPSTONE_CAVES);

        addClimateParameterList(ModBiomes.MARBLED_CAVES, ClimateParameters.MARBLED_CAVES);
        addSurfaceRule(BiomeSurfaceRules.marbledRules());

        addClimateParameterList(ModBiomes.ICY_CAVES, ClimateParameters.ICY_CAVES);
        addSurfaceRule(BiomeSurfaceRules.icyRules());

        addClimateParameterList(ModBiomes.BURIED_JUNGLE, ClimateParameters.BURIED_JUNGLE);
        addSurfaceRule(BiomeSurfaceRules.jungleRules());

    }

    private static void addClimateParameterList(ResourceKey<Biome> biome, List<Climate.ParameterPoint> points) {
        for (Climate.ParameterPoint point : points) {
            BiomePlacement.addOverworld(biome, point);
        }
    }

    private static void addSurfaceRule(SurfaceRules.RuleSource ruleSource) {
        SurfaceGeneration.addOverworldSurfaceRules(overworldRules, ruleSource);
    }
}
