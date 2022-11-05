package top.ssskkk.mc.deathlogger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;

public final class DeathLogger extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Death Logger is Enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Death Logger is Disabled");
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        Location loc = player.getLocation();

        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();

        String worldName;
        try {
            worldName = Objects.requireNonNull(loc.getWorld()).getName();
        }
        catch (NullPointerException exception){
            worldName = "w:NULL";
        }

        getLogger().log(Level.INFO, player.getName() +
                " in " + "[WorldName: " + worldName + "]" +
                " [Location: " + "x = " + x + " y = " + y + " z = " + z + "]");

        player.sendMessage(ChatColor.RED + player.getName() +
                ChatColor.RESET + " in " + ChatColor.GREEN +"[WorldName: " + worldName + "]" +
                " [Location: " + "x = " + x + " y = " + y + " z = " + z + "]");
    }
}
