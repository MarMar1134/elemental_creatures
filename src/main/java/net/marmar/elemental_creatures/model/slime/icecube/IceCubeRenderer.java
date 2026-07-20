package net.marmar.elemental_creatures.model.slime.icecube;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.slime.IceCube;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.slime.AbstractSlimeRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("removal")
public class IceCubeRenderer extends AbstractSlimeRenderer<IceCube> {
    private static final ResourceLocation ICE_CUBE_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/slime/ice_cube.png");

    public IceCubeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.ICE_CUBE, ICE_CUBE_LOCATION);
        this.addLayer(new IceCubeOuterLayer(this, pContext.getModelSet()));
    }
}
