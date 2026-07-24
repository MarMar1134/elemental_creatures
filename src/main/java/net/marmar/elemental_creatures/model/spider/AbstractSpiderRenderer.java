package net.marmar.elemental_creatures.model.spider;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.world.entity.monster.Spider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractSpiderRenderer<T extends Spider> extends MobRenderer<T, SpiderModel<T>> {
    private final float scale;

    public AbstractSpiderRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pModelLayer, float pScale) {
        super(pContext, new SpiderModel<>(pContext.bakeLayer(pModelLayer)), 0.8F);
        scale = pScale;
        this.shadowRadius *= this.scale;
    }

    @Override
    protected void scale(T pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        pPoseStack.scale(this.scale, this.scale, this.scale);
    }

    protected float getFlipDegrees(T pLivingEntity) {
        return 180.0F;
    }
}
