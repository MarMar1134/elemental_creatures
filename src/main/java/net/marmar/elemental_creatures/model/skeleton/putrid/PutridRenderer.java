package net.marmar.elemental_creatures.model.skeleton.putrid;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.skeleton.dried.DriedOuterLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("removal")
public class PutridRenderer extends SkeletonRenderer {
    private static final ResourceLocation PUTRID_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/skeleton/putrid/putrid.png");

    public PutridRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.PUTRID, ECModelLayers.PUTRID_INNER_ARMOR, ECModelLayers.PUTRID_OUTER_ARMOR);

        this.addLayer(new PutridOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton pEntity) {
        return PUTRID_LOCATION;
    }
}
