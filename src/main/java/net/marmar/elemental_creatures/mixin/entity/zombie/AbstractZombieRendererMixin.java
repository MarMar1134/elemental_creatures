package net.marmar.elemental_creatures.mixin.entity.zombie;

import net.marmar.elemental_creatures.util.accessor.ZombieDataAccessors;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractZombieRenderer.class)
public class AbstractZombieRendererMixin {
    @Inject(method = "isShaking(Lnet/minecraft/world/entity/monster/Zombie;)Z", at = @At("RETURN"), cancellable = true)
    private void onShake(Zombie zombie, CallbackInfoReturnable<Boolean> cir){
        if (!cir.getReturnValue() && zombie instanceof ZombieDataAccessors dataAccessors){
            cir.setReturnValue(dataAccessors.isZombieDrying() || dataAccessors.isZombieScorching() || dataAccessors.isZombieRotting() || dataAccessors.isZombieDecaying());
        }
    }
}
