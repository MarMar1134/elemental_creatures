package net.marmar.elemental_creatures.model.spider;

import com.mojang.blaze3d.vertex.PoseStack;
import net.marmar.elemental_creatures.entity.spider.AbstractSpider;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.world.entity.monster.Spider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractSpiderRenderer<T extends AbstractSpider> extends MobRenderer<T, SpiderModel<T>> {
    private final float scale;

    public AbstractSpiderRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pModelLayer, float pScale) {
        super(pContext, new SpiderModel<>(pContext.bakeLayer(pModelLayer)), 0.8F);
        scale = pScale;
        this.shadowRadius *= this.scale;
    }

    @Override
    protected void scale(T pEntity, PoseStack pPoseStack, float pPartialTickTime) {
        pPoseStack.scale(this.scale, this.scale, this.scale);
    }

    @Override
    protected float getFlipDegrees(T pEntity) {
        return 180.0F;
    }

//    @Override
//    protected boolean isShaking(T pEntity) {
//        return super.isShaking(pEntity) || pEntity.isDecaying();
//    }
}
