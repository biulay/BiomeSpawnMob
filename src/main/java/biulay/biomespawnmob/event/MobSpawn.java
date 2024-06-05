package biulay.biomespawnmob.event;


import biulay.biomespawnmob.BiomeSpawnMob;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static biulay.biomespawnmob.event.CheckConfig.*;


public class MobSpawn{

    public static void MobSpawn(EntitySpawnEvent event) {
        if(event.getEntityType() != replaceEntity) return;
        if(event.getLocation().getBlock().getBiome()!=biome)return;
        new BukkitRunnable() {
            @Override
            public void run()
            {
                Location location = event.getLocation();
                event.setCancelled(true);
                if(!chanceSwitch) {location.getWorld().spawnEntity(location, entityMob);return;}
                if(random()<=chance){location.getWorld().spawnEntity(location,randomSpawnEntity);return;}
                location.getWorld().spawnEntity(location, entityMob);
            }
        }.run();

    }
    public static double random() {
        DecimalFormat df = new DecimalFormat("#.0");
        return Double.parseDouble(df.format(Math.random()));
    }
    public static void MobLimit(EntitySpawnEvent event)
    {
        if(BiomeMobLimit==-1)return;
        if(event.getEntityType() != entityMob)return;
        if(event.getLocation().getBlock().getBiome()!=biome)return;
        Location location = event.getLocation();
        AtomicInteger mobCount = new AtomicInteger();
        location.getWorld().getEntitiesByClass(event.getEntity().getClass()).stream().filter(mob -> event.getEntity().getLocation().getBlock().getBiome() == location.getBlock().getBiome()).forEach(mob -> mobCount.incrementAndGet());
        System.out.println(mobCount + event.getEntity().getName());
        if(mobCount.get() >= BiomeMobLimit)
        {
            event.setCancelled(true);
        }
    }
}
