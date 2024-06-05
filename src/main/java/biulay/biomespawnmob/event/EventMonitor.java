package biulay.biomespawnmob.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EventMonitor implements Listener {
    @EventHandler
    public static void guardianSpawnSet(EntitySpawnEvent event)
    {
        MobSpawn.MobSpawn(event);
        MobSpawn.MobLimit(event);
    }
}
