package net.marmar.elemental_creatures.item.custom.food;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IdunnAppleItem extends Item {
    public IdunnAppleItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pTarget, InteractionHand pUsedHand) {
        if (!(pTarget instanceof Player)){
            if (!pPlayer.level().isClientSide() && pTarget.isAlive() && pTarget instanceof Mob mob){
                CompoundTag mobTag = mob.getPersistentData();

                if (!mobTag.contains("elemental_creatures.changeImmune")){
                    mobTag.putBoolean("elemental_creatures.changeImmune", true);

                    mob.addAdditionalSaveData(mobTag);

                    mob.setPersistenceRequired();

                    pStack.shrink(1);
                }

                return InteractionResult.sidedSuccess(pPlayer.level().isClientSide());
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("item." + ElementalCreatures.MOD_ID + ".idunn_apple.desc")
                .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
