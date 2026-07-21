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

        addItem(ECItems.LIGHTNING_ESSENCE, "Esencia de relámpago");

        addItem(ECItems.LIGHTNING_ARROW, "Flecha eléctrica");
        addItem(ECItems.SOUL_ARROW, "Flecha de alma");
        addItem(ECItems.PRISMARINE_ARROW, "Flecha de prismarina");

        //Zombies
        addZombieType(ECEntityTypes.SCORCHED.get(),"Scorched", ECItems.SCORCHED_SPAWN_EGG, "Generar Quemado");
        addMobSubtitles("scorched", "Quemado gruñendo", "Quemado caminando", "Quemado lastimado", "Quemado muriendo");

        addZombieType(ECEntityTypes.SOUL_SCORCHED.get(),"Soul Scorched", ECItems.SOUL_SCORCHED_SPAWN_EGG, "Generar Quemado pneumático");
        addMobSubtitles("soul_scorched", "Quemado pneumático gruñendo", "Quemado pneumático caminando", "Quemado pneumático lastimado", "Quemado pneumático muriendo");

        addZombieType(ECEntityTypes.LOST.get(),"Lost", ECItems.LOST_SPAWN_EGG, "Generar Perdido");
        addMobSubtitles("lost", "Perdido gruñendo", "Perdido caminando", "Perdido lastimado", "Perdido muriendo");

        addZombieType(ECEntityTypes.ROTTEN.get(),"Rotten", ECItems.ROTTEN_SPAWN_EGG, "Generar Podrido");
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

        addSkeletonType(ECEntityTypes.SUNKEN.get(), "Húndido", ECItems.SUNKEN_SPAWN_EGG, "Generar Húndido");
        addMobSubtitles("sunken", "Húndido gruñendo", "Húndido caminando", "Húndido lastimado", "Húndido muriendo");

        addSkeletonType(ECEntityTypes.DRIED.get(), "Resecado", ECItems.DRIED_SPAWN_EGG, "Generar Resecado");
        addMobSubtitles("dried", "Resecado gruñendo", "Resecado caminando", "Resecado lastimado", "Resecado muriendo");

        addSkeletonType(ECEntityTypes.PUTRID.get(), "Pútrido", ECItems.PUTRID_SPAWN_EGG, "Generar Pútrido");
        addMobSubtitles("putrid", "Pútrido gruñendo", "Pútrido caminando", "Pútrido lastimado", "Pútrido muriendo");

        //Slimes
        addSlimeType(ECEntityTypes.ICE_CUBE.get(), "Cubo Helado", ECItems.ICE_CUBE_SPAWN_EGG, "Generar Cubo Helado");
        addMobSubtitles("ice_cube", "Cubo Helado tranquilo", "Cubo Helado saltando", "Cubo Helado lastimado", "Cubo Helado muriendo");

        addSlimeType(ECEntityTypes.SAND_CUBE.get(), "Cubo de Arena", ECItems.SAND_CUBE_SPAWN_EGG, "Generar Cubo de Arena");
        addMobSubtitles("sand_cube", "Cubo de Arena tranquilo", "Cubo de Arena saltando", "Cubo de Arena lastimado", "Cubo de Arena muriendo");

        addSlimeType(ECEntityTypes.RED_SAND_CUBE.get(), "Cubo de Arena Rojiza", ECItems.RED_SAND_CUBE_SPAWN_EGG, "Generar Cubo de Arena Rojiza");
        addMobSubtitles("red_sand_cube", "Cubo de Arena Rojiza tranquilo", "Cubo de Arena Rojiza saltando", "Cubo de Arena Rojiza lastimado", "Cubo de Arena Rojiza muriendo");

        addSlimeType(ECEntityTypes.PHRANQUE.get(), "Phranque", ECItems.PHRANQUE_SPAWN_EGG, "Generar Phranque");
        addMobSubtitles("phranque", "Phranque tranquilo", "Phranque saltando", "Phranque lastimado", "Phranque muriendo");
    }
}
