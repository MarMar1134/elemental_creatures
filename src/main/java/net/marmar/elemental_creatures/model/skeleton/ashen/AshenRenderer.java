package net.marmar.elemental_creatures.model.skeleton.ashen;

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
public class AshenRenderer extends SkeletonRenderer {
    private static final ResourceLocation ASHEN_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/skeleton/ashen/ashen.png");
    
    public AshenRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.ASHEN, ECModelLayers.ASHEN_INNER_ARMOR, ECModelLayers.ASHEN_OUTER_ARMOR);

        this.addLayer(new AshenOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton pEntity) {
        return ASHEN_LOCATION;
    }
}
