package net.marmar.elemental_creatures.model.spider.snowyspider;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class SnowySpiderEyesLayer<T extends Entity, M extends SpiderModel<T>> extends EyesLayer<T, M> {
    private static final RenderType SNOWY_SPIDER_EYES = RenderType.eyes(ResourceLocation.fromNamespaceAndPath(ElementalCreatures.MOD_ID,
            "textures/entity/spider/snowy_spider/snowy_spider_eyes.png"));

    public SnowySpiderEyesLayer(RenderLayerParent<T, M> pRenderer) {
        super(pRenderer);
    }

    @Override
    public RenderType renderType() {
        return SNOWY_SPIDER_EYES;
    }
}
