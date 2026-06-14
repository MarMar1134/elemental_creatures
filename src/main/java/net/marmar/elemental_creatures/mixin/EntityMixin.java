package net.marmar.elemental_creatures.mixin;

import net.marmar.elemental_creatures.util.SoulFireUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "setSecondsOnFire", at = @At("HEAD"))
    private void clearSoulFireOnNormalFire(int seconds, CallbackInfo ci) {
        Entity self = (Entity)(Object) this;

        if (self.level().isClientSide())
            return;

        if (!(self instanceof LivingEntity livingEntity))
            return;

        if (!SoulFireUtils.hasSoulFire(livingEntity) || SoulFireUtils.isApplyingSoulFire())
            return;

        SoulFireUtils.clearSoulFire(livingEntity);
    }

    @Inject(method = "baseTick", at = @At("HEAD"))
    private void clearSoulFireOnExtinguish(CallbackInfo ci) {
        Entity self = (Entity)(Object)this;

        if (self.level().isClientSide())
            return;

        if (!(self instanceof LivingEntity livingEntity))
            return;

        if (SoulFireUtils.hasSoulFire(livingEntity) && !livingEntity.isOnFire()) {
            SoulFireUtils.clearSoulFire(livingEntity);
        }
    }
}
