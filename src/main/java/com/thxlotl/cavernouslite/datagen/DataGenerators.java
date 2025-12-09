package com.thxlotl.cavernouslite.datagen;

import com.thxlotl.cavernouslite.CavernousLite;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = CavernousLite.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event)
    {
        registerProviders(event);
    }

    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event)
    {
        registerProviders(event);
    }

    private static void registerProviders(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        // Tags
        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider);
        generator.addProvider(true, blockTagsProvider);

        // Datapack
        generator.addProvider(true, new ModDatapackProvider(packOutput, lookupProvider));
    }
}