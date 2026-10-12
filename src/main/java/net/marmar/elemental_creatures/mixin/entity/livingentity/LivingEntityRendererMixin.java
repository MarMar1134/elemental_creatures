package net.marmar.elemental_creatures.mixin.entity.livingentity;

import net.marmar.elemental_creatures.util.accessor.SpiderDataAccessors;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Spider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
    @Inject(method = "isShaking", at = @At("RETURN"), cancellable = true)
    private void onShake(LivingEntity pEntity, CallbackInfoReturnable<Boolean> cir){
        if (!(pEntity instanceof Spider spider)){
            return;
        }

        if (!cir.getReturnValue() && spider instanceof SpiderDataAccessors dataAccessors){
            cir.setReturnValue(dataAccessors.isDecaying());
        }
    }
}
