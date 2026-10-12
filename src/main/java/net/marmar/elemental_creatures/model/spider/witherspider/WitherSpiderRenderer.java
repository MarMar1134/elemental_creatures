package net.marmar.elemental_creatures.model.spider.witherspider;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.spider.WitherSpider;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.spider.AbstractSpiderRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("removal")
public class WitherSpiderRenderer extends AbstractSpiderRenderer<WitherSpider> {
    private static final ResourceLocation WITHER_SPIDER_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/spider/wither_spider/wither_spider.png");
    
    public WitherSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.WITHER_SPIDER, 1.2f);
        this.addLayer(new WitherSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(WitherSpider pEntity) {
        return WITHER_SPIDER_LOCATION;
    }
}
