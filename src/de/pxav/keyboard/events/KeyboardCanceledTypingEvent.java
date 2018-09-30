package de.pxav.keyboard.events;

// The project SpigotMC.org - KeyboardAPI is developed and updated by PXAV.
// You are not allowed to claim this as your own, give it to 
// others or even sell it.
//
// Contact me on:
// YouTube: https://www.youtube.com/channel/UCtXSAGTwurKVeEbwEKMlFog
// Twitter: https://twitter.com/OrigPXAV
// 
// (c) 2018 PXAV     

import de.pxav.keyboard.keyboard.Keyboard;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class KeyboardCanceledTypingEvent extends Event {

    public static HandlerList handlerList = new HandlerList();

    private Player player;
    private Keyboard keyboard;

    public KeyboardCanceledTypingEvent(final Player player, final Keyboard keyboard) {
        this.keyboard = keyboard;
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return KeyboardCanceledTypingEvent.handlerList;
    }

    public static HandlerList getHandlerList(){
        return KeyboardCanceledTypingEvent.handlerList;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Player getPlayer() {
        return player;
    }
}
