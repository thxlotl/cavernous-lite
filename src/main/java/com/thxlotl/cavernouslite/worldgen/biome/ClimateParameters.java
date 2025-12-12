package com.thxlotl.cavernouslite.worldgen.biome;

import net.minecraft.world.level.biome.Climate;

import java.util.List;

public class ClimateParameters {

    private static final Climate.Parameter shallowCaveDepth = Climate.Parameter.span(0.2f, 0.6f);
    private static final Climate.Parameter deepCaveDepth = Climate.Parameter.span(0.9f, 1.2f);
    private static final Climate.Parameter allCaveDepth = Climate.Parameter.span(0.2f, 1.2f);
    private static final Climate.Parameter weirdness = Climate.Parameter.span(-1f, 1f);
    private static final Climate.Parameter all = Climate.Parameter.span(-2f, 2f);

    public static final List<Climate.ParameterPoint> FUNGAL_CAVES = List.of(
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-0.15f, 0.2f), // Temperature
                    Climate.Parameter.span(0.1f, 1.0f), // Humidity
                    Climate.Parameter.span(-0.11f, 0.8f), // Continentalness
                    Climate.Parameter.span(-0.375f, 0.45f), // Erosion
                    allCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    all, // Temperature
                    all, // Humidity
                    Climate.Parameter.span(-1.2f, -0.95f), // Continentalness
                    all, // Erosion
                    deepCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> VOLCANIC_CAVES = List.of(
            new Climate.ParameterPoint(
                    all,  // Temperature
                    all,  // Humidity
                    Climate.Parameter.span(0.2f, 1f), // Continentalness
                    Climate.Parameter.span(-0.1f, 0.55f), // Erosion
                    deepCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> CRYSTAL_CAVES = List.of(
            new Climate.ParameterPoint(
                    all,  // Temperature
                    all,  // Humidity
                    Climate.Parameter.span(0.03f, 1f), // Continentalness
                    Climate.Parameter.span(-1.2f, -0.45f), // Erosion
                    allCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> LUSH_DRIPSTONE_CAVES = List.of(
            new Climate.ParameterPoint(
                    all,  // Temperature
                    Climate.Parameter.span(0.6f, 1f),  // Humidity
                    Climate.Parameter.span(0.3f, 1f), // Continentalness
                    all, // Erosion
                    shallowCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> MARBLED_CAVES = List.of(
            new Climate.ParameterPoint(
                    all,  // Temperature
                    all,  // Humidity
                    Climate.Parameter.span(0.5f, 0.8f), // Continentalness
                    Climate.Parameter.span(-0.45f, -0.3f), // Erosion
                    shallowCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> ARID_CAVES = List.of(
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.55f, 2.0f), // Temperature
                    all, // Humidity
                    Climate.Parameter.span(-1.2f, 0.7f), // Continentalness
                    all, // Erosion
                    shallowCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.55f, 2.0f), // Temperature
                    all, // Humidity
                    Climate.Parameter.span(-1.2f, 0.7f), // Continentalness
                    Climate.Parameter.span(-0.2f, 0.8f), // Erosion
                    deepCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> ICY_CAVES = List.of(
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1.0f, 0.2f), // Temperature
                    all, // Humidity
                    Climate.Parameter.span(0.03f, 1.0f), // Continentalness
                    Climate.Parameter.span(-1f, -0.375f), // Erosion
                    shallowCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> BURIED_JUNGLE = List.of(
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.2f, 0.55f), // Temperature
                    Climate.Parameter.span(0.1f, 1.0f), // Humidity
                    Climate.Parameter.span(-0.11f, 0.8f), // Continentalness
                    Climate.Parameter.span(0.05f, 0.55f), // Erosion
                    shallowCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.2f, 0.55f), // Temperature
                    Climate.Parameter.span(0.1f, 1.0f), // Humidity
                    Climate.Parameter.span(-0.11f, 0.6f), // Continentalness
                    Climate.Parameter.span(0.05f, 0.55f), // Erosion
                    deepCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L)
    );

}
