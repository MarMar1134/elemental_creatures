package net.marmar.elemental_creatures.util.enchantment;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ECEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ElementalCreatures.MOD_ID);

    public static final RegistryObject<Enchantment> ZEUS_BLESSING = ENCHANTMENTS.register(
            "zeus_blessing", () -> new ZeusBlessingEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus){
        ElementalCreatures.LOGGER.info("Registering Elemental Creatures enchantments...");
        ENCHANTMENTS.register(eventBus);
    }
}
