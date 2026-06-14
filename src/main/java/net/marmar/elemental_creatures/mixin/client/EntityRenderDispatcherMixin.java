package net.marmar.elemental_creatures.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.marmar.elemental_creatures.util.SoulFireUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@OnlyIn(Dist.CLIENT)
@Mixin(EntityRenderDispatcher.class)
public class EntityRenderDispatcherMixin {
    @Inject(method = "renderFlame", at = @At("HEAD"), cancellable = true)
    public void catchRenderFire(PoseStack pPoseStack, MultiBufferSource pBuffer, Entity pEntity, CallbackInfo ci){
        if (!(pEntity instanceof LivingEntity livingEntity))
            return;

        if (!SoulFireUtils.hasSoulFire(livingEntity))
            return;

        ci.cancel();

        renderSoulFlame(pPoseStack, pBuffer, pEntity);
    }

    //Method directly copied of renderFlame from EntityRenderDispatcher. The only differences are the fire textures.
    @Unique
    @SuppressWarnings("removal")
    private void renderSoulFlame(PoseStack pPoseStack, MultiBufferSource pBuffer, Entity pEntity) {
        var atlas = Minecraft.getInstance().getModelManager().getAtlas(TextureAtlas.LOCATION_BLOCKS);

        var sprite0 = atlas.getSprite(new ResourceLocation("minecraft", "block/soul_fire_0"));
        var sprite1 = atlas.getSprite(new ResourceLocation("minecraft", "block/soul_fire_1"));

        var camera = Minecraft.getInstance().gameRenderer.getMainCamera();

        pPoseStack.pushPose();

        float f = pEntity.getBbWidth() * 1.4F;
        pPoseStack.scale(f, f, f);
        float f1 = 0.5F;
        float f3 = pEntity.getBbHeight() / f;
        float f4 = 0.0F;
        pPoseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        pPoseStack.translate(0.0F, 0.0F, -0.3F + (float)((int)f3) * 0.02F);
        float f5 = 0.0F;
        int i = 0;
        VertexConsumer vertexConsumer = pBuffer.getBuffer(Sheets.cutoutBlockSheet());

        for(PoseStack.Pose pose = pPoseStack.last(); f3 > 0.0F; ++i) {
            TextureAtlasSprite currentSprite = i % 2 == 0 ? sprite0 : sprite1;
            float u0 = currentSprite.getU0();
            float v0 = currentSprite.getV0();
            float u1 = currentSprite.getU1();
            float v1 = currentSprite.getV1();
            if (i / 2 % 2 == 0) {
                float f10 = u1;
                u1 = u0;
                u0 = f10;
            }

            soulFireVertex(pose, vertexConsumer, f1 - 0.0F, 0.0F - f4, f5, u1, v1);
            soulFireVertex(pose, vertexConsumer, -f1 - 0.0F, 0.0F - f4, f5, u0, v1);
            soulFireVertex(pose, vertexConsumer, -f1 - 0.0F, 1.4F - f4, f5, u0, v0);
            soulFireVertex(pose, vertexConsumer, f1 - 0.0F, 1.4F - f4, f5, u1, v0);
            f3 -= 0.45F;
            f4 -= 0.45F;
            f1 *= 0.9F;
            f5 += 0.03F;
        }

        pPoseStack.popPose();
    }

    //Method directly copied of fireVertex from EntityRenderDispatcher. The only difference is the fire color.
    @Unique
    private void soulFireVertex(PoseStack.Pose pPose, VertexConsumer pConsumer, float pX, float pY, float pZ, float pU, float pV) {
        pConsumer.vertex(pPose.pose(), pX, pY, pZ)
                .color(1f, 1f, 1f, 1f)
                .uv(pU, pV)
                .overlayCoords(0, 10)
                .uv2(240)
                .normal(pPose.normal(),0f, 1f, 0f)
                .endVertex();
    }
}
