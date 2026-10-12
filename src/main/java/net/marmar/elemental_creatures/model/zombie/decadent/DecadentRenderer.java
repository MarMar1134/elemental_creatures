package net.marmar.elemental_creatures.model.zombie.decadent;

import com.mojang.blaze3d.vertex.PoseStack;
import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.zombie.Decadent;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DecadentRenderer extends AbstractZombieRenderer<Decadent, ZombieModel<Decadent>> {
    public DecadentRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ZombieModel<>(pContext.bakeLayer(ECModelLayers.DECADENT)),
                new ZombieModel<>(pContext.bakeLayer(ECModelLayers.DECADENT_INNER_ARMOR)),
                new ZombieModel<>(pContext.bakeLayer(ECModelLayers.DECADENT_OUTER_ARMOR)));

        this.addLayer(new DecadentOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    protected void scale(Decadent pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        pPoseStack.scale(1.2f, 1.2f, 1.2f);
    }

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getTextureLocation(Zombie pEntity) {
        return new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/zombie/decadent/decadent.png");
    }
}
