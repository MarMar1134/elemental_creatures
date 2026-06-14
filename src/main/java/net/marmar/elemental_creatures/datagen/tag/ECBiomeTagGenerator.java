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
    }
}
