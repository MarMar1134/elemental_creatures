package net.marmar.elemental_creatures.model.skeleton.soulreaper;

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
public class SoulReaperRenderer extends SkeletonRenderer {
    private static final ResourceLocation SOUL_REAPER_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/skeleton/soul_reaper.png");

    public SoulReaperRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.SOUL_REAPER, ECModelLayers.LOST_INNER_ARMOR, ECModelLayers.SOUL_REAPER_OUTER_ARMOR);

        this.addLayer(new SoulReaperOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton pEntity) {
        return SOUL_REAPER_LOCATION;
    }
}
