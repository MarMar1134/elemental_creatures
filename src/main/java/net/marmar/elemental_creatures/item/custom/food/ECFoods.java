package net.marmar.elemental_creatures.item.custom.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ECFoods {
    //Flesh
    public static final FoodProperties BURNT_FLESH = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 600, 0), 0.8f)
            .meat()
            .build();
    public static final FoodProperties FROZEN_FLESH = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 0), 0.8f)
            .meat()
            .build();
    public static final FoodProperties POISONOUS_FLESH = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 300, 0), 0.8f)
            .meat()
            .build();
    public static final FoodProperties DECAYING_FLESH = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 300, 0), 0.8f)
            .meat()
            .build();
    public static final FoodProperties FUNGAL_FLESH = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 600, 0), 0.8f)
            .meat()
            .build();

    //Others
    public static final FoodProperties IDUNN_APPLE = new FoodProperties.Builder()
            .nutrition(4).saturationMod(1.2F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 20, 0), 1.0F)
            .alwaysEat()
            .build();
}
