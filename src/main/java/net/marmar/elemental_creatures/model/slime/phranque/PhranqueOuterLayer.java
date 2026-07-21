package net.marmar.elemental_creatures.model.slime.phranque;

import net.marmar.elemental_creatures.entity.slime.Phranque;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.slime.AbstractSlimeOuterLayer;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PhranqueOuterLayer extends AbstractSlimeOuterLayer<Phranque> {
    public PhranqueOuterLayer(RenderLayerParent<Phranque, SlimeModel<Phranque>> pRenderer, EntityModelSet pModelSet) {
        super(pRenderer, pModelSet, ECModelLayers.PHRANQUE_OUTER);
    }
}
