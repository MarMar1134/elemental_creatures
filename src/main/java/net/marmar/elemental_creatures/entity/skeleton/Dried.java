package net.marmar.elemental_creatures.entity.skeleton;

import net.marmar.elemental_creatures.util.ECSounds;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class Dried extends AbstractSkeleton {
    private static final EntityDataAccessor<Boolean> UNDER_WATER_ACCESSOR = SynchedEntityData.defineId(Dried.class, EntityDataSerializers.BOOLEAN);
    private int timeUnderwater;

    public Dried(EntityType<? extends AbstractSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createDriedAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 18f)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.getEntityData().define(UNDER_WATER_ACCESSOR, false);
    }

    @Override
    public void tick() {
        if (this.isUnderWater()){
            timeUnderwater++;

            if (timeUnderwater >= 400){
                this.getEntityData().set(UNDER_WATER_ACCESSOR, true);
            }

            if (timeUnderwater >= 600){
                this.level().playSound(this, this.getOnPos(), SoundEvents.HUSK_CONVERTED_TO_ZOMBIE, SoundSource.AMBIENT, 1f, 1f);
                this.convertTo(EntityType.SKELETON, true);
            }
        } else {
            timeUnderwater = 0;
            this.getEntityData().set(UNDER_WATER_ACCESSOR, false);
        }

        super.tick();
    }

    public boolean isUnderwaterConverting(){
        return this.getEntityData().get(UNDER_WATER_ACCESSOR);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ECSounds.DRIED_AMBIENT.get();
    }

    @Override
    protected SoundEvent getStepSound() {
        return ECSounds.DRIED_STEP.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ECSounds.DRIED_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ECSounds.DRIED_DEATH.get();
    }

    protected AbstractArrow getArrow(ItemStack pArrowStack, float pDistanceFactor) {
        AbstractArrow abstractarrow = super.getArrow(pArrowStack, pDistanceFactor);
        if (abstractarrow instanceof Arrow) {
            ((Arrow)abstractarrow).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 600));
        }

        return abstractarrow;
    }
}
