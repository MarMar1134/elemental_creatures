package net.marmar.elemental_creatures.mixin.entity.skeleton;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WitherSkeleton.class)
public class WitherSkeletonMixin {
    @Inject(method = "getArrow", at = @At("RETURN"), cancellable = true)
    protected void onGetArrow(ItemStack pArrowStack, float pDistanceFactor, CallbackInfoReturnable<AbstractArrow> cir){
        AbstractArrow arrow = cir.getReturnValue();

        if (arrow instanceof Arrow){
            arrow.clearFire();

            ((Arrow) arrow).addEffect(new MobEffectInstance(MobEffects.WITHER, 200));

            cir.setReturnValue(arrow);
        }
    }
}
