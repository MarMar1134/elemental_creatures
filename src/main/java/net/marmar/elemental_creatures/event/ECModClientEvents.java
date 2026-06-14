package net.marmar.elemental_creatures.event;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.projectile.LightningArrowRenderer;
import net.marmar.elemental_creatures.model.projectile.SoulArrowRenderer;
import net.marmar.elemental_creatures.model.zombie.illapista.IllapistaRenderer;
import net.marmar.elemental_creatures.model.zombie.lost.LostRenderer;
import net.marmar.elemental_creatures.model.zombie.rotten.RottenRenderer;
import net.marmar.elemental_creatures.model.zombie.scorched.ScorchedRenderer;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ElementalCreatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ECModClientEvents {
    public static final CubeDeformation OUTER_ARMOR_DEFORMATION = new CubeDeformation(1.0F);
    public static final CubeDeformation INNER_ARMOR_DEFORMATION = new CubeDeformation(0.5F);

    @SubscribeEvent
    public static void subscribeEntityRenderers(FMLClientSetupEvent event){
        //Projectiles
        EntityRenderers.register(ECEntityTypes.LIGHTNING_ARROW.get(), LightningArrowRenderer::new);
        EntityRenderers.register(ECEntityTypes.SOUL_ARROW.get(), SoulArrowRenderer::new);

        //Zombies
        EntityRenderers.register(ECEntityTypes.SCORCHED.get(), ScorchedRenderer::new);
        EntityRenderers.register(ECEntityTypes.LOST.get(), LostRenderer::new);
        EntityRenderers.register(ECEntityTypes.ROTTEN.get(), RottenRenderer::new);
        EntityRenderers.register(ECEntityTypes.ILLAPISTA.get(), IllapistaRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityLayerRenderers(EntityRenderersEvent.RegisterLayerDefinitions event){
        //Scorched
        event.registerLayerDefinition(ECModelLayers.SCORCHED, () ->
                LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f), 64, 64));
        event.registerLayerDefinition(ECModelLayers.SCORCHED_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.SCORCHED_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.SCORCHED_OUTER, () ->
                LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.25f), 0.0f), 64, 64));

        //Lost
        event.registerLayerDefinition(ECModelLayers.LOST, () ->
                LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f), 64, 64));
        event.registerLayerDefinition(ECModelLayers.LOST_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.LOST_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.LOST_OUTER, () ->
                LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.25f), 0.0f), 64, 64));

        //Rotten
        event.registerLayerDefinition(ECModelLayers.ROTTEN, () ->
                LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f), 64, 64));
        event.registerLayerDefinition(ECModelLayers.ROTTEN_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.ROTTEN_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.ROTTEN_OUTER, () ->
                LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.25f), 0.0f), 64, 64));

        //Illapista
        event.registerLayerDefinition(ECModelLayers.ILLAPISTA, () ->
                LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f), 64, 64));
        event.registerLayerDefinition(ECModelLayers.ILLAPISTA_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.ILLAPISTA_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
    }
}
