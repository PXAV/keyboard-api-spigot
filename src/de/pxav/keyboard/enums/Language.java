package de.pxav.keyboard.enums;

// The project SpigotMC.org - KeyboardPlugin is developed and updated by PXAV.
// You are not allowed to claim this as your own, give it to 
// others or even sell it.
//
// Contact me on:
// YouTube: https://www.youtube.com/channel/UCtXSAGTwurKVeEbwEKMlFog
// Twitter: https://twitter.com/OrigPXAV
// 
// (c) 2018 PXAV     

public enum Language {

    GERMAN("Deutsch"),
    ENGLISH("English"),
    FRENCH("Francais");

    private String displayName;

    Language(final String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
