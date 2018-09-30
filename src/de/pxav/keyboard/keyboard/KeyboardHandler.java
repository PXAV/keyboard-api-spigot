package de.pxav.keyboard.keyboard;

// The project SpigotMC.org - KeyboardPlugin is developed and updated by PXAV.
// You are not allowed to claim this as your own, give it to 
// others or even sell it.
//
// Contact me on:
// YouTube: https://www.youtube.com/channel/UCtXSAGTwurKVeEbwEKMlFog
// Twitter: https://twitter.com/OrigPXAV
// 
// (c) 2018 PXAV     

import de.pxav.keyboard.enums.Language;
import org.bukkit.entity.Player;

import java.util.*;

public class KeyboardHandler {

    private List<Keyboard> activeKeyboards = new ArrayList<>();
    private Map<UUID, Keyboard> playerKeyboards = new HashMap<>();

    /**
     * Registers a new keyboard. This method automatically saves the inventory of a player.
     * @param matchingPlayer The player to who the keyboard should be assigned to.
     * @param language The language format for the keyboard (German and English keyboards
     *                 have a different layout).
     * @return Returns the final result of the created Keyboard.
     */
    public Keyboard registerNewKeyboard(final Player matchingPlayer, final Language language) {

        final Keyboard keyboard = new Keyboard();
        keyboard.setMatchingPlayer(matchingPlayer);
        keyboard.setTypeResult("");
        keyboard.setLanguage(language);

        activeKeyboards.add(keyboard);
        playerKeyboards.put(matchingPlayer.getUniqueId(), keyboard);

        return keyboard;

    }

    /**
     * @param player The player who should be checked.
     * @return Returns {@code true} if the player currently has a keyboard.
     */
    public boolean playerHasKeyboard(final Player player) {
        return activeKeyboards.contains(this.getMatchingKeyboard(player)) || playerKeyboards.containsKey(player.getUniqueId());
    }

    /**
     * Returns the keyboard which is in use of a certain player.
     * @param matchingPlayer The player whose keyboard you want to get.
     * @return The final keyboard. If the player does not have a keyboard it will
     *         return null.
     */
    public Keyboard getMatchingKeyboard(final Player matchingPlayer) {
        return playerKeyboards.getOrDefault(matchingPlayer.getUniqueId(), null);
    }

    /**
     * Unregisters the keyboard of a player.
     * @param owner The owner of the keyboard.
     */
    public void unregisterKeyboard(final Player owner) {
        activeKeyboards.remove(this.getMatchingKeyboard(owner));
        playerKeyboards.remove(owner.getUniqueId());
    }

    /**
     * @return Returns a list with all keyboards that are currently in use.
     */
    public List<Keyboard> getActiveKeyboards() {
        return activeKeyboards;
    }

}
