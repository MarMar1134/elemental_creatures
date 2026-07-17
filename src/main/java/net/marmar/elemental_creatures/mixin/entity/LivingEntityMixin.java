package net.marmar.elemental_creatures.mixin.entity;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Skeleton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Unique
    private int timeOnWater;

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    public void onHurt(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;

        if (!(self instanceof Skeleton skeleton) || self.level().isClientSide())
            return;

        if (pSource.is(DamageTypes.LIGHTNING_BOLT)) {
            skeleton.convertTo(ECEntityTypes.TLALOCQUIAN.get(), true);
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void convertUnderWater(CallbackInfo ci){
        LivingEntity self = (LivingEntity) (Object) this;

        if (!(self instanceof Skeleton skeleton) || self.level().isClientSide())
            return;

        if (skeleton.isUnderWater()){
            timeOnWater++;

            if (timeOnWater >= 600){
                skeleton.level().playSound(skeleton, skeleton.getOnPos(), SoundEvents.ZOMBIE_CONVERTED_TO_DROWNED, SoundSource.AMBIENT, 1f, 1f);
                skeleton.convertTo(ECEntityTypes.SUNKEN.get(), true);
            }
        } else {
            timeOnWater = 0;
        }
    }
}
