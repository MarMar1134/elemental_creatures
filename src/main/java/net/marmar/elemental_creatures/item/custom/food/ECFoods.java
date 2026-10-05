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
}
