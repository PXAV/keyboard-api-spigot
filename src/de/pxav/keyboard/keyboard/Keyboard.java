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

import de.pxav.keyboard.KeyboardPlugin;
import de.pxav.keyboard.enums.Language;
import org.bukkit.entity.Player;

public class Keyboard {

    private String typeResult;
    private Player matchingPlayer;
    private Language language;

    public Keyboard() {}

    public void openKeyboard() {
        KeyboardPlugin.getInstance().getKeyboardInventoryBuilder().openAlphabet(matchingPlayer, language);
    }

    public String getTypeResult() {
        return typeResult;
    }

    public void setTypeResult(String typeResult) {
        this.typeResult = typeResult;
    }

    public Player getMatchingPlayer() {
        return matchingPlayer;
    }

    public void setMatchingPlayer(Player matchingPlayer) {
        this.matchingPlayer = matchingPlayer;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
