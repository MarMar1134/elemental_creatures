package net.marmar.elemental_creatures.datagen.tag;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.biome.Biome;

@SuppressWarnings("removal")
public class ECTags {
    public static class Entities {
        public static final TagKey<EntityType<?>> ZOMBIE = entityTag("zombie");

        private static TagKey<EntityType<?>> entityTag(String name){
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(ElementalCreatures.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> CAN_SPAWN_LOST = biomeTag("can_spawn_lost");

        private static TagKey<Biome> biomeTag(String name){
            return TagKey.create(Registries.BIOME, new ResourceLocation(ElementalCreatures.MOD_ID,name));
        }
    }
}
