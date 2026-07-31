package com.thxlotl.cavernouslite.worldgen.biome;

//import com.terraformersmc.biolith.api.biome.BiomePlacement;
//import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import com.thxlotl.cavernouslite.worldgen.ModNoiseSettings;
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
        addSurfaceRule(ModNoiseSettings.ARID_RULES);

        addClimateParameterList(ModBiomes.FUNGAL_CAVES, ClimateParameters.FUNGAL_CAVES);
        addSurfaceRule(ModNoiseSettings.FUNGAL_RULES);

        addClimateParameterList(ModBiomes.VOLCANIC_CAVES, ClimateParameters.VOLCANIC_CAVES);
        addSurfaceRule(ModNoiseSettings.VOLCANIC_RULES);

        addClimateParameterList(ModBiomes.CRYSTAL_CAVES, ClimateParameters.CRYSTAL_CAVES);
        addSurfaceRule(ModNoiseSettings.CRYSTAL_RULES);

        addClimateParameterList(ModBiomes.LUSH_DRIPSTONE_CAVES, ClimateParameters.LUSH_DRIPSTONE_CAVES);

        addClimateParameterList(ModBiomes.MARBLED_CAVES, ClimateParameters.MARBLED_CAVES);
        addSurfaceRule(ModNoiseSettings.MARBLED_RULES);

        addClimateParameterList(ModBiomes.ICY_CAVES, ClimateParameters.ICY_CAVES);
        addSurfaceRule(ModNoiseSettings.ICY_RULES);

        addClimateParameterList(ModBiomes.BURIED_JUNGLE, ClimateParameters.BURIED_JUNGLE);
        addSurfaceRule(ModNoiseSettings.JUNGLE_RULES);

    }

    private static void addClimateParameterList(ResourceKey<Biome> biome, List<Climate.ParameterPoint> points) {
        for (Climate.ParameterPoint point : points) {
            //BiomePlacement.addOverworld(biome, point);
        }
    }

    private static void addSurfaceRule(SurfaceRules.RuleSource ruleSource) {
        //SurfaceGeneration.addOverworldSurfaceRules(overworldRules, ruleSource);
    }
}
