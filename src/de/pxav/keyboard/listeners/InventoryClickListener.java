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
import de.pxav.keyboard.events.KeyboardEnteredResultEvent;
import de.pxav.keyboard.items.KeyboardInventoryBuilder;
import de.pxav.keyboard.keyboard.Keyboard;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        if(event.getWhoClicked() instanceof Player && event.getClickedInventory() != null) {
            final Player player = (Player) event.getWhoClicked();

            if(KeyboardAPI.getInstance().getKeyboardHandler().playerHasKeyboard(player)) {
                final Keyboard keyboard = KeyboardAPI.getInstance().getKeyboardHandler().getMatchingKeyboard(player);
                if(KeyboardPlugin.getInstance().getKeyboardUtils().isKeyboardAlphabetInventory(event.getClickedInventory())
                        || KeyboardPlugin.getInstance().getKeyboardUtils().isKeyboardAsciiInventory(event.getClickedInventory())
                        || KeyboardPlugin.getInstance().getKeyboardUtils().isKeyboardSymbolsInventory(event.getClickedInventory())) {
                    event.setCancelled(true);
                    if((event.getCurrentItem().getType() == Material.SKULL_ITEM || event.getCurrentItem().getType() == Material.FLOWER_POT_ITEM)
                            && event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§a§l")) {
                        final String letter = event.getCurrentItem().getItemMeta().getDisplayName().replace("§a§l", "");
                        keyboard.setTypeResult(keyboard.getTypeResult() + letter);
                        player.playSound(player.getLocation(), Sound.CLICK, 3, 1);
                        KeyboardPlugin.getInstance().getKeyboardInventoryBuilder().updateTypeResult(player, letter);
                    } else if(event.getCurrentItem().getType() == Material.STICK) {
                        final String letter = " ";
                        keyboard.setTypeResult(keyboard.getTypeResult() + letter);
                        player.playSound(player.getLocation(), Sound.CLICK, 3, 1);
                        KeyboardPlugin.getInstance().getKeyboardInventoryBuilder().updateTypeResult(player, letter);
                    } else if(event.getCurrentItem().getType() == Material.DIAMOND && (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_DONE_ENGLISH)
                            || event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_DONE_GERMAN)
                            || event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_DONE_FRENCH))) {
                        KeyboardPlugin.getInstance().getKeyboardUtils().closeKeyboardByPlugin(player);
                        player.closeInventory();
                        Bukkit.getPluginManager().callEvent(new KeyboardEnteredResultEvent(player, keyboard));
                        player.playSound(player.getLocation(), Sound.CLICK, 3, 1);
                    } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_CANCEL_ENGLISH)
                            || event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_CANCEL_FRENCH)
                            || event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_CANCEL_GERMAN)) {
                        KeyboardPlugin.getInstance().getKeyboardUtils().closeKeyboardByPlugin(player);
                        player.closeInventory();
                        Bukkit.getPluginManager().callEvent(new KeyboardCanceledTypingEvent(player, keyboard));
                        player.playSound(player.getLocation(), Sound.CLICK, 3, 1);
                    } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_SYMBOLS_ENGLISH)
                            || event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_SYMBOLS_GERMAN)
                            || event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_SYMBOLS_FRENCH)) {
                        KeyboardPlugin.getInstance().getKeyboardUtils().closeKeyboardByPlugin(player);
                        player.closeInventory();
                        KeyboardPlugin.getInstance().getKeyboardInventoryBuilder().openSymbolsMenu(player, keyboard.getLanguage());
                        player.playSound(player.getLocation(), Sound.CLICK, 3, 1);
                    } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_ASCII_ENGLISH)
                            || event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_ASCII_GERMAN)
                            || event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_ASCII_FRENCH)) {
                        KeyboardPlugin.getInstance().getKeyboardUtils().closeKeyboardByPlugin(player);
                        player.closeInventory();
                        KeyboardPlugin.getInstance().getKeyboardInventoryBuilder().openAsciiMenu(player, keyboard.getLanguage());
                        player.playSound(player.getLocation(), Sound.CLICK, 3, 1);
                    } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_ALPHABET_ENGLISH)
                            || event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_ALPHABET_GERMAN)
                            || event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(KeyboardInventoryBuilder.ITEM_ALPHABET_FRENCH)) {
                        KeyboardPlugin.getInstance().getKeyboardUtils().closeKeyboardByPlugin(player);
                        player.closeInventory();
                        KeyboardPlugin.getInstance().getKeyboardInventoryBuilder().openAlphabet(player, keyboard.getLanguage());
                        player.playSound(player.getLocation(), Sound.CLICK, 3, 1);
                    }
                }
            }
        }
    }

}
