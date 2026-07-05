package net.marmar.elemental_creatures.mixin.block;

import net.marmar.elemental_creatures.util.SoulFireUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.SoulFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BaseFireBlock.class)
public class BaseFireBlockMixin {
    @Inject(method = "entityInside", at = @At("TAIL"))
    public void setSoulFire(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity, CallbackInfo ci){
        BaseFireBlock self = (BaseFireBlock) (Object) this;

        if (!(self instanceof SoulFireBlock) || !(pEntity instanceof LivingEntity livingEntity))
            return;

        SoulFireUtils.applySoulFire(livingEntity);
    }
}