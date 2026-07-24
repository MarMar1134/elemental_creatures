package net.marmar.elemental_creatures.model.spider.snowyspider;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.spider.SnowySpider;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.spider.AbstractSpiderRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SnowySpiderRenderer extends AbstractSpiderRenderer<SnowySpider> {
    private static final ResourceLocation SNOWY_SPIDER_LOCATION = ResourceLocation.fromNamespaceAndPath(ElementalCreatures.MOD_ID,
            "textures/entity/spider/snowy_spider/snowy_spider.png");

    public SnowySpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.SNOWY_SPIDER, 0.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(SnowySpider pEntity) {
        return SNOWY_SPIDER_LOCATION;
    }
}
