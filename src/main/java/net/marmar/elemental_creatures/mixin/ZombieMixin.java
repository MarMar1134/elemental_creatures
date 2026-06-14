package net.marmar.elemental_creatures.mixin;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Zombie.class)
public class ZombieMixin {
    @Unique
    private int timeInLava;

    @Unique
    private int timeToFreeze;

    @Inject(method = "addAdditionalSaveData", at = @At("RETURN"))
    private void writeAdditional(CompoundTag pCompound, CallbackInfo ci){
        pCompound.putInt("elemental_creatures.timeInLava", timeInLava);
        pCompound.putInt("elemental_creatures.timeToFreeze", timeToFreeze);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("RETURN"))
    private void readAdditional(CompoundTag pCompound, CallbackInfo ci){
        timeInLava = pCompound.getInt("elemental_creatures.timeInLava");
        timeToFreeze = pCompound.getInt("elemental_creatures.timeToFreeze");
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci){
        Zombie self = (Zombie) (Object) this;

        if (self.getClass() != Zombie.class || self.level().isClientSide)
            return;


        if (self.isFullyFrozen()){
            timeToFreeze++;

            if (timeToFreeze >= 200){
                self.convertTo(ECEntityTypes.LOST.get(), true);
            }

        } else {
            timeToFreeze = 0;
        }

        if (self.isInLava()){
            timeInLava++;

            if (timeInLava >= 200){
                self.convertTo(ECEntityTypes.SCORCHED.get(), true);
            }
        } else {
            timeInLava = 0;
        }
    }

    @Inject(method = "hurt", at = @At("HEAD"))
    public void onHurt(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir){
        Zombie self = (Zombie) (Object) this;

        if (self.getClass() != Zombie.class || self.level().isClientSide)
            return;


        if (pSource.is(DamageTypes.LIGHTNING_BOLT)){
            //self.hurt(pSource, pAmount);
            self.convertTo(ECEntityTypes.ILLAPISTA.get(), true);
        }

        //self.hurt(pSource, pAmount);
    }
}
