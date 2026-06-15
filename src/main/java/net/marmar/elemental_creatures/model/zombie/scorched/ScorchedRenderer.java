package net.marmar.elemental_creatures.model.zombie.scorched;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.entity.zombie.Scorched;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScorchedRenderer extends AbstractZombieRenderer<Scorched, ZombieModel<Scorched>> {
    public ScorchedRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ZombieModel<>(pContext.bakeLayer(ECModelLayers.SCORCHED)),
                new ZombieModel<>(pContext.bakeLayer(ECModelLayers.SCORCHED_INNER_ARMOR)),
                new ZombieModel<>(pContext.bakeLayer(ECModelLayers.SCORCHED_OUTER_ARMOR)));

        this.addLayer(new ScorchedOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getTextureLocation(Zombie pEntity) {
        return new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/zombie/scorched.png");
    }
}
