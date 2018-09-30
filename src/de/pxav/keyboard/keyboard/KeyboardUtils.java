package de.pxav.keyboard.keyboard;

// The project SpigotMC.org - KeyboardAPI is developed and updated by PXAV.
// You are not allowed to claim this as your own, give it to 
// others or even sell it.
//
// Contact me on:
// YouTube: https://www.youtube.com/channel/UCtXSAGTwurKVeEbwEKMlFog
// Twitter: https://twitter.com/OrigPXAV
// 
// (c) 2018 PXAV     

import de.pxav.keyboard.items.KeyboardInventoryBuilder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KeyboardUtils {

    private Map<UUID, Boolean> keyboardClosed = new HashMap<>();

    /***
     * @param player The player whose result should be returned.
     * @return Returns {@code true} if any data about the keyboard
     *         behaviour exists.
     */
    public boolean pluginClosedKeyboard(final Player player) {
        return keyboardClosed.containsKey(player.getUniqueId());
    }

    /**
     * Closes the keyboard of a player and saves the information
     * that the keyboard was closed with a in-game key and not
     * via the player's real keyboard.
     * @param player The player whose keyboard should be closed.
     */
    public void closeKeyboardByPlugin(final Player player) {
        keyboardClosed.put(player.getUniqueId(), true);
    }

    /**
     * Clears the information about the appearance of the keyboard about
     * a player. This means that the plugins knows if the player closed his keyboard
     * with the [ESC] or [E] key of his real keyboard or if he used the red key
     * in the in-game keyboard.
     * @param player The player whose data should be cleared.
     */
    public void clearPlayerData(final Player player) {
        keyboardClosed.remove(player.getUniqueId());
    }

    /**
     * @param inventory The inventory which should be checked.
     * @return Returns {@code true} if the name of the inventory equals one of
     *         pre-defined alphabet inventory names.
     */
    public boolean isKeyboardAlphabetInventory(final Inventory inventory) {
        return inventory.getName().equalsIgnoreCase(KeyboardInventoryBuilder.ALPHABET_TITLE_ENGLISH)
                || inventory.getName().equalsIgnoreCase(KeyboardInventoryBuilder.ALPHABET_TITLE_FRENCH)
                || inventory.getName().equalsIgnoreCase(KeyboardInventoryBuilder.ALPHABET_TITLE_GERMAN);
    }

    /**
     * @param inventory The inventory which should be checked.
     * @return Returns {@code true} if the name of the inventory equals one of
     *         pre-defined ascii inventory names.
     */
    public boolean isKeyboardAsciiInventory(final Inventory inventory) {
        return inventory.getName().equalsIgnoreCase(KeyboardInventoryBuilder.ASCII_TITLE_ENGLISH)
                || inventory.getName().equalsIgnoreCase(KeyboardInventoryBuilder.ASCII_TITLE_FRENCH)
                || inventory.getName().equalsIgnoreCase(KeyboardInventoryBuilder.ASCII_TITLE_GERMAN);
    }

    /**
     * @param inventory The inventory which should be checked.
     * @return Returns {@code true} if the name of the inventory equals one of
     *         pre-defined symbol inventory names.
     */
    public boolean isKeyboardSymbolsInventory(final Inventory inventory) {
        return inventory.getName().equalsIgnoreCase(KeyboardInventoryBuilder.SYMBOLS_TITLE_ENGLISH)
                || inventory.getName().equalsIgnoreCase(KeyboardInventoryBuilder.SYMBOLS_TITLE_FRENCH)
                || inventory.getName().equalsIgnoreCase(KeyboardInventoryBuilder.SYMBOLS_TITLE_GERMAN);
    }

}
