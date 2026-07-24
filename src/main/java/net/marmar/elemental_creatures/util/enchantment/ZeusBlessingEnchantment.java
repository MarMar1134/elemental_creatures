package net.marmar.elemental_creatures.util.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class ZeusBlessingEnchantment extends Enchantment {
    public ZeusBlessingEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, EnchantmentCategory.BOW, pApplicableSlots);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ProjectileWeaponItem;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return super.checkCompatibility(pOther) && pOther != Enchantments.FLAMING_ARROWS;
    }
}
