package net.marmar.elemental_creatures.entity.skeleton;

import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.item.arrow.PrismarineArrowItem;
import net.marmar.elemental_creatures.util.ECSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class Sunken extends AbstractSkeleton {
    
    public Sunken(EntityType<? extends AbstractSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    private static boolean isValidSpawnPlace(ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom){
        return pLevel.getDifficulty() != Difficulty.PEACEFUL
                && isDarkEnoughToSpawn(pLevel, pPos, pRandom)
                && (pSpawnType == MobSpawnType.SPAWNER || pLevel.getFluidState(pPos).is(FluidTags.WATER));
    }

    //Spawn rules have been copied and simplified from vanilla's Drowned class
    public static boolean checkSunkenSpawnRules(EntityType<Sunken> pSunken, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom){
        if (!pLevel.getFluidState(pPos.below()).is(FluidTags.WATER)) {
            return false;
        } else {
            if (pLevel.getBiome(pPos).is(BiomeTags.MORE_FREQUENT_DROWNED_SPAWNS)) {
                return isValidSpawnPlace(pLevel, pSpawnType, pPos, pRandom);
            } else {
                return pPos.getY() < 58 && isValidSpawnPlace(pLevel, pSpawnType, pPos, pRandom);
            }
        }
    }

    public static AttributeSupplier.Builder createSunkenAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 24f)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.ARMOR, 2f)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ECSounds.SUNKEN_AMBIENT.get();
    }

    @Override
    protected SoundEvent getStepSound() {
        return ECSounds.SUNKEN_STEP.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ECSounds.SUNKEN_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ECSounds.SUNKEN_DEATH.get();
    }

    @Override
    protected AbstractArrow getArrow(ItemStack pArrowStack, float pVelocity) {
        PrismarineArrowItem prismarineArrow = (PrismarineArrowItem) (pArrowStack.getItem() instanceof PrismarineArrowItem
                ? pArrowStack.getItem()
                : ECItems.PRISMARINE_ARROW.get());

        AbstractArrow abstractArrow = prismarineArrow.createArrow(this.level(), pArrowStack, this);

        abstractArrow.setEnchantmentEffectsFromEntity(this, pVelocity);

        return abstractArrow;
    }
}
