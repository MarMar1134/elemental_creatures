package net.marmar.elemental_creatures.mixin.entity.livingentity;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.entity.slime.AbstractSlime;
import net.marmar.elemental_creatures.entity.spider.AbstractSpider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    public void onHurt(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;

        if (self.level().isClientSide())
            return;

        if (pSource.is(DamageTypes.LIGHTNING_BOLT)) {
            //Only regular Skeletons can convert to Followers of Tláloc
            if (self instanceof Skeleton skeleton){
                skeleton.convertTo(ECEntityTypes.TLALOCQUIAN.get(), true);
                cir.setReturnValue(false);

            //Only regular Slimes can convert to Phranques
            } else if (self instanceof Slime slime && !(slime instanceof AbstractSlime) && !(slime instanceof MagmaCube)){
                slime.convertTo(ECEntityTypes.PHRANQUE.get(), true);
                cir.setReturnValue(false);

            //Only regular Spiders can convert to Children of Aracne
            } else if (self instanceof Spider spider && !(spider instanceof AbstractSpider) && !(spider instanceof CaveSpider)) {
                spider.convertTo(ECEntityTypes.ARACNIAN.get(), true);
                cir.setReturnValue(false);
            }
        }
    }
}
