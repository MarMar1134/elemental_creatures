package net.marmar.elemental_creatures.entity.spider;

import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class DesertSpider extends AbstractSpider {
    public DesertSpider(EntityType<? extends Spider> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createDesertSpiderAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3d)
                .add(Attributes.MAX_HEALTH, 18d);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        if (super.doHurtTarget(pEntity)) {
            if (pEntity instanceof LivingEntity) {
                int i = 0;
                if (this.level().getDifficulty() == Difficulty.NORMAL) {
                    i = 7;
                } else if (this.level().getDifficulty() == Difficulty.HARD) {
                    i = 15;
                }

                if (i > 0) {
                    ((LivingEntity)pEntity).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, i * 20, 0), this);
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
