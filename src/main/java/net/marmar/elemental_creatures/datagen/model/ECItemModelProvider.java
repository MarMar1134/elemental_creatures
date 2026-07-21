package net.marmar.elemental_creatures.datagen.model;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.item.ECItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ECItemModelProvider extends ItemModelProvider {
    public ECItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ElementalCreatures.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Others
        addItem(ECItems.LIGHTNING_ESSENCE);

        //Projectiles
        addItem(ECItems.LIGHTNING_ARROW);
        addItem(ECItems.SOUL_ARROW);
        addItem(ECItems.PRISMARINE_ARROW);

        //Zombie spawn eggs
        spawnEggItem(ECItems.SCORCHED_SPAWN_EGG);
        spawnEggItem(ECItems.SOUL_SCORCHED_SPAWN_EGG);
        spawnEggItem(ECItems.LOST_SPAWN_EGG);
        spawnEggItem(ECItems.ROTTEN_SPAWN_EGG);
        spawnEggItem(ECItems.ILLAPISTA_SPAWN_EGG);

        //Skeleton spawn eggs
        spawnEggItem(ECItems.SOUL_REAPER_SPAWN_EGG);
        spawnEggItem(ECItems.TLALOCQUIAN_SPAWN_EGG);
        spawnEggItem(ECItems.SUNKEN_SPAWN_EGG);
        spawnEggItem(ECItems.DRIED_SPAWN_EGG);
        spawnEggItem(ECItems.PUTRID_SPAWN_EGG);

        //Slime spawn eggs
        spawnEggItem(ECItems.ICE_CUBE_SPAWN_EGG);
        spawnEggItem(ECItems.SAND_CUBE_SPAWN_EGG);
        spawnEggItem(ECItems.RED_SAND_CUBE_SPAWN_EGG);
        spawnEggItem(ECItems.PHRANQUE_SPAWN_EGG);
    }

    private void addItem(RegistryObject<Item> pItem){
        withExistingParent(pItem.getId().getPath(),
                mcLoc("item/generated")).texture("layer0",
                modLoc("item/" + pItem.getId().getPath()));
    }

    private void spawnEggItem(RegistryObject<Item> pItem){
        withExistingParent(pItem.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
