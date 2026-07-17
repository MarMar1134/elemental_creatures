package net.marmar.elemental_creatures.datagen.tag;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ECBiomeTagGenerator extends BiomeTagsProvider {
    public ECBiomeTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, ElementalCreatures.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ECTags.Biomes.CAN_SPAWN_LOST).add(
                Biomes.ICE_SPIKES,
                Biomes.SNOWY_PLAINS,
                Biomes.JAGGED_PEAKS,
                Biomes.DEEP_FROZEN_OCEAN,
                Biomes.FROZEN_PEAKS,
                Biomes.FROZEN_OCEAN,
                Biomes.FROZEN_RIVER,
                Biomes.SNOWY_SLOPES
        );

        this.tag(ECTags.Biomes.CAN_SPAWN_ROTTEN).add(
                Biomes.SWAMP,
                Biomes.MANGROVE_SWAMP,
                Biomes.LUSH_CAVES
        );

        this.tag(ECTags.Biomes.CAN_SPAWN_SOUL_REAPER).add(
                Biomes.SOUL_SAND_VALLEY
        );

        this.tag(ECTags.Biomes.CAN_SPAWN_SUNKEN).add(
                Biomes.RIVER,
                Biomes.OCEAN,
                Biomes.DEEP_OCEAN,
                Biomes.COLD_OCEAN,
                Biomes.DEEP_COLD_OCEAN,
                Biomes.FROZEN_OCEAN,
                Biomes.DEEP_FROZEN_OCEAN,
                Biomes.LUKEWARM_OCEAN,
                Biomes.DEEP_LUKEWARM_OCEAN,
                Biomes.WARM_OCEAN,
                Biomes.FROZEN_RIVER
        );

        this.tag(ECTags.Biomes.CAN_SPAWN_DRIED).add(
                Biomes.DESERT
        );

        this.tag(ECTags.Biomes.CAN_SPAWN_PUTRID).add(
                Biomes.SWAMP,
                Biomes.MANGROVE_SWAMP,
                Biomes.LUSH_CAVES
        );
    }
}
