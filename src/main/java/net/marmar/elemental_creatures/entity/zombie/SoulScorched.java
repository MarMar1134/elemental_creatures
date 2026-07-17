package net.marmar.elemental_creatures.entity.zombie;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class SoulScorched extends Scorched {
    public SoulScorched(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected boolean applySoulFire(Entity pEntity, boolean isSoulFire) {
        return super.applySoulFire(pEntity, true);
    }

    public static AttributeSupplier.Builder createSoulScorchedAttributes(){
        return Scorched.createScorchedAttributes()
                .add(Attributes.MAX_HEALTH, 14f)
                .add(Attributes.ATTACK_DAMAGE, 4d);
    }
}
