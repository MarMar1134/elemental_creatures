package net.marmar.elemental_creatures.entity.skeleton;

import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.item.arrow.SoulArrowItem;
import net.marmar.elemental_creatures.util.ECSounds;
import net.marmar.elemental_creatures.util.SoulFireUtils;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SoulReaper extends AbstractSkeleton {
    public SoulReaper(EntityType<? extends AbstractSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 26f)
                .add(Attributes.ARMOR, 4f)
                .add(Attributes.ARMOR_TOUGHNESS, 0f)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ECSounds.SOUL_REAPER_AMBIENT.get();
    }

    @Override
    protected SoundEvent getStepSound() {
        return ECSounds.SOUL_REAPER_STEP.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ECSounds.SOUL_REAPER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ECSounds.SOUL_REAPER_DEATH.get();
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean hurt = super.doHurtTarget(pEntity);

        if (this.level().isClientSide)
            return hurt;

        if (hurt && pEntity instanceof LivingEntity mob){
            SoulFireUtils.applySoulFire(mob, 5);
        }

        return hurt;
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
