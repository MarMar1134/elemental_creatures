package net.marmar.elemental_creatures.model.spider.aracnian;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.spider.Aracnian;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.spider.AbstractSpiderRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class AracnianRenderer extends AbstractSpiderRenderer<Aracnian> {
    private static final ResourceLocation ARACNIAN_LOCATION = ResourceLocation.fromNamespaceAndPath(ElementalCreatures.MOD_ID,
            "textures/entity/spider/aracnian/aracnian.png");

    public AracnianRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.ARACNIAN, 1.2f);
        this.addLayer(new AracnianEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Aracnian pEntity) {
        return ARACNIAN_LOCATION;
    }
}
