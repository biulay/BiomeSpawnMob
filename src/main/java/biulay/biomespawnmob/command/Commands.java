package biulay.biomespawnmob.command;

import biulay.biomespawnmob.BiomeSpawnMob;
import biulay.biomespawnmob.event.CheckConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Commands implements CommandExecutor, TabExecutor {
    Plugin plugin = BiomeSpawnMob.getPlugin();
    public Commands()
    {
        plugin.getLogger().info("    §a插件指令已注册");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender.isOp()&&(s.equalsIgnoreCase("bsm")||s.equalsIgnoreCase("biomespawnmob")))
        {
            if(strings.length==0){sender.sendMessage("指令仅仅有reload");}
            else switch (strings[0])
            {
                case "reload":
                    BiomeSpawnMob.getPlugin().reloadConfig();
                    plugin.saveDefaultConfig();
                    new CheckConfig();
                    sender.sendMessage("配置文件已重载");
                    break;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] strings) {
        if(sender.isOp()&&strings.length==1){
            List<String> list = new ArrayList<>();
            list.add("reload");
            return list;
        }
        return null;
    }
}
