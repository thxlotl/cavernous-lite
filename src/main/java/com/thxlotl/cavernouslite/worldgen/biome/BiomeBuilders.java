package com.thxlotl.cavernouslite.worldgen.biome;

import com.thxlotl.cavernouslite.worldgen.features.placed.FungalCavesPlacedFeatures;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BiomeBuilders {

    //Helper methods
    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }


    public static Biome fungalCaves(BootstrapContext<Biome> context) {

        // Build mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);


        // Build feature generation
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        // Default features
        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);

        /*
        NEED TO ADD ORE STUFF
         */

        // Custom features
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.MOSS_PATCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.MYCELIUM_PATCH);


        // Biome characteristics
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.015f))
                        .waterColor(4178916)
                        .waterFogColor(335155)
                        .skyColor(12377016)
                        .fogColor(12377016)
                        .grassColorOverride(7311404)
                        .foliageColorOverride(7311404)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES)).build())
                .build();
    }


}
