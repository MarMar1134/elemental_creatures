package net.marmar.elemental_creatures.model.spider.aracnian;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

@SuppressWarnings("removal")
public class AracnianEyesLayer<T extends Entity, M extends SpiderModel<T>> extends EyesLayer<T, M> {
    private static final RenderType ARACNIAN_EYES = RenderType.eyes(new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/spider/aracnian/aracnian_eyes.png"));

    public AracnianEyesLayer(RenderLayerParent<T, M> pRenderer) {
        super(pRenderer);
    }

    @Override
    public RenderType renderType() {
        return ARACNIAN_EYES;
    }
}
