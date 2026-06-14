package net.marmar.elemental_creatures.datagen.model;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.item.ECItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ECItemModelProvider extends ItemModelProvider {
    public ECItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ElementalCreatures.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Projectiles
        addItem(ECItems.LIGHTNING_ARROW);
        addItem(ECItems.SOUL_ARROW);

        //Spawn eggs
        spawnEggItem(ECItems.SCORCHED_SPAWN_EGG);
        spawnEggItem(ECItems.LOST_SPAWN_EGG);
        spawnEggItem(ECItems.ROTTEN_SPAWN_EGG);
        spawnEggItem(ECItems.ILLAPISTA_SPAWN_EGG);
    }

    private ItemModelBuilder addItem(RegistryObject<Item> pItem){
        return withExistingParent(pItem.getId().getPath(),
                mcLoc("item/generated")).texture ("layer0",
                modLoc("item/" + pItem.getId().getPath()));
    }

    private ItemModelBuilder spawnEggItem(RegistryObject<Item> pItem){
        return withExistingParent(pItem.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
