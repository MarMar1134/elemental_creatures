package net.marmar.elemental_creatures.datagen.lang;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public abstract class AbstractLangProvider extends LanguageProvider {
    public AbstractLangProvider(PackOutput output, String locale) {
        super(output, ElementalCreatures.MOD_ID, locale);
    }

    protected void addCreativeModeTab(String pTab, String pName){
        this.add("tab." + ElementalCreatures.MOD_ID + "." + pTab, pName);
    }

    protected void addMobSubtitles(String pMob, String pIdle, String pStep, String pHurt, String pDeath){
        this.add("sound." + ElementalCreatures.MOD_ID + "." + pMob + "_ambient", pIdle);
        this.add("sound." + ElementalCreatures.MOD_ID + "." + pMob + "_step", pStep);
        this.add("sound." + ElementalCreatures.MOD_ID + "." + pMob + "_hurt", pHurt);
        this.add("sound." + ElementalCreatures.MOD_ID + "." + pMob + "_death", pDeath);
    }

    protected void addZombieType(EntityType<? extends Zombie> pZombie, String pName, RegistryObject<Item> pEgg, String pEggName){
        this.add(pZombie, pName);
        this.addItem(pEgg, pEggName);
    }

    protected void addSkeletonType(EntityType<? extends AbstractSkeleton> pSkeleton, String pName, RegistryObject<Item> pEgg, String pEggName){
        this.add(pSkeleton, pName);
        this.addItem(pEgg, pEggName);
    }

    protected void addLightingDamage(String message, String killByPlayer){
        this.add("death.attack.lightning_damage", "%1$s " + message);
        this.add("death.attack.lightning_damage.player", "%1$s " + killByPlayer + " %2$s");
    }
}
