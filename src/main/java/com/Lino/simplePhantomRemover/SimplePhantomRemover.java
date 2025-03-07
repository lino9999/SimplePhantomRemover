package com.Lino.simplePhantomRemover;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplePhantomRemover extends JavaPlugin {

    private static final EntityType PHANTOM = EntityType.PHANTOM;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PhantomListener(), this);
    }

    @Override
    public void onDisable() {

    }

    private static final class PhantomListener implements Listener {

        @EventHandler(
                priority = EventPriority.HIGHEST,
                ignoreCancelled = true
        )
        public void onEntitySpawn(EntitySpawnEvent e) {
            if (e.getEntityType() == PHANTOM) {
                e.setCancelled(true);
            }
        }
    }
}