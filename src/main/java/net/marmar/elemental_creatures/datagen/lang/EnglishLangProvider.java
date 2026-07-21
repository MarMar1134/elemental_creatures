package net.marmar.elemental_creatures.datagen.lang;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.item.ECItems;
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

        addItem(ECItems.LIGHTNING_ESSENCE, "Lightning essence");
        
        addItem(ECItems.LIGHTNING_ARROW, "Lightning arrow");
        addItem(ECItems.SOUL_ARROW, "Soul arrow");
        addItem(ECItems.PRISMARINE_ARROW, "Prismarine arrow");

        //Zombies
        addZombieType(ECEntityTypes.SCORCHED.get(),"Scorched", ECItems.SCORCHED_SPAWN_EGG, "Scorched spawn egg");
        addMobSubtitles("scorched", "Scorched growling", "Scorched walking", "Hurt Scorched", "Dying Scorched");

        addZombieType(ECEntityTypes.SOUL_SCORCHED.get(),"Soul Scorched", ECItems.SOUL_SCORCHED_SPAWN_EGG, "Soul Scorched spawn egg");
        addMobSubtitles("soul_scorched", "Soul Scorched growling", "Soul Scorched walking", "Hurt Soul Scorched", "Dying Soul Scorched");

        addZombieType(ECEntityTypes.LOST.get(),"Lost", ECItems.LOST_SPAWN_EGG, "Lost spawn egg");
        addMobSubtitles("lost", "Lost freezing", "Lost walking", "Hurt Lost", "Dying Lost");

        addZombieType(ECEntityTypes.ROTTEN.get(),"Rotten", ECItems.ROTTEN_SPAWN_EGG, "Rotten spawn egg");
        addMobSubtitles("rotten", "Rotten growling", "Rotten walking", "Hurt Rotten", "Dying Rotten");

        addZombieType(ECEntityTypes.ILLAPISTA.get(), "Worshipper of Illapa", ECItems.ILLAPISTA_SPAWN_EGG, "Worshipper of Illapa spawn egg");
        addMobSubtitles("illapista", "Worshipper of Illapa growling", "Worshipper of Illapa walking",
                "Hurt Worshipper of Illapa", "Dying Worshipper of Illapa");

        //Skeletons
        addSkeletonType(ECEntityTypes.SOUL_REAPER.get(), "Soul Reaper", ECItems.SOUL_REAPER_SPAWN_EGG, "Soul Reaper spawn egg");
        addMobSubtitles("soul_reaper", "Soul Reaper growling", "Soul Reaper walking", "Hurt Soul Reaper", "Dying Soul Reaper");

        addSkeletonType(ECEntityTypes.TLALOCQUIAN.get(), "Follower of Tláloc", ECItems.TLALOCQUIAN_SPAWN_EGG, "Follower of Tláloc spawn egg");
        addMobSubtitles("tlalocquian", "Follower of Tláloc growling", "Follower of Tláloc walking",
                "Hurt Follower of Tláloc", "Dying Follower of Tláloc");

        addSkeletonType(ECEntityTypes.SUNKEN.get(), "Sunken", ECItems.SUNKEN_SPAWN_EGG, "Sunken spawn egg");
        addMobSubtitles("sunken", "Sunken growling", "Sunken walking", "Hurt Sunken", "Dying Sunken");

        addSkeletonType(ECEntityTypes.DRIED.get(), "Dried", ECItems.DRIED_SPAWN_EGG, "Dried spawn egg");
        addMobSubtitles("dried", "Dried growling", "Dried walking", "Hurt Dried", "Dying Dried");

        addSkeletonType(ECEntityTypes.PUTRID.get(), "Putrid", ECItems.PUTRID_SPAWN_EGG, "Putrid spawn egg");
        addMobSubtitles("putrid", "Putrid growling", "Putrid walking", "Hurt Putrid", "Dying Putrid");

        //Slimes
        addSlimeType(ECEntityTypes.ICE_CUBE.get(), "Ice Cube", ECItems.ICE_CUBE_SPAWN_EGG, "Ice Cube spawn egg");
        addMobSubtitles("ice_cube", "Ice Cube squishing", "Ice Cube jumping", "Hurt Ice Cube", "Dying Ice Cube");

        addSlimeType(ECEntityTypes.SAND_CUBE.get(), "Sand Cube", ECItems.SAND_CUBE_SPAWN_EGG, "Sand Cube spawn egg");
        addMobSubtitles("sand_cube", "Sand Cube squishing", "Sand Cube jumping", "Hurt Sand Cube", "Dying Sand Cube");

        addSlimeType(ECEntityTypes.RED_SAND_CUBE.get(), "Red Sand Cube", ECItems.RED_SAND_CUBE_SPAWN_EGG, "Red Sand Cube spawn egg");
        addMobSubtitles("red_sand_cube", "Red Sand Cube squishing", "Red Sand Cube jumping", "Hurt Red Sand Cube", "Dying Red Sand Cube");

        addSlimeType(ECEntityTypes.PHRANQUE.get(), "Phranque", ECItems.PHRANQUE_SPAWN_EGG, "Phranque spawn egg");
        addMobSubtitles("phranque", "Phranque squishing", "Phranque jumping", "Hurt Phranque", "Dying Phranque");
    }
}
