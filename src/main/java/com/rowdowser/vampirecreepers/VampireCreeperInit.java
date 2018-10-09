package com.rowdowser.vampirecreepers;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = VampireCreepersMain.MODID)
public class VampireCreeperInit
{
	/**
	 * Replace Creeper on spawn with VampireCreeper that burns in sunlight.
	 * @param event
	 */
	@SubscribeEvent
    public static void OnEntityJoinWorld(EntityJoinWorldEvent event) 
    {
    	if (event.getEntity() instanceof EntityCreeper && !(event.getEntity() instanceof VampireCreeper) && !event.getWorld().isRemote)
    	{
    		EntityCreeper oldCreeper = (EntityCreeper) event.getEntity();
    		VampireCreeper newCreeper = new VampireCreeper(event.getWorld());
    		newCreeper.setLocationAndAngles(oldCreeper.posX, oldCreeper.posY, oldCreeper.posZ,oldCreeper.rotationYaw, oldCreeper.rotationPitch);
    		oldCreeper.setDead();
    		event.getWorld().spawnEntity(newCreeper);
    	}
    }
    
}
