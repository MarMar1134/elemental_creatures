package net.marmar.elemental_creatures.worldgen;

import net.marmar.elemental_creatures.ECConfig;
import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.datagen.tag.ECTags;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ECBiomeModifiers {
//    public static final ResourceKey<BiomeModifier> REMOVE_ZOMBIE_FROM_FROZEN_BIOMES = registerKey("remove_zombie_from_frozen_biomes");
//    public static final ResourceKey<BiomeModifier> REMOVE_ZOMBIE_FROM_SWAMPS = registerKey("remove_zombie_from_swamps");

    public static final ResourceKey<BiomeModifier> ADD_LOST = registerKey("add_lost");
    public static final ResourceKey<BiomeModifier> ADD_ROTTEN = registerKey("add_rotten");

    public static void bootstrap(BootstapContext<BiomeModifier> context){
        var biomes = context.lookup(Registries.BIOME);
        var entities = context.lookup(Registries.ENTITY_TYPE);

        //Entity removers
//        context.register(REMOVE_ZOMBIE_FROM_FROZEN_BIOMES, new ForgeBiomeModifiers.RemoveSpawnsBiomeModifier(
//                biomes.getOrThrow(ECTags.Biomes.CAN_SPAWN_LOST),
//                entities.getOrThrow(ECTags.Entities.ZOMBIE)
//        ));
//        context.register(REMOVE_ZOMBIE_FROM_SWAMPS, new ForgeBiomeModifiers.RemoveSpawnsBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP), biomes.getOrThrow(Biomes.MANGROVE_SWAMP)),
//                entities.getOrThrow(ECTags.Entities.ZOMBIE)
//        ));

        //The lost
//        context.register(ADD_LOST, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
//                biomes.getOrThrow(ECTags.Biomes.CAN_SPAWN_LOST),
//                List.of(new MobSpawnSettings.SpawnerData(ECEntityTypes.LOST.get(), 70, 2, 4))
//        ));

        //The rotten
//        context.register(ADD_ROTTEN, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP), biomes.getOrThrow(Biomes.MANGROVE_SWAMP)),
//                List.of(new MobSpawnSettings.SpawnerData(ECEntityTypes.ROTTEN.get(), 70, 2, 4))
//        ));
    }

    @SuppressWarnings("removal")
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ElementalCreatures.MOD_ID, name));
    }
}
