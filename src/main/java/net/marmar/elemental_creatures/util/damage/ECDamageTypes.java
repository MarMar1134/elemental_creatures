package net.marmar.elemental_creatures.util.damage;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public interface ECDamageTypes {
    ResourceKey<DamageType> LIGHTNING_DAMAGE = registryKey("lightning_damage");

    static void boostrap(BootstapContext<DamageType> context){
        context.register(LIGHTNING_DAMAGE, new DamageType("lightning_damage", DamageScaling.NEVER, 0.1f));
    }

    @SuppressWarnings("removal")
    private static ResourceKey<DamageType> registryKey(String name){
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ElementalCreatures.MOD_ID, name));
    }
}
