package net.marmar.elemental_creatures.datagen.recipe;

import net.marmar.elemental_creatures.item.ECItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ECRecipeProvider extends RecipeProvider {
    public ECRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ECItems.LIGHTNING_ESSENCE.get(), 8)
                .pattern("AAA")
                .pattern("ALA")
                .pattern("AAA")
                .define('L', ECItems.LIGHTNING_ESSENCE.get())
                .define('A', Items.ARROW)
                .unlockedBy(getHasName(ECItems.LIGHTNING_ESSENCE.get()), has(ECItems.LIGHTNING_ESSENCE.get()))
                .unlockedBy(getHasName(ECItems.LIGHTNING_ARROW.get()), has(ECItems.LIGHTNING_ARROW.get()))
                .save(pWriter);
    }
}
