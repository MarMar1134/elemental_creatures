package net.marmar.elemental_creatures.entity.slime;

import net.marmar.elemental_creatures.util.damage.ECDamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

public class Phranque extends AbstractSlime {
    public Phranque(EntityType<? extends Slime> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createPhranqueAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.2d)
                .add(Attributes.MAX_HEALTH, 12d)
                .add(Attributes.ARMOR, 4d)
                .add(Attributes.ATTACK_DAMAGE, 2d);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean hurt = super.doHurtTarget(pEntity);

        if (hurt){
            pEntity.hurt(new ECDamageSources(level().registryAccess()).lightningDamage(), 4f);
        }

        return hurt;
    }
}
