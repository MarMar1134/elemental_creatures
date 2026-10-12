package net.marmar.elemental_creatures.datagen.lang;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.util.enchantment.ECEnchantments;
import net.minecraft.data.PackOutput;

public class EnglishLangProvider extends AbstractLangProvider {
    public EnglishLangProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        addCreativeModeTab("elementals_spawn_eggs", "Elemental's Spawn Eggs");
        addCreativeModeTab("elemental_items", "Elemental's Items");

        addLightingDamage("has been punished by the gods", "has been punished by the gods trying to scape");

        //Special drops
        addItem(ECItems.LIGHTNING_ESSENCE, "Lightning essence");
        addItem(ECItems.SOUL_FRAGMENT, "Soul fragment");

        //Flesh
        addItem(ECItems.SCORCHED_FLESH, "Burnt flesh");
        addItem(ECItems.SOUL_SCORCHED_FLESH, "Pneumatic flesh");
        addItem(ECItems.FROZEN_FLESH, "Frozen flesh");
        addItem(ECItems.POISONOUS_FLESH, "Poisonous flesh");
        addItem(ECItems.DECAYING_FLESH, "Decaying flesh");
        addItem(ECItems.FUNGAL_FLESH, "Fungal flesh");

        //Other food
        addItem(ECItems.IDUNN_APPLE, "Iðunn apple");
        addItemDesc("idunn_apple", "Gives Healing when consumed. When used on a mob, prevents its convertion to an Elemental.");

        //Arrows
        addItem(ECItems.LIGHTNING_ARROW, "Lightning arrow");
        addItemDesc("lightning_arrow", "Deals lightning damage. Can summon lightning bolts when used with Zeus Blessing.");

        addItem(ECItems.SOUL_ARROW, "Soul arrow");
        addItemDesc("soul_arrow", "Ingnites the target with soul fire, causing additional damage.");

        addItem(ECItems.PRISMARINE_ARROW, "Prismarine arrow");
        addItemDesc("prismarine_arrow", "Travels the water like if it was air.");

        //Potions
        addPotion("decay_potion", "Potion of Decay", "Splash potion of Decay", "Lingering potion of Decay", "Arrow of Decay");
        addPotion("long_decay_potion", "Potion of Decay", "Splash potion of Decay", "Lingering potion of Decay", "Arrow of Decay");
        addPotion("strong_decay_potion", "Potion of Decay", "Splash potion of Decay", "Lingering potion of Decay", "Arrow of Decay");

        addPotion("blindness_potion", "Potion of Blindness", "Splash potion of Blindness", "Lingering potion of Blindness", "Arrow of Blindness");
        addPotion("long_blindness_potion", "Potion of Blindness", "Splash potion of Blindness", "Lingering potion of Blindness", "Arrow of Blindness");
        addPotion("strong_blindness_potion", "Potion of Blindness", "Splash potion of Blindness", "Lingering potion of Blindness", "Arrow of Blindness");

        //Enchantments
        addEnchantment(ECEnchantments.ZEUS_BLESSING, "Zeus Blessing");
        addEnchantmentDesc("zeus_blessing", "When shooting a Lightning arrow, spawns a lightning bolt on hit.");

        addEnchantment(ECEnchantments.WILL_O_THE_WISP, "Will o' the Wisp");
        addEnchantmentDesc("will_o_the_wisp", "Ignites the target on soul fire. The time on fire is 5 * enchantmentLevel.");

        //Zombies
        addZombieType(ECEntityTypes.SCORCHED.get(),"Scorched", ECItems.SCORCHED_SPAWN_EGG, "Scorched spawn egg");
        addMobDesc("scorched", "This hostile mob burns the player on touch. It spawns when a Zombie stays on fire for 15 seconds.");
        addMobSubtitles("scorched", "Scorched growling", "Scorched walking", "Hurt Scorched", "Dying Scorched");

        addZombieType(ECEntityTypes.SOUL_SCORCHED.get(),"Soul Scorched", ECItems.SOUL_SCORCHED_SPAWN_EGG, "Soul Scorched spawn egg");
        addMobDesc("soul_scorched", "This hostile mob burns the player with soul fire on touch. It spawns when a Zombie stays on soul fire for 15 seconds.");
        addMobSubtitles("soul_scorched", "Soul Scorched growling", "Soul Scorched walking", "Hurt Soul Scorched", "Dying Soul Scorched");

