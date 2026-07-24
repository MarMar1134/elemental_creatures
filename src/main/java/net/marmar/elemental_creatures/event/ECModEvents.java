package net.marmar.elemental_creatures.event;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.entity.skeleton.*;
import net.marmar.elemental_creatures.entity.slime.*;
import net.marmar.elemental_creatures.entity.spider.Aracnian;
import net.marmar.elemental_creatures.entity.spider.DesertSpider;
import net.marmar.elemental_creatures.entity.spider.SnowySpider;
import net.marmar.elemental_creatures.entity.zombie.*;
import net.marmar.elemental_creatures.network.ECNetwork;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ElementalCreatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ECModEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        //Zombie attributes
        event.put(ECEntityTypes.SCORCHED.get(), Scorched.createScorchedAttributes().build());
        event.put(ECEntityTypes.SOUL_SCORCHED.get(), SoulScorched.createSoulScorchedAttributes().build());
        event.put(ECEntityTypes.LOST.get(), Lost.createLostAttributes().build());
        event.put(ECEntityTypes.ROTTEN.get(), Rotten.createRottenAttributes().build());
        event.put(ECEntityTypes.ILLAPISTA.get(), Illapista.createIllapistaAttributes().build());

        //Skeleton attributes
        event.put(ECEntityTypes.SOUL_REAPER.get(), SoulReaper.createSoulReaperAttributes().build());
        event.put(ECEntityTypes.TLALOCQUIAN.get(), Tlalocquian.createTlalocquianAttributes().build());
        event.put(ECEntityTypes.SUNKEN.get(), Sunken.createSunkenAttributes().build());
        event.put(ECEntityTypes.DRIED.get(), Dried.createDriedAttributes().build());
        event.put(ECEntityTypes.PUTRID.get(), Putrid.createPutridAttributes().build());

        //Slime attributes
        event.put(ECEntityTypes.ICE_CUBE.get(), IceCube.createIceCubeAttributes().build());
        event.put(ECEntityTypes.SAND_CUBE.get(), SandCube.createSandCubeAttributes().build());
        event.put(ECEntityTypes.RED_SAND_CUBE.get(), RedSandCube.createRedSandCubeAttributes().build());
        event.put(ECEntityTypes.PHRANQUE.get(), Phranque.createPhranqueAttributes().build());

        //Spider attributes
        event.put(ECEntityTypes.DESERT_SPIDER.get(), DesertSpider.createDesertSpiderAttributes().build());
        event.put(ECEntityTypes.SNOWY_SPIDER.get(), SnowySpider.createSnowySpiderAttributes().build());
        event.put(ECEntityTypes.ARACNIAN.get(), Aracnian.createAracnianAttributes().build());
    }

    @SubscribeEvent
    public static void registerMobSpawns(SpawnPlacementRegisterEvent event){
        //Zombies
        event.register(ECEntityTypes.SCORCHED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Scorched::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.SOUL_SCORCHED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                SoulScorched::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.LOST.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Lost::checkLostSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.ROTTEN.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Rotten::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.ILLAPISTA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Illapista::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);

        //Skeletons
        event.register(ECEntityTypes.SOUL_REAPER.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                SoulReaper::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.TLALOCQUIAN.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Tlalocquian::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.SUNKEN.get(),SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Sunken::checkSunkenSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.DRIED.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Dried::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.PUTRID.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Putrid::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);

        //Slimes
        event.register(ECEntityTypes.ICE_CUBE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractSlime::checkSlimeLikeSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.SAND_CUBE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractSlime::checkSlimeLikeSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.RED_SAND_CUBE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractSlime::checkSlimeLikeSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.PHRANQUE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractSlime::checkSlimeLikeSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);

        //Spiders
        event.register(ECEntityTypes.DESERT_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.SNOWY_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ECEntityTypes.ARACNIAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        ECNetwork.register();
    }
}
