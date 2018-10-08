package main.java.com.rowdowser.vampirecreepers;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.material.MapColor;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;


public class VampireCreeperRegister {
	
	private static final String VAMPIRE_CREEPER = "vampire_creeper";
    public static final ImmutableSet<EntityEntry> CUSTOM_ENTITIES = ImmutableSet.of(
            EntityEntryBuilder.create()
            .entity(VampireCreeper.class)
            .id(new ResourceLocation(VampireCreepersMain.MODID, VAMPIRE_CREEPER), 0)
            .name(VAMPIRE_CREEPER)
            .tracker(80, 3, false)
            .egg(MapColor.GREEN.colorValue, MapColor.BLACK.colorValue)
            .spawn(EnumCreatureType.CREATURE, 20, 1, 5, BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST))
            .build()
            );


    @EventBusSubscriber(modid = VampireCreepersMain.MODID)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void onEvent(final RegistryEvent.Register<EntityEntry> event)
        {
            final IForgeRegistry<EntityEntry> registry = event.getRegistry();

            for (final EntityEntry entityEntry : CUSTOM_ENTITIES)
            {
                registry.register(entityEntry);
            }

        }
    }

}