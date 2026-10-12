package net.marmar.elemental_creatures.entity.zombie.fungus;

import net.marmar.elemental_creatures.datagen.loot.ECEntityLootTables;
import net.marmar.elemental_creatures.datagen.tag.ECTags;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.Nullable;

public class Fungus extends Zombie implements VariantHolder<FungusVariant> {
    private static final EntityDataAccessor<Integer> FUNGUS_VARIANT = SynchedEntityData.defineId(Fungus.class, EntityDataSerializers.INT);

    public Fungus(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createFungusAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 24d)
                .add(Attributes.ARMOR, 4d)
                .add(Attributes.ATTACK_DAMAGE, 4d)
                .add(Attributes.MOVEMENT_SPEED, 0.2d)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(FUNGUS_VARIANT, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("elemental_creatures.fungus.variant", this.getVariant().getId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setVariant(FungusVariant.byId(pCompound.getInt("elemental_creatures.fungus.variant")));
    }

    public ResourceLocation getTextureLocation(){
        return this.getVariant().getTextureLocation();
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return switch (this.getVariant()){
            case RED -> ECEntityLootTables.RED_FUNGUS;
            case BROWN -> ECEntityLootTables.BROWN_FUNGUS;
            case CRIMSON -> ECEntityLootTables.CRIMSON_FUNGUS;
            case WARPED -> ECEntityLootTables.WARPED_FUNGUS;
        };
    }

    @Override
    public void setVariant(FungusVariant pVariant) {
        this.getEntityData().set(FUNGUS_VARIANT, pVariant.getId());
    }

    @Override
    public FungusVariant getVariant() {
        return FungusVariant.byId(this.getEntityData().get(FUNGUS_VARIANT));
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean hurt = super.doHurtTarget(pEntity);

        if (this.level().isClientSide)
            return hurt;

        if (hurt && pEntity instanceof LivingEntity mob) {
            mob.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0), this);
        }

        return hurt;
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        Holder<Biome> biome = pLevel.getBiome(this.blockPosition());
        RandomSource randomSource = pLevel.getRandom();

        //Tries to spawn a red or brown fungus
        if (biome.is(ECTags.Biomes.CAN_SPAWN_RED_FUNGUS)){
            if (biome.is(ECTags.Biomes.CAN_SPAWN_BROWN_FUNGUS)){
                if (randomSource.nextDouble() <= 0.5d){
                    this.setVariant(FungusVariant.BROWN);
                } else {
                    this.setVariant(FungusVariant.RED);
                }
            } else {
                this.setVariant(FungusVariant.RED);
            }

        //Tries to spawn a brown or red fungus
        } else if (biome.is(ECTags.Biomes.CAN_SPAWN_BROWN_FUNGUS)) {
            if (biome.is(ECTags.Biomes.CAN_SPAWN_RED_FUNGUS)) {
                if (randomSource.nextDouble() <= 0.5d) {
                    this.setVariant(FungusVariant.RED);
                } else {
                    this.setVariant(FungusVariant.BROWN);
                }
            } else {
                this.setVariant(FungusVariant.BROWN);
            }

        //Tries to spawn crimson fungus
        } else if (biome.is(ECTags.Biomes.CAN_SPAWN_CRIMSON_FUNGUS)){
            this.setVariant(FungusVariant.CRIMSON);

        //Tries to spawn warped fungus
        } else if (biome.is(ECTags.Biomes.CAN_SPAWN_WARPED_FUNGUS)){
            this.setVariant(FungusVariant.WARPED);
        }

        //Fallback to red fungus
        else {
            this.setVariant(FungusVariant.RED);
        }

        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }
}
