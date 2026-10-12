package net.marmar.elemental_creatures.mixin.entity.zombie;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.datagen.tag.ECTags;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.entity.zombie.fungus.Fungus;
import net.marmar.elemental_creatures.util.SoulFireUtils;
import net.marmar.elemental_creatures.util.accessor.ZombieDataAccessors;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.Tags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Zombie.class)
public class ZombieMixin implements ZombieDataAccessors {
    //Data accessors
    @Unique
    private static final EntityDataAccessor<Boolean> DRY_DATA_ACCESSOR = SynchedEntityData.defineId(Zombie.class, EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> BURN_DATA_ACCESSOR = SynchedEntityData.defineId(Zombie.class, EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> ROT_DATA_ACCESSOR = SynchedEntityData.defineId(Zombie.class, EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> DECAY_DATA_ACCESSOR = SynchedEntityData.defineId(Zombie.class, EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> FUNGI_DATA_ACCESSOR = SynchedEntityData.defineId(Zombie.class, EntityDataSerializers.BOOLEAN);

    //Counters
    @Unique
    private int timeToDry;
    @Unique
    private int timeOnFire;
    @Unique
    private int timeToFreeze;
    @Unique
    private int timeToDecay;
    @Unique
    private int timeToRot;
    @Unique
    private int timeToFungi;

    @Override
    public boolean isZombieDrying() {
        Zombie self = (Zombie) (Object) this;

        return self.getEntityData().get(DRY_DATA_ACCESSOR);
    }

    @Override
    public boolean isZombieScorching() {
        Zombie self = (Zombie) (Object) this;

        return self.getEntityData().get(BURN_DATA_ACCESSOR);
    }

    @Override
    public boolean isZombieRotting() {
        Zombie self = (Zombie) (Object) this;

        return self.getEntityData().get(ROT_DATA_ACCESSOR);
    }

    @Override
    public boolean isZombieDecaying() {
        Zombie self = (Zombie) (Object) this;

        return self.getEntityData().get(DECAY_DATA_ACCESSOR);
    }

    @Override
    public boolean isZombieFunging() {
        Zombie self = (Zombie) (Object) this;
        
        return self.getEntityData().get(FUNGI_DATA_ACCESSOR);
    }

    @Inject(method = "addAdditionalSaveData", at = @At("RETURN"))
    private void writeAdditional(CompoundTag pCompound, CallbackInfo ci){
        pCompound.putInt("elemental_creatures.timeToDry", timeToDry);
        pCompound.putInt("elemental_creatures.timeonFire", timeOnFire);
        pCompound.putInt("elemental_creatures.timeToFreeze", timeToFreeze);
        pCompound.putInt("elemental_creatures.timeToDecay", timeToDecay);
        pCompound.putInt("elemental_creatures.timeToRot", timeToRot);
        pCompound.putInt("elemental_creatures.timeToFungi", timeToFungi);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("RETURN"))
    private void readAdditional(CompoundTag pCompound, CallbackInfo ci){
        timeToDry = pCompound.getInt("elemental_creatures.timeToDry");
        timeOnFire = pCompound.getInt("elemental_creatures.timeonFire");
        timeToFreeze = pCompound.getInt("elemental_creatures.timeToFreeze");
        timeToDecay = pCompound.getInt("elemental_creatures.timeToDecay");
        timeToRot = pCompound.getInt("elemental_creatures.timeToRot");
        timeToFungi = pCompound.getInt("elemental_creatures.timeToFungi");
    }

    @Inject(method = "defineSynchedData", at = @At("RETURN"))
    private void onSynchedData(CallbackInfo ci){
        Zombie self = (Zombie) (Object) this;

        if (self != null){
            self.getEntityData().define(DRY_DATA_ACCESSOR, false);
            self.getEntityData().define(BURN_DATA_ACCESSOR, false);
            self.getEntityData().define(ROT_DATA_ACCESSOR, false);
            self.getEntityData().define(DECAY_DATA_ACCESSOR, false);
            self.getEntityData().define(FUNGI_DATA_ACCESSOR, false);
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci){
        Zombie self = (Zombie) (Object) this;

        boolean isChangeImmune = self.getPersistentData().getBoolean("elemental_creatures.changeImmune");

        if (self.getClass() != Zombie.class || self.level().isClientSide() || isChangeImmune) {
            return;
        }

        //Conversion process to Husk
        if (self.level().getBiome(self.getOnPos()).is(Tags.Biomes.IS_DESERT)){
            timeToDry++;

            if (timeToDry >= 23800){
                self.getEntityData().set(DRY_DATA_ACCESSOR, true);
            }

            if (timeToDry >= 24000){
                self.convertTo(EntityType.HUSK, true);
            }
        } else {
            timeToDry = 0;
            self.getEntityData().set(DRY_DATA_ACCESSOR, false);
        }

        //Conversion process to the Lost
        if (self.isFullyFrozen()){
            timeToFreeze++;

            if (timeToFreeze >= 200){
                self.convertTo(ECEntityTypes.LOST.get(), true);
            }
        } else {
            timeToFreeze = 0;
        }

        //Conversion process to the Scorched
        if (self.isInLava() || self.isOnFire()){
            timeOnFire++;


            if (timeOnFire >= 150){
                self.getEntityData().set(BURN_DATA_ACCESSOR, true);
            }

            if (timeOnFire >= 300){
                if (SoulFireUtils.hasSoulFire(self))
                    self.convertTo(ECEntityTypes.SOUL_SCORCHED.get(), true);
                else
                    self.convertTo(ECEntityTypes.SCORCHED.get(), true);
            }
        } else {
            timeOnFire = 0;
            self.getEntityData().set(BURN_DATA_ACCESSOR, false);
        }

        //Conversion process to the Rotten
        if (self.level().getBiome(self.getOnPos()).is(ECTags.Biomes.CAN_SPAWN_ROTTEN)){
            timeToRot++;

            if (timeToRot >= 23800){
                self.getEntityData().set(ROT_DATA_ACCESSOR, true);
            }

            if (timeToRot >= 24000){
                self.convertTo(ECEntityTypes.ROTTEN.get(), true);
            }
        } else {
            timeToRot = 0;
            self.getEntityData().set(ROT_DATA_ACCESSOR, false);
        }

        //Conversion process to the Decadent
        if (self.hasEffect(MobEffects.WITHER)){
            timeToDecay++;

            if (timeToDecay >= 50){
                self.getEntityData().set(DECAY_DATA_ACCESSOR, true);
            }

            if (timeToDecay >= 100){
                self.convertTo(ECEntityTypes.DECADENT.get(), true);
            }
        } else {
            timeToDecay = 0;
            self.getEntityData().set(DECAY_DATA_ACCESSOR, false);
        }
        
        if (self.level().getBiome(self.getOnPos()).is(ECTags.Biomes.CAN_SPAWN_FUNGUS)){
            timeToFungi++;
            
            if (timeToFungi >= 23800){
                self.getEntityData().set(FUNGI_DATA_ACCESSOR, true);
            }
            
            if (timeToFungi >= 24000){
                Fungus fungus = self.convertTo(ECEntityTypes.FUNGUS.get(), true);

                if (fungus != null){
                    fungus.finalizeSpawn((ServerLevelAccessor) fungus.level(), fungus.level().getCurrentDifficultyAt(fungus.getOnPos()), MobSpawnType.CONVERSION, null, null);
                }
            }
            
        } else {
            timeToFungi = 0;
            self.getEntityData().set(FUNGI_DATA_ACCESSOR, false);
        }
    }

    @Inject(method = "hurt", at = @At("HEAD"))
    public void onHurt(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir){
        Zombie self = (Zombie) (Object) this;

        if (self.getClass() != Zombie.class || self.level().isClientSide())
            return;

        if (pSource.is(DamageTypes.LIGHTNING_BOLT)){
            self.convertTo(ECEntityTypes.ILLAPISTA.get(), true);
        }
    }
}
