package com.thxlotl.cavernouslite.datagen;

import com.thxlotl.cavernouslite.CavernousLite;
import com.thxlotl.cavernouslite.worldgen.ModNoiseSettings;
import com.thxlotl.cavernouslite.worldgen.biome.BiomeSurfaceRules;
import com.thxlotl.cavernouslite.worldgen.biome.ModBiomes;
import com.thxlotl.cavernouslite.worldgen.ModNoises;
import com.thxlotl.cavernouslite.worldgen.features.ModConfiguredFeatures;
import com.thxlotl.cavernouslite.worldgen.features.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            //.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(Registries.BIOME, ModBiomes::bootstrap)
            .add(Registries.NOISE, ModNoises::bootstrap)
            ;

    public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CavernousLite.MODID));
    }
}