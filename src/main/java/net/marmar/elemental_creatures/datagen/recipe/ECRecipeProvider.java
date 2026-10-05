package net.marmar.elemental_creatures.datagen.recipe;

import net.marmar.elemental_creatures.item.ECItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class ECRecipeProvider extends RecipeProvider {
    public ECRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        //Arrows
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ECItems.LIGHTNING_ARROW.get(), 8)
                .pattern("AAA")
                .pattern("ALA")
                .pattern("AAA")
                .define('L', ECItems.LIGHTNING_ESSENCE.get())
                .define('A', Items.ARROW)
                .unlockedBy(getHasName(ECItems.LIGHTNING_ESSENCE.get()), has(ECItems.LIGHTNING_ESSENCE.get()))
                .unlockedBy(getHasName(ECItems.LIGHTNING_ARROW.get()), has(ECItems.LIGHTNING_ARROW.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ECItems.SOUL_ARROW.get(), 8)
                .pattern("AAA")
                .pattern("ALA")
                .pattern("AAA")
                .define('L', ECItems.SOUL_FRAGMENT.get())
                .define('A', Items.ARROW)
                .unlockedBy(getHasName(ECItems.SOUL_FRAGMENT.get()), has(ECItems.SOUL_FRAGMENT.get()))
                .unlockedBy(getHasName(ECItems.LIGHTNING_ARROW.get()), has(ECItems.LIGHTNING_ARROW.get()))
                .save(pWriter);

        //Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.SOUL_SAND, 4)
                .pattern("SF")
                .pattern("FS")
                .define('S', Tags.Items.SAND)
                .define('F', ECItems.SOUL_FRAGMENT.get())
                .unlockedBy(getHasName(ECItems.SOUL_FRAGMENT.get()), has(ECItems.SOUL_FRAGMENT.get()))
                .unlockedBy(getHasName(Blocks.SOUL_SAND), has(Blocks.SOUL_SAND))
                .group("soul_sand")
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.SOUL_SOIL, 4)
                .pattern("DF")
                .pattern("FD")
                .define('D', Items.DIRT)
                .define('F', ECItems.SOUL_FRAGMENT.get())
                .unlockedBy(getHasName(ECItems.SOUL_FRAGMENT.get()), has(ECItems.SOUL_FRAGMENT.get()))
                .unlockedBy(getHasName(Blocks.SOUL_SOIL), has(Blocks.SOUL_SOIL))
                .group("soul_soil")
                .save(pWriter);
    }
}
