package net.marmar.elemental_creatures.mixin.entity.spider;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.util.accessor.SpiderDataAccessors;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Spider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Spider.class)
public class SpiderMixin implements SpiderDataAccessors {
    @Unique
    private static final EntityDataAccessor<Boolean> DECAY_DATA_ACCESSOR = SynchedEntityData.defineId(Spider.class, EntityDataSerializers.BOOLEAN);

    @Unique
    private int timeToDecay;

    @Override
    public boolean isDecaying(){
        Spider self = (Spider) (Object) this;

        return self.getEntityData().get(DECAY_DATA_ACCESSOR);
    }

    @Inject(method = "defineSynchedData", at = @At("RETURN"))
    protected void onSynchedData(CallbackInfo ci) {
        Spider self = (Spider) (Object) this;

        if (self != null) {
            self.getEntityData().define(DECAY_DATA_ACCESSOR, false);
        }
    }

    @Inject(method = "tick", at = @At("RETURN"))
    public void onTick(CallbackInfo ci) {
        Spider self = (Spider) (Object) this;

        boolean isChangeImmune = self.getPersistentData().getBoolean("elemental_creatures.changeImmune");

        if (self.level().isClientSide() || isChangeImmune){
            return;
        }

        if (self.hasEffect(MobEffects.WITHER)){
            timeToDecay++;

            if (timeToDecay >= 75){
                self.getEntityData().set(DECAY_DATA_ACCESSOR, true);
            }

            if (timeToDecay >= 150){
                self.convertTo(ECEntityTypes.WITHER_SPIDER.get(), true);
            }
        } else {
            timeToDecay = 0;
            self.getEntityData().set(DECAY_DATA_ACCESSOR, false);
        }
    }
}
