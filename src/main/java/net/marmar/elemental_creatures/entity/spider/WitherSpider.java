package net.marmar.elemental_creatures.entity.spider;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class WitherSpider extends AbstractSpider {
    public WitherSpider(EntityType<? extends Spider> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createWitheredSpiderAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 24d)
                .add(Attributes.MOVEMENT_SPEED, 0.3d)
                .add(Attributes.ATTACK_DAMAGE, 3d)
                .add(Attributes.ARMOR, 2d)
                .add(Attributes.ARMOR_TOUGHNESS, 2d);
    }

    @Override
    public boolean canBeAffected(MobEffectInstance pEffectInstance) {
        return pEffectInstance.getEffect() != MobEffects.WITHER && super.canBeAffected(pEffectInstance);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean hurt = super.doHurtTarget(pEntity);

        if (this.level().isClientSide)
            return hurt;

        if (hurt && pEntity instanceof LivingEntity mob) {
            mob.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0), this);
        }

        return hurt;
    }
}
