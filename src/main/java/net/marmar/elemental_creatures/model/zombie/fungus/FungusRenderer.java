package net.marmar.elemental_creatures.model.zombie.fungus;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.zombie.fungus.Fungus;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("removal")
public class FungusRenderer extends AbstractZombieRenderer<Fungus, ZombieModel<Fungus>> {
    private static final ResourceLocation FUNGUS_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/zombie/fungus/fungus.png");

    public FungusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ZombieModel<>(pContext.bakeLayer(ECModelLayers.FUNGUS)),
                new ZombieModel<>(pContext.bakeLayer(ECModelLayers.FUNGUS_INNER_ARMOR)),
                new ZombieModel<>(pContext.bakeLayer(ECModelLayers.FUNGUS_OUTER_ARMOR)));

        this.addLayer(new FungusOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(Fungus pEntity) {
        return FUNGUS_LOCATION;
    }
}
