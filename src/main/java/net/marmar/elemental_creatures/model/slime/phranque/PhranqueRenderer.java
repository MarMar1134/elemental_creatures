package net.marmar.elemental_creatures.model.slime.phranque;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.slime.Phranque;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.slime.AbstractSlimeRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("removal")
public class PhranqueRenderer extends AbstractSlimeRenderer<Phranque> {
    private static final ResourceLocation PHRANQUE_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/slime/phranque.png");

    public PhranqueRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.PHRANQUE);
        this.addLayer(new PhranqueOuterLayer(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(Phranque pEntity) {
        return PHRANQUE_LOCATION;
    }
}
