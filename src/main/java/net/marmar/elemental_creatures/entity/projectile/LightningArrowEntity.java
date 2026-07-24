package net.marmar.elemental_creatures.entity.projectile;

import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.util.damage.ECDamageSources;
import net.marmar.elemental_creatures.util.enchantment.ECEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class LightningArrowEntity extends AbstractArrow {
    public LightningArrowEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public LightningArrowEntity(Level pLevel, double pX, double pY, double pZ) {
        this(ECEntityTypes.LIGHTNING_ARROW.get(), pLevel);
        this.setPos(pX, pY, pZ);
    }

    public LightningArrowEntity(Level pLevel, LivingEntity pShooter){
        super(ECEntityTypes.LIGHTNING_ARROW.get(), pShooter, pLevel);
        this.setBaseDamage(3d);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        Entity target = pResult.getEntity();
        Entity shooter = this.getOwner();

        if (shooter instanceof LivingEntity livingEntity && EnchantmentHelper.getEnchantmentLevel(ECEnchantments.ZEUS_BLESSING.get(), livingEntity) > 0){
            BlockPos targetPos = target.blockPosition();
            if (this.level().canSeeSky(targetPos)) {
                LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(this.level());
                if (lightningBolt != null) {
                    lightningBolt.moveTo(Vec3.atBottomCenterOf(targetPos));
                    lightningBolt.setCause(shooter instanceof ServerPlayer serverPlayer ? serverPlayer : null);
                    this.level().addFreshEntity(lightningBolt);
                }
            }
        }
    }

    @Override
    protected void doPostHurtEffects(LivingEntity pTarget) {
        super.doPostHurtEffects(pTarget);
        pTarget.hurt(new ECDamageSources(pTarget.level().registryAccess()).lightningDamage(), 3f);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ECItems.LIGHTNING_ARROW.get());
    }
}
