package net.marmar.elemental_creatures.model.slime.redsandcube;

import net.marmar.elemental_creatures.entity.slime.RedSandCube;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.slime.AbstractSlimeOuterLayer;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;

public class RedSandCubeOuterLayer extends AbstractSlimeOuterLayer<RedSandCube> {
    public RedSandCubeOuterLayer(RenderLayerParent<RedSandCube, SlimeModel<RedSandCube>> pRenderer, EntityModelSet pModelSet) {
        super(pRenderer, pModelSet, ECModelLayers.RED_SAND_CUBE_OUTER);
    }
}
