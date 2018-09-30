package de.pxav.keyboard.items;

// The project SpigotMC.org - KeyboardPlugin is developed and updated by PXAV.
// You are not allowed to claim this as your own, give it to 
// others or even sell it.
//
// Contact me on:
// YouTube: https://www.youtube.com/channel/UCtXSAGTwurKVeEbwEKMlFog
// Twitter: https://twitter.com/OrigPXAV
// 
// (c) 2018 PXAV     

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private ItemStack item;
    private List<String> lore = new ArrayList<>();
    private ItemMeta meta;

    public ItemBuilder(Material material, short subID, int amount) {
        this.item = new ItemStack(material, amount, subID);
        this.meta = this.item.getItemMeta();
    }

    public ItemBuilder(final ItemStack itemStack) {
        this.item = itemStack;
        this.meta = itemStack.getItemMeta();
    }

    public ItemBuilder(final Material mat, final short subID) {
        this.item = new ItemStack(mat, 1, subID);
        this.meta = this.item.getItemMeta();
    }

    public ItemBuilder(final Material mat, final int amount) {
        this.item = new ItemStack(mat, amount, (short) 0);
        this.meta = this.item.getItemMeta();
    }

    public ItemBuilder(final Material material) {
        this.item = new ItemStack(material, 1, (short) 0);
        this.meta = this.item.getItemMeta();
    }

    public ItemBuilder setAmount(final int value) {
        this.item.setAmount(value);
        return this;
    }

    public ItemBuilder setNoName() {
        this.meta.setDisplayName(" ");
        return this;
    }

    public ItemBuilder setGlow() {
        this.meta.addEnchant(Enchantment.DURABILITY, 1, true);
        this.meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    public ItemBuilder setData(final short data) {
        this.item.setDurability(data);
        return this;
    }

    public ItemBuilder addLoreLine(final String line) {
        this.lore.add(line);
        return this;
    }

    public ItemBuilder addLoreArray(final String[] lines) {
        this.lore.addAll(Arrays.asList(lines));

        return this;
    }

    public ItemBuilder addLoreAll(final List<String> lines) {
        this.lore.addAll(lines);
        return this;
    }

    public ItemBuilder setDisplayName(final String displayName) {
        this.meta.setDisplayName(displayName);
        return this;
    }

    public ItemBuilder setSkullOwner(final String owner) {
        ((SkullMeta) this.meta).setOwner(owner);
        return this;
    }

    public ItemBuilder setColor(final Color color) {
        ((LeatherArmorMeta) this.meta).setColor(color);
        return this;
    }

    public ItemBuilder setBannerColor(final DyeColor dyeColor) {
        ((BannerMeta) this.meta).setBaseColor(dyeColor);
        return this;
    }

    public ItemBuilder setUnbreakable(final boolean value) {
        this.meta.spigot().setUnbreakable(value);
        return this;
    }

    public ItemBuilder addEnchantment(final Enchantment enchantment, int level) {
        this.meta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder addItemFlag(final ItemFlag itemFlag) {
        this.meta.addItemFlags(itemFlag);
        return this;
    }

    public ItemBuilder addLeatherColor(final Color color) {
        ((LeatherArmorMeta) this.meta).setColor(color);
        return this;
    }

    public ItemStack build() {
        if (!this.lore.isEmpty())
            this.meta.setLore(this.lore);
        this.item.setItemMeta(this.meta);
        return this.item;
    }

}
