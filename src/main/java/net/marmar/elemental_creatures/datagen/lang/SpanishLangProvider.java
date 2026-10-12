package net.marmar.elemental_creatures.datagen.lang;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.util.enchantment.ECEnchantments;
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

        //Special drops
        addItem(ECItems.LIGHTNING_ESSENCE, "Esencia de relámpago");
        addItem(ECItems.SOUL_FRAGMENT, "Fragmento de alma");

        //Flesh
        addItem(ECItems.SCORCHED_FLESH, "Carne chamuscada");
        addItem(ECItems.SOUL_SCORCHED_FLESH, "Carne pneumática");
        addItem(ECItems.FROZEN_FLESH, "Carne congelada");
        addItem(ECItems.POISONOUS_FLESH, "Carne venenosa");
        addItem(ECItems.DECAYING_FLESH, "Carne decadente");
        addItem(ECItems.FUNGAL_FLESH, "Carne fúngica");

        //Other food
        addItem(ECItems.IDUNN_APPLE, "Manzana de Iðunn");
        addItemDesc("idunn_apple", "Aplica Regeneración cuando se consume. Al dárselo a un mob, previene que se convierta en Elemental.");

        //Arrows
        addItem(ECItems.LIGHTNING_ARROW, "Flecha eléctrica");
        addItemDesc("lightning_arrow", "Causa daño eléctrico que penetra la armadura. Chance de generar relámpagos cuando se usa con Bendición de Zeus.");

        addItem(ECItems.SOUL_ARROW, "Flecha de alma");
        addItemDesc("soul_arrow", "Quema al objetivo con fuego de almas, causando daño adicional.");

        addItem(ECItems.PRISMARINE_ARROW, "Flecha de prismarina");
        addItemDesc("prismarine_arrow", "Recorre el agua como si fuése aire.");

        //Potions
        addPotion("decay_potion", "Poción de Decadencia", "Poción arojadiza de Decadencia", "Poción persistente de Decadencia", "Flecha de Decadencia");
        addPotion("long_decay_potion", "Poción de Decadencia", "Poción arojadiza de Decadencia", "Poción persistente de Decadencia", "Flecha de Decadencia");
        addPotion("strong_decay_potion", "Poción de Decadencia", "Poción arojadiza de Decadencia", "Poción persistente de Decadencia", "Flecha de Decadencia");

        addPotion("blindness_potion", "Poción de Ceguera", "Poción arojadiza de Ceguera", "Poción persistente de Ceguera", "Flecha de Ceguera");
        addPotion("long_blindness_potion", "Poción de Ceguera", "Poción arojadiza de Ceguera", "Poción persistente de Ceguera", "Flecha de Ceguera");
        addPotion("strong_blindness_potion", "Poción de Ceguera", "Poción arojadiza de Ceguera", "Poción persistente de Ceguera", "Flecha de Ceguera");

        //Enchantments
        addEnchantment(ECEnchantments.ZEUS_BLESSING, "Bendición de Zeus");
        addEnchantmentDesc("zeus_blessing", "Genera un relámpago al impactar un objetivo con flechas eléctricas.");

        addEnchantment(ECEnchantments.WILL_O_THE_WISP, "Fuego fátuo");
        addEnchantmentDesc("will_o_the_wisp", "Incendia al objetivo con fuego de alma. El tiempo base es 5 segundos, y se multiplica por el nivel del encantamiento.");

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

        addZombieType(ECEntityTypes.DECADENT.get(), "Decadente", ECItems.DECADENT_SPAWN_EGG, "Generar Decadente");
        addMobDesc("decadent", "Este enemigo inflinge Wither al atacar. Se genera cuando un zombi se mantiene bajo el efecto de Wither durante 15 segundos.");

        addZombieType(ECEntityTypes.FUNGUS.get(), "Fúngico", ECItems.FUNGUS_SPAWN_EGG, "Generar Fúngico");
        addMobDesc("fungus", "Este enemigo inflinge Ceguera al atacar. Se genera cuando un zombi se queda en un bioma fúngico durante un dia entero (20 minutos).");

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

        addSkeletonType(ECEntityTypes.ASHEN.get(), "Pálido", ECItems.ASHEN_SPAWN_EGG, "Generar Pálido");
        addMobSubtitles("ashen", "Pálido gruñendo", "Pálido caminando", "Pálido lastimado", "Pálido muriendo");

        addSkeletonType(ECEntityTypes.BLIGHT.get(), "Marchito", ECItems.BLIGHT_SPAWN_EGG, "Generar Marchito");
        addMobSubtitles("blight", "Marchito gruñendo", "Marchito caminando", "Marchito lastimado", "Marchito muriendo");

        //Slimes
        addSlimeType(ECEntityTypes.ICE_CUBE.get(), "Cubo Helado", ECItems.ICE_CUBE_SPAWN_EGG, "Generar Cubo Helado");
        addMobSubtitles("ice_cube", "Cubo Helado tranquilo", "Cubo Helado saltando", "Cubo Helado lastimado", "Cubo Helado muriendo");

        addSlimeType(ECEntityTypes.SAND_CUBE.get(), "Cubo de Arena", ECItems.SAND_CUBE_SPAWN_EGG, "Generar Cubo de Arena");
        addMobSubtitles("sand_cube", "Cubo de Arena tranquilo", "Cubo de Arena saltando", "Cubo de Arena lastimado", "Cubo de Arena muriendo");

        addSlimeType(ECEntityTypes.RED_SAND_CUBE.get(), "Cubo de Arena Rojiza", ECItems.RED_SAND_CUBE_SPAWN_EGG, "Generar Cubo de Arena Rojiza");
        addMobSubtitles("red_sand_cube", "Cubo de Arena Rojiza tranquilo", "Cubo de Arena Rojiza saltando", "Cubo de Arena Rojiza lastimado", "Cubo de Arena Rojiza muriendo");

        addSlimeType(ECEntityTypes.PHRANQUE.get(), "Phranque", ECItems.PHRANQUE_SPAWN_EGG, "Generar Phranque");
        addMobSubtitles("phranque", "Phranque tranquilo", "Phranque saltando", "Phranque lastimado", "Phranque muriendo");

        //Spiders
        addSpiderType(ECEntityTypes.DESERT_SPIDER.get(), "Araña del desierto", ECItems.DESERT_SPIDER_SPAWN_EGG, "Generar Araña del desierto");
        addMobSubtitles("desert_spider", "Araña del desierto hablando", "Araña del desierto caminando", "Araña del desierto lastimada", "Araña del desierto muriendo");

        addSpiderType(ECEntityTypes.SNOWY_SPIDER.get(), "Araña de las Nieves", ECItems.SNOWY_SPIDER_SPAWN_EGG, "Generar Araña de las Nieves");
        addMobSubtitles("snowy_spider", "Araña de las Nieves hablando", "Araña de las Nieves caminando", "Araña de las Nieves lastimada", "Araña de las Nieves muriendo");

        addSpiderType(ECEntityTypes.ARACNIAN.get(), "Hija de Aracne", ECItems.ARACNIAN_SPAWN_EGG, "Generar Hija de Aracne");
        addMobSubtitles("aracnian", "Hija de Aracne hablando", "Hija de Aracne caminando", "Hija de Aracne lastimada", "Hija de Aracne muriendo");

        addSpiderType(ECEntityTypes.WITHER_SPIDER.get(), "Araña del Wither", ECItems.WITHER_SPIDER_SPAWN_EGG, "Generar Araña del Wither");
        addMobDesc("wither_spider", "Este mob neutral aplica Wither al atacar. Se genera cuando una araña se encuentra bajo el efecto Wither durante 7,5 segundos.");
    }
}
