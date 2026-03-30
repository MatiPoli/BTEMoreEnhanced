package com.github.dixiecyanide.btemoreenhanced.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (event.getItem() != null && event.getItem().getType() == Material.WOODEN_AXE) {
            switch (event.getAction()) {
                case LEFT_CLICK_AIR:
                    if (p.isSneaking()) {
                        p.performCommand("/shift " + 1);
                    } else {
                        p.performCommand("/expand " + 1);
                    }
                    break;
                case RIGHT_CLICK_AIR:
                    p.performCommand("/contract " + 1);
                    break;
                default:
                    break;
            }
        }
    }
}
