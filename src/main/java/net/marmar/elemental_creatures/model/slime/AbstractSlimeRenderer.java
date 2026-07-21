package net.marmar.elemental_creatures.model.slime;

import com.mojang.blaze3d.vertex.PoseStack;
import net.marmar.elemental_creatures.entity.slime.AbstractSlime;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public abstract class AbstractSlimeRenderer<T extends AbstractSlime> extends MobRenderer<T, SlimeModel<T>> {
    public AbstractSlimeRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pInnerLayer) {
        super(pContext, new SlimeModel<>(pContext.bakeLayer(pInnerLayer)), 0.25f);
    }

    @Override
    public void render(T pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        this.shadowRadius = 0.25F * (float)pEntity.getSize();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    protected void scale(T pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        pPoseStack.scale(0.999F, 0.999F, 0.999F);
        pPoseStack.translate(0.0F, 0.001F, 0.0F);
        float size = (float)pLivingEntity.getSize();
        float partialTick = Mth.lerp(pPartialTickTime, pLivingEntity.oSquish, pLivingEntity.squish) / (size * 0.5F + 1.0F);
        float scale = 1.0F / (partialTick + 1.0F);
        pPoseStack.scale(scale * size, 1.0F / scale * size, scale * size);
    }
}
