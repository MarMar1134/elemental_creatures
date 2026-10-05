package net.marmar.elemental_creatures.item.custom.food;

import net.marmar.elemental_creatures.util.SoulFireUtils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class BurningFleshItem extends Item {
    private final boolean isSoulFire;

    public BurningFleshItem(Properties pProperties, boolean isSoulFire) {
        super(pProperties);
        this.isSoulFire = isSoulFire;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity entity) {
        Player player = entity instanceof Player ? (Player) entity : null;

        if (player instanceof ServerPlayer){
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, pStack);
        }

        if (player != null){
            player.awardStat(Stats.ITEM_USED.get(this));

            if (!player.getAbilities().instabuild){
                pStack.hurtAndBreak(1, player, (entity1 -> entity1.broadcastBreakEvent(entity1.getUsedItemHand())));

                if (this.isSoulFire){
                    SoulFireUtils.applySoulFire(player, 5);
                } else {
                    player.setSecondsOnFire(5);
                }
            }
        }

        if (pStack.getDamageValue() == 0){
            pStack.shrink(1);
        }

        entity.gameEvent(GameEvent.EAT);

        return pStack;
    }
}
