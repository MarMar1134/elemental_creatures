package net.marmar.elemental_creatures.worldgen;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.datagen.tag.ECTags;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ECBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_SUNKEN = registerKey("add_sunken");

    public static void bootstrap(BootstapContext<BiomeModifier> context){
        var biomes = context.lookup(Registries.BIOME);
        var entities = context.lookup(Registries.ENTITY_TYPE);

        //Sunken
        context.register(ADD_SUNKEN, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ECTags.Biomes.CAN_SPAWN_SUNKEN),
                List.of(new MobSpawnSettings.SpawnerData(ECEntityTypes.SUNKEN.get(), 70, 2, 4))
        ));
    }

    @SuppressWarnings("removal")
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ElementalCreatures.MOD_ID, name));
    }
}
