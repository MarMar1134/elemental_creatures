package net.marmar.elemental_creatures.item.arrow;

import net.marmar.elemental_creatures.entity.projectile.PrismarineArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PrismarineArrowItem extends ArrowItem {
    public PrismarineArrowItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new PrismarineArrowEntity(pLevel, pShooter);
    }
}
