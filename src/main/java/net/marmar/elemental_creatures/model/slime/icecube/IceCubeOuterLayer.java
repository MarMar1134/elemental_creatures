package net.marmar.elemental_creatures.model.slime.icecube;

import net.marmar.elemental_creatures.entity.slime.IceCube;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.slime.AbstractSlimeOuterLayer;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;

public class IceCubeOuterLayer extends AbstractSlimeOuterLayer<IceCube> {
    public IceCubeOuterLayer(RenderLayerParent<IceCube, SlimeModel<IceCube>> pRenderer, EntityModelSet pModelSet) {
        super(pRenderer, pModelSet, ECModelLayers.ICE_CUBE_OUTER);
    }
}
