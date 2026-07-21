package net.marmar.elemental_creatures.util;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.item.ECItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ECTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElementalCreatures.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ELEMENTALS_SPAWN_EGGS = TABS.register(
            "elementals_spawm_eggs", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ECItems.SCORCHED_SPAWN_EGG.get()))
                    .title(Component.translatable("tab." + ElementalCreatures.MOD_ID + ".elementals_spawn_eggs"))
                    .withTabsAfter(ECTabs.ELEMENTAL_ITEMS.getId())
                    .displayItems(((pParameters, pOutput) -> {
                        //Zombies
                        pOutput.accept(ECItems.SCORCHED_SPAWN_EGG.get());
                        pOutput.accept(ECItems.SOUL_SCORCHED_SPAWN_EGG.get());
                        pOutput.accept(ECItems.LOST_SPAWN_EGG.get());
                        pOutput.accept(ECItems.ROTTEN_SPAWN_EGG.get());
                        pOutput.accept(ECItems.ILLAPISTA_SPAWN_EGG.get());

                        //Skeletons
                        pOutput.accept(ECItems.SOUL_REAPER_SPAWN_EGG.get());
                        pOutput.accept(ECItems.TLALOCQUIAN_SPAWN_EGG.get());
                        pOutput.accept(ECItems.SUNKEN_SPAWN_EGG.get());
                        pOutput.accept(ECItems.DRIED_SPAWN_EGG.get());
                        pOutput.accept(ECItems.PUTRID_SPAWN_EGG.get());

                        //Slimes
                        pOutput.accept(ECItems.ICE_CUBE_SPAWN_EGG.get());
                        pOutput.accept(ECItems.SAND_CUBE_SPAWN_EGG.get());
                        pOutput.accept(ECItems.RED_SAND_CUBE_SPAWN_EGG.get());
                        pOutput.accept(ECItems.PHRANQUE_SPAWN_EGG.get());
                    }))
                    .build());

    public static final RegistryObject<CreativeModeTab> ELEMENTAL_ITEMS = TABS.register(
            "elemental_items", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ECItems.LIGHTNING_ESSENCE.get()))
                    .title(Component.translatable("tab." + ElementalCreatures.MOD_ID + ".elemental_items"))
                    .withTabsBefore(ECTabs.ELEMENTALS_SPAWN_EGGS.getId())
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ECItems.LIGHTNING_ESSENCE.get());

                        pOutput.accept(ECItems.LIGHTNING_ARROW.get());
                        pOutput.accept(ECItems.SOUL_ARROW.get());
                        pOutput.accept(ECItems.PRISMARINE_ARROW.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }
}
