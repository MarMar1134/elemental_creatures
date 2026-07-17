package net.marmar.elemental_creatures.model.zombie.rotten;

import com.mojang.blaze3d.vertex.PoseStack;
import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.entity.zombie.Rotten;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("removal")
public class RottenOuterLayer<T extends Rotten> extends RenderLayer<T, ZombieModel<T>> {
    private static final ResourceLocation ROTTEN_OUTER_LOCATION = new ResourceLocation(ElementalCreatures.MOD_ID,
            "textures/entity/zombie/rotten/rotten_outer_layer.png");
    private final ZombieModel<T> model;

    public RottenOuterLayer(RenderLayerParent<T, ZombieModel<T>> pRenderer, EntityModelSet pModelSet) {
        super(pRenderer);
        this.model = new ZombieModel<>(pModelSet.bakeLayer(ECModelLayers.ROTTEN_OUTER));
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, ROTTEN_OUTER_LOCATION, pPoseStack, pBuffer, pPackedLight, pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch, pPartialTick, 1.0F, 1.0F, 1.0F);
    }
}
