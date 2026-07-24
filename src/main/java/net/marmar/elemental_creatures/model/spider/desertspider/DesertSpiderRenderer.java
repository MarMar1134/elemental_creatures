package net.marmar.elemental_creatures.model.spider.desertspider;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.spider.DesertSpider;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.spider.AbstractSpiderRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("removal")
public class DesertSpiderRenderer extends AbstractSpiderRenderer<DesertSpider> {
    private static final ResourceLocation DESERT_SPIDER_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/spider/desert_spider/desert_spider.png");

    public DesertSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.DESERT_SPIDER, 1f);
        this.addLayer(new DesertSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(DesertSpider pEntity) {
        return DESERT_SPIDER_LOCATION;
    }
}