        addZombieType(ECEntityTypes.LOST.get(),"Lost", ECItems.LOST_SPAWN_EGG, "Lost spawn egg");
        addMobDesc("lost", "This hostile mob freezes the player on touch. It spawns on snowy biomes or when a Zombie stays on powder snow for 20 seconds.");
        addMobSubtitles("lost", "Lost freezing", "Lost walking", "Hurt Lost", "Dying Lost");

        addZombieType(ECEntityTypes.ROTTEN.get(),"Rotten", ECItems.ROTTEN_SPAWN_EGG, "Rotten spawn egg");
        addMobDesc("rotten", "This hostile mob poisons the player on touch. It spawns on swamps.");
        addMobSubtitles("rotten", "Rotten growling", "Rotten walking", "Hurt Rotten", "Dying Rotten");

        addZombieType(ECEntityTypes.ILLAPISTA.get(), "Worshipper of Illapa", ECItems.ILLAPISTA_SPAWN_EGG, "Worshipper of Illapa spawn egg");
        addMobDesc("illapista", "This hostile mob Inflicts lightning damage, which penetrates armor. It spawns when a Zombie is struck with a lightning bolt. Drops Lightning essence.");
        addMobSubtitles("illapista", "Worshipper of Illapa growling", "Worshipper of Illapa walking",
                "Hurt Worshipper of Illapa", "Dying Worshipper of Illapa");

        addZombieType(ECEntityTypes.DECADENT.get(), "Decadent", ECItems.DECADENT_SPAWN_EGG, "Decadent spawn egg");
        addMobDesc("decadent", "This hostile mob inflicts wither on touch. It spawns when a Zombie stays withered for 15 seconds.");

        addZombieType(ECEntityTypes.FUNGUS.get(), "Fungal", ECItems.FUNGUS_SPAWN_EGG, "Fungal spawn egg");
        addMobDesc("fungus", "This hostile mob inflicts blindness on touch. It spawns when a Zombie stays on a fungal biome for a whole Minecraft day.");

        //Skeletons
        addSkeletonType(ECEntityTypes.SOUL_REAPER.get(), "Soul Reaper", ECItems.SOUL_REAPER_SPAWN_EGG, "Soul Reaper spawn egg");
        addMobDesc("soul_reaper", "This hostile mob shoots soul arrows, which inflict soul fire to the target. It spawns on Soul sand valleys");
        addMobSubtitles("soul_reaper", "Soul Reaper growling", "Soul Reaper walking", "Hurt Soul Reaper", "Dying Soul Reaper");

        addSkeletonType(ECEntityTypes.TLALOCQUIAN.get(), "Follower of Tláloc", ECItems.TLALOCQUIAN_SPAWN_EGG, "Follower of Tláloc spawn egg");
        addMobDesc("tlaloquian", "This hostile mob shoots lightning arrows, which penetrates armor. It spawns when a Skeleton is struck with a lightning bolt. Drops Lightning essence.");
        addMobSubtitles("tlalocquian", "Follower of Tláloc growling", "Follower of Tláloc walking",
                "Hurt Follower of Tláloc", "Dying Follower of Tláloc");

        addSkeletonType(ECEntityTypes.SUNKEN.get(), "Sunken", ECItems.SUNKEN_SPAWN_EGG, "Sunken spawn egg");
        addMobDesc("sunken", "This hostile mob shoots prismarine arrows, which travel the water like air. It spawns when a Skeleton stays underwater for 30 seconds.");
        addMobSubtitles("sunken", "Sunken growling", "Sunken walking", "Hurt Sunken", "Dying Sunken");

        addSkeletonType(ECEntityTypes.DRIED.get(), "Dried", ECItems.DRIED_SPAWN_EGG, "Dried spawn egg");
        addMobDesc("dried", "This hostile mob shoots weakness arrows. It spawns on deserts.");
        addMobSubtitles("dried", "Dried growling", "Dried walking", "Hurt Dried", "Dying Dried");

        addSkeletonType(ECEntityTypes.PUTRID.get(), "Putrid", ECItems.PUTRID_SPAWN_EGG, "Putrid spawn egg");
        addMobDesc("putrid", "This hostile mob shoots poisonous arrows. It spawns on swamps.");
        addMobSubtitles("putrid", "Putrid growling", "Putrid walking", "Hurt Putrid", "Dying Putrid");

