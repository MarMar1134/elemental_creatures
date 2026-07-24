package net.marmar.elemental_creatures.entity.spider;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

/**
 * The main purpose of this class is to serve as an interface to control lightning bolt conversions via mixin
 */
public abstract class AbstractSpider extends Spider {
    public AbstractSpider(EntityType<? extends Spider> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
}
