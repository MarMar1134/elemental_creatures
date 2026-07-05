package net.marmar.elemental_creatures.entity.skeleton;

import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.item.arrow.LightningArrowItem;
import net.marmar.elemental_creatures.util.damage.ECDamageSources;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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

public class Tlalocquian extends AbstractSkeleton {
    public Tlalocquian(EntityType<? extends AbstractSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 24f)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.ARMOR, 4f)
                .add(Attributes.ARMOR_TOUGHNESS, 1f)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean hurt = super.doHurtTarget(pEntity);

        if (this.level().isClientSide)
            return hurt;

        if (hurt && pEntity instanceof LivingEntity mob){
            mob.hurt(new ECDamageSources(level().registryAccess()).lightningDamage(), 2f);
        }

        return hurt;
    }

    @Override
    protected AbstractArrow getArrow(ItemStack pArrowStack, float pVelocity) {
        LightningArrowItem lightningArrow = (LightningArrowItem) (pArrowStack.getItem() instanceof LightningArrowItem
                ? pArrowStack.getItem()
                : ECItems.LIGHTNING_ARROW.get());

        AbstractArrow abstractArrow = lightningArrow.createArrow(this.level(), pArrowStack, this);

        abstractArrow.setEnchantmentEffectsFromEntity(this, pVelocity);

        return abstractArrow;
    }
}
