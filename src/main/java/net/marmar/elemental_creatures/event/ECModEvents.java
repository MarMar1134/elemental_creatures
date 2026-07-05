package net.marmar.elemental_creatures.event;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.entity.skeleton.SoulReaper;
import net.marmar.elemental_creatures.entity.skeleton.Sunken;
import net.marmar.elemental_creatures.entity.skeleton.Tlalocquian;
import net.marmar.elemental_creatures.entity.zombie.Illapista;
import net.marmar.elemental_creatures.entity.zombie.Lost;
import net.marmar.elemental_creatures.entity.zombie.Rotten;
import net.marmar.elemental_creatures.entity.zombie.Scorched;
import net.marmar.elemental_creatures.network.ECNetwork;
import net.minecraft.world.entity.SpawnPlacements;
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
        event.put(ECEntityTypes.SCORCHED.get(), Scorched.createAttributes().build());
        event.put(ECEntityTypes.LOST.get(), Lost.createAttributes().build());
        event.put(ECEntityTypes.ROTTEN.get(), Rotten.createAttributes().build());
        event.put(ECEntityTypes.ILLAPISTA.get(), Illapista.createAttributes().build());

        //Skeleton attributes
        event.put(ECEntityTypes.SOUL_REAPER.get(), SoulReaper.createAttributes().build());
        event.put(ECEntityTypes.TLALOCQUIAN.get(), Tlalocquian.createAttributes().build());
        event.put(ECEntityTypes.SUNKEN.get(), Sunken.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerMobSpawns(SpawnPlacementRegisterEvent event){
        //Zombies
        event.register(ECEntityTypes.SCORCHED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Scorched::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
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
        event.register(ECEntityTypes.SUNKEN.get(),SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.OCEAN_FLOOR_WG,
                Sunken::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        ECNetwork.register();
    }
}
