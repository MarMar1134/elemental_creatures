package net.marmar.elemental_creatures.entity.skeleton.blight;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ByIdMap;

import java.util.function.IntFunction;

@SuppressWarnings("removal")
public enum BlightVariant {
    RED(0, new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/skeleton/blight/red_blight.png")),
    BROWN(1, new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/skeleton/blight/brown_blight.png")),
    CRIMSON(2, new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/skeleton/blight/crimson_blight.png")),
    WARPED(3, new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/skeleton/blight/warped_blight.png"));

    private final int id;
    private final ResourceLocation textureLocation;

    private static final IntFunction<BlightVariant> BY_ID = ByIdMap.continuous(BlightVariant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);

    BlightVariant(int pId, ResourceLocation pTextureLocation) {
        this.id = pId;
        this.textureLocation = pTextureLocation;
    }

    public int getId() {
        return this.id;
    }

    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }

    public static BlightVariant byId(int pId){
        return BY_ID.apply(pId);
    }
}
