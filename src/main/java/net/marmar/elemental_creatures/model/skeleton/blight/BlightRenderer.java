package net.marmar.elemental_creatures.model.skeleton.blight;

import net.marmar.elemental_creatures.entity.skeleton.blight.Blight;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BlightRenderer extends SkeletonRenderer {
    public BlightRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.BLIGHT, ECModelLayers.BLIGHT_INNER_ARMOR, ECModelLayers.BLIGHT_OUTER_ARMOR);

        this.addLayer(new BlightOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton pEntity) {
        if (pEntity instanceof Blight blight){
            return blight.getTextureLocation();
        }
        
        return super.getTextureLocation(pEntity);
    }
}
