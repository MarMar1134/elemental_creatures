package net.marmar.elemental_creatures.datagen;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.util.damage.ECDamageTypes;
import net.marmar.elemental_creatures.worldgen.ECBiomeModifiers;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ECDataPackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ECBiomeModifiers::bootstrap)
            .add(Registries.DAMAGE_TYPE, ECDamageTypes::boostrap);

    public ECDataPackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ElementalCreatures.MOD_ID));
    }
}
