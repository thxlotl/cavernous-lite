package com.thxlotl.cavernouslite.worldgen;

import com.thxlotl.cavernouslite.CavernousLite;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class ModNoises {

    public static final ResourceKey<NormalNoise.NoiseParameters> FUNGAL_SURFACE = createKey("fungal_surface");

    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context) {
        register(context, FUNGAL_SURFACE, -6,
                2, 2, 4);
    }


    private static ResourceKey<NormalNoise.NoiseParameters> createKey(String key) {
        return ResourceKey.create(Registries.NOISE, ResourceLocation.fromNamespaceAndPath(CavernousLite.MODID, key));
    }
    private static void register(
            BootstrapContext<NormalNoise.NoiseParameters> context,
            ResourceKey<NormalNoise.NoiseParameters> key,
            int firstOctave,
            double amplitude,
            double... otherAmplitudes
    ) {
        context.register(key, new NormalNoise.NoiseParameters(firstOctave, amplitude, otherAmplitudes));
    }

}
