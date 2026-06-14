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
        add("tab.elemental_creatures.elementals_spawn_eggs", "Generadores de elementales");

        addLightingDamage("fue castigado por los dioses", "fue castigado por los dioses mientras luchaba con");

        addItem(ECItems.LIGHTNING_ARROW, "Flecha eléctrica");

        addZombieType(ECEntityTypes.SCORCHED.get(),"Scorched", ECItems.SCORCHED_SPAWN_EGG, "Generar Scorched");
        addZombieType(ECEntityTypes.LOST.get(),"Lost", ECItems.LOST_SPAWN_EGG, "Generar Lost");
        addZombieType(ECEntityTypes.ROTTEN.get(),"Rotten", ECItems.ROTTEN_SPAWN_EGG, "Generar Rotten");
        addZombieType(ECEntityTypes.ILLAPISTA.get(), "Adorador de Illapa", ECItems.ILLAPISTA_SPAWN_EGG, "Generar Adorador de Illapa");
    }
}
