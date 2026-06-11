package com.thxlotl.cavernouslite.worldgen.biome;

import com.thxlotl.cavernouslite.worldgen.features.placed.*;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.AmbientParticle;
import net.minecraft.world.attribute.AmbientSounds;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BiomeBuilders {

    //Helper methods
    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);;
        BiomeDefaultFeatures.addDefaultMushrooms(builder);
    }

    private static void caveSpawns(MobSpawnSettings.Builder builder) {
        BiomeDefaultFeatures.commonSpawns(builder);
    }

    public static void addUndergroundOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_COAL_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_COAL_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_COPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_COPPER_LARGE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_IRON_MIDDLE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_IRON_SMALL);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_IRON_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_GOLD);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_GOLD_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_REDSTONE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_REDSTONE_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_LAPIS);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_LAPIS_BURIED);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_DIAMOND);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_DIAMOND_BURIED);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_DIAMOND_LARGE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_DIAMOND_MEDIUM);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacedFeatures.UNDERGROUND_ORE_EMERALD);
    }


    public static Biome fungalCaves(BootstrapContext<Biome> context) {

        // Build mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        caveSpawns(spawnBuilder);

        // Build feature generation
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // Default features
        globalOverworldGeneration(biomeBuilder);
        addUndergroundOres(biomeBuilder);

        // Custom features
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.MOSS_PATCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.MYCELIUM_PATCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.BROWN_1);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.RED_1);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.BROWN_2);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.RED_2);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.GLOWSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.FLIP_STEP_1);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.FLIP_STEP_2);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FungalCavesPlacedFeatures.FLIP_STEP_3);


        // Biome characteristics
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4178916)
                        .grassColorOverride(7311404)
                        .foliageColorOverride(7311404)
                        .build()
                )
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 335155)
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 10014123) //12377016 old color
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 10014123)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 85f)
                .setAttribute(EnvironmentAttributes.SKY_LIGHT_FACTOR, 0f)
                .setAttribute(EnvironmentAttributes.AMBIENT_PARTICLES, AmbientParticle.of(ParticleTypes.SPORE_BLOSSOM_AIR, 0.015f))
                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, AmbientSounds.LEGACY_CAVE_SETTINGS)
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES))
                .build();
    }

    public static Biome volcanicCaves(BootstrapContext<Biome> context) {

        // Build mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        caveSpawns(spawnBuilder);

        // Build feature generation
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // Default features
        globalOverworldGeneration(biomeBuilder);
        addUndergroundOres(biomeBuilder);

        // Custom features
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VolcanicCavesPlacedFeatures.DIAMOND_EXTRA);
        biomeBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, VolcanicCavesPlacedFeatures.LAVA_POOL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VolcanicCavesPlacedFeatures.SCORCHED_TREE);

        // Biome characteristics
        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(1.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4178916)
                        .grassColorOverride(7311404)
                        .foliageColorOverride(7311404)
                        .build()
                )
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 3552822)
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 8870956) //12377016 old color
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 13464130)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 85f)
                .setAttribute(EnvironmentAttributes.SKY_LIGHT_FACTOR, 0f)
                .setAttribute(EnvironmentAttributes.AMBIENT_PARTICLES, AmbientParticle.of(ParticleTypes.WHITE_ASH, 0.08f))
                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, AmbientSounds.LEGACY_CAVE_SETTINGS)
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES))
                .build();
    }

    public static Biome crystalCaves(BootstrapContext<Biome> context) {

        // Build mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        caveSpawns(spawnBuilder);

        // Build feature generation
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // Default features
        globalOverworldGeneration(biomeBuilder);
        addUndergroundOres(biomeBuilder);

        // Custom features

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CrystalCavesPlacedFeatures.BUD_UP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CrystalCavesPlacedFeatures.BUD_DOWN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CrystalCavesPlacedFeatures.BUD_NORTH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CrystalCavesPlacedFeatures.BUD_EAST);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CrystalCavesPlacedFeatures.BUD_SOUTH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CrystalCavesPlacedFeatures.BUD_WEST);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, CrystalCavesPlacedFeatures.BIG_GEODE);

        // Biome characteristics
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.8f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .grassColorOverride(7311404)
                        .foliageColorOverride(7311404)
                        .build()
                )
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 329011)
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 7907327)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 12638463)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 85f)
                .setAttribute(EnvironmentAttributes.SKY_LIGHT_FACTOR, 0f)
                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, AmbientSounds.LEGACY_CAVE_SETTINGS)
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES))
                .build();
    }

    public static Biome lushDripstoneCaves(BootstrapContext<Biome> context) {

        // Build mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        caveSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.MONSTER, 95, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 4, 4));

        // Build feature generation
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // Default features
        globalOverworldGeneration(biomeBuilder);
        addUndergroundOres(biomeBuilder);

        // Custom features
        BiomeDefaultFeatures.addLushCavesVegetationFeatures(biomeBuilder);
        BiomeDefaultFeatures.addDripstone(biomeBuilder);



        // Biome characteristics
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4178916)
                        .grassColorOverride(7311404)
                        .foliageColorOverride(7311404)
                        .build()
                )
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 335155)
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 8103167)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 12638463)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 85f)
                .setAttribute(EnvironmentAttributes.SKY_LIGHT_FACTOR, 0f)
                .setAttribute(EnvironmentAttributes.AMBIENT_PARTICLES,
                        AmbientParticle.of(ParticleTypes.SPORE_BLOSSOM_AIR, 0.007f))
                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, AmbientSounds.LEGACY_CAVE_SETTINGS)
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC,
                        new BackgroundMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES))
                .build();
    }

    public static Biome basicCave(BootstrapContext<Biome> context) {

        // Build mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        caveSpawns(spawnBuilder);

        // Build feature generation
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        // Default features
        globalOverworldGeneration(biomeBuilder);
        addUndergroundOres(biomeBuilder);

        // Biome characteristics
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.8f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .grassColorOverride(7311404)
                        .foliageColorOverride(7311404)
                        .build()
                )
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 329011)
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 7907327)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 12638463)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 85f)
                .setAttribute(EnvironmentAttributes.SKY_LIGHT_FACTOR, 0f)
                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, AmbientSounds.LEGACY_CAVE_SETTINGS)
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC,
                        new BackgroundMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES))
                .build();
    }

    public static Biome aridCaves(BootstrapContext<Biome> context) {

        // Build mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        caveSpawns(spawnBuilder);

        // Build feature generation
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // Default features
        globalOverworldGeneration(biomeBuilder);
        addUndergroundOres(biomeBuilder);

        // Custom features
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, AridCavesPlacedFeatures.HOODOO_1);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, AridCavesPlacedFeatures.HOODOO_2);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AridCavesPlacedFeatures.PATCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AridCavesPlacedFeatures.GIANT_DEAD_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, AridCavesPlacedFeatures.GOLD_EXTRA);

        // Biome characteristics
        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(2f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4163300)
                        .grassColorOverride(7039851)
                        .foliageColorOverride(7039851)
                        .build()
                )
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 329011)
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 8103167)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 12638463)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 85f)
                .setAttribute(EnvironmentAttributes.SKY_LIGHT_FACTOR, 0f)
                .setAttribute(EnvironmentAttributes.AMBIENT_PARTICLES,
                        AmbientParticle.of(
                                new BlockParticleOption(ParticleTypes.FALLING_DUST, Blocks.SAND.defaultBlockState()),
                                0.005f))
                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, AmbientSounds.LEGACY_CAVE_SETTINGS)
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC,
                        new BackgroundMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES))
                .build();
    }

    public static Biome icyCaves(BootstrapContext<Biome> context) {
        // Build mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        caveSpawns(spawnBuilder);

        // Build feature generation
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        // Default features
        globalOverworldGeneration(biomeBuilder);
        addUndergroundOres(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcyCavesPlacedFeatures.ICE_PILLAR);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcyCavesPlacedFeatures.DIAMOND_EXTRA);

        // Biome characteristics
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.9f)
                .temperature(-0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(40447)
                        .grassColorOverride(7311404)
                        .foliageColorOverride(7311404)
                        .build()
                )
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 40447)
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 7907327)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 12638463)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 85f)
                .setAttribute(EnvironmentAttributes.SKY_LIGHT_FACTOR, 0f)
                .setAttribute(EnvironmentAttributes.AMBIENT_PARTICLES,
                        AmbientParticle.of(ParticleTypes.SNOWFLAKE, 0.0019f))
                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, AmbientSounds.LEGACY_CAVE_SETTINGS)
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC,
                        new BackgroundMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES))
                .build();
    }

    public static Biome buriedJungle(BootstrapContext<Biome> context) {
        // Build mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        caveSpawns(spawnBuilder);

        // Build feature generation
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        // Default features
        globalOverworldGeneration(biomeBuilder);
        addUndergroundOres(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, BuriedJunglePlacedFeatures.COARSE_DIRT_PATCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, BuriedJunglePlacedFeatures.MUD_POOL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BuriedJunglePlacedFeatures.PATCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BuriedJunglePlacedFeatures.TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BuriedJunglePlacedFeatures.RED_TREE);

        // Biome characteristics
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.9f)
                .temperature(0.8f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(5883291)
                        .grassColorOverride(7311404)
                        .foliageColorOverride(7311404)
                        .build()
                )
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 340786)
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 8103167)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 12638463)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 85f)
                .setAttribute(EnvironmentAttributes.SKY_LIGHT_FACTOR, 0f)
                .setAttribute(EnvironmentAttributes.AMBIENT_PARTICLES,
                        AmbientParticle.of(ParticleTypes.SPORE_BLOSSOM_AIR, 0.002f))
                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, AmbientSounds.LEGACY_CAVE_SETTINGS)
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC,
                        new BackgroundMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES))
                .build();
    }
}
