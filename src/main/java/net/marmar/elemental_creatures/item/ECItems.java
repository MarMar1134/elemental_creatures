package net.marmar.elemental_creatures.item;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.item.arrow.LightningArrowItem;
import net.marmar.elemental_creatures.item.arrow.PrismarineArrowItem;
import net.marmar.elemental_creatures.item.arrow.SoulArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ECItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, ElementalCreatures.MOD_ID);

    //Others
    public static final RegistryObject<Item> LIGHTNING_ESSENCE = ITEMS.register(
            "lightning_essence", () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC)));

    //Projectiles
    public static final RegistryObject<Item> LIGHTNING_ARROW = ITEMS.register(
            "lightning_arrow", () -> new LightningArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> SOUL_ARROW = ITEMS.register(
            "soul_arrow", () -> new SoulArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> PRISMARINE_ARROW = ITEMS.register(
            "prismarine_arrow", () -> new PrismarineArrowItem(new Item.Properties()));

    //Zombie spawn eggs
    public static final RegistryObject<Item> SCORCHED_SPAWN_EGG = ITEMS.register(
            "scorched_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.SCORCHED, 0x53310d,
                    0xac6e2a, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_SCORCHED_SPAWN_EGG = ITEMS.register(
            "soul_scorched_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.SOUL_SCORCHED, 0x113b3c,
                    0x3f483e, new Item.Properties()));
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
    public static final RegistryObject<Item> TLALOCQUIAN_SPAWN_EGG = ITEMS.register(
            "tlalocquian_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.TLALOCQUIAN, 0x979797,
                    0x061e83, new Item.Properties()));
    public static final RegistryObject<Item> SUNKEN_SPAWN_EGG = ITEMS.register(
            "sunken_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.SUNKEN, 0x40615f,
                    0x53ba73, new Item.Properties()));
    public static final RegistryObject<Item> DRIED_SPAWN_EGG = ITEMS.register(
            "dried_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.DRIED, 0x74746b,
                    0x9e8a5f, new Item.Properties()));
    public static final RegistryObject<Item> PUTRID_SPAWN_EGG = ITEMS.register(
            "putrid_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.PUTRID, 0xcbccbb,
                    0x212c06, new Item.Properties()));

    //Slime spawn eggs
    public static final RegistryObject<Item> ICE_CUBE_SPAWN_EGG = ITEMS.register(
            "ice_cube_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.ICE_CUBE, 0x70a4e5,
                    0x314b6c, new Item.Properties()));

    public static final RegistryObject<Item> SAND_CUBE_SPAWN_EGG = ITEMS.register(
            "sand_cube_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.SAND_CUBE, 0xd1ba8a,
                    0xa3a279, new Item.Properties()));

    public static final RegistryObject<Item> RED_SAND_CUBE_SPAWN_EGG = ITEMS.register(
            "red_sand_cube_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.RED_SAND_CUBE, 0xc06822,
                    0xc2955e, new Item.Properties()));

    public static final RegistryObject<Item> PHRANQUE_SPAWN_EGG = ITEMS.register(
            "phranque_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.PHRANQUE, 0x00e0e0,
                    0x9da9a8, new Item.Properties()));

    //Spider spawn eggs
    public static final RegistryObject<Item> DESERT_SPIDER_SPAWN_EGG = ITEMS.register(
            "desert_spider_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.DESERT_SPIDER, 0x473f31,
                    0x02303c, new Item.Properties()));

    public static final RegistryObject<Item> SNOWY_SPIDER_SPAWN_EGG = ITEMS.register(
            "snowy_spider_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.SNOWY_SPIDER, 0x717170,
                    0x213c02, new Item.Properties()));

    public static final RegistryObject<Item> ARACNIAN_SPAWN_EGG = ITEMS.register(
            "aracnian_spawn_egg", () -> new ForgeSpawnEggItem(ECEntityTypes.ARACNIAN, 0x376260,
                    0xa8710e, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ElementalCreatures.LOGGER.info("Registering Elemental Creatures items...");
        ITEMS.register(eventBus);
    }
}
