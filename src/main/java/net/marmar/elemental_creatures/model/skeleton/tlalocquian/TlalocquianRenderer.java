package net.marmar.elemental_creatures.model.skeleton.tlalocquian;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;

@SuppressWarnings("removal")
public class TlalocquianRenderer extends SkeletonRenderer {
    private static final ResourceLocation TLALOCQUIAN_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/skeleton/tlalocquian/tlalocquian.png");

    public TlalocquianRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.TLALOCQUIAN, ECModelLayers.TLALOCQUIAN_INNER_ARMOR, ECModelLayers.TLALOCQUIAN_OUTER_ARMOR);

        this.addLayer(new TlalocquianOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton pEntity) {
        return TLALOCQUIAN_LOCATION;
    }
}
