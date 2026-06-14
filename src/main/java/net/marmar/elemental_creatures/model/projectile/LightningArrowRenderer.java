package net.marmar.elemental_creatures.model.projectile;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.projectile.LightningArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LightningArrowRenderer extends ArrowRenderer<LightningArrowEntity> {
    public LightningArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getTextureLocation(LightningArrowEntity pEntity) {
        return new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/projectiles/lightning_arrow.png");
    }
}
