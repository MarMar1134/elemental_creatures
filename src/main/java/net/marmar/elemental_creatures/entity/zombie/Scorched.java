package net.marmar.elemental_creatures.entity.zombie;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class Scorched extends Zombie {
    public Scorched(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.25f)
                .add(Attributes.ATTACK_DAMAGE, 3.0d)
                .add(Attributes.MAX_HEALTH, 16f)
                .add(Attributes.ARMOR, 2.0d)
                .add(Attributes.ARMOR_TOUGHNESS, 0d)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        float timeOnFire = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
        pEntity.setSecondsOnFire(2 * (int)timeOnFire);

        return super.doHurtTarget(pEntity);
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
