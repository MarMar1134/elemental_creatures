package net.marmar.elemental_creatures.entity.skeleton;

import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.item.arrow.PrismarineArrowItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Sunken extends AbstractSkeleton {
    public Sunken(EntityType<? extends AbstractSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 24f)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.ARMOR, 2f)
                .add(Attributes.MOVEMENT_SPEED, 0.2D);
    }

    @Override
    protected SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    @Override
    protected AbstractArrow getArrow(ItemStack pArrowStack, float pVelocity) {
        PrismarineArrowItem prismarineArrow = (PrismarineArrowItem) (pArrowStack.getItem() instanceof PrismarineArrowItem
                ? pArrowStack.getItem()
                : ECItems.PRISMARINE_ARROW.get());

        AbstractArrow abstractArrow = prismarineArrow.createArrow(this.level(), pArrowStack, this);

        abstractArrow.setEnchantmentEffectsFromEntity(this, pVelocity);

        return abstractArrow;
    }
}
