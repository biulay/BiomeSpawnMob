package biulay.biomespawnmob.event;

import biulay.biomespawnmob.BiomeSpawnMob;
import org.bukkit.block.Biome;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;

;

public class CheckConfig {
    Plugin plugin = BiomeSpawnMob.getPlugin();
    public static Biome biome;
    public static EntityType entityMob;
    public static EntityType replaceEntity;
    public static EntityType randomSpawnEntity;
    public static int BiomeMobLimit;
    public static boolean chanceSwitch;
    public static double chance;
    public CheckConfig()
    {
        biome = (Biome.valueOf(plugin.getConfig().getString("biomeName").toUpperCase())!=null) ? Biome.valueOf(plugin.getConfig().getString("biomeName").toUpperCase()) : null;
        entityMob = (EntityType.valueOf(plugin.getConfig().getString("entity").toUpperCase())!=null) ? EntityType.valueOf(plugin.getConfig().getString("entity").toUpperCase()) : null;
        replaceEntity = (EntityType.valueOf(plugin.getConfig().getString("replaceEntity").toUpperCase())!=null) ? EntityType.valueOf(plugin.getConfig().getString("replaceEntity").toUpperCase()) : null;
        randomSpawnEntity = (EntityType.valueOf(plugin.getConfig().getString("chanceEnetity").toUpperCase())!=null) ? EntityType.valueOf(plugin.getConfig().getString("chanceEnetity").toUpperCase()) : null;
        chanceSwitch = plugin.getConfig().getBoolean("switch");
        chance = plugin.getConfig().getDouble("chance");
        BiomeMobLimit = plugin.getConfig().getInt("limit");
    }
}
