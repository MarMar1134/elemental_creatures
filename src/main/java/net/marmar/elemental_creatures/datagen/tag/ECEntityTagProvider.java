package net.marmar.elemental_creatures.datagen.tag;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
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

        this.tag(EntityTypeTags.ARROWS).add(
                ECEntityTypes.SOUL_ARROW.get(),
                ECEntityTypes.LIGHTNING_ARROW.get(),
                ECEntityTypes.PRISMARINE_ARROW.get()
        );

        this.tag(EntityTypeTags.SKELETONS).add(
                ECEntityTypes.SOUL_REAPER.get(),
                ECEntityTypes.TLALOCQUIAN.get(),
                ECEntityTypes.SUNKEN.get(),
                ECEntityTypes.DRIED.get(),
                ECEntityTypes.PUTRID.get(),
                ECEntityTypes.ASHEN.get(),
                ECEntityTypes.BLIGHT.get()
        );
    }
}
