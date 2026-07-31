package com.thxlotl.cavernouslite.worldgen.biome.terrablender;

import com.mojang.datafixers.util.Pair;
import com.thxlotl.cavernouslite.worldgen.biome.ClimateParameters;
import com.thxlotl.cavernouslite.worldgen.biome.ModBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.worldgen.DefaultOverworldRegion;

import java.util.List;
import java.util.function.Consumer;

public class CavernousLiteRegion extends Region {

    public CavernousLiteRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {

        this.addBiome(mapper, ClimateParameters.ARID_CAVES, ModBiomes.ARID_CAVES);
        this.addBiome(mapper, ClimateParameters.FUNGAL_CAVES, ModBiomes.FUNGAL_CAVES);
        this.addBiome(mapper, ClimateParameters.VOLCANIC_CAVES, ModBiomes.VOLCANIC_CAVES);
        this.addBiome(mapper, ClimateParameters.CRYSTAL_CAVES, ModBiomes.CRYSTAL_CAVES);
        this.addBiome(mapper, ClimateParameters.LUSH_DRIPSTONE_CAVES, ModBiomes.LUSH_DRIPSTONE_CAVES);
        this.addBiome(mapper, ClimateParameters.MARBLED_CAVES, ModBiomes.MARBLED_CAVES);
        this.addBiome(mapper, ClimateParameters.ICY_CAVES, ModBiomes.ICY_CAVES);
        this.addBiome(mapper, ClimateParameters.BURIED_JUNGLE, ModBiomes.BURIED_JUNGLE);

        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {} );
    }

    private void addBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper, List<Climate.ParameterPoint> parametersList, ResourceKey<Biome> biome) {

        for (Climate.ParameterPoint parameter : parametersList) {
            this.addBiome(mapper, parameter, biome);
        }

    }
}
