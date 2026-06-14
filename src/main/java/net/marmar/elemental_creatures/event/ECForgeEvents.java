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
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElementalCreatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ECForgeEvents {
    @SubscribeEvent
    public static void onLivingEntityTick(LivingEvent event){
        LivingEntity entity = event.getEntity();

        if (entity == null) return;

        if (SoulFireUtils.hasSoulFire(entity) && !entity.isOnFire()){
            SoulFireUtils.clearSoulFire(entity);
        }
    }

    @SubscribeEvent
    public static void onZombieSpawn(MobSpawnEvent.FinalizeSpawn event){
        if (!(event.getEntity() instanceof Zombie zombie) || zombie.getClass() != Zombie.class)
            return;

        if (zombie.getSpawnType() != MobSpawnType.NATURAL)
            return;


        ServerLevelAccessor level = event.getLevel();
        BlockPos pos = zombie.blockPosition();
        Holder<Biome> biome = level.getBiome(pos);
        RandomSource random = zombie.getRandom();

        if (biome.is(ECTags.Biomes.CAN_SPAWN_LOST) && random.nextFloat() < 0.8F && ECConfig.SPAWN_LOST.get()) {
            spawnReplacement(ECEntityTypes.LOST.get(), event, level, pos);
        }

        if (biome.is(Tags.Biomes.IS_SWAMP) && random.nextFloat() < 0.8F && ECConfig.SPAWN_ROTTEN.get()) {
            spawnReplacement(ECEntityTypes.ROTTEN.get(), event, level, pos);
        }
    }

    private static <T extends Mob> void spawnReplacement(EntityType<T> pReplacement, MobSpawnEvent.FinalizeSpawn event, ServerLevelAccessor pLevel, BlockPos pPos) {
        T replacement = pReplacement.create(pLevel.getLevel());
        if (replacement == null)
            return;

        Mob original = event.getEntity();
        replacement.moveTo(pPos.getX() + 0.5, pPos.getY(), pPos.getZ() + 0.5,
                original.getYRot(), original.getXRot());

        ForgeEventFactory.onFinalizeSpawn(replacement, pLevel, event.getDifficulty(), MobSpawnType.NATURAL, null, null);

        pLevel.addFreshEntityWithPassengers(replacement);
        event.setResult(Event.Result.DENY);
    }
}
