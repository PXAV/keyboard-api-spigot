package de.pxav.keyboard.listeners;

// The project SpigotMC.org - KeyboardAPI is developed and updated by PXAV.
// You are not allowed to claim this as your own, give it to 
// others or even sell it.
//
// Contact me on:
// YouTube: https://www.youtube.com/channel/UCtXSAGTwurKVeEbwEKMlFog
// Twitter: https://twitter.com/OrigPXAV
// 
// (c) 2018 PXAV     

import de.pxav.keyboard.KeyboardAPI;
import de.pxav.keyboard.KeyboardPlugin;
import de.pxav.keyboard.events.KeyboardCanceledTypingEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryCloseListener implements Listener {

    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent event) {
        if(event.getPlayer() instanceof Player) {
            final Player player = (Player) event.getPlayer();
            if(KeyboardPlugin.getInstance().getKeyboardUtils().isKeyboardAlphabetInventory(event.getInventory())
                    || KeyboardPlugin.getInstance().getKeyboardUtils().isKeyboardAsciiInventory(event.getInventory())
                    || KeyboardPlugin.getInstance().getKeyboardUtils().isKeyboardSymbolsInventory(event.getInventory())) {
                if(!KeyboardPlugin.getInstance().getKeyboardUtils().pluginClosedKeyboard(player))
                    Bukkit.getPluginManager().callEvent(new KeyboardCanceledTypingEvent(player, KeyboardAPI.getInstance().getKeyboardHandler().getMatchingKeyboard(player)));
                else Bukkit.getScheduler().runTaskLater(KeyboardPlugin.getInstance(), () -> KeyboardPlugin.getInstance().getKeyboardUtils().clearPlayerData(player), 1L);
            }
        }
    }


}
