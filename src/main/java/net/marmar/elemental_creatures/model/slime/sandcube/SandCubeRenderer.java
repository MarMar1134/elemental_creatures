package net.marmar.elemental_creatures.model.slime.sandcube;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.slime.SandCube;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.slime.AbstractSlimeRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("removal")
public class SandCubeRenderer extends AbstractSlimeRenderer<SandCube> {
    private static final ResourceLocation SAND_CUBE_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/slime/sand_cube.png");

    public SandCubeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.SAND_CUBE);
        this.addLayer(new SandCubeOuterLayer(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(SandCube pEntity) {
        return SAND_CUBE_LOCATION;
    }
}
