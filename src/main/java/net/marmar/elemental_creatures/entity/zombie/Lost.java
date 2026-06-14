package net.marmar.elemental_creatures.entity.zombie;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class Lost extends Zombie {
    public Lost(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static boolean checkLostSpawnRules(EntityType<Lost> pLost, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom){
        BlockPos blockpos = pPos;

        do {
            blockpos = blockpos.above();
        } while(pLevel.getBlockState(blockpos).is(Blocks.POWDER_SNOW));

        return checkMonsterSpawnRules(pLost, pLevel, pSpawnType, pPos, pRandom) && (pSpawnType == MobSpawnType.SPAWNER || pLevel.canSeeSky(blockpos.below()));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.17f)
                .add(Attributes.ATTACK_DAMAGE, 3.0d)
                .add(Attributes.MAX_HEALTH, 24f)
                .add(Attributes.ARMOR, 4.0d)
                .add(Attributes.ARMOR_TOUGHNESS, 1.0d)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean hurt = super.doHurtTarget(pEntity);

        if (hurt) {
            pEntity.setTicksFrozen(300);
        }

        return hurt;
    }

    @Override
    protected boolean convertsInWater() {
        return false;
    }

    @Override
    public boolean canFreeze() {
        return false;
    }
}
