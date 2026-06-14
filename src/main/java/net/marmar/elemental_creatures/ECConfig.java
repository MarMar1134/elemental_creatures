package net.marmar.elemental_creatures;

import net.minecraftforge.common.ForgeConfigSpec;

public class ECConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue SPAWN_LOST;
    public static final ForgeConfigSpec.BooleanValue SPAWN_ROTTEN;

    static {
        BUILDER.push("Elemental Creatures spawn configuration");

        SPAWN_LOST = BUILDER.comment("Defines if the Lost can spawn naturally on the Overworld.")
                .define("spawnLost", true);

        SPAWN_ROTTEN = BUILDER.comment("Defines if the Rotten can spawn naturally on the Overworld.")
                .define("spawnRotten", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
