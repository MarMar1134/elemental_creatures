package net.marmar.elemental_creatures.entity.zombie.fungus;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ByIdMap;

import java.util.function.IntFunction;

@SuppressWarnings("removal")
public enum FungusVariant {
    RED(0, new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/zombie/fungus/red_fungus.png")),
    BROWN(1, new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/zombie/fungus/brown_fungus.png")),
    CRIMSON(2, new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/zombie/fungus/crimson_fungus.png")),
    WARPED(3, new ResourceLocation(ElementalCreatures.MOD_ID, "textures/entity/zombie/fungus/warped_fungus.png"));

    private final int id;
    private final ResourceLocation textureLocation;

    private static final IntFunction<FungusVariant> BY_ID = ByIdMap.continuous(FungusVariant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);

    FungusVariant(int pId, ResourceLocation pTextureLocation) {
        this.id = pId;
        this.textureLocation = pTextureLocation;
    }

    public int getId() {
        return this.id;
    }

    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }

    public static FungusVariant byId(int pId){
        return BY_ID.apply(pId);
    }
}
