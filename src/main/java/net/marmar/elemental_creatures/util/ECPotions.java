package net.marmar.elemental_creatures.util;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ECPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(
                    ForgeRegistries.POTIONS, ElementalCreatures.MOD_ID);

    //Decay
    public static final RegistryObject<Potion> DECAY_POTION = POTIONS.register("decay_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.WITHER, 800, 0)));
    public static final RegistryObject<Potion> LONG_DECAY_POTION = POTIONS.register("long_decay_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.WITHER, 1600, 0)));
    public static final RegistryObject<Potion> STRONG_DECAY_POTION = POTIONS.register("strong_decay_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.WITHER, 400, 1)));

    //Blindness
    public static final RegistryObject<Potion> BLINDNESS_POTION = POTIONS.register("blindness_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS, 1800, 0)));
    public static final RegistryObject<Potion> LONG_BLINDNESS_POTION = POTIONS.register("long_blindness_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS, 3600, 0)));
    public static final RegistryObject<Potion> STRONG_BLINDNESS_POTION = POTIONS.register("strong_blindness_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS, 900, 1)));


    public static void register(IEventBus eventBus) {
        ElementalCreatures.LOGGER.info("Registering Elemental Creatures potions...");
        POTIONS.register(eventBus);
    }
}
