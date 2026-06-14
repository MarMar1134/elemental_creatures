package net.marmar.elemental_creatures.datagen.tag;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.util.damage.ECDamageTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ECDamageTypeTagGenerator extends DamageTypeTagsProvider {
    public ECDamageTypeTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, ElementalCreatures.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(DamageTypeTags.BYPASSES_ARMOR).add(
                ECDamageTypes.LIGHTNING_DAMAGE
        );
    }
}
