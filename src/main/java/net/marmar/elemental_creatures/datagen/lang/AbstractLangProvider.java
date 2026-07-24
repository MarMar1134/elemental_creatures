package net.marmar.elemental_creatures.datagen.lang;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.marmar.elemental_creatures.entity.slime.AbstractSlime;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Spider;
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

    protected void addMobSubtitles(String pMobId, String pIdle, String pStep, String pHurt, String pDeath){
        this.add("sound." + ElementalCreatures.MOD_ID + "." + pMobId + "_ambient", pIdle);
        this.add("sound." + ElementalCreatures.MOD_ID + "." + pMobId + "_step", pStep);
        this.add("sound." + ElementalCreatures.MOD_ID + "." + pMobId + "_hurt", pHurt);
        this.add("sound." + ElementalCreatures.MOD_ID + "." + pMobId + "_death", pDeath);
    }

    protected void addItemDesc(String pItem, String pDesc){
        this.add("item." + ElementalCreatures.MOD_ID + "." + pItem + ".desc", pDesc);
    }

    protected void addMobDesc(String pMobId, String pDesc){
        this.add("entity." + ElementalCreatures.MOD_ID + "." + pMobId + ".description", pDesc);
    }

    protected void addEnchantmentDesc(String enchantmentName, String description){
        this.add("enchantment." + ElementalCreatures.MOD_ID + "." + enchantmentName + ".desc", description);
    }

    protected void addZombieType(EntityType<? extends Zombie> pZombie, String pName, RegistryObject<Item> pEgg, String pEggName){
        this.add(pZombie, pName);
        this.addItem(pEgg, pEggName);
    }

    protected void addSkeletonType(EntityType<? extends AbstractSkeleton> pSkeleton, String pName, RegistryObject<Item> pEgg, String pEggName){
        this.add(pSkeleton, pName);
        this.addItem(pEgg, pEggName);
    }

    protected void addSlimeType(EntityType<? extends AbstractSlime> pSlime, String pName, RegistryObject<Item> pEgg, String pEggName){
        this.add(pSlime, pName);
        this.addItem(pEgg, pEggName);
    }

    protected void addSpiderType(EntityType<? extends Spider> pSpider, String pName, RegistryObject<Item> pEgg, String pEggName){
        this.add(pSpider, pName);
        this.addItem(pEgg, pEggName);
    }

    protected void addLightingDamage(String message, String killByPlayer){
        this.add("death.attack.lightning_damage", "%1$s " + message);
        this.add("death.attack.lightning_damage.player", "%1$s " + killByPlayer + " %2$s");
    }
}
