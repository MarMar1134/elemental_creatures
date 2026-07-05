package net.marmar.elemental_creatures.util;

import net.marmar.elemental_creatures.network.ECNetwork;
import net.marmar.elemental_creatures.network.SoulFireSyncPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.PacketDistributor;

public class SoulFireUtils {
    private static boolean applyingSoulFire = false;

    public static void applySoulFire(LivingEntity target){
        if (target.level().isClientSide())
            return;

        target.getPersistentData().putBoolean("elemental_creatures.soul_fire", true);
        SyncFireStateToNetwork(target, true);
    }

    public static void applySoulFire(LivingEntity target, int seconds) {
        if (target.level().isClientSide())
            return;

        applyingSoulFire = true;
        try {
            if (seconds > 0) target.setSecondsOnFire(seconds);
        } finally {
            applyingSoulFire = false;
        }

        target.getPersistentData().putBoolean("elemental_creatures.soul_fire", true);
        SyncFireStateToNetwork(target, true);
    }

    public static void clearSoulFire(LivingEntity target) {
        if (target.level().isClientSide())
            return;

        target.getPersistentData().remove("elemental_creatures.soul_fire");
        SyncFireStateToNetwork(target, false);
    }

    public static boolean hasSoulFire(LivingEntity target) {
        return target.getPersistentData().getBoolean("elemental_creatures.soul_fire");
    }

    public static boolean isApplyingSoulFire() {
        return applyingSoulFire;
    }

    private static void SyncFireStateToNetwork(LivingEntity target, boolean onFire) {
        var packet = new SoulFireSyncPacket(target.getId(), onFire);

        if (target instanceof ServerPlayer player) {
            ECNetwork.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), packet);
        }

        ECNetwork.CHANNEL.send(PacketDistributor.TRACKING_ENTITY.with(() -> target), packet);
    }
}
