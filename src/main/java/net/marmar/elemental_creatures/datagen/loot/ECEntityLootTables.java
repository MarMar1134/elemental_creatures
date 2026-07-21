package net.marmar.elemental_creatures.datagen.loot;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.item.ECItems;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.SlimePredicate;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ECEntityLootTables implements LootTableSubProvider {
    //Zombies
    public static final ResourceLocation SCORCHED = register("scorched");
    public static final ResourceLocation SOUL_SCORCHED = register("soul_scorched");
    public static final ResourceLocation LOST = register("lost");
    public static final ResourceLocation ROTTEN = register("rotten");
    public static final ResourceLocation ILLAPISTA = register("illapista");

    //Skeletons
    public static final ResourceLocation SOUL_REAPER = register("soul_reaper");
    public static final ResourceLocation SUNKEN = register("sunken");
    public static final ResourceLocation DRIED = register("dried");
    public static final ResourceLocation PUTRID = register("putrid");
    public static final ResourceLocation TLALOQUIAN = register("tlalocquian");

    //Slimes
    public static final ResourceLocation ICE_CUBE = register("ice_cube");
    public static final ResourceLocation SAND_CUBE = register("sand_cube");
    public static final ResourceLocation RED_SAND_CUBE = register("red_sand_cube");
    public static final ResourceLocation PHRANQUE = register("phranque");

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pOutput) {
        //Zombies
        pOutput.accept(SCORCHED, generateScorchedLootTable());
        pOutput.accept(SOUL_SCORCHED, generateScorchedLootTable());
        pOutput.accept(LOST, generateLostLootTable());
        pOutput.accept(ROTTEN, generateRottenLootTable());
        pOutput.accept(ILLAPISTA, generateIllapistaLootTable());

        //Skeletons
        pOutput.accept(SOUL_REAPER, generateSoulReaperLootTable());
        pOutput.accept(SUNKEN, generateSunkenLootTable());
        pOutput.accept(DRIED, generateDriedLootTable());
        pOutput.accept(PUTRID, generatePutridLootTable());
        pOutput.accept(TLALOQUIAN, generateTlaloquianLootTable());

        //Slimes
        pOutput.accept(ICE_CUBE, generateSlimeLootTable(Items.SNOWBALL));
        pOutput.accept(SAND_CUBE, generateSlimeLootTable(Items.SAND));
        pOutput.accept(RED_SAND_CUBE, generateSlimeLootTable(Items.RED_SAND));
        pOutput.accept(PHRANQUE, generateSlimeLootTable(ECItems.LIGHTNING_ESSENCE.get()));
    }

    //Zombies
    private LootTable.Builder generateScorchedLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                                .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.CHARCOAL)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.5f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
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

    private LootTable.Builder generateIllapistaLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))
                                .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(1))))
                )
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ECItems.LIGHTNING_ESSENCE.get())
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.083f, 0.1f))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                );
    }

    //Skeletons
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
//                        .add(LootItem.lootTableItem(Items.BOW)
//                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.085f, 0.1f))
//                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(50, 340))))
                );
    }

    private LootTable.Builder generateSunkenLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ECItems.PRISMARINE_ARROW.get())
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2))))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0,2))))
                )
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(Items.PRISMARINE_SHARD)
                                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.083f, 0.1f))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.SEAGRASS)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2))))
                );
    }

    private LootTable.Builder generateDriedLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .apply(SetPotionFunction.setPotion(Potions.WEAKNESS)))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0,2))))
                )
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.STRING)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.083f, 0.1f))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.SAND)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2))))
                );
    }

    private LootTable.Builder generatePutridLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .apply(SetPotionFunction.setPotion(Potions.POISON)))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0,2))))
                )
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.LILY_PAD)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.083f, 0.1f))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.STICK)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2))))
                );
    }

    private LootTable.Builder generateTlaloquianLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ECItems.LIGHTNING_ARROW.get())
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2))))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0,2))))
                )
                .withPool(LootPool.lootPool().setBonusRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ECItems.LIGHTNING_ESSENCE.get())
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.66f, 0.1f))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2))))
                );
    }

    //Slimes
    private LootTable.Builder generateSlimeLootTable(ItemLike pAdditionalDrop){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.SLIME_BALL)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))
                        .add(LootItem.lootTableItem(pAdditionalDrop)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))
                        .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.entity().subPredicate(SlimePredicate.sized(MinMaxBounds.Ints.exactly(1)))))
                );
    }

    private static ResourceLocation register(String pName){
        return ResourceLocation.fromNamespaceAndPath(ElementalCreatures.MOD_ID, "entities/" + pName);
    }
}
