package net.marmar.elemental_creatures.model.projectile;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.projectile.SoulArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SoulArrowRenderer extends ArrowRenderer<SoulArrowEntity> {
    public SoulArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getTextureLocation(SoulArrowEntity pEntity) {
        return new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/projectiles/soul_arrow.png");
    }
}
