package net.marmar.elemental_creatures.model.zombie.scorched.soul;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.zombie.SoulScorched;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("removal")
public class SoulScorchedRenderer extends AbstractZombieRenderer<SoulScorched, ZombieModel<SoulScorched>> {
    public SoulScorchedRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ZombieModel<>(pContext.bakeLayer(ECModelLayers.SOUL_SCORCHED)),
                new ZombieModel<>(pContext.bakeLayer(ECModelLayers.SOUL_SCORCHED_INNER_ARMOR)),
                new ZombieModel<>(pContext.bakeLayer(ECModelLayers.SOUL_SCORCHED_OUTER_ARMOR)));

        this.addLayer(new SoulScorchedOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(Zombie pEntity) {
        return new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/zombie/scorched/soul/soul_scorched.png");
    }
}
