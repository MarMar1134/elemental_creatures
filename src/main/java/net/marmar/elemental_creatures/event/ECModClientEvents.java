package net.marmar.elemental_creatures.event;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.entity.slime.IceCube;
import net.marmar.elemental_creatures.model.ECModelLayers;
import net.marmar.elemental_creatures.model.projectile.LightningArrowRenderer;
import net.marmar.elemental_creatures.model.projectile.PrismarineArrowRenderer;
import net.marmar.elemental_creatures.model.projectile.SoulArrowRenderer;
import net.marmar.elemental_creatures.model.skeleton.dried.DriedRenderer;
import net.marmar.elemental_creatures.model.skeleton.putrid.PutridRenderer;
import net.marmar.elemental_creatures.model.skeleton.soulreaper.SoulReaperRenderer;
import net.marmar.elemental_creatures.model.skeleton.sunken.SunkenRenderer;
import net.marmar.elemental_creatures.model.skeleton.tlalocquian.TlalocquianRenderer;
import net.marmar.elemental_creatures.model.slime.icecube.IceCubeRenderer;
import net.marmar.elemental_creatures.model.slime.phranque.PhranqueRenderer;
import net.marmar.elemental_creatures.model.slime.redsandcube.RedSandCubeRenderer;
import net.marmar.elemental_creatures.model.slime.sandcube.SandCubeRenderer;
import net.marmar.elemental_creatures.model.zombie.illapista.IllapistaRenderer;
import net.marmar.elemental_creatures.model.zombie.lost.LostRenderer;
import net.marmar.elemental_creatures.model.zombie.rotten.RottenRenderer;
import net.marmar.elemental_creatures.model.zombie.scorched.ScorchedRenderer;
import net.marmar.elemental_creatures.model.zombie.scorched.soul.SoulScorchedRenderer;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.SlimeModel;
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
        EntityRenderers.register(ECEntityTypes.PRISMARINE_ARROW.get(), PrismarineArrowRenderer::new);

        //Zombies
        EntityRenderers.register(ECEntityTypes.SCORCHED.get(), ScorchedRenderer::new);
        EntityRenderers.register(ECEntityTypes.SOUL_SCORCHED.get(), SoulScorchedRenderer::new);
        EntityRenderers.register(ECEntityTypes.LOST.get(), LostRenderer::new);
        EntityRenderers.register(ECEntityTypes.ROTTEN.get(), RottenRenderer::new);
        EntityRenderers.register(ECEntityTypes.ILLAPISTA.get(), IllapistaRenderer::new);

        //Skeletons
        EntityRenderers.register(ECEntityTypes.SOUL_REAPER.get(), SoulReaperRenderer::new);
        EntityRenderers.register(ECEntityTypes.TLALOCQUIAN.get(), TlalocquianRenderer::new);
        EntityRenderers.register(ECEntityTypes.SUNKEN.get(), SunkenRenderer::new);
        EntityRenderers.register(ECEntityTypes.DRIED.get(), DriedRenderer::new);
        EntityRenderers.register(ECEntityTypes.PUTRID.get(), PutridRenderer::new);

        //Slimes
        EntityRenderers.register(ECEntityTypes.ICE_CUBE.get(), IceCubeRenderer::new);
        EntityRenderers.register(ECEntityTypes.SAND_CUBE.get(), SandCubeRenderer::new);
        EntityRenderers.register(ECEntityTypes.RED_SAND_CUBE.get(), RedSandCubeRenderer::new);
        EntityRenderers.register(ECEntityTypes.PHRANQUE.get(), PhranqueRenderer::new);
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

        //Soul scorched
        event.registerLayerDefinition(ECModelLayers.SOUL_SCORCHED, () ->
                LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f), 64, 64));
        event.registerLayerDefinition(ECModelLayers.SOUL_SCORCHED_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.SOUL_SCORCHED_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.SOUL_SCORCHED_OUTER, () ->
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
        
        //Soul Reaper
        event.registerLayerDefinition(ECModelLayers.SOUL_REAPER, SkeletonModel::createBodyLayer);
        event.registerLayerDefinition(ECModelLayers.SOUL_REAPER_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.SOUL_REAPER_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.SOUL_REAPER_OUTER, () ->
                LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.2f), 0.0f), 64, 32));

        //Tlalocquian
        event.registerLayerDefinition(ECModelLayers.TLALOCQUIAN, SkeletonModel::createBodyLayer);
        event.registerLayerDefinition(ECModelLayers.TLALOCQUIAN_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.TLALOCQUIAN_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.TLALOCQUIAN_OUTER, () ->
                LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.2f), 0.0f), 64, 32));

        //Sunken
        event.registerLayerDefinition(ECModelLayers.SUNKEN, SkeletonModel::createBodyLayer);
        event.registerLayerDefinition(ECModelLayers.SUNKEN_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.SUNKEN_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.SUNKEN_OUTER, () ->
                LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.2f), 0.0f), 64, 32));

        //Dried
        event.registerLayerDefinition(ECModelLayers.DRIED, SkeletonModel::createBodyLayer);
        event.registerLayerDefinition(ECModelLayers.DRIED_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.DRIED_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.DRIED_OUTER, () ->
                LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.2f), 0.0f), 64, 32));

        //Putrid
        event.registerLayerDefinition(ECModelLayers.PUTRID, SkeletonModel::createBodyLayer);
        event.registerLayerDefinition(ECModelLayers.PUTRID_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.PUTRID_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(ECModelLayers.PUTRID_OUTER, () ->
                LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.2f), 0.0f), 64, 32));

        //Ice cube
        event.registerLayerDefinition(ECModelLayers.ICE_CUBE, SlimeModel::createInnerBodyLayer);
        event.registerLayerDefinition(ECModelLayers.ICE_CUBE_OUTER, SlimeModel::createOuterBodyLayer);

        //Sand cube
        event.registerLayerDefinition(ECModelLayers.SAND_CUBE, SlimeModel::createInnerBodyLayer);
        event.registerLayerDefinition(ECModelLayers.SAND_CUBE_OUTER, SlimeModel::createOuterBodyLayer);

        //Red Sand Cube
        event.registerLayerDefinition(ECModelLayers.RED_SAND_CUBE, SlimeModel::createInnerBodyLayer);
        event.registerLayerDefinition(ECModelLayers.RED_SAND_CUBE_OUTER, SlimeModel::createOuterBodyLayer);

        //Phranque
        event.registerLayerDefinition(ECModelLayers.PHRANQUE, SlimeModel::createInnerBodyLayer);
        event.registerLayerDefinition(ECModelLayers.PHRANQUE_OUTER, SlimeModel::createOuterBodyLayer);
    }
}
