package com.thxlotl.cavernouslite.worldgen.biome;

import com.thxlotl.cavernouslite.CavernousLite;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {

    // Biome initialization
    public static final ResourceKey<Biome> FUNGAL_CAVES = createBiomeKey("fungal_caves");
    public static final ResourceKey<Biome> VOLCANIC_CAVES = createBiomeKey("volcanic_caves");
    public static final ResourceKey<Biome> CRYSTAL_CAVES = createBiomeKey("crystal_caves");
    public static final ResourceKey<Biome> LUSH_DRIPSTONE_CAVES = createBiomeKey("lush_dripstone_caves");
    public static final ResourceKey<Biome> MARBLED_CAVES = createBiomeKey("marbled_caves");
    public static final ResourceKey<Biome> ARID_CAVES = createBiomeKey("arid_caves");
    public static final ResourceKey<Biome> ICY_CAVES = createBiomeKey("icy_caves");
    public static final ResourceKey<Biome> BURIED_JUNGLE = createBiomeKey("buried_jungle");

    private static ResourceKey<Biome> createBiomeKey(String name) {
        return ResourceKey.create(Registries.BIOME,
                Identifier.fromNamespaceAndPath(CavernousLite.MODID, name));
    }

    // Generate data
    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(FUNGAL_CAVES, BiomeBuilders.fungalCaves(context));
        context.register(VOLCANIC_CAVES, BiomeBuilders.volcanicCaves(context));
        context.register(CRYSTAL_CAVES, BiomeBuilders.crystalCaves(context));
        context.register(LUSH_DRIPSTONE_CAVES, BiomeBuilders.lushDripstoneCaves(context));
        context.register(MARBLED_CAVES, BiomeBuilders.basicCave(context));
        context.register(ARID_CAVES, BiomeBuilders.aridCaves(context));
        context.register(ICY_CAVES, BiomeBuilders.icyCaves(context));
        context.register(BURIED_JUNGLE, BiomeBuilders.buriedJungle(context));
    }
}
