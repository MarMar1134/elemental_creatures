package net.marmar.elemental_creatures.entity.projectile;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.item.ECItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PrismarineArrowEntity extends AbstractArrow {
    public PrismarineArrowEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public PrismarineArrowEntity(double pX, double pY, double pZ, Level pLevel) {
        super(ECEntityTypes.PRISMARINE_ARROW.get(), pX, pY, pZ, pLevel);
    }

    public PrismarineArrowEntity(Level pLevel, LivingEntity pShooter) {
        super(ECEntityTypes.PRISMARINE_ARROW.get(), pShooter, pLevel);
    }

    @Override
    protected float getWaterInertia() {
        return 0.89f;
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ECItems.PRISMARINE_ARROW.get());
    }
}
