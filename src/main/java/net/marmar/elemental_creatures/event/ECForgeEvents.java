package net.marmar.elemental_creatures.event;

import net.marmar.elemental_creatures.ECConfig;
import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.datagen.tag.ECTags;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.util.SoulFireUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElementalCreatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ECForgeEvents {
    @SubscribeEvent
    public static void onLivingEntityTick(LivingEvent.LivingTickEvent event){
        LivingEntity entity = event.getEntity();

        if (entity == null)
            return;

        if (SoulFireUtils.hasSoulFire(entity) && !entity.isOnFire()){
            SoulFireUtils.clearSoulFire(entity);
        }
    }

    @SubscribeEvent
    public static void onZombieSpawn(MobSpawnEvent.FinalizeSpawn event){
        if (!(event.getEntity() instanceof Zombie zombie) || zombie.getClass() != Zombie.class)
            return;

        if (zombie.getSpawnType() == MobSpawnType.SPAWN_EGG)
            return;

        ServerLevelAccessor level = event.getLevel();
        BlockPos pos = zombie.blockPosition();
        Holder<Biome> biome = level.getBiome(pos);
        RandomSource random = zombie.getRandom();

        if (ECConfig.SPAWN_SCORCHED.get() && biome.is(ECTags.Biomes.CAN_SPAWN_SCORCHED) && random.nextDouble() < ECConfig.SCORCHED_SPAWN_RATE.get()) {
            spawnReplacement(ECEntityTypes.SCORCHED.get(), event, level, pos);
        }

        if (ECConfig.SPAWN_SOUL_SCORCHED.get() && biome.is(ECTags.Biomes.CAN_SPAWN_SOUL_SCORCHED) && random.nextDouble() < ECConfig.SOUL_SCORCHED_SPAWN_RATE.get()) {
            spawnReplacement(ECEntityTypes.SOUL_SCORCHED.get(), event, level, pos);
        }

        if (ECConfig.SPAWN_LOST.get() && biome.is(ECTags.Biomes.CAN_SPAWN_LOST) && random.nextDouble() < ECConfig.LOST_SPAWN_RATE.get()) {
            spawnReplacement(ECEntityTypes.LOST.get(), event, level, pos);
        }

        if (ECConfig.SPAWN_ROTTEN.get() && biome.is(ECTags.Biomes.CAN_SPAWN_ROTTEN) && random.nextDouble() < ECConfig.ROTTEN_SPAWN_RATE.get()) {
            spawnReplacement(ECEntityTypes.ROTTEN.get(), event, level, pos);
        }

        if (ECConfig.SPAWN_ILLAPISTA.get() && biome.is(ECTags.Biomes.CAN_SPAWN_ILLAPISTA) && random.nextDouble() < ECConfig.ILLAPISTA_SPAWN_RATE.get()) {
            spawnReplacement(ECEntityTypes.ILLAPISTA.get(), event, level, pos);
        }
    }

    @SubscribeEvent
    public static void onSkeletonSpawn(MobSpawnEvent.FinalizeSpawn event){
        if (!(event.getEntity() instanceof Skeleton skeleton) || skeleton.getClass() != Skeleton.class)
            return;

        if (skeleton.getSpawnType() == MobSpawnType.SPAWN_EGG)
            return;

        ServerLevelAccessor level = event.getLevel();
        BlockPos pos = skeleton.blockPosition();
        Holder<Biome> biome = level.getBiome(pos);
        RandomSource random = skeleton.getRandom();

        if (ECConfig.SPAWN_SOUL_REAPER.get() && biome.is(ECTags.Biomes.CAN_SPAWN_SOUL_REAPER) && random.nextDouble() < ECConfig.SOUL_REAPER_SPAWN_RATE.get()){
            spawnReplacement(ECEntityTypes.SOUL_REAPER.get(), event, level, pos);
        }

        if (ECConfig.SPAWN_TLALOCQUIAN.get() && biome.is(ECTags.Biomes.CAN_SPAWN_TLALOCQUIAN) && random.nextDouble() < ECConfig.TLALOCQUIAN_SPAWN_RATE.get()){
            spawnReplacement(ECEntityTypes.TLALOCQUIAN.get(), event, level, pos);
        }

        if (ECConfig.SPAWN_SUNKEN.get() && biome.is(ECTags.Biomes.CAN_SPAWN_SUNKEN) && random.nextDouble() < ECConfig.SUNKEN_SPAWN_RATE.get()){
            spawnReplacement(ECEntityTypes.SUNKEN.get(), event, level, pos);
        }

        if (ECConfig.SPAWN_DRIED.get() && biome.is(ECTags.Biomes.CAN_SPAWN_DRIED) && random.nextDouble() < ECConfig.DRIED_SPAWN_RATE.get()){
            spawnReplacement(ECEntityTypes.DRIED.get(), event, level, pos);
        }

        if (ECConfig.SPAWN_PUTRID.get() && biome.is(ECTags.Biomes.CAN_SPAWN_PUTRID) && random.nextDouble() < ECConfig.PUTRID_SPAWN_RATE.get()){
            spawnReplacement(ECEntityTypes.PUTRID.get(), event, level, pos);
        }
    }

    private static <T extends Mob> void spawnReplacement(EntityType<T> pReplacement, MobSpawnEvent.FinalizeSpawn event, ServerLevelAccessor pLevel, BlockPos pPos) {
        T replacement = pReplacement.create(pLevel.getLevel());
        if (replacement == null)
            return;

        Mob original = event.getEntity();
        replacement.moveTo(pPos.getX() + 1f, pPos.getY(), pPos.getZ() + 1f, original.getYRot(), original.getXRot());

        ForgeEventFactory.onFinalizeSpawn(replacement, pLevel, event.getDifficulty(), MobSpawnType.NATURAL, null, null);

        pLevel.addFreshEntityWithPassengers(replacement);

        event.setResult(Event.Result.DENY);
    }
}
