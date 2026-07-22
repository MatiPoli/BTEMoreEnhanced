package com.github.dixiecyanide.btemoreenhanced.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.dixiecyanide.btemoreenhanced.BTEMoreEnhanced;

public class PlayerInteractListener implements Listener {
    private static final BTEMoreEnhanced bme = BTEMoreEnhanced.getPlugin(BTEMoreEnhanced.class);

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Boolean shortcutEnabled = (Boolean) bme.getUdUtils().getOnlineUdValue(p.getUniqueId(), "ShortcutEnabled");
        Integer shortcutIncrement = (Integer) bme.getUdUtils().getOnlineUdValue(p.getUniqueId(), "ShortcutIncrement");

        if (!shortcutEnabled) {
            return;
        }
        if (!p.hasPermission("btemoreenhanced.player.shortcuts")) {
            return;
        }
        if (event.getItem() != null && event.getItem().getType() == Material.WOODEN_AXE) {
            switch (event.getAction()) {
                case LEFT_CLICK_AIR:
                    if (p.isSneaking()) {
                        p.performCommand("/shift " + shortcutIncrement);
                    } else {
                        p.performCommand("/expand " + shortcutIncrement);
                    }
                    break;
                case RIGHT_CLICK_AIR:
                    p.performCommand("/contract " + shortcutIncrement);
                    break;
                default:
                    break;
            }
        }
    }
}
