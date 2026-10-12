package net.marmar.elemental_creatures.mixin.entity.skeleton;

import net.marmar.elemental_creatures.datagen.tag.ECTags;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.entity.skeleton.blight.Blight;
import net.marmar.elemental_creatures.util.accessor.SkeletonDataAccessors;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Skeleton.class)
public class SkeletonMixin implements SkeletonDataAccessors {
    @Unique
    private static final EntityDataAccessor<Boolean> DRY_DATA_ACCESSOR = SynchedEntityData.defineId(Skeleton.class, EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> UNDER_WATER_DATA_ACCESSOR = SynchedEntityData.defineId(Skeleton.class, EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> ROT_DATA_ACCESSOR = SynchedEntityData.defineId(Skeleton.class, EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> BURN_DATA_ACCESSOR = SynchedEntityData.defineId(Skeleton.class, EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> FUNGI_DATA_ACCESSOR = SynchedEntityData.defineId(Skeleton.class, EntityDataSerializers.BOOLEAN);

    @Unique
    private int timeToDry;
    @Unique
    private int timeOnWater;
    @Unique
    private int timeToRot;
    @Unique
    private int timeOnFire;
    @Unique
    private int timeToFungi;

    @Override
    public boolean isSkeletonDrying() {
        Skeleton self = (Skeleton) (Object) this;

        return self.getEntityData().get(DRY_DATA_ACCESSOR);
    }

    @Override
    public boolean isSkeletonDrowning() {
        Skeleton self = (Skeleton) (Object) this;

        return self.getEntityData().get(UNDER_WATER_DATA_ACCESSOR);
    }

    @Override
    public boolean isSkeletonRotting() {
        Skeleton self = (Skeleton) (Object) this;

        return self.getEntityData().get(ROT_DATA_ACCESSOR);
    }

    @Override
    public boolean isSkeletonBurning() {
        Skeleton self = (Skeleton) (Object) this;

        return self.getEntityData().get(BURN_DATA_ACCESSOR);
    }

    @Override
    public boolean isSkeletonFunging() {
        Skeleton self = (Skeleton) (Object) this;

        return self.getEntityData().get(FUNGI_DATA_ACCESSOR);
    }

    @Inject(method = "addAdditionalSaveData", at = @At("RETURN"))
    private void writeAdditionalSaveData(CompoundTag pCompound, CallbackInfo ci){
        pCompound.putInt("elemental_creatures.timeToDry", timeToDry);
        pCompound.putInt("elemental_creatures.timeUnderWater", timeOnWater);
        pCompound.putInt("elemental_creatures.timeToRot", timeToRot);
        pCompound.putInt("elemental_creatures.timeOnFire", timeOnFire);
        pCompound.putInt("elemental_creatures.timeToFungi", timeToFungi);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("RETURN"))
    private void readAdditionalSAveData(CompoundTag pCompound, CallbackInfo ci){
        timeToDry = pCompound.getInt("elemental_creatures.timeToDry");
        timeOnWater = pCompound.getInt("elemental_creatures.timeUnderWater");
        timeToRot = pCompound.getInt("elemental_creatures.timeToRot");
        timeOnFire = pCompound.getInt("elemental_creatures.timeOnFire");
        timeToFungi = pCompound.getInt("elemental_creatures.timeToFungi");
    }

    @Inject(method = "defineSynchedData", at = @At("RETURN"))
    private void onSynchedData(CallbackInfo ci){
        Skeleton self = (Skeleton) (Object) this;

        if (self != null) {
            self.getEntityData().define(DRY_DATA_ACCESSOR, false);
            self.getEntityData().define(UNDER_WATER_DATA_ACCESSOR, false);
            self.getEntityData().define(ROT_DATA_ACCESSOR, false);
            self.getEntityData().define(BURN_DATA_ACCESSOR, false);
            self.getEntityData().define(FUNGI_DATA_ACCESSOR, false);
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void onTick(CallbackInfo ci){
        LivingEntity self = (LivingEntity) (Object) this;

        boolean isChangeImmune = self.getPersistentData().getBoolean("elemental_creatures.changeImmune");

        if (self.level().isClientSide() || !(self instanceof Skeleton skeleton) || isChangeImmune) {
            return;
        }

        //Conversion process to the Sunken
        if (skeleton.isUnderWater()){
            timeOnWater++;

            if (timeOnWater >= 400){
                skeleton.getEntityData().set(UNDER_WATER_DATA_ACCESSOR, true);
            }

            if (timeOnWater >= 600){
                skeleton.level().playSound(skeleton, skeleton.getOnPos(), SoundEvents.ZOMBIE_CONVERTED_TO_DROWNED, SoundSource.AMBIENT, 1f, 1f);
                skeleton.convertTo(ECEntityTypes.SUNKEN.get(), true);
            }
        } else {
            timeOnWater = 0;
            skeleton.getEntityData().set(UNDER_WATER_DATA_ACCESSOR, false);
        }

        //Conversion process to the Dried
        if (skeleton.level().getBiome(skeleton.getOnPos()).is(ECTags.Biomes.CAN_SPAWN_DRIED)){
            timeToDry++;

            if (timeToDry >= 23800){
                skeleton.getEntityData().set(DRY_DATA_ACCESSOR, true);
            }

            if (timeToDry >= 24000){
                skeleton.convertTo(ECEntityTypes.DRIED.get(), true);
            }
        } else {
            timeToDry = 0;
            skeleton.getEntityData().set(DRY_DATA_ACCESSOR, false);
        }

        //Conversion process to the Putrid
        if (skeleton.level().getBiome(skeleton.getOnPos()).is(ECTags.Biomes.CAN_SPAWN_PUTRID)){
            timeToRot++;

            if (timeToRot >= 23800){
                skeleton.getEntityData().set(ROT_DATA_ACCESSOR, true);
            }

            if (timeToRot >= 24000){
                skeleton.convertTo(ECEntityTypes.PUTRID.get(), true);
            }
        } else {
            timeToRot = 0;
            skeleton.getEntityData().set(ROT_DATA_ACCESSOR, false);
        }

        //Conversion process to Ashen
        if (skeleton.isOnFire() || skeleton.isInLava()){
            timeOnFire++;

            if (timeOnFire >= 150){
                skeleton.getEntityData().set(BURN_DATA_ACCESSOR, true);
            }

            if (timeOnFire >= 300){
                skeleton.convertTo(ECEntityTypes.ASHEN.get(), true);
            }
        } else {
            timeOnFire = 0;
            skeleton.getEntityData().set(BURN_DATA_ACCESSOR, false);
        }

        //Conversion process to the Blight
        if (skeleton.level().getBiome(skeleton.getOnPos()).is(ECTags.Biomes.CAN_SPAWN_BLIGHT)){
            timeToFungi++;

            if (timeToFungi >= 23800){
                skeleton.getEntityData().set(FUNGI_DATA_ACCESSOR, true);
            }

            if (timeToFungi >= 24000){
                Blight blight = skeleton.convertTo(ECEntityTypes.BLIGHT.get(), true);

                if (blight != null){
                    blight.finalizeSpawn((ServerLevelAccessor) blight.level(), blight.level().getCurrentDifficultyAt(blight.getOnPos()), MobSpawnType.CONVERSION, null, null);
                }
            }

        } else {
            timeToFungi = 0;
            skeleton.getEntityData().set(FUNGI_DATA_ACCESSOR, false);
        }
    }
}
