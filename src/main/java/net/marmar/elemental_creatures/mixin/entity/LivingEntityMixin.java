package net.marmar.elemental_creatures.mixin.entity;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Skeleton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    public void onHurt(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;

        if (!(self instanceof Skeleton skeleton) || self.level().isClientSide())
            return;

        if (pSource.is(DamageTypes.LIGHTNING_BOLT)) {
            skeleton.convertTo(ECEntityTypes.TLALOCQUIAN.get(), true);
            return;
        }

        cir.setReturnValue(false);
    }
}
