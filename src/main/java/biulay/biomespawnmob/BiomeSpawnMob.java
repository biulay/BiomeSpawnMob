package biulay.biomespawnmob;

import biulay.biomespawnmob.command.Commands;
import biulay.biomespawnmob.event.CheckConfig;
import biulay.biomespawnmob.event.EventMonitor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class BiomeSpawnMob extends JavaPlugin {
    private static Plugin plugin;
    @Override
    public void onEnable() {
        this.setPlugin();
        config(this);
        getLogger().info("    §a编写者: Yoe");
        getLogger().info("    §a插件版本Version: §b" + this.getDescription().getVersion());
        this.getServer().getPluginManager().registerEvents(new EventMonitor(), this);
        new CheckConfig();
        Commands commands = new Commands();
        Objects.requireNonNull(getCommand("bsm")).setExecutor(commands);
        Objects.requireNonNull(getCommand("bsm")).setTabCompleter(commands);
        Objects.requireNonNull(getCommand("biomespawnmob")).setExecutor(commands);
        Objects.requireNonNull(getCommand("biomespawnmob")).setTabCompleter(commands);
    }

    @Override
    public void onDisable() {getLogger().info("    §a插件已注销");}
    public void config(Plugin config)
    {
        config.getConfig().options().copyDefaults();
        config.saveDefaultConfig();
        getLogger().info("    §a配置文件加载成功");
    }
    public static Plugin getPlugin() {
        return plugin;
    }
    public void setPlugin() {
        plugin = this;
    }
}
