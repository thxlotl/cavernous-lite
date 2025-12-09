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

}
