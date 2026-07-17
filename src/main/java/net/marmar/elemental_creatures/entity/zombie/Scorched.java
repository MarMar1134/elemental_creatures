package net.marmar.elemental_creatures.entity.zombie;

import net.marmar.elemental_creatures.util.ECSounds;
import net.marmar.elemental_creatures.util.SoulFireUtils;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class Scorched extends Zombie {
    public Scorched(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createScorchedAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.26f)
                .add(Attributes.ATTACK_DAMAGE, 3.0d)
                .add(Attributes.MAX_HEALTH, 16f)
                .add(Attributes.ARMOR, 2.0d)
                .add(Attributes.ARMOR_TOUGHNESS, 0d)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ECSounds.SCORCHED_AMBIENT.get();
    }

    @Override
    protected SoundEvent getStepSound() {
        return ECSounds.SCORCHED_STEP.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ECSounds.SCORCHED_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ECSounds.SCORCHED_DEATH.get();
    }

    protected boolean applySoulFire(Entity pEntity, boolean isSoulFire){
        float timeOnFire = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();

        if (isSoulFire){
            SoulFireUtils.applySoulFire((LivingEntity) pEntity, (int) (2 * timeOnFire));
        } else {
            pEntity.setSecondsOnFire(2 * (int)timeOnFire);
        }

        return super.doHurtTarget(pEntity);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        return applySoulFire(pEntity, false);
    }

    @Override
    protected boolean convertsInWater() {
        return false;
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    protected boolean isSunSensitive() {
        return false;
    }
}
