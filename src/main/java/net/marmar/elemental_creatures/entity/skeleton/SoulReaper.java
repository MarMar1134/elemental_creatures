package net.marmar.elemental_creatures.entity.skeleton;

import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.item.arrow.SoulArrowItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SoulReaper extends AbstractSkeleton {
    protected SoulReaper(EntityType<? extends AbstractSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    @Override
    protected AbstractArrow getArrow(ItemStack pArrowStack, float pVelocity) {
        SoulArrowItem soulArrow = (SoulArrowItem) (pArrowStack.getItem() instanceof SoulArrowItem
                ? pArrowStack.getItem()
                : ECItems.SOUL_ARROW.get());

        AbstractArrow abstractArrow = soulArrow.createArrow(this.level(), pArrowStack, this);

        abstractArrow.setEnchantmentEffectsFromEntity(this, pVelocity);

        return abstractArrow;
    }
}
