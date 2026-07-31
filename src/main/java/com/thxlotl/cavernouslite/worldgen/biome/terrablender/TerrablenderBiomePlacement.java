package com.thxlotl.cavernouslite.worldgen.biome.terrablender;

import com.thxlotl.cavernouslite.CavernousLite;
import terrablender.api.SurfaceRuleManager;

public class TerrablenderBiomePlacement {

    public static void registerSurfaceRules() {

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, CavernousLite.MODID, SurfaceRuleData::overworld);

    }

}
