package net.marmar.elemental_creatures.mixin.entity.skeleton;

import net.marmar.elemental_creatures.util.accessor.SkeletonDataAccessors;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Skeleton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SkeletonRenderer.class)
public class SkeletonRendererMixin {
    @Inject(method = "isShaking(Lnet/minecraft/world/entity/monster/AbstractSkeleton;)Z", at = @At("RETURN"), cancellable = true)
    private void onShake(AbstractSkeleton pEntity, CallbackInfoReturnable<Boolean> cir){
        if (!cir.getReturnValue() && pEntity instanceof Skeleton skeleton && skeleton instanceof SkeletonDataAccessors dataAccessors){
            cir.setReturnValue(dataAccessors.isSkeletonDrowning() || dataAccessors.isSkeletonDrying() ||
                    dataAccessors.isSkeletonRotting() || dataAccessors.isSkeletonBurning() || dataAccessors.isSkeletonFunging());
        }
    }
}
