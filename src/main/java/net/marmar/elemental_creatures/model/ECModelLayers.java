package net.marmar.elemental_creatures.model;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ECModelLayers {
    //Scorched
    public static final ModelLayerLocation SCORCHED = registerMainLayer("scorched");
    public static final ModelLayerLocation SCORCHED_INNER_ARMOR = registerInnerArmorLayer("scorched_inner_armor");
    public static final ModelLayerLocation SCORCHED_OUTER_ARMOR = registerOuterArmorLayer("scorched_outer_armor");
    public static final ModelLayerLocation SCORCHED_OUTER = registerOuterLayer("scorched_outer");

    //Lost
    public static final ModelLayerLocation LOST = registerMainLayer("lost");
    public static final ModelLayerLocation LOST_INNER_ARMOR = registerInnerArmorLayer("lost_inner_armor");
    public static final ModelLayerLocation LOST_OUTER_ARMOR = registerOuterArmorLayer("lost_outer_armor");
    public static final ModelLayerLocation LOST_OUTER = registerOuterLayer("lost_outer");

    //Rotten
    public static final ModelLayerLocation ROTTEN = registerMainLayer("rotten");
    public static final ModelLayerLocation ROTTEN_INNER_ARMOR = registerInnerArmorLayer("rotten_inner_armor");
    public static final ModelLayerLocation ROTTEN_OUTER_ARMOR = registerOuterArmorLayer("rotten_outer_armor");
    public static final ModelLayerLocation ROTTEN_OUTER = registerOuterLayer("rotten_outer");

    //Illapista
    public static final ModelLayerLocation ILLAPISTA = registerMainLayer("illapista");
    public static final ModelLayerLocation ILLAPISTA_INNER_ARMOR = registerInnerArmorLayer("illapista_inner_armor");
    public static final ModelLayerLocation ILLAPISTA_OUTER_ARMOR = registerOuterArmorLayer("illapista_outer_armor");

    //Soul Reaper
    public static final ModelLayerLocation SOUL_REAPER = registerMainLayer("soul_reaper");
    public static final ModelLayerLocation SOUL_REAPER_INNER_ARMOR = registerInnerArmorLayer("soul_reaper_inner_armor");
    public static final ModelLayerLocation SOUL_REAPER_OUTER_ARMOR = registerOuterArmorLayer("soul_reaper_outer_armor");
    public static final ModelLayerLocation SOUL_REAPER_OUTER = registerOuterLayer("soul_reaper_outer");

    //Helpers
    @SuppressWarnings("removal")
    private static ResourceLocation modLoc(String pPath){
        return new ResourceLocation(ElementalCreatures.MOD_ID, pPath);
    }

    public static ModelLayerLocation registerMainLayer(String pLayer){
        return new ModelLayerLocation(modLoc(pLayer), "main");
    }

    public static ModelLayerLocation registerInnerArmorLayer(String pLayer){
        return new ModelLayerLocation(modLoc(pLayer), "inner_armor");
    }

    public static ModelLayerLocation registerOuterArmorLayer(String pLayer){
        return new ModelLayerLocation(modLoc(pLayer), "outer_armor");
    }

    public static ModelLayerLocation registerOuterLayer(String pLayer){
        return new ModelLayerLocation(modLoc(pLayer), "outer");
    }
}
