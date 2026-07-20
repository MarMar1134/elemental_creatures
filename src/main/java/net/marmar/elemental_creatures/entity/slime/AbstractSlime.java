package net.marmar.elemental_creatures.entity.slime;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.WorldgenRandom;

public abstract class AbstractSlime extends Slime {
    public AbstractSlime(EntityType<? extends Slime> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static boolean checkSlimeLikeSpawnRules(EntityType<? extends AbstractSlime> pSlimeLike, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.getDifficulty() != Difficulty.PEACEFUL) {
            if (pLevel.getBiome(pPos).is(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS) && pPos.getY() > 50 && pPos.getY() < 70 && pRandom.nextFloat() < 0.5F && pRandom.nextFloat() < pLevel.getMoonBrightness() && pLevel.getMaxLocalRawBrightness(pPos) <= pRandom.nextInt(8)) {
                return checkMobSpawnRules(pSlimeLike, pLevel, pSpawnType, pPos, pRandom);
            }

            if (!(pLevel instanceof WorldGenLevel)) {
                return false;
            }

            ChunkPos chunkpos = new ChunkPos(pPos);
            boolean flag = WorldgenRandom.seedSlimeChunk(chunkpos.x, chunkpos.z, ((WorldGenLevel)pLevel).getSeed(), 987234911L).nextInt(10) == 0;
            if (pRandom.nextInt(10) == 0 && flag && pPos.getY() < 40) {
                return checkMobSpawnRules(pSlimeLike, pLevel, pSpawnType, pPos, pRandom);
            }
        }

        return false;
    }
}
