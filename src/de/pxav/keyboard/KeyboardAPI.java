package de.pxav.keyboard;

// The project SpigotMC.org - KeyboardAPI is developed and updated by PXAV.
// You are not allowed to claim this as your own, give it to 
// others or even sell it.
//
// Contact me on:
// YouTube: https://www.youtube.com/channel/UCtXSAGTwurKVeEbwEKMlFog
// Twitter: https://twitter.com/OrigPXAV
// 
// (c) 2018 PXAV     

import de.pxav.keyboard.keyboard.KeyboardHandler;

public class KeyboardAPI  {

    private static KeyboardAPI instance = new KeyboardAPI();
    private String prefix;

    private final KeyboardHandler keyboardHandler = new KeyboardHandler();

    public void setup(final String prefix) {
        this.setPrefix(prefix);
    }

    public String getPrefix() {
        return prefix;
    }

    private void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public static KeyboardAPI getInstance() {
        return instance;
    }

    public KeyboardHandler getKeyboardHandler() {
        return keyboardHandler;
    }
}