        addSkeletonType(ECEntityTypes.ASHEN.get(), "Ashen", ECItems.ASHEN_SPAWN_EGG, "Ashen spawn egg");
        addMobDesc("ashen", "This hostile mob shoots fire arrows. It spawns when a skeleton stays on fire for 15 seconds.");
        addMobSubtitles("ashen", "Ashen growling", "Ashen walking", "Hurt Ashen", "Dying Ashen");

        addSkeletonType(ECEntityTypes.BLIGHT.get(), "Blighted", ECItems.BLIGHT_SPAWN_EGG, "Blighted spawn egg");
        addMobDesc("blight", "This hostile mob shoots blindness arrows. It spawns when a skeleton stays on a fungal biome for a whole Minecraft day.");
        addMobSubtitles("blight", "Blighted growling", "Blighted walking", "Hurt Blighted", "Dying Blighted");

        //Slimes
        addSlimeType(ECEntityTypes.ICE_CUBE.get(), "Ice Cube", ECItems.ICE_CUBE_SPAWN_EGG, "Ice Cube spawn egg");
        addMobDesc("ice_cube", "This hostile mob freezes the player on touch and drops additional snowballs when killed. It spawns on snowy biomes.");
        addMobSubtitles("ice_cube", "Ice Cube squishing", "Ice Cube jumping", "Hurt Ice Cube", "Dying Ice Cube");

        addSlimeType(ECEntityTypes.SAND_CUBE.get(), "Sand Cube", ECItems.SAND_CUBE_SPAWN_EGG, "Sand Cube spawn egg");
        addMobDesc("sand_cube", "This hostile mob drops additional sand when killed. It spawns on deserts.");
        addMobSubtitles("sand_cube", "Sand Cube squishing", "Sand Cube jumping", "Hurt Sand Cube", "Dying Sand Cube");

        addSlimeType(ECEntityTypes.RED_SAND_CUBE.get(), "Red Sand Cube", ECItems.RED_SAND_CUBE_SPAWN_EGG, "Red Sand Cube spawn egg");
        addMobDesc("red_sand_cube", "This hostile mob drops additional red sand when killed. It spawns on badlands.");
        addMobSubtitles("red_sand_cube", "Red Sand Cube squishing", "Red Sand Cube jumping", "Hurt Red Sand Cube", "Dying Red Sand Cube");

        addSlimeType(ECEntityTypes.PHRANQUE.get(), "Phranque", ECItems.PHRANQUE_SPAWN_EGG, "Phranque spawn egg");
        addMobDesc("phranque", "This hostile mob inflicts additional lightning damage. It spawns when a Slime is struck with a lightning bolt. Drops Lightning essence.");
        addMobSubtitles("phranque", "Phranque squishing", "Phranque jumping", "Hurt Phranque", "Dying Phranque");

        //Spiders
        addSpiderType(ECEntityTypes.DESERT_SPIDER.get(), "Desert Spider", ECItems.DESERT_SPIDER_SPAWN_EGG, "Desert Spider spawn egg");
        addMobDesc("desert_spider", "This neutral mob weakens the player on touch. It spawns on deserts.");
        addMobSubtitles("desert_spider", "Desert Spider talking", "Desert Spider walking", "Hurt Desert Spider", "Dying Desert Spider");

        addSpiderType(ECEntityTypes.SNOWY_SPIDER.get(), "Snowy Spider", ECItems.SNOWY_SPIDER_SPAWN_EGG, "Snowy Spider spawn egg");
        addMobDesc("snowy_spider", "This neutral mob slows the player on touch. It spawns on snowy biomes.");
        addMobSubtitles("snowy_spider", "Snowy Spider talking", "Snowy Spider walking", "Hurt Snowy Spider", "Dying Snowy Spider");

        addSpiderType(ECEntityTypes.ARACNIAN.get(), "Child of Aracne", ECItems.ARACNIAN_SPAWN_EGG, "Child of Aracne spawn egg");
        addMobDesc("aracnian", "This neutral mob inflicts additional lightning damage. It spawns when a Spider is struck with a lightning bolt. Drops Lightning essence.");
        addMobSubtitles("aracnian", "Child of Aracne talking", "Child of Aracne walking", "Hurt Child of Aracne", "Dying Child of Aracne");

        addSpiderType(ECEntityTypes.WITHER_SPIDER.get(), "Wither spider", ECItems.WITHER_SPIDER_SPAWN_EGG, "Wither Spider spawn egg");
        addMobDesc("wither_spider", "This neutral mob inflicts Wither on touch. It spawns when a Spider stays withered for 7.5 seconds");
    }
}
