package net.marmar.elemental_creatures.model.projectile;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.projectile.PrismarineArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class PrismarineArrowRenderer extends ArrowRenderer<PrismarineArrowEntity> {
    public PrismarineArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getTextureLocation(PrismarineArrowEntity pEntity) {
        return new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/projectiles/prismarine_arrow.png");
    }
}
