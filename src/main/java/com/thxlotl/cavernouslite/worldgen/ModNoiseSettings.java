package com.thxlotl.cavernouslite.worldgen;

import com.terraformersmc.biolith.impl.Biolith;
import com.thxlotl.cavernouslite.worldgen.biome.BiolithBiomePlacement;
import com.thxlotl.cavernouslite.worldgen.biome.BiomeSurfaceRules;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModNoiseSettings {

    public static SurfaceRules.RuleSource FUNGAL_RULES;
    public static SurfaceRules.RuleSource ARID_RULES;
    public static SurfaceRules.RuleSource VOLCANIC_RULES;
    public static SurfaceRules.RuleSource CRYSTAL_RULES;
    public static SurfaceRules.RuleSource MARBLED_RULES;
    public static SurfaceRules.RuleSource ICY_RULES;
    public static SurfaceRules.RuleSource JUNGLE_RULES;

    public static void bootstrap(BootstrapContext<?> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);


        FUNGAL_RULES = BiomeSurfaceRules.fungalRules(biomes);
        ARID_RULES = BiomeSurfaceRules.aridRules(biomes);
        VOLCANIC_RULES = BiomeSurfaceRules.volcanicRules(biomes);
        CRYSTAL_RULES = BiomeSurfaceRules.crystalRules(biomes);
        MARBLED_RULES = BiomeSurfaceRules.marbledRules(biomes);
        ICY_RULES = BiomeSurfaceRules.icyRules(biomes);
        JUNGLE_RULES = BiomeSurfaceRules.jungleRules(biomes);

        BiolithBiomePlacement.createBiomePlacementsAndSurfaceRules();
    }

}
