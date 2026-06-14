package net.marmar.elemental_creatures.network;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

@SuppressWarnings("removal")
public class ECNetwork {
    private static final String PROTOCOL = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(ElementalCreatures.MOD_ID, "main"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals
    );

    public static void register() {
        CHANNEL.registerMessage(
                0,
                SoulFireSyncPacket.class,
                SoulFireSyncPacket::encode,
                SoulFireSyncPacket::decode,
                SoulFireSyncPacket::handle,
                java.util.Optional.of(NetworkDirection.PLAY_TO_CLIENT)
        );
    }
}
