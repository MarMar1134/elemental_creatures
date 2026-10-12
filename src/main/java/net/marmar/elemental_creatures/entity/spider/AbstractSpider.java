package net.marmar.elemental_creatures.entity.spider;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public abstract class AbstractSpider extends Spider {
    public AbstractSpider(EntityType<? extends Spider> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
}
