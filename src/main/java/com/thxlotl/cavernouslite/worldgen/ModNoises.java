package com.thxlotl.cavernouslite.worldgen;

import com.thxlotl.cavernouslite.CavernousLite;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class ModNoises {

    public static final ResourceKey<NormalNoise.NoiseParameters> FUNGAL_SURFACE = createKey("fungal_surface");
    public static final ResourceKey<NormalNoise.NoiseParameters> VOLCANIC = createKey("volcanic");
    public static final ResourceKey<NormalNoise.NoiseParameters> STRIPEY = createKey("stripey");
    public static final ResourceKey<NormalNoise.NoiseParameters> STRIPEY_SMALL = createKey("stripey_small");
    public static final ResourceKey<NormalNoise.NoiseParameters> SCATTERED = createKey("scattered");

    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context) {
        register(context, FUNGAL_SURFACE, -6,
                2, 2, 4);
        register(context, VOLCANIC, -5,
                1, 2, 1);
        register(context, STRIPEY, -6,
                1.1, 1);
        register(context, SCATTERED, -6,
                1.5, 1, 1, 2.5);
        register(context, STRIPEY_SMALL, -3,
                1.1, 1);
    }


    private static ResourceKey<NormalNoise.NoiseParameters> createKey(String key) {
        return ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(CavernousLite.MODID, key));
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
