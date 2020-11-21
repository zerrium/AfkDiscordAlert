package zerrium;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 *
 * @author willysusilo
 */
public class AfkDiscordAlert extends JavaPlugin {
    
    @Override
    public void onEnable() {
        System.out.println(ChatColor.YELLOW+"[AfkDiscordAlert] v0.1 by zerrium");
        getServer().getPluginManager().registerEvents(new AfkEvent(), this);
        
        if(Bukkit.getPluginManager().getPlugin("Essentials") != null || Bukkit.getPluginManager().getPlugin("EssentialsX") != null){
            System.out.println(ChatColor.YELLOW+"[AfkDiscordAlert] Essentials plugin detected. Checking DiscordSRV depedency...");
        }else{
            System.out.println(ChatColor.YELLOW+"[AfkDiscordAlert] No Essentials plugin detected. Disabling plugin...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        
        if(Bukkit.getPluginManager().getPlugin("DiscordSRV") != null || Bukkit.getPluginManager().getPlugin("discordsrv") != null){
            System.out.println(ChatColor.YELLOW+"[AfkDiscordAlert] DiscordSRV plugin detected. Plugin enabled.");
        }else{
            System.out.println(ChatColor.YELLOW+"[AfkDiscordAlert] DiscordSRV plugin not detected. Disabling plugin...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.YELLOW+"[AfkDiscordAlert] v0.1 disabling plugin");
    }
}
