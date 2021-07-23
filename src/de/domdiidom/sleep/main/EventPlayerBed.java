package de.domdiidom.sleep.main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class EventPlayerBed implements Listener {

    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent event){
        Main.getInstance().playersInBed++;
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event){
        Main.getInstance().playersInBed--;
    }
}
