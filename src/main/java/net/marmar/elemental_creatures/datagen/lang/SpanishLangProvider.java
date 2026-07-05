package net.marmar.elemental_creatures.datagen.lang;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.item.ECItems;
import net.minecraft.data.PackOutput;

public class SpanishLangProvider extends AbstractLangProvider {
    public SpanishLangProvider(PackOutput output, String locale) {
        super(output, locale);
    }

    @Override
    protected void addTranslations() {
        addCreativeModeTab("elementals_spawn_eggs", "Generadores de Elementales");
        addCreativeModeTab("elemental_items", "Objetos de Elementales");

        addLightingDamage("fue castigado por los dioses", "fue castigado por los dioses mientras luchaba con");

        addItem(ECItems.LIGHTNING_ARROW, "Flecha eléctrica");
        addItem(ECItems.SOUL_ARROW, "Flecha de alma");

        //Zombies
        addZombieType(ECEntityTypes.SCORCHED.get(),"Scorched", ECItems.SCORCHED_SPAWN_EGG, "Generar Quemado (Scorched)");
        addMobSubtitles("scorched", "Quemado gruñendo", "Quemado caminando", "Quemado lastimado", "Quemado muriendo");

        addZombieType(ECEntityTypes.LOST.get(),"Lost", ECItems.LOST_SPAWN_EGG, "Generar Perdido (Lost)");
        addMobSubtitles("lost", "Perdido gruñendo", "Perdido caminando", "Perdido lastimado", "Perdido muriendo");

        addZombieType(ECEntityTypes.ROTTEN.get(),"Rotten", ECItems.ROTTEN_SPAWN_EGG, "Generar Podrido (Rotten)");
        addMobSubtitles("rotten", "Podrido gruñendo", "Podrido caminando", "Podrido lastimado", "Podrido muriendo");

        addZombieType(ECEntityTypes.ILLAPISTA.get(), "Adorador de Illapa", ECItems.ILLAPISTA_SPAWN_EGG, "Generar Adorador de Illapa");
        addMobSubtitles("illapista", "Adorador de Illapa gruñendo", "Adorador de Illapa caminando",
                "Adorador de Illapa lastimado", "Adorador de Illapa muriendo");

        //Skeletons
        addSkeletonType(ECEntityTypes.SOUL_REAPER.get(), "Segador de Almas", ECItems.SOUL_REAPER_SPAWN_EGG, "Generar Segador de Almas");
        addMobSubtitles("soul_reaper", "Segador de Almas gruñendo", "Segador de Almas caminando",
                "Segador de Almas lastimado", "Segador de Almas muriendo");

        addSkeletonType(ECEntityTypes.TLALOCQUIAN.get(), "Seguidor de Tláloc", ECItems.TLALOCQUIAN_SPAWN_EGG, "Generar Seguidor de Tláloc");
        addMobSubtitles("tlalocquian", "Seguidor de Tláloc gruñendo", "Seguidor de Tláloc caminando",
                "Seguidor de Tláloc lastimado", "Seguidor de Tláloc muriendo");
    }
}
