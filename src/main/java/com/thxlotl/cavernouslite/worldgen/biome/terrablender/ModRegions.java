package com.thxlotl.cavernouslite.worldgen.biome.terrablender;

import com.thxlotl.cavernouslite.CavernousLite;
import net.minecraft.resources.Identifier;
import terrablender.api.Regions;

public class ModRegions {

    public static void register() {

        Regions.register(new CavernousLiteRegion(
                Identifier.fromNamespaceAndPath(CavernousLite.MODID, "overworld"),
                100
        ));

    }

}
