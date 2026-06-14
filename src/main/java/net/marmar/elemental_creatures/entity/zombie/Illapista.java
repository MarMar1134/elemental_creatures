package net.marmar.elemental_creatures.entity.zombie;

import net.marmar.elemental_creatures.util.damage.ECDamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class Illapista extends Zombie {
    public Illapista(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.23f)
                .add(Attributes.ATTACK_DAMAGE, 4.0d)
                .add(Attributes.MAX_HEALTH, 24f)
                .add(Attributes.ARMOR, 4.0d)
                .add(Attributes.ARMOR_TOUGHNESS, 0d)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        return pEntity.hurt(new ECDamageSources(level().registryAccess()).lightningDamage(), 4f);
    }
}
