package de.pxav.keyboard;

// The project SpigotMC.org - KeyboardPlugin is developed and updated by PXAV.
// You are not allowed to claim this as your own, give it to 
// others or even sell it.
//
// Contact me on:
// YouTube: https://www.youtube.com/channel/UCtXSAGTwurKVeEbwEKMlFog
// Twitter: https://twitter.com/OrigPXAV
// 
// (c) 2018 PXAV     

import de.pxav.keyboard.items.KeyboardInventoryBuilder;
import de.pxav.keyboard.keyboard.KeyboardUtils;
import de.pxav.keyboard.listeners.InventoryClickListener;
import de.pxav.keyboard.listeners.InventoryCloseListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class KeyboardPlugin extends JavaPlugin {

    private static KeyboardPlugin instance;

    private KeyboardInventoryBuilder keyboardInventoryBuilder = new KeyboardInventoryBuilder();
    private KeyboardUtils keyboardUtils = new KeyboardUtils();

    @Override
    public void onEnable() {
        setInstance(this);
        Bukkit.getConsoleSender().sendMessage("§8§m-----------------------------");
        Bukkit.getConsoleSender().sendMessage("§3KEYBOARD API [SPICE UP YOUR PLUGINS WITH KEYBOARDS]");
        Bukkit.getConsoleSender().sendMessage("§7Enabling Plugin...");
        Bukkit.getConsoleSender().sendMessage("§8> §7Downloading Skins from Mojang database...");
        this.getKeyboardInventoryBuilder().prepareItemStacks();
        Bukkit.getConsoleSender().sendMessage("§8> §7Preparing items...");
        Bukkit.getConsoleSender().sendMessage("§8> §7Registering API-Events...");
        this.registerEvents();
        Bukkit.getConsoleSender().sendMessage("§8> §7Registering normal events...");
        Bukkit.getConsoleSender().sendMessage("§8> §aDONE! Plugin successfully enabled!");
        Bukkit.getConsoleSender().sendMessage("§8§m-----------------------------");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§8§m-----------------------------");
        Bukkit.getConsoleSender().sendMessage("§3KEYBOARD API [SPICE UP YOUR PLUGINS WITH KEYBOARDS]");
        Bukkit.getConsoleSender().sendMessage("§7Disabling plugin...");
        Bukkit.getConsoleSender().sendMessage("§8> §7Unregistering key boards...");
        Bukkit.getConsoleSender().sendMessage("§8> §7Unregistering events...");
        Bukkit.getConsoleSender().sendMessage("§8> §cDONE! Plugin successfully disabled!");
        Bukkit.getConsoleSender().sendMessage("§8§m-----------------------------");
    }

    private void registerEvents() {
        final PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new InventoryClickListener(), this);
        pluginManager.registerEvents(new InventoryCloseListener(), this);
    }

    public static KeyboardPlugin getInstance() {
        return instance;
    }

    private static void setInstance(KeyboardPlugin instance) {
        KeyboardPlugin.instance = instance;
    }

    public KeyboardInventoryBuilder getKeyboardInventoryBuilder() {
        return keyboardInventoryBuilder;
    }

    public KeyboardUtils getKeyboardUtils() {
        return keyboardUtils;
    }
}
