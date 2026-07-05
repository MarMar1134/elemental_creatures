package net.marmar.elemental_creatures.entity.zombie;

import net.marmar.elemental_creatures.util.ECSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class Rotten extends Zombie {
    public Rotten(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.23f)
                .add(Attributes.ATTACK_DAMAGE, 3.0d)
                .add(Attributes.MAX_HEALTH, 24f)
                .add(Attributes.ARMOR, 4.0d)
                .add(Attributes.ARMOR_TOUGHNESS, 0d)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ECSounds.ROTTEN_AMBIENT.get();
    }

    @Override
    protected SoundEvent getStepSound() {
        return ECSounds.ROTTEN_STEP.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ECSounds.ROTTEN_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ECSounds.ROTTEN_DEATH.get();
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean hurt = super.doHurtTarget(pEntity);

        if (this.level().isClientSide)
            return hurt;

        int poisonLevel = switch (this.level().getDifficulty()) {
            case NORMAL -> 1;
            case HARD -> 2;
            default -> 0;
        };

        if (hurt && pEntity instanceof LivingEntity mob) {
            mob.addEffect(new MobEffectInstance(MobEffects.POISON, 100, poisonLevel));
        }

        return hurt;
    }
}
