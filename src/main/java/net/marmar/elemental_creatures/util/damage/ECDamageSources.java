package net.marmar.elemental_creatures.util.damage;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;

public class ECDamageSources {
    private final Registry<DamageType> damageTypes;

    private final DamageSource lightningDamage;

    public ECDamageSources(RegistryAccess registryAccess){
        this.damageTypes = registryAccess.registryOrThrow(Registries.DAMAGE_TYPE);

        this.lightningDamage = this.source(ECDamageTypes.LIGHTNING_DAMAGE);
    }

    public DamageSource lightningDamage() {
        return this.lightningDamage;
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey));
    }
}
