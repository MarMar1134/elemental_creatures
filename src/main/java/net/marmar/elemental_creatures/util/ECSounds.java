package net.marmar.elemental_creatures.util;

import net.marmar.elemental_creatures.ElementalCreatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ECSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, ElementalCreatures.MOD_ID);

    //Scorched
    public static final RegistryObject<SoundEvent> SCORCHED_AMBIENT = registerSoundEvents("scorched_ambient");
    public static final RegistryObject<SoundEvent> SCORCHED_STEP = registerSoundEvents("scorched_step");
    public static final RegistryObject<SoundEvent> SCORCHED_HURT = registerSoundEvents("scorched_hurt");
    public static final RegistryObject<SoundEvent> SCORCHED_DEATH = registerSoundEvents("scorched_death");

    //Lost
    public static final RegistryObject<SoundEvent> LOST_AMBIENT = registerSoundEvents("lost_ambient");
    public static final RegistryObject<SoundEvent> LOST_STEP = registerSoundEvents("lost_step");
    public static final RegistryObject<SoundEvent> LOST_HURT = registerSoundEvents("lost_hurt");
    public static final RegistryObject<SoundEvent> LOST_DEATH = registerSoundEvents("lost_death");

    //Rotten
    public static final RegistryObject<SoundEvent> ROTTEN_AMBIENT = registerSoundEvents("rotten_ambient");
    public static final RegistryObject<SoundEvent> ROTTEN_STEP = registerSoundEvents("rotten_step");
    public static final RegistryObject<SoundEvent> ROTTEN_HURT = registerSoundEvents("rotten_hurt");
    public static final RegistryObject<SoundEvent> ROTTEN_DEATH = registerSoundEvents("rotten_death");

    //Soul Reaper
    public static final RegistryObject<SoundEvent> SOUL_REAPER_AMBIENT = registerSoundEvents("soul_reaper_ambient");
    public static final RegistryObject<SoundEvent> SOUL_REAPER_STEP = registerSoundEvents("soul_reaper_step");
    public static final RegistryObject<SoundEvent> SOUL_REAPER_HURT = registerSoundEvents("soul_reaper_hurt");
    public static final RegistryObject<SoundEvent> SOUL_REAPER_DEATH = registerSoundEvents("soul_reaper_death");

    //Sunken
    public static final RegistryObject<SoundEvent> SUNKEN_AMBIENT = registerSoundEvents("sunken_ambient");
    public static final RegistryObject<SoundEvent> SUNKEN_STEP = registerSoundEvents("sunken_step");
    public static final RegistryObject<SoundEvent> SUNKEN_HURT = registerSoundEvents("sunken_hurt");
    public static final RegistryObject<SoundEvent> SUNKEN_DEATH = registerSoundEvents("sunken_death");

    //Dried
    public static final RegistryObject<SoundEvent> DRIED_AMBIENT = registerSoundEvents("dried_ambient");
    public static final RegistryObject<SoundEvent> DRIED_STEP = registerSoundEvents("dried_step");
    public static final RegistryObject<SoundEvent> DRIED_HURT = registerSoundEvents("dried_hurt");
    public static final RegistryObject<SoundEvent> DRIED_DEATH = registerSoundEvents("dried_death");

    @SuppressWarnings("removal")
    private static RegistryObject<SoundEvent> registerSoundEvents(String sound_name){
        return SOUND_EVENTS.register(sound_name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ElementalCreatures.MOD_ID, sound_name)));
    }

    public static void register(IEventBus eventBus){
        ElementalCreatures.LOGGER.info("Registering Elemental Creatures sounds...");
        SOUND_EVENTS.register(eventBus);
    }
}
