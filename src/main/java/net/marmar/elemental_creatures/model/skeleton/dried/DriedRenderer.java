package net.marmar.elemental_creatures.model.skeleton.dried;

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
public class DriedRenderer extends SkeletonRenderer {
    private static final ResourceLocation DRIED_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/skeleton/dried/dried.png");

    public DriedRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.DRIED, ECModelLayers.DRIED_INNER_ARMOR, ECModelLayers.DRIED_OUTER_ARMOR);

        this.addLayer(new DriedOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton pEntity) {
        return DRIED_LOCATION;
    }
}
