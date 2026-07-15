package com.thxlotl.cavernouslite.worldgen.biome;

import net.minecraft.world.level.biome.Climate;

import java.util.List;

public class ClimateParameters {

    private static final Climate.Parameter shallowCaveDepth = Climate.Parameter.span(0.2f, 0.6f);
    private static final Climate.Parameter deepCaveDepth = Climate.Parameter.span(0.9f, 1.2f);
    private static final Climate.Parameter allCaveDepth = Climate.Parameter.span(0.2f, 1.2f);
    private static final Climate.Parameter midCaveDepth = Climate.Parameter.span(0.2f, 0.9f);
    private static final Climate.Parameter weirdness = Climate.Parameter.span(-1f, 1f);
    private static final Climate.Parameter allErosion = Climate.Parameter.span(-1f, 1f);
    private static final Climate.Parameter all = Climate.Parameter.span(-2f, 2f);

    public static final List<Climate.ParameterPoint> FUNGAL_CAVES = List.of(
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, 0.55f), // Temperature
                    Climate.Parameter.span(-1f, -0.35f), // Humidity
                    Climate.Parameter.span(-1.2f, -1.05f), // Continentalness
                    allErosion, // Erosion
                    midCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, 0.55f), // Temperature
                    Climate.Parameter.span(-1f, -0.35f), // Humidity
                    Climate.Parameter.span(-1.05f, 0.8f), // Continentalness
                    Climate.Parameter.span(-1f, -0.375f), // Erosion
                    midCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, 0.55f), // Temperature
                    Climate.Parameter.span(-1f, -0.35f), // Humidity
                    Climate.Parameter.span(-1.05f, -0.19f), // Continentalness
                    Climate.Parameter.span(-0.2225f, 1f), // Erosion
                    midCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, 0.55f), // Temperature
                    Climate.Parameter.span(-1f, -0.35f), // Humidity
                    Climate.Parameter.span(-0.455f, -0.19f), // Continentalness
                    Climate.Parameter.span(-0.375f, 1f), // Erosion
                    midCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, 0.55f), // Temperature
                    Climate.Parameter.span(-1f, -0.35f), // Humidity
                    Climate.Parameter.span(-0.19f, 0.8f), // Continentalness
                    Climate.Parameter.span(-0.375f, 0.05f), // Erosion
                    midCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, 0.55f), // Temperature
                    Climate.Parameter.span(-1f, -0.35f), // Humidity
                    Climate.Parameter.span(-0.19f, 0.3f), // Continentalness
                    Climate.Parameter.span(0.55f, 1f), // Erosion
                    midCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, 0.55f), // Temperature
                    Climate.Parameter.span(-1f, -0.35f), // Humidity
                    Climate.Parameter.span(-0.11f, 0.3f), // Continentalness
                    Climate.Parameter.span(0.05f, 1f), // Erosion
                    midCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, 0.55f), // Temperature
                    Climate.Parameter.span(-1f, -0.35f), // Humidity
                    Climate.Parameter.span(0.3f, 0.8f), // Continentalness
                    Climate.Parameter.span(0.05f, 0.45f), // Erosion
                    midCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> VOLCANIC_CAVES = List.of(
            new Climate.ParameterPoint(
                    all,  // Temperature
                    all,  // Humidity
                    Climate.Parameter.span(-1.2f, 1f), // Continentalness
                    all, // Erosion
                    Climate.Parameter.span(0.9f, 1f), // Depth
                    Climate.Parameter.span(0.05f, 0.76666f), // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> CRYSTAL_CAVES = List.of(
            new Climate.ParameterPoint(
                    all,  // Temperature
                    all,  // Humidity
                    Climate.Parameter.span(-1.05f, -0.455f), // Continentalness
                    Climate.Parameter.span(-0.375f, -0.2225f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> LUSH_DRIPSTONE_CAVES = List.of(
            new Climate.ParameterPoint(
                    all,  // Temperature
                    all,  // Humidity
                    Climate.Parameter.span(0.3f, 0.8f), // Continentalness
                    Climate.Parameter.span(0.45f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> MARBLED_CAVES = List.of(
            new Climate.ParameterPoint(
                    all,  // Temperature
                    all,  // Humidity
                    Climate.Parameter.span(-0.19f, -0.11f), // Continentalness
                    Climate.Parameter.span(0.5f, 0.55f), // Erosion
                    midCaveDepth, // Depth
                    weirdness, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> ARID_CAVES = List.of(
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.55f, 1f), // Temperature
                    Climate.Parameter.span(-1f, 0.3f), // Humidity
                    Climate.Parameter.span(-1.2f, -1.05f), // Continentalness
                    all, // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.55f, 1f), // Temperature
                    Climate.Parameter.span(-1f, 0.3f), // Humidity
                    Climate.Parameter.span(-1.05f, 0.8f), // Continentalness
                    Climate.Parameter.span(-1f, -0.375f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.55f, 1f), // Temperature
                    Climate.Parameter.span(-1f, 0.3f), // Humidity
                    Climate.Parameter.span(-1.05f, -0.19f), // Continentalness
                    Climate.Parameter.span(-0.2225f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.55f, 1f), // Temperature
                    Climate.Parameter.span(-1f, 0.3f), // Humidity
                    Climate.Parameter.span(-0.455f, -0.19f), // Continentalness
                    Climate.Parameter.span(-0.375f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.55f, 1f), // Temperature
                    Climate.Parameter.span(-1f, 0.3f), // Humidity
                    Climate.Parameter.span(-0.19f, 0.8f), // Continentalness
                    Climate.Parameter.span(-0.375f, 0.05f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.55f, 1f), // Temperature
                    Climate.Parameter.span(-1f, 0.3f), // Humidity
                    Climate.Parameter.span(-0.19f, 0.3f), // Continentalness
                    Climate.Parameter.span(0.55f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.55f, 1f), // Temperature
                    Climate.Parameter.span(-1f, 0.3f), // Humidity
                    Climate.Parameter.span(-0.11f, 0.3f), // Continentalness
                    Climate.Parameter.span(0.05f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(0.55f, 1f), // Temperature
                    Climate.Parameter.span(-1f, 0.3f), // Humidity
                    Climate.Parameter.span(0.3f, 0.8f), // Continentalness
                    Climate.Parameter.span(0.05f, 0.45f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> ICY_CAVES = List.of(
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, -0.45f), // Temperature
                    Climate.Parameter.span(-0.35f, 0.7f), // Humidity
                    Climate.Parameter.span(-1.2f, -1.05f), // Continentalness
                    Climate.Parameter.span(-1f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, -0.45f), // Temperature
                    Climate.Parameter.span(-0.35f, 0.7f), // Humidity
                    Climate.Parameter.span(-1.05f, 0.8f), // Continentalness
                    Climate.Parameter.span(-1f, -0.375f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, -0.45f), // Temperature
                    Climate.Parameter.span(-0.35f, 0.7f), // Humidity
                    Climate.Parameter.span(-1.05f, -0.19f), // Continentalness
                    Climate.Parameter.span(-0.2225f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, -0.45f), // Temperature
                    Climate.Parameter.span(-0.35f, 0.7f), // Humidity
                    Climate.Parameter.span(-0.455f, -0.19f), // Continentalness
                    Climate.Parameter.span(-0.375f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, -0.45f), // Temperature
                    Climate.Parameter.span(-0.35f, 0.7f), // Humidity
                    Climate.Parameter.span(-0.19f, 0.8f), // Continentalness
                    Climate.Parameter.span(-0.375f, 0.05f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, -0.45f), // Temperature
                    Climate.Parameter.span(-0.35f, 0.7f), // Humidity
                    Climate.Parameter.span(-0.19f, 0.3f), // Continentalness
                    Climate.Parameter.span(0.55f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, -0.45f), // Temperature
                    Climate.Parameter.span(-0.35f, 0.7f), // Humidity
                    Climate.Parameter.span(-0.11f, 0.3f), // Continentalness
                    Climate.Parameter.span(0.05f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-1f, -0.45f), // Temperature
                    Climate.Parameter.span(-0.35f, 0.7f), // Humidity
                    Climate.Parameter.span(0.3f, 0.8f), // Continentalness
                    Climate.Parameter.span(0.05f, 0.45f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L)
    );

    public static final List<Climate.ParameterPoint> BURIED_JUNGLE = List.of(
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-0.15f, 0.55f), // Temperature
                    Climate.Parameter.span(0.1f, 0.7f), // Humidity
                    Climate.Parameter.span(-1.2f, -1.05f), // Continentalness
                    Climate.Parameter.span(-1f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-0.15f, 0.55f), // Temperature
                    Climate.Parameter.span(0.1f, 0.7f), // Humidity
                    Climate.Parameter.span(-1.05f, 0.8f), // Continentalness
                    Climate.Parameter.span(-1f, -0.375f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-0.15f, 0.55f), // Temperature
                    Climate.Parameter.span(0.1f, 0.7f), // Humidity
                    Climate.Parameter.span(-1.05f, -0.19f), // Continentalness
                    Climate.Parameter.span(-0.2225f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-0.15f, 0.55f), // Temperature
                    Climate.Parameter.span(0.1f, 0.7f), // Humidity
                    Climate.Parameter.span(-0.455f, -0.19f), // Continentalness
                    Climate.Parameter.span(-0.375f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-0.15f, 0.55f), // Temperature
                    Climate.Parameter.span(0.1f, 0.7f), // Humidity
                    Climate.Parameter.span(-0.19f, 0.8f), // Continentalness
                    Climate.Parameter.span(-0.375f, 0.05f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-0.15f, 0.55f), // Temperature
                    Climate.Parameter.span(0.1f, 0.7f), // Humidity
                    Climate.Parameter.span(-0.19f, 0.3f), // Continentalness
                    Climate.Parameter.span(0.55f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-0.15f, 0.55f), // Temperature
                    Climate.Parameter.span(0.1f, 0.7f), // Humidity
                    Climate.Parameter.span(-0.11f, 0.3f), // Continentalness
                    Climate.Parameter.span(0.05f, 1f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L),
            new Climate.ParameterPoint(
                    Climate.Parameter.span(-0.15f, 0.55f), // Temperature
                    Climate.Parameter.span(0.1f, 0.7f), // Humidity
                    Climate.Parameter.span(0.3f, 0.8f), // Continentalness
                    Climate.Parameter.span(0.05f, 0.45f), // Erosion
                    midCaveDepth, // Depth
                    all, // Weirdness
                    0L)
    );

}
