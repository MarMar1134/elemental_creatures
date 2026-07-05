package net.marmar.elemental_creatures.model.skeleton.sunken;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("removal")
public class SunkenRenderer extends SkeletonRenderer {
    private static final ResourceLocation SUNKEN_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/skeleton/sunken/sunken.png");

    public SunkenRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.SUNKEN, ECModelLayers.SUNKEN_INNER_ARMOR, ECModelLayers.SUNKEN_OUTER_ARMOR);

        this.addLayer(new SunkenOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton pEntity) {
        return SUNKEN_LOCATION;
    }
}
