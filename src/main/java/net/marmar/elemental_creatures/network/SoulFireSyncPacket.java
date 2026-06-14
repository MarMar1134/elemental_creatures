package net.marmar.elemental_creatures.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SoulFireSyncPacket {
    private final int entityId;
    private final boolean onFire;

    public SoulFireSyncPacket(int pEntityId, boolean pOnFire) {
        this.entityId = pEntityId;
        this.onFire = pOnFire;
    }

    public static void encode(SoulFireSyncPacket pPacket, FriendlyByteBuf pBuffer) {
        pBuffer.writeInt(pPacket.entityId);
        pBuffer.writeBoolean(pPacket.onFire);
    }

    public static SoulFireSyncPacket decode(FriendlyByteBuf pBuffer) {
        return new SoulFireSyncPacket(pBuffer.readInt(), pBuffer.readBoolean());
    }

    public static void handle(SoulFireSyncPacket pPacket, Supplier<NetworkEvent.Context> pContext) {
        pContext.get().enqueueWork(() -> {
            var level = Minecraft.getInstance().level;
            if (level == null) return;

            var entity = level.getEntity(pPacket.entityId);
            if (!(entity instanceof LivingEntity livingEntity)) return;

            if (pPacket.onFire) {
                livingEntity.getPersistentData().putBoolean("elemental_creatures.soul_fire", true);
            } else {
                livingEntity.getPersistentData().remove("elemental_creatures.soul_fire");
            }
        });

        pContext.get().setPacketHandled(true);
    }
}
