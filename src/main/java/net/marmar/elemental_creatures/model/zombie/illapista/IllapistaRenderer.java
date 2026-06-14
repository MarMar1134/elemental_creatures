package net.marmar.elemental_creatures.model.zombie.illapista;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.entity.zombie.Illapista;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class IllapistaRenderer extends AbstractZombieRenderer<Illapista, ZombieModel<Illapista>> {
    public IllapistaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ZombieModel<>(pContext.bakeLayer(ECModelLayers.ILLAPISTA)),
                new ZombieModel<>(pContext.bakeLayer(ECModelLayers.ILLAPISTA_INNER_ARMOR)),
                new ZombieModel<>(pContext.bakeLayer(ECModelLayers.ILLAPISTA_OUTER_ARMOR)));

        //this.addLayer(new ScorchedOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getTextureLocation(Zombie pEntity) {
        return new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/zombie/illapista.png");
    }
}
