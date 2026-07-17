package net.marmar.elemental_creatures.entity;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.projectile.LightningArrowEntity;
import net.marmar.elemental_creatures.entity.projectile.PrismarineArrowEntity;
import net.marmar.elemental_creatures.entity.projectile.SoulArrowEntity;
import net.marmar.elemental_creatures.entity.skeleton.*;
import net.marmar.elemental_creatures.entity.zombie.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ECEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ElementalCreatures.MOD_ID);

    //Projectiles
    public static final RegistryObject<EntityType<LightningArrowEntity>> LIGHTNING_ARROW =
            ENTITY_TYPES.register("lightning_arrow", () -> EntityType.Builder.<LightningArrowEntity>of(LightningArrowEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
                    .build("lightning_arrow"));

    public static final RegistryObject<EntityType<SoulArrowEntity>> SOUL_ARROW =
            ENTITY_TYPES.register("soul_arrow", () -> EntityType.Builder.<SoulArrowEntity>of(SoulArrowEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
                    .build("soul_arrow"));

    public static final RegistryObject<EntityType<PrismarineArrowEntity>> PRISMARINE_ARROW =
            ENTITY_TYPES.register("prismarine_arrow", () -> EntityType.Builder.<PrismarineArrowEntity>of(PrismarineArrowEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
                    .build("prismarine_arrow"));

    //Zombies
    public static final RegistryObject<EntityType<Scorched>> SCORCHED =
            ENTITY_TYPES.register("scorched", () -> EntityType.Builder.of(Scorched::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build("scorched"));

    public static final RegistryObject<EntityType<SoulScorched>> SOUL_SCORCHED =
            ENTITY_TYPES.register("soul_scorched", () -> EntityType.Builder.of(SoulScorched::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build("soul_scorched"));

    public static final RegistryObject<EntityType<Lost>> LOST =
            ENTITY_TYPES.register("lost", () -> EntityType.Builder.of(Lost::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build("lost"));

    public static final RegistryObject<EntityType<Rotten>> ROTTEN =
            ENTITY_TYPES.register("rotten", () -> EntityType.Builder.of(Rotten::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build("rotten"));

    public static final RegistryObject<EntityType<Illapista>> ILLAPISTA =
            ENTITY_TYPES.register("illapista", () -> EntityType.Builder.of(Illapista::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build("illapista"));

    //Skeletons
    public static final RegistryObject<EntityType<SoulReaper>> SOUL_REAPER =
            ENTITY_TYPES.register("soul_reaper", () -> EntityType.Builder.of(SoulReaper::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.99F).build("soul_reaper"));

    public static final RegistryObject<EntityType<Tlalocquian>> TLALOCQUIAN =
            ENTITY_TYPES.register("tlalocquian", () -> EntityType.Builder.of(Tlalocquian::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.99F).build("tlalocquian"));

    public static final RegistryObject<EntityType<Sunken>> SUNKEN =
            ENTITY_TYPES.register("sunken", () -> EntityType.Builder.of(Sunken::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.99F).build("sunken"));

    public static final RegistryObject<EntityType<Dried>> DRIED =
            ENTITY_TYPES.register("dried", () -> EntityType.Builder.of(Dried::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.99F).build("dried"));

    public static final RegistryObject<EntityType<Putrid>> PUTRID =
            ENTITY_TYPES.register("putrid", () -> EntityType.Builder.of(Putrid::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.99F).build("putrid"));

    public static void register(IEventBus eventBus){
        ElementalCreatures.LOGGER.info("Registering Elemental Creatures entities...");
        ENTITY_TYPES.register(eventBus);
    }
}
