package net.marmar.elemental_creatures;

import com.mojang.logging.LogUtils;
import net.marmar.elemental_creatures.entity.ECEntityTypes;
import net.marmar.elemental_creatures.item.ECItems;
import net.marmar.elemental_creatures.util.ECSounds;
import net.marmar.elemental_creatures.util.ECTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ElementalCreatures.MOD_ID)
public class ElementalCreatures {
    public static final String MOD_ID = "elemental_creatures";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ElementalCreatures(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ECItems.register(modEventBus);
        ECSounds.register(modEventBus);
        ECEntityTypes.register(modEventBus);
        ECTabs.register(modEventBus);

        context.registerConfig(ModConfig.Type.COMMON, ECConfig.SPEC, "elemental_creatures-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }
}
