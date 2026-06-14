package net.marmar.elemental_creatures.entity.projectile;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.util.SoulFireUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class SoulArrowEntity extends AbstractArrow {
    public SoulArrowEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SoulArrowEntity(Level pLevel, double pX, double pY, double pZ) {
        this(ECEntityTypes.SOUL_ARROW.get(), pLevel);
        this.setPos(pX, pY, pZ);
    }

    public SoulArrowEntity(Level pLevel, LivingEntity pShooter){
        super(ECEntityTypes.SOUL_ARROW.get(), pShooter, pLevel);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        if (!level().isClientSide && pResult.getEntity() instanceof LivingEntity livingEntity){
            SoulFireUtils.applySoulFire(livingEntity, 5);
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ECItems.SOUL_ARROW.get());
    }
}
