package de.pxav.keyboard.skulls;

// The project SpigotMC.org - KeyboardPlugin is developed and updated by PXAV.
// You are not allowed to claim this as your own, give it to 
// others or even sell it.
//
// Contact me on:
// YouTube: https://www.youtube.com/channel/UCtXSAGTwurKVeEbwEKMlFog
// Twitter: https://twitter.com/OrigPXAV
// 
// (c) 2018 PXAV


/* --------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!--------
  This class it not completely written by myself. I only changed some
  properties but the main work comes from 'Sep2703'.
  The forum post of him: http://postcrafter.de/viewtopic.php?f=15&t=2773
 -----!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!---------*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Base64;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class ItemSkulls {

    private static Class<?> skullMetaClass, tileEntityClass, blockPositionClass;
    private static int mcVersion;

    static {
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        mcVersion = Integer.parseInt(version.replaceAll("[^0-9]", ""));
        try {
            skullMetaClass = Class.forName("org.bukkit.craftbukkit." + version + ".inventory.CraftMetaSkull");
            tileEntityClass = Class.forName("net.minecraft.server." + version + ".TileEntitySkull");
            if (mcVersion > 174) {
                blockPositionClass = Class.forName("net.minecraft.server." + version + ".BlockPosition");
            } else {
                blockPositionClass = null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param skinURL The URL to the skin-image (full skin)
     * @return The itemstack (SKULL_ITEM) with the given look (skin-image)
     */
    public static ItemStack getSkull(String skinURL) {
        return getSkull(skinURL, 1);
    }

    /**
     *
     * @param skinURL The URL to the skin-image (full skin)
     * @return The itemstack (SKULL_ITEM) with the given look (skin-image)
     */
    public static ItemStack getSkull(String skinURL, String displayName) {
        final ItemStack itemStack = getSkull(skinURL, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    /**
     *
     * @param skinURL The URL to the skin-image (full skin)
     * @return The itemstack (SKULL_ITEM) with the given look (skin-image)
     */
    public static ItemStack getSkull(String skinURL, String displayName, ArrayList<String> lore) {
        return getSkull(skinURL, 1);
    }

    /**
     *
     * @param skinURL The URL to the skin-image (full skin)
     * @param amount The amount of skulls (for ItemStack)
     * @return The itemstack (SKULL_ITEM) with the given look (skin-image)
     */
    public static ItemStack getSkull(String skinURL, int amount) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, amount, (short) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        try {
            Field profileField = skullMetaClass.getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, getProfile(skinURL));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        skull.setItemMeta(meta);
        return skull;
    }

    /**
     *
     * @param loc The location to place the skull
     * @param skinURL The url to the skin-image
     * @return If the block at the given location was replaced with a skull
     */
    public static boolean setBlock(Location loc, String skinURL) {
        return setBlock(loc.getBlock(), skinURL);
    }

    /**
     *
     * @param block The block to set skull
     * @param skinURL The url to the skin-image
     * @return If the block at the given location was replaced with a skull
     */
    public static boolean setBlock(Block block, String skinURL) {
        boolean flag = block.getType() == Material.SKULL;
        if (!flag) {
            block.setType(Material.SKULL);
        }
        try {
            Object nmsWorld = block.getWorld().getClass().getMethod("getHandle").invoke(block.getWorld());
            Object tileEntity = null;

            if (mcVersion <= 174) {
                Method getTileEntity = nmsWorld.getClass().getMethod("getTileEntity", int.class, int.class, int.class);
                tileEntity = tileEntityClass.cast(getTileEntity.invoke(nmsWorld, block.getX(), block.getY(), block.getZ()));
            } else {
                Method getTileEntity = nmsWorld.getClass().getMethod("getTileEntity", blockPositionClass);
                tileEntity = tileEntityClass.cast(getTileEntity.invoke(nmsWorld, getBlockPositionFor(block.getX(), block.getY(), block.getZ())));
            }

            tileEntityClass.getMethod("setGameProfile", GameProfile.class).invoke(tileEntity, getProfile(skinURL));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return !flag;
    }

    private static GameProfile getProfile(String skinURL) {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        String base64encoded = Base64.getEncoder().encodeToString(new String("{textures:{SKIN:{url:\"" + skinURL + "\"}}}").getBytes());
        Property property = new Property("textures", base64encoded);
        profile.getProperties().put("textures", property);
        return profile;
    }

    private static Object getBlockPositionFor(int x, int y, int z) {
        Object blockPosition = null;
        try {
            Constructor<?> cons = blockPositionClass.getConstructor(int.class, int.class, int.class);
            blockPosition = cons.newInstance(x, y, z);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return blockPosition;
    }

}
