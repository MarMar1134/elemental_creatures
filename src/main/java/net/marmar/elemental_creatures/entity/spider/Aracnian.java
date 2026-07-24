package net.marmar.elemental_creatures.entity.spider;

import net.marmar.elemental_creatures.util.damage.ECDamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class Aracnian extends AbstractSpider {
    public Aracnian(EntityType<? extends Spider> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAracnianAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.32d)
                .add(Attributes.MAX_HEALTH, 20d)
                .add(Attributes.ARMOR, 4f)
                .add(Attributes.ATTACK_DAMAGE, 3f);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean hurt = super.doHurtTarget(pEntity);

        if (hurt){
            pEntity.hurt(new ECDamageSources(level().registryAccess()).lightningDamage(), 3f);
        }

        return hurt;
    }
}
