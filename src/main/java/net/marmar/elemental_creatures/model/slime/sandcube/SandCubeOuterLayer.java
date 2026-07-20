package net.marmar.elemental_creatures.model.slime.sandcube;

import net.marmar.elemental_creatures.entity.slime.SandCube;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.slime.AbstractSlimeOuterLayer;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;

public class SandCubeOuterLayer extends AbstractSlimeOuterLayer<SandCube> {
    public SandCubeOuterLayer(RenderLayerParent<SandCube, SlimeModel<SandCube>> pRenderer, EntityModelSet pModelSet) {
        super(pRenderer, pModelSet, ECModelLayers.SAND_CUBE_OUTER);
    }
}
