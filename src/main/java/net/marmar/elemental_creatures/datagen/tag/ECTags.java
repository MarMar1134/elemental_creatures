package net.marmar.elemental_creatures.datagen.tag;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;

public class ECTags {
    public static class Entities {
        public static final TagKey<EntityType<?>> ZOMBIE = entityTag("zombie");

        @SuppressWarnings("removal")
        private static TagKey<EntityType<?>> entityTag(String name){
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(ElementalCreatures.MOD_ID, name));
        }
    }

    public static class Biomes {
        //Zombies
        public static final TagKey<Biome> CAN_SPAWN_SCORCHED = biomeTag("can_spawn_scorched");
        public static final TagKey<Biome> CAN_SPAWN_SOUL_SCORCHED = biomeTag("can_spawn_soul_scorched");
        public static final TagKey<Biome> CAN_SPAWN_LOST = biomeTag("can_spawn_lost");
        public static final TagKey<Biome> CAN_SPAWN_ROTTEN = biomeTag("can_spawn_rotten");
        public static final TagKey<Biome> CAN_SPAWN_ILLAPISTA = biomeTag("can_spawn_illapista");
        public static final TagKey<Biome> CAN_SPAWN_DECADENT = biomeTag("can_spawn_decadent");

            //Fungus variants
            public static final TagKey<Biome> CAN_SPAWN_FUNGUS = biomeTag("can_spawn_fungus");
            public static final TagKey<Biome> CAN_SPAWN_BROWN_FUNGUS = biomeTag("can_spawn_brown_fungus");
            public static final TagKey<Biome> CAN_SPAWN_RED_FUNGUS = biomeTag("can_spawn_red_fungus");
            public static final TagKey<Biome> CAN_SPAWN_CRIMSON_FUNGUS = biomeTag("can_spawn_crimson_fungus");
            public static final TagKey<Biome> CAN_SPAWN_WARPED_FUNGUS = biomeTag("can_spawn_warped_fungus");

        //Skeletons
        public static final TagKey<Biome> CAN_SPAWN_SOUL_REAPER = biomeTag("can_spawn_soul_reaper");
        public static final TagKey<Biome> CAN_SPAWN_TLALOCQUIAN = biomeTag("can_spawn_tlalocquian");
        public static final TagKey<Biome> CAN_SPAWN_SUNKEN = biomeTag("can_spawn_sunken");
        public static final TagKey<Biome> CAN_SPAWN_DRIED = biomeTag("can_spawn_dried");
        public static final TagKey<Biome> CAN_SPAWN_PUTRID = biomeTag("can_spawn_putrid");
        public static final TagKey<Biome> CAN_SPAWN_ASHEN = biomeTag("can_spawn_ashen");

            //Blight variants
            public static final TagKey<Biome> CAN_SPAWN_BLIGHT = biomeTag("can_spawn_blight");
            public static final TagKey<Biome> CAN_SPAWN_BROWN_BLIGHT = biomeTag("can_spawn_brown_blight");
            public static final TagKey<Biome> CAN_SPAWN_RED_BLIGHT = biomeTag("can_spawn_red_blight");
            public static final TagKey<Biome> CAN_SPAWN_CRIMSON_BLIGHT = biomeTag("can_spawn_crimson_blight");
            public static final TagKey<Biome> CAN_SPAWN_WARPED_BLIGHT = biomeTag("can_spawn_warped_blight");

        //Slimes
        public static final TagKey<Biome> CAN_SPAWN_ICE_CUBE = biomeTag("can_spawn_ice_cube");
        public static final TagKey<Biome> CAN_SPAWN_SAND_CUBE = biomeTag("can_spawn_sand_cube");
        public static final TagKey<Biome> CAN_SPAWN_RED_SAND_CUBE = biomeTag("can_spawn_red_sand_cube");
        public static final TagKey<Biome> CAN_SPAWN_PHRANQUE = biomeTag("can_spawn_phranque");

        //Spiders
        public static final TagKey<Biome> CAN_SPAWN_DESERT_SPIDER = biomeTag("can_spawn_desert_spider");
        public static final TagKey<Biome> CAN_SPAWN_SNOWY_SPIDER = biomeTag("can_spawn_snowy_spider");
        public static final TagKey<Biome> CAN_SPAWN_ARACNIAN = biomeTag("can_spawn_aracnian");
        public static final TagKey<Biome> CAN_SPAWN_WITHER_SPIDER = biomeTag("can_spawn_wither_spider");

        @SuppressWarnings("removal")
        private static TagKey<Biome> biomeTag(String name){
            return TagKey.create(Registries.BIOME, new ResourceLocation(ElementalCreatures.MOD_ID,name));
        }
    }
}
