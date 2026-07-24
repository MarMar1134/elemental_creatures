package net.marmar.elemental_creatures;

import net.minecraftforge.common.ForgeConfigSpec;

public class ECConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    //Zombies
    public static final ForgeConfigSpec.BooleanValue SPAWN_SCORCHED;
    public static final ForgeConfigSpec.DoubleValue SCORCHED_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_SOUL_SCORCHED;
    public static final ForgeConfigSpec.DoubleValue SOUL_SCORCHED_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_LOST;
    public static final ForgeConfigSpec.DoubleValue LOST_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_ROTTEN;
    public static final ForgeConfigSpec.DoubleValue ROTTEN_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_ILLAPISTA;
    public static final ForgeConfigSpec.DoubleValue ILLAPISTA_SPAWN_RATE;

    //Skeletons
    public static final ForgeConfigSpec.BooleanValue SPAWN_SOUL_REAPER;
    public static final ForgeConfigSpec.DoubleValue SOUL_REAPER_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_TLALOCQUIAN;
    public static final ForgeConfigSpec.DoubleValue TLALOCQUIAN_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_SUNKEN;
    public static final ForgeConfigSpec.DoubleValue SUNKEN_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_DRIED;
    public static final ForgeConfigSpec.DoubleValue DRIED_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_PUTRID;
    public static final ForgeConfigSpec.DoubleValue PUTRID_SPAWN_RATE;

    //Slimes
    public static final ForgeConfigSpec.BooleanValue SPAWN_ICE_CUBE;
    public static final ForgeConfigSpec.DoubleValue ICE_CUBE_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_SAND_CUBE;
    public static final ForgeConfigSpec.DoubleValue SAND_CUBE_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_RED_SAND_CUBE;
    public static final ForgeConfigSpec.DoubleValue RED_SAND_CUBE_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_PHRANQUE;
    public static final ForgeConfigSpec.DoubleValue PHRANQUE_SPAWN_RATE;

    //Spiders
    public static final ForgeConfigSpec.BooleanValue SPAWN_DESERT_SPIDER;
    public static final ForgeConfigSpec.DoubleValue DESERT_SPIDER_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_SNOWY_SPIDER;
    public static final ForgeConfigSpec.DoubleValue SNOWY_SPIDER_SPAWN_RATE;

    public static final ForgeConfigSpec.BooleanValue SPAWN_ARACNIAN;
    public static final ForgeConfigSpec.DoubleValue ARACNIAN_SPAWN_RATE;

    static {
        BUILDER.push("Elemental Creatures spawn configuration");

        //Zombies
        SPAWN_SCORCHED = BUILDER.comment("Defines if the Scorched can spawn naturally on the Overworld.")
                .define("spawn_scorched", false);
        SCORCHED_SPAWN_RATE = BUILDER.comment("Determines the probability of a Zombie being replaced by a Scorched.")
                .defineInRange("scorched_spawn_rate", 0.8d, 0.01d, 1d);

        SPAWN_SOUL_SCORCHED = BUILDER.comment("Defines if the Soul Scorched can spawn naturally on the Overworld.")
                .define("spawn_soul_scorched", false);
        SOUL_SCORCHED_SPAWN_RATE = BUILDER.comment("Determines the probability of a Zombie being replaced by a Soul Scorched.")
                .defineInRange("soul_scorched_spawn_rate", 0.8d, 0.01d, 1d);

        SPAWN_LOST = BUILDER.comment("Defines if the Lost can spawn naturally on the Overworld.")
                .define("spawn_lost", true);
        LOST_SPAWN_RATE = BUILDER.comment("Determines the probability of a Zombie being replaced by a Lost.")
                .defineInRange("lost_spawn_rate", 0.8d, 0.01d, 1d);

        SPAWN_ROTTEN = BUILDER.comment("Defines if the Rotten can spawn naturally on the Overworld.")
                .define("spawn_rotten", true);
        ROTTEN_SPAWN_RATE = BUILDER.comment("Determines the probability of a Zombie being replaced by a Rotten.")
                .defineInRange("rotten_spawn_rate", 0.8d, 0.01d, 1d);

        SPAWN_ILLAPISTA = BUILDER.comment("Defines if the Worshipper of Illapa can spawn naturally on the Overworld.")
                .define("spawn_worshipper_of_illapa", false);
        ILLAPISTA_SPAWN_RATE = BUILDER.comment("Determines the probability of a Zombie being replaced by a Worshipper of Illapa.")
                .defineInRange("worshipper_of_illapa_spawn_rate", 0.8d, 0.01d, 1d);

        //Skeletons
        SPAWN_SOUL_REAPER = BUILDER.comment("Defines if the Soul Reaper can spawn naturally on the Nether.")
                .define("spawn_soul_reaper", true);
        SOUL_REAPER_SPAWN_RATE = BUILDER.comment("Determines the probability of a Skeleton being replaced by a Soul Reaper.")
                .defineInRange("soul_reaper_spawn_rate", 0.8d, 0.01d, 1d);

        SPAWN_TLALOCQUIAN = BUILDER.comment("Defines if the Follower of Tláloc can spawn naturally on the Overworld.")
                .define("spawn_follower_of_tlaloc", false);
        TLALOCQUIAN_SPAWN_RATE = BUILDER.comment("Determines the probability of a Skeleton being replaced by a Follower of Tláloc.")
                .defineInRange("follower_of_tlaloc_spawn_rate", 0.8d, 0.01d, 1d);

        SPAWN_SUNKEN = BUILDER.comment("Defines if the Sunken can spawn naturally on the Overworld.")
                .define("spawn_sunken", true);
        SUNKEN_SPAWN_RATE = BUILDER.comment("Determines the probability of a Sunken to be placed.")
                .defineInRange("sunken_spawn_rate", 0.8d, 0.01d, 1d);

        SPAWN_DRIED = BUILDER.comment("Defines if the Dried can spawn naturally on the Overworld.")
                .define("spawn_dried", true);
        DRIED_SPAWN_RATE = BUILDER.comment("Determines the probability of a Dried to be placed.")
                .defineInRange("dried_spawn_rate", 0.8d, 0.01d, 1d);

        SPAWN_PUTRID = BUILDER.comment("Defines if the Putrid can spawn naturally on the Overworld.")
                .define("spawn_putrid", true);
        PUTRID_SPAWN_RATE = BUILDER.comment("Determines the probability of a Putrid to be placed.")
                .defineInRange("putrid_spawn_rate", 0.8d, 0.01d, 1d);

        //Slimes
        SPAWN_ICE_CUBE = BUILDER.comment("defines if the Ice Cubes can spawn on Slime chunks.")
                .define("spawn_ice_cube", true);
        ICE_CUBE_SPAWN_RATE = BUILDER.comment("Determines the probability of a Ice Cube replacing a Slime.")
                .defineInRange("ice_cube_spawn_rate", 1d, 0.01d, 1d);

        SPAWN_SAND_CUBE = BUILDER.comment("defines if the Sand Cubes can spawn on Slime chunks.")
                .define("spawn_sand_cube", true);
        SAND_CUBE_SPAWN_RATE = BUILDER.comment("Determines the probability of a Sand Cube replacing a Slime.")
                .defineInRange("sand_cube_spawn_rate", 1d, 0.01d, 1d);

        SPAWN_RED_SAND_CUBE = BUILDER.comment("defines if the Red Sand Cubes can spawn on Slime chunks.")
                .define("spawn_red_sand_cube", true);
        RED_SAND_CUBE_SPAWN_RATE = BUILDER.comment("Determines the probability of a Red Sand Cube replacing a Slime.")
                .defineInRange("red_sand_cube_spawn_rate", 1d, 0.01d, 1d);

        SPAWN_PHRANQUE = BUILDER.comment("defines if a Phranque can spawn on Slime chunks.")
                .define("spawn_phranque", false);
        PHRANQUE_SPAWN_RATE = BUILDER.comment("Determines the probability of a Phranque replacing a Slime.")
                .defineInRange("phranque_spawn_rate", 0.8d, 0.1d, 1d);

        //Spiders
        SPAWN_DESERT_SPIDER = BUILDER.comment("defines if a Desert Spider can spawn naturally on the Overworld.")
                .define("spawn_desert_spider", true);
        DESERT_SPIDER_SPAWN_RATE = BUILDER.comment("Determines the probability of a Desert Spider replacing a Spider.")
                .defineInRange("desert_spider_spawn_rate", 1d, 0.1d, 1d);

        SPAWN_SNOWY_SPIDER = BUILDER.comment("defines if a Snowy Spider can spawn naturally on the Overworld.")
                .define("spawn_desert_spider", true);
        SNOWY_SPIDER_SPAWN_RATE = BUILDER.comment("Determines the probability of a Snowy Spider replacing a Spider.")
                .defineInRange("desert_spider_spawn_rate", 1d, 0.1d, 1d);

        SPAWN_ARACNIAN = BUILDER.comment("defines if a Child of Aracne can spawn naturally on the Overworld.")
                .define("spawn_child_of_aracne", false);
        ARACNIAN_SPAWN_RATE = BUILDER.comment("Determines the probability of a Child of Aracne replacing a Spider.")
                .defineInRange("child_of_aracne_spawn_rate", 0.8d, 0.1d, 1d);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
