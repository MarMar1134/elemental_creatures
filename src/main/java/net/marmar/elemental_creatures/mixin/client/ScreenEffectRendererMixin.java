package net.marmar.elemental_creatures.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import net.marmar.elemental_creatures.util.SoulFireUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@OnlyIn(Dist.CLIENT)
@Mixin(ScreenEffectRenderer.class)
public class ScreenEffectRendererMixin {
    @Inject(method = "renderFire", at = @At("HEAD"), cancellable = true)
    private static void interceptFireOverlay(Minecraft pMinecraft, PoseStack pPoseStack, CallbackInfo ci) {
        if (pMinecraft.player == null)
            return;

        if (!SoulFireUtils.hasSoulFire(pMinecraft.player))
            return;

        ci.cancel();

        renderSoulFireOverlay(pMinecraft, pPoseStack);
    }

    //Method directly copied from renderFire() on ScreenEffectRenderer. The only difference is the texture taken.
    @Unique
    @SuppressWarnings("removal")
    private static void renderSoulFireOverlay(Minecraft pMinecraft, PoseStack pPoseStack) {
        var atlas = pMinecraft.getModelManager().getAtlas(TextureAtlas.LOCATION_BLOCKS);
        var sprite = atlas.getSprite(new ResourceLocation("minecraft", "block/soul_fire_1"));

        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
        RenderSystem.depthFunc(519);
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();

        RenderSystem.setShaderTexture(0, sprite.atlasLocation());
        float f = sprite.getU0();
        float f1 = sprite.getU1();
        float f2 = (f + f1) / 2.0F;
        float f3 = sprite.getV0();
        float f4 = sprite.getV1();
        float f5 = (f3 + f4) / 2.0F;
        float f6 = sprite.uvShrinkRatio();
        float f7 = Mth.lerp(f6, f, f2);
        float f8 = Mth.lerp(f6, f1, f2);
        float f9 = Mth.lerp(f6, f3, f5);
        float f10 = Mth.lerp(f6, f4, f5);

        for(int i = 0; i < 2; ++i) {
            pPoseStack.pushPose();
            pPoseStack.translate((float)(-(i * 2 - 1)) * 0.24F, -0.3F, 0.0F);
            pPoseStack.mulPose(Axis.YP.rotationDegrees((float)(i * 2 - 1) * 10.0F));
            Matrix4f matrix4f = pPoseStack.last().pose();
            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR_TEX);
            bufferbuilder.vertex(matrix4f, -0.5F, -0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).uv(f8, f10).endVertex();
            bufferbuilder.vertex(matrix4f, 0.5F, -0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).uv(f7, f10).endVertex();
            bufferbuilder.vertex(matrix4f, 0.5F, 0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).uv(f7, f9).endVertex();
            bufferbuilder.vertex(matrix4f, -0.5F, 0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).uv(f8, f9).endVertex();
            BufferUploader.drawWithShader(bufferbuilder.end());
            pPoseStack.popPose();
        }

        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.depthFunc(515);
    }
}
