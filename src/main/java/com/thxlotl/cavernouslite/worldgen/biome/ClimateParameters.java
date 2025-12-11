package com.thxlotl.cavernouslite.worldgen.biome;

import net.minecraft.world.level.biome.Climate;

public class ClimateParameters {

    public static final Climate.ParameterPoint FUNGAL_CAVES = new Climate.ParameterPoint(
            Climate.Parameter.span(-0.45f, 0.2f),
            Climate.Parameter.span(-0.35f, 0.7f),
            Climate.Parameter.span(-1.05f, -0.455f),
            Climate.Parameter.span(-0.375f, 1f),
            Climate.Parameter.span(0.2f, 0.7f),
            Climate.Parameter.span(-1.0f, 1.0f),
            0L);
    public static final Climate.ParameterPoint VOLCANIC_CAVES = new Climate.ParameterPoint(
            Climate.Parameter.span(-1.0f, 1.0f), // Temperature
            Climate.Parameter.span(-1.0f, 1.0f), // Humidity
            Climate.Parameter.span(-1.05f, -0.11f), // Continentalness
            Climate.Parameter.span(0.05f, 0.45f), // Erosion
            Climate.Parameter.span(0.35f, 1f), // Depth
            Climate.Parameter.span(-1.0f, 1.0f), // Weirdness
            0L);
    public static final Climate.ParameterPoint CRYSTAL_CAVES = new Climate.ParameterPoint(
            Climate.Parameter.span(-0.2f, 0.45f),
            Climate.Parameter.span(-0.7f, 0.35f),
            Climate.Parameter.span(0.455f, 1.05f),
            Climate.Parameter.span(-1f, 0.375f),
            Climate.Parameter.span(0.35f, 1f), // Depth
            Climate.Parameter.span(-1.0f, 1.0f),
            0L);
    public static final Climate.ParameterPoint LUSH_DRIPSTONE_CAVES = new Climate.ParameterPoint(
            Climate.Parameter.span(-1f, 0f),
            Climate.Parameter.span(-0.7f, 0.35f),
            Climate.Parameter.span(-0.455f, 0f),
            Climate.Parameter.span(-1f, 0.375f),
            Climate.Parameter.span(0.35f, 1f), // Depth
            Climate.Parameter.span(0f, 1.0f),
            0L);
    public static final Climate.ParameterPoint MARBLED_CAVES = new Climate.ParameterPoint(
            Climate.Parameter.span(-1f, 0f),
            Climate.Parameter.span(-0.7f, 0.35f),
            Climate.Parameter.span(-0.455f, 0f),
            Climate.Parameter.span(-1f, 1f),
            Climate.Parameter.span(0.35f, 1f), // Depth
            Climate.Parameter.span(0f, 1.0f),
            0L);
    public static final Climate.ParameterPoint ARID_CAVES = new Climate.ParameterPoint(
            Climate.Parameter.span(0.5f, 2.0f), // Temperature
            Climate.Parameter.span(-2.0f, -0.5f), // Humidity
            Climate.Parameter.span(-0.75f, 0.4f), // Continentalness
            Climate.Parameter.span(0.05f, 1.0f), // Erosion
            Climate.Parameter.span(0.35f, 1f), // Depth
            Climate.Parameter.span(-1.0f, 1f), // Weirdness
            0L);
    public static final Climate.ParameterPoint ICY_CAVES = new Climate.ParameterPoint(
            Climate.Parameter.span(-2.0f, -0.3f), // Temperature
            Climate.Parameter.span(-2.0f, -0.5f), // Humidity
            Climate.Parameter.span(0.5f, 1.0f), // Continentalness
            Climate.Parameter.span(0.05f, 0.3f), // Erosion
            Climate.Parameter.span(0.35f, 1f), // Depth
            Climate.Parameter.span(-1.0f, 1f), // Weirdness
            0L);

}
