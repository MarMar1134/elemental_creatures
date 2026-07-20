package net.marmar.elemental_creatures.model.slime.redsandcube;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.slime.RedSandCube;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.slime.AbstractSlimeRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("removal")
public class RedSandCubeRenderer extends AbstractSlimeRenderer<RedSandCube> {
    private static final ResourceLocation RED_SAND_CUBE_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/slime/red_sand_cube.png");

    public RedSandCubeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, ECModelLayers.RED_SAND_CUBE, RED_SAND_CUBE_LOCATION);
        this.addLayer(new RedSandCubeOuterLayer(this, pContext.getModelSet()));
    }
}
