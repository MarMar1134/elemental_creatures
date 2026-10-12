package net.marmar.elemental_creatures.entity.skeleton.blight;

import net.marmar.elemental_creatures.datagen.loot.ECEntityLootTables;
import net.marmar.elemental_creatures.datagen.tag.ECTags;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.VariantHolder;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.Nullable;

public class Blight extends AbstractSkeleton implements VariantHolder<BlightVariant> {
    private static final EntityDataAccessor<Integer> BLIGHT_VARIANT = SynchedEntityData.defineId(Blight.class, EntityDataSerializers.INT);

    public Blight(EntityType<? extends AbstractSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    //TODO: Add custom sounds
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SKELETON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    public static AttributeSupplier.Builder createBlightAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 24d)
                .add(Attributes.ARMOR, 4d)
                .add(Attributes.ATTACK_DAMAGE, 4d)
                .add(Attributes.MOVEMENT_SPEED, 0.27d);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.getEntityData().define(BLIGHT_VARIANT, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);

        pCompound.putInt("elemental_creatures.blight.variant", this.getVariant().getId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);

        this.setVariant(BlightVariant.byId(pCompound.getInt("elemental_creatures.blight.variant")));
    }

    @Override
    protected AbstractArrow getArrow(ItemStack pArrowStack, float pVelocity) {
        AbstractArrow arrow = super.getArrow(pArrowStack, pVelocity);

        if (arrow instanceof Arrow){
            ((Arrow) arrow).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 400));
        }

        return arrow;
    }

    public ResourceLocation getTextureLocation(){
        return this.getVariant().getTextureLocation();
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return switch (this.getVariant()){
            case RED -> ECEntityLootTables.RED_BLIGHT;
            case BROWN -> ECEntityLootTables.BROWN_BLIGHT;
            case CRIMSON -> ECEntityLootTables.CRIMSON_BLIGHT;
            case WARPED -> ECEntityLootTables.WARPED_BLIGHT;
        };
    }

    @Override
    public void setVariant(BlightVariant pVariant) {
        this.getEntityData().set(BLIGHT_VARIANT, pVariant.getId());
    }

    @Override
    public BlightVariant getVariant() {
        return BlightVariant.byId(this.getEntityData().get(BLIGHT_VARIANT));
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        Holder<Biome> biome = pLevel.getBiome(this.blockPosition());
        RandomSource randomSource = pLevel.getRandom();

        //Tries to spawn a red or brown blight
        if (biome.is(ECTags.Biomes.CAN_SPAWN_RED_BLIGHT)){
            if (biome.is(ECTags.Biomes.CAN_SPAWN_BROWN_BLIGHT)){
                if (randomSource.nextDouble() <= 0.5d){
                    this.setVariant(BlightVariant.BROWN);
                } else {
                    this.setVariant(BlightVariant.RED);
                }
            } else {
                this.setVariant(BlightVariant.RED);
            }

            //Tries to spawn a brown or red blight
        } else if (biome.is(ECTags.Biomes.CAN_SPAWN_BROWN_BLIGHT)) {
            if (biome.is(ECTags.Biomes.CAN_SPAWN_RED_BLIGHT)) {
                if (randomSource.nextDouble() <= 0.5d) {
                    this.setVariant(BlightVariant.RED);
                } else {
                    this.setVariant(BlightVariant.BROWN);
                }
            } else {
                this.setVariant(BlightVariant.BROWN);
            }

            //Tries to spawn crimson blight
        } else if (biome.is(ECTags.Biomes.CAN_SPAWN_CRIMSON_BLIGHT)){
            this.setVariant(BlightVariant.CRIMSON);

            //Tries to spawn warped blight
        } else if (biome.is(ECTags.Biomes.CAN_SPAWN_WARPED_BLIGHT)){
            this.setVariant(BlightVariant.WARPED);
        }

        //Fallback to red blight
        else {
            this.setVariant(BlightVariant.RED);
        }

        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }
}
