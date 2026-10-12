package net.marmar.elemental_creatures.entity.zombie;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class Decadent extends Zombie {
    public Decadent(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createDecadentAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.23f)
                .add(Attributes.ATTACK_DAMAGE, 3.0d)
                .add(Attributes.MAX_HEALTH, 24f)
                .add(Attributes.ARMOR, 2.0d)
                .add(Attributes.ARMOR_TOUGHNESS, 2.0d)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
    }

    @Override
    protected boolean isSunSensitive() {
        return false;
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
