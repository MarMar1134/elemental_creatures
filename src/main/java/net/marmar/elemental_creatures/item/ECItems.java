package net.marmar.elemental_creatures.item;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.item.arrow.LightningArrowItem;
import net.marmar.elemental_creatures.item.arrow.SoulArrowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ECItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, ElementalCreatures.MOD_ID);

    //Projectiles
    public static final RegistryObject<Item> LIGHTNING_ARROW = ITEMS.register(
            "lightning_arrow", () -> new LightningArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> SOUL_ARROW = ITEMS.register(
            "soul_arrow", () -> new SoulArrowItem(new Item.Properties()));

    //Zombie spawn eggs
    public static final RegistryObject<Item> SCORCHED_SPAWN_EGG = ITEMS.register(
            "scorched_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.SCORCHED, 0x53310d,
                    0xac6e2a, new Item.Properties()));

    public static final RegistryObject<Item> LOST_SPAWN_EGG = ITEMS.register(
            "lost_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.LOST, 0x525a51,
                    0x4c4630, new Item.Properties()));

    public static final RegistryObject<Item> ROTTEN_SPAWN_EGG = ITEMS.register(
            "rotten_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.ROTTEN, 0x343a4c,
                    0x71955b, new Item.Properties()));

    public static final RegistryObject<Item> ILLAPISTA_SPAWN_EGG = ITEMS.register(
            "illapista_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.ILLAPISTA, 0x6d1604,
                    0x3a4730, new Item.Properties()));

    //Skeleton spawn eggs
    public static final RegistryObject<Item> SOUL_REAPER_SPAWN_EGG = ITEMS.register(
            "soul_reaper_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.SOUL_REAPER, 0x292420,
                    0x01a7ac, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ElementalCreatures.LOGGER.info("Registering Elemental Creatures items...");
        ITEMS.register(eventBus);
    }
}
