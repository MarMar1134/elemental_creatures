package net.marmar.elemental_creatures.item.arrow;

import net.marmar.elemental_creatures.entity.projectile.LightningArrowEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LightningArrowItem extends ArrowItem {
    public LightningArrowItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new LightningArrowEntity(pLevel, pShooter);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("item.elemental_creatures.lightning_arrow.desc")
                .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
