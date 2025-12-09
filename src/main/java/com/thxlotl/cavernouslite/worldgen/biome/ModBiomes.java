package com.thxlotl.cavernouslite.worldgen.biome;

import com.thxlotl.cavernouslite.CavernousLite;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {

    // Biome initialization
    public static final ResourceKey<Biome> FUNGAL_CAVES = createBiomeKey("fungal_caves");

    private static ResourceKey<Biome> createBiomeKey(String name) {
        return ResourceKey.create(Registries.BIOME,
                ResourceLocation.fromNamespaceAndPath(CavernousLite.MODID, name));
    }

    // Generate data
    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(FUNGAL_CAVES, BiomeBuilders.fungalCaves(context));
    }
}
