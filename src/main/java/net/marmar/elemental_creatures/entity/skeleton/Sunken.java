package net.marmar.elemental_creatures.entity.skeleton;

import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.item.custom.arrow.PrismarineArrowItem;
import net.marmar.elemental_creatures.util.ECSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class Sunken extends AbstractSkeleton {
    private final WaterBoundPathNavigation waterNavigation;
    private final GroundPathNavigation groundNavigation;

    public Sunken(EntityType<? extends AbstractSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setMaxUpStep(1.0F);
        this.moveControl = new SunkenMoveControl(this);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.waterNavigation = new WaterBoundPathNavigation(this, pLevel);
        this.groundNavigation = new GroundPathNavigation(this, pLevel);
        this.navigation = this.groundNavigation;
    }

    private boolean wantsToSwim() {
        LivingEntity target = this.getTarget();
        return target != null && target.isInWater();
    }

    @Override
    public void travel(Vec3 pTravelVector) {
        if (this.isControlledByLocalInstance() && this.isInWater() && this.wantsToSwim()) {
            this.moveRelative(0.01F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
        } else {
            super.travel(pTravelVector);
        }
    }

    @Override
    public void updateSwimming() {
        if (!this.level().isClientSide) {
            if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
                this.navigation = this.waterNavigation;
                this.setSwimming(true);
            } else {
                this.navigation = this.groundNavigation;
                this.setSwimming(false);
            }
        }
    }

    @Override
    public boolean isVisuallySwimming() {
        return this.isSwimming();
    }

    @Override
    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }

    private static boolean isValidSpawnPlace(ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom){
        return pLevel.getDifficulty() != Difficulty.PEACEFUL
                && isDarkEnoughToSpawn(pLevel, pPos, pRandom)
                && (pSpawnType == MobSpawnType.SPAWNER || pLevel.getFluidState(pPos).is(FluidTags.WATER));
    }

    public static boolean checkSunkenSpawnRules(EntityType<Sunken> pSunken, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom){
        if (!pLevel.getFluidState(pPos.below()).is(FluidTags.WATER)) {
            return false;
        }

        boolean ocean = pLevel.getBiome(pPos).is(BiomeTags.IS_OCEAN);

        return (ocean || pPos.getY() < pLevel.getSeaLevel() - 5)
                && isValidSpawnPlace(pLevel, pSpawnType, pPos, pRandom);
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

    private static class SunkenMoveControl extends MoveControl {
        private final Sunken sunken;

        private SunkenMoveControl(Sunken pSunken) {
            super(pSunken);
            this.sunken = pSunken;
        }

        @Override
        public void tick() {
            LivingEntity target = this.sunken.getTarget();
            if (this.sunken.wantsToSwim() && this.sunken.isInWater()) {
                if (target != null && target.getY() > this.sunken.getY()) {
                    this.sunken.setDeltaMovement(this.sunken.getDeltaMovement().add(0.0D, 0.002D, 0.0D));
                }

                if (this.operation != Operation.MOVE_TO || this.sunken.getNavigation().isDone()) {
                    this.sunken.setSpeed(0.0F);
                    return;
                }

                double dx = this.wantedX - this.sunken.getX();
                double dy = this.wantedY - this.sunken.getY();
                double dz = this.wantedZ - this.sunken.getZ();
                double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
                dy /= distance;
                float yaw = (float)(Mth.atan2(dz, dx) * (double)(180.0F / (float)Math.PI)) - 90.0F;
                this.sunken.setYRot(this.rotlerp(this.sunken.getYRot(), yaw, 90.0F));
                this.sunken.yBodyRot = this.sunken.getYRot();
                float speed = (float)(this.speedModifier * this.sunken.getAttributeValue(Attributes.MOVEMENT_SPEED));
                float smoothedSpeed = Mth.lerp(0.125F, this.sunken.getSpeed(), speed);
                this.sunken.setSpeed(smoothedSpeed);
                this.sunken.setDeltaMovement(this.sunken.getDeltaMovement().add(
                        (double)smoothedSpeed * dx * 0.005D,
                        (double)smoothedSpeed * dy * 0.1D,
                        (double)smoothedSpeed * dz * 0.005D
                ));
            } else {
                if (!this.sunken.onGround()) {
                    this.sunken.setDeltaMovement(this.sunken.getDeltaMovement().add(0.0D, -0.008D, 0.0D));
                }

                super.tick();
            }
        }
    }
}
