package net.marmar.elemental_creatures.datagen;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.datagen.lang.EnglishLangProvider;
import net.marmar.elemental_creatures.datagen.lang.SpanishLangProvider;
import net.marmar.elemental_creatures.datagen.loot.ECLootTableProviders;
import net.marmar.elemental_creatures.datagen.model.ECItemModelProvider;
import net.marmar.elemental_creatures.datagen.tag.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ElementalCreatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //Datapack generator
        ECDataPackProvider dataPackProvider = new ECDataPackProvider(packOutput, lookupProvider);
        generator.addProvider(event.includeServer(), dataPackProvider);

        //Tag providers
        generator.addProvider(event.includeServer(), new ECEntityTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ECBiomeTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ECDamageTypeTagGenerator(packOutput, dataPackProvider.getRegistryProvider(), existingFileHelper));

        ECBlockTagGenerator blockTagGenerator = new ECBlockTagGenerator(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagGenerator);

        generator.addProvider(event.includeServer(), new ECItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

        //Loot tables
        generator.addProvider(event.includeServer(), ECLootTableProviders.create(packOutput));

        //Models
        generator.addProvider(event.includeClient(), new ECItemModelProvider(packOutput, existingFileHelper));

        //Languages
        generator.addProvider(event.includeClient(), new EnglishLangProvider(packOutput));
        generator.addProvider(event.includeClient(), new SpanishLangProvider(packOutput, "es_ar"));
        generator.addProvider(event.includeClient(), new SpanishLangProvider(packOutput, "es_uy"));
        generator.addProvider(event.includeClient(), new SpanishLangProvider(packOutput, "es_cl"));
        generator.addProvider(event.includeClient(), new SpanishLangProvider(packOutput, "es_ec"));
        generator.addProvider(event.includeClient(), new SpanishLangProvider(packOutput, "es_es"));
        generator.addProvider(event.includeClient(), new SpanishLangProvider(packOutput, "es_mx"));
        generator.addProvider(event.includeClient(), new SpanishLangProvider(packOutput, "es_ve"));
    }
}
