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

        addItem(ECItems.LIGHTNING_ARROW, "Lightning arrow");
        addItem(ECItems.SOUL_ARROW, "Soul arrow");

        //Zombies
        addZombieType(ECEntityTypes.SCORCHED.get(),"Scorched", ECItems.SCORCHED_SPAWN_EGG, "Scorched spawn egg");
        addMobSubtitles("scorched", "Scorched growling", "Scorched walking", "Hurt Scorched", "Dying Scorched");

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
    }
}
