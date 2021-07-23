package de.domdiidom.sleep.main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {

    private static Main INSTANCE;

    public int playersInBed = 0;

    @Override
    public void onEnable(){
        INSTANCE = this;

        Bukkit.getPluginManager().registerEvents(new EventPlayerBed(), this);

        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        new BukkitRunnable(){

            int playerCount = getConfig().getInt("sleep.playerCount");
            World world = Bukkit.getWorld(getConfig().getString("sleep.world"));

            @Override
            public void run() {
                int onlinePlayers = Bukkit.getOnlinePlayers().size();
                if(playersInBed >= playerCount){
                    world.setTime(0);
                    Bukkit.broadcastMessage(getConfig().getString("sleep.message_to_day"));
                }else{
                    if(onlinePlayers < playerCount){
                        if(playersInBed == onlinePlayers){
                            world.setTime(0);
                            Bukkit.broadcastMessage(getConfig().getString("sleep.message_to_day"));

                        }
                    }
                }
            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }

    @Override
    public void onDisable(){

    }

    public static Main getInstance(){
        return INSTANCE;
    }
}
