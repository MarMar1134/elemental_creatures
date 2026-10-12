package net.marmar.elemental_creatures.model.zombie.fungus;

import com.mojang.blaze3d.vertex.PoseStack;
import net.marmar.elemental_creatures.entity.zombie.fungus.Fungus;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FungusOuterLayer<T extends Fungus> extends RenderLayer<T, ZombieModel<T>> {
    private final ZombieModel<T> model;

    public FungusOuterLayer(RenderLayerParent<T, ZombieModel<T>> pRenderer, EntityModelSet pModelSet) {
        super(pRenderer);
        this.model = new ZombieModel<>(pModelSet.bakeLayer(ECModelLayers.FUNGUS_OUTER));
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, pLivingEntity.getTextureLocation(), pPoseStack, pBuffer, pPackedLight, pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch, pPartialTick, 1.0F, 1.0F, 1.0F);
    }
}
