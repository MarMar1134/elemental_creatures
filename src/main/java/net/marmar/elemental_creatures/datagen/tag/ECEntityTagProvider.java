package net.marmar.elemental_creatures.datagen.tag;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ECEntityTagProvider extends EntityTypeTagsProvider {
    public ECEntityTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, ElementalCreatures.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ECTags.Entities.ZOMBIE).add(
                EntityType.ZOMBIE
        );
    }
}
