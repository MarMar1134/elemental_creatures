package net.marmar.elemental_creatures.datagen.loot;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.item.ECItems;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ECEntityLootTables implements LootTableSubProvider {
    public static final ResourceLocation SCORCHED = register("scorched");
    public static final ResourceLocation LOST = register("lost");
    public static final ResourceLocation ROTTEN = register("rotten");
    public static final ResourceLocation ILLAPISTA = register("illapista");

    public static final ResourceLocation SOUL_REAPER = register("soul_reaper");

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pOutput) {
        pOutput.accept(SCORCHED, generateScorchedLootTable());
        pOutput.accept(LOST, generateLostLootTable());
        pOutput.accept(ROTTEN, generateRottenLootTable());

        pOutput.accept(SOUL_REAPER, generateSoulReaperLootTable());
    }

    private LootTable.Builder generateScorchedLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                                .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(1))))
                )
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.BAKED_POTATO)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.083f, 0.1f))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.083f, 0.1f))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                )
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.SPLASH_POTION)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.064f, 0.1f))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                                .apply(SetPotionFunction.setPotion(Potions.FIRE_RESISTANCE)))
                );
    }

    private LootTable.Builder generateLostLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))
                )
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.PUMPKIN)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.083f, 0.1f))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.CARROT)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.083f, 0.1f))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.TORCH)
                                .when(LootItemRandomChanceCondition.randomChance(0.083f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3))))
                );
    }

    private LootTable.Builder generateRottenLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))
                                .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(1))))
                )
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.LILY_PAD)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.083f, 0.1f))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.STICK)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.115f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0,2))))
                );
    }

    private LootTable.Builder generateSoulReaperLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ECItems.SOUL_ARROW.get())
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2))))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0,2))))
                )
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.SOUL_TORCH)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.083f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3))))
                        .add(LootItem.lootTableItem(Items.BOW)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.085f, 0.1f))
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(50, 340))))
                );
    }

    private static ResourceLocation register(String pName){
        return ResourceLocation.fromNamespaceAndPath(ElementalCreatures.MOD_ID, "entities/" + pName);
    }
}
