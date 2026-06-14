package net.marmar.elemental_creatures.entity.projectile;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.util.damage.ECDamageSources;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LightningArrowEntity extends AbstractArrow {
    public LightningArrowEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public LightningArrowEntity(Level pLevel, double pX, double pY, double pZ) {
        this(ECEntityTypes.LIGHTNING_ARROW.get(), pLevel);
        this.setPos(pX, pY, pZ);
    }

    public LightningArrowEntity(Level pLevel, LivingEntity pShooter){
        super(ECEntityTypes.LIGHTNING_ARROW.get(), pShooter, pLevel);
        this.setBaseDamage(3d);
    }

    @Override
    protected void doPostHurtEffects(LivingEntity pTarget) {
        super.doPostHurtEffects(pTarget);
        pTarget.hurt(new ECDamageSources(pTarget.level().registryAccess()).lightningDamage(), 3f);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ECItems.LIGHTNING_ARROW.get());
    }
}
