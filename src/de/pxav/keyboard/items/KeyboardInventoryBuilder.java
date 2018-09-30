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

import de.pxav.keyboard.KeyboardAPI;
import de.pxav.keyboard.KeyboardPlugin;
import de.pxav.keyboard.enums.Language;
import de.pxav.keyboard.skulls.ItemSkulls;
import net.minecraft.server.v1_8_R3.ItemSkull;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class KeyboardInventoryBuilder {

    private ItemStack keyA, keyB, keyC, keyD, keyE, keyF, keyG, keyH, keyI, keyN, keyO, keyP, keyQ;
    private ItemStack keyR, keyS, keyT, keyU, keyV, keyW, keyX, keyY, keyZ, keyJ, keyK, keyL, keyM;

    private ItemStack keySlash, keyExclamation, keyQuestion, keyDot, keyDot2, keyArrowLeft, keyArrowRight, keyArrowUp, keyArrowDown;
    private ItemStack key1, key2, key3, key4, key5, key6, key7, key8, key9, key0, keyGapOn, keyGapOff;

    private ItemStack asciiArrow1, asciiArrow2, asciiHeart, asciiCross, asciiTick, asciiArrow3;

    public static String ALPHABET_TITLE_GERMAN = "§3§lTASTATUR §8> §7Alphabet";
    public static String ALPHABET_TITLE_FRENCH = "§3§lCLAVIER §8> §7Alphabet";
    public static String ALPHABET_TITLE_ENGLISH = "§3§lKEYBOARD §8> §7Alphabet";

    public static String SYMBOLS_TITLE_GERMAN = "§3§lTASTATUR §8> §7Zeichen";
    public static String SYMBOLS_TITLE_FRENCH = "§3§lCLAVIER §8> §7Signes";
    public static String SYMBOLS_TITLE_ENGLISH = "§3§lKEYBOARD §8> §7Symbols";

    public static String ASCII_TITLE_GERMAN = "§3§lTASTATUR §8> §7ASCII Zeichen";
    public static String ASCII_TITLE_FRENCH = "§3§lCLAVIER §8> §7ASCII Signes";
    public static String ASCII_TITLE_ENGLISH = "§3§lKEYBOARD §8> §7ASCII Symbols";

    public static String ITEM_ASCII_GERMAN = "§8➡ §3ASCII Zeichen";
    public static String ITEM_ASCII_FRENCH = "§8➡ §3ASCII signes";
    public static String ITEM_ASCII_ENGLISH = "§8➡ §3ASCII symbols";

    public static String ITEM_SYMBOLS_GERMAN = "§8➡ §3Zeichen";
    public static String ITEM_SYMBOLS_FRENCH = "§8➡ §3Signes";
    public static String ITEM_SYMBOLS_ENGLISH = "§8➡ §3Symbols";

    public static String ITEM_ALPHABET_GERMAN = "§8➡ §3Alphabet";
    public static String ITEM_ALPHABET_FRENCH = "§8➡ §3Alphabet";
    public static String ITEM_ALPHABET_ENGLISH = "§8➡ §3Alphabet";

    public static String ITEM_SPACE_GERMAN = "§8➡ §3Leerzeichen";
    public static String ITEM_SPACE_FRENCH = "§8➡ §3Espace";
    public static String ITEM_SPACE_ENGLISH = "§8➡ §3Space";

    public static String ITEM_DONE_GERMAN = "§8➡ §3Fertig und bestätigen";
    public static String ITEM_DONE_FRENCH = "§8➡ §3Terminer et confirmer";
    public static String ITEM_DONE_ENGLISH = "§8➡ §3Finish and confirm";

    public static String ITEM_CANCEL_GERMAN = "§8➡ §3Abbrechen";
    public static String ITEM_CANCEL_FRENCH = "§8➡ §3Interrompre";
    public static String ITEM_CANCEL_ENGLISH = "§8➡ §3Cancel";

    private List<String> LORE_ENGLISH_DONE = new ArrayList<>();
    private List<String> LORE_GERMAN_DONE = new ArrayList<>();
    private List<String> LORE_FRENCH_DONE = new ArrayList<>();

    public static Map<UUID, Inventory> playerKeyboardInventories = new HashMap<>();

    /**
     * Prepares all item stacks. It downloads all skins and assigns it to a key variable.
     */
    public void prepareItemStacks() {

        LORE_ENGLISH_DONE.add("§8§m---------------------");
        LORE_ENGLISH_DONE.add("§7Exit the keyboard and confirm");
        LORE_ENGLISH_DONE.add("§7your input.");
        LORE_ENGLISH_DONE.add("§8§m---------------------");

        LORE_GERMAN_DONE.add("§8§m---------------------");
        LORE_GERMAN_DONE.add("§7Verlasse die Tastatur und");
        LORE_GERMAN_DONE.add("§7bestätige deine Eingabe.");
        LORE_GERMAN_DONE.add("§8§m---------------------");

        LORE_FRENCH_DONE.add("§8§m---------------------");
        LORE_FRENCH_DONE.add("§7Quittez le clavier et confirmez");
        LORE_FRENCH_DONE.add("§7votre saisie.");
        LORE_FRENCH_DONE.add("§8§m---------------------");

        // Letters
        keyA = ItemSkulls.getSkull("http://textures.minecraft.net/texture/a67d813ae7ffe5be951a4f41f2aa619a5e3894e85ea5d4986f84949c63d7672e", "§a§lA");
        keyB = ItemSkulls.getSkull("http://textures.minecraft.net/texture/50c1b584f13987b466139285b2f3f28df6787123d0b32283d8794e3374e23", "§a§lB");
        keyC = ItemSkulls.getSkull("http://textures.minecraft.net/texture/abe983ec478024ec6fd046fcdfa4842676939551b47350447c77c13af18e6f", "§a§lC");
        keyD = ItemSkulls.getSkull("http://textures.minecraft.net/texture/3193dc0d4c5e80ff9a8a05d2fcfe269539cb3927190bac19da2fce61d71", "§a§lD");
        keyE = ItemSkulls.getSkull("http://textures.minecraft.net/texture/dbb2737ecbf910efe3b267db7d4b327f360abc732c77bd0e4eff1d510cdef", "§a§lE");
        keyF = ItemSkulls.getSkull("http://textures.minecraft.net/texture/b183bab50a3224024886f25251d24b6db93d73c2432559ff49e459b4cd6a", "§a§lF");
        keyG = ItemSkulls.getSkull("http://textures.minecraft.net/texture/1ca3f324beeefb6a0e2c5b3c46abc91ca91c14eba419fa4768ac3023dbb4b2", "§a§lG");
        keyH = ItemSkulls.getSkull("http://textures.minecraft.net/texture/31f3462a473549f1469f897f84a8d4119bc71d4a5d852e85c26b588a5c0c72f", "§a§lH");
        keyI = ItemSkulls.getSkull("http://textures.minecraft.net/texture/46178ad51fd52b19d0a3888710bd92068e933252aac6b13c76e7e6ea5d3226", "§a§lI");
        keyJ = ItemSkulls.getSkull("http://textures.minecraft.net/texture/3a79db9923867e69c1dbf17151e6f4ad92ce681bcedd3977eebbc44c206f49", "§a§lJ");
        keyS = ItemSkulls.getSkull("http://textures.minecraft.net/texture/3e41c60572c533e93ca421228929e54d6c856529459249c25c32ba33a1b1517", "§a§lS");
        keyR = ItemSkulls.getSkull("http://textures.minecraft.net/texture/a5ced9931ace23afc351371379bf05c635ad186943bc136474e4e5156c4c37", "§a§lR");
        keyX = ItemSkulls.getSkull("http://textures.minecraft.net/texture/5a6787ba32564e7c2f3a0ce64498ecbb23b89845e5a66b5cec7736f729ed37", "§a§lX");
        keyU = ItemSkulls.getSkull("http://textures.minecraft.net/texture/607fbc339ff241ac3d6619bcb68253dfc3c98782baf3f1f4efdb954f9c26", "§a§lU");
        keyL = ItemSkulls.getSkull("http://textures.minecraft.net/texture/319f50b432d868ae358e16f62ec26f35437aeb9492bce1356c9aa6bb19a386", "§a§lL");
        keyP = ItemSkulls.getSkull("http://textures.minecraft.net/texture/a0a7989b5d6e621a121eedae6f476d35193c97c1a7cb8ecd43622a485dc2e912", "§a§lP");
        keyQ = ItemSkulls.getSkull("http://textures.minecraft.net/texture/43609f1faf81ed49c5894ac14c94ba52989fda4e1d2a52fd945a55ed719ed4", "§a§lQ");
        keyN = ItemSkulls.getSkull("http://textures.minecraft.net/texture/35b8b3d8c77dfb8fbd2495c842eac94fffa6f593bf15a2574d854dff3928", "§a§lN");
        keyY = ItemSkulls.getSkull("http://textures.minecraft.net/texture/c52fb388e33212a2478b5e15a96f27aca6c62ac719e1e5f87a1cf0de7b15e918", "§a§lY");
        keyO = ItemSkulls.getSkull("http://textures.minecraft.net/texture/d11de1cadb2ade61149e5ded1bd885edf0df6259255b33b587a96f983b2a1", "§a§lO");
        keyT = ItemSkulls.getSkull("http://textures.minecraft.net/texture/1562e8c1d66b21e459be9a24e5c027a34d269bdce4fbee2f7678d2d3ee4718", "§a§lT");
        keyM = ItemSkulls.getSkull("http://textures.minecraft.net/texture/49c45a24aaabf49e217c15483204848a73582aba7fae10ee2c57bdb76482f", "§a§lM");
        keyK = ItemSkulls.getSkull("http://textures.minecraft.net/texture/9461b38c8e45782ada59d16132a4222c193778e7d70c4542c9536376f37be42", "§a§lK");
        keyV = ItemSkulls.getSkull("http://textures.minecraft.net/texture/cc9a138638fedb534d79928876baba261c7a64ba79c424dcbafcc9bac7010b8", "§a§lV");
        keyZ = ItemSkulls.getSkull("http://textures.minecraft.net/texture/90582b9b5d97974b11461d63eced85f438a3eef5dc3279f9c47e1e38ea54ae8d", "§a§lZ");
        keyW = ItemSkulls.getSkull("http://textures.minecraft.net/texture/67e165c3edc5541d4654c4728871e6908f613fc0ec46e823c96eac82ac62e62", "§a§lW");

        // Symbols
        keySlash = ItemSkulls.getSkull("http://textures.minecraft.net/texture/7f95d7c1bbf3afa285d8d96757bb5572259a3ae854f5389dc53207699d94fd8", "§a§l/");
        keyExclamation = ItemSkulls.getSkull("http://textures.minecraft.net/texture/6a53bdd1545531c9ebb9c6f895bc576012f61820e6f489885988a7e8709a3f48", "§a§l!");
        keyQuestion = ItemSkulls.getSkull("http://textures.minecraft.net/texture/5163dafac1d91a8c91db576caac784336791a6e18d8f7f62778fc47bf146b6", "§a§l?");
        keyDot = ItemSkulls.getSkull("http://textures.minecraft.net/texture/733aa24916c88696ee71db7ac8cd306ad73096b5b6ffd868e1c384b1d62cfb3c", "§a§l.");
        keyDot2 = ItemSkulls.getSkull("http://textures.minecraft.net/texture/bd898c40e47c5d2d76924065360768065d624ee5b9ee0be9e12b98fb77c76", "§a§l:");
        key9 = ItemSkulls.getSkull("http://textures.minecraft.net/texture/e67caf7591b38e125a8017d58cfc6433bfaf84cd499d794f41d10bff2e5b840", "§a§l9");
        key3 = ItemSkulls.getSkull("http://textures.minecraft.net/texture/1d4eae13933860a6df5e8e955693b95a8c3b15c36b8b587532ac0996bc37e5", "§a§l3");
        key1 = ItemSkulls.getSkull("http://textures.minecraft.net/texture/71bc2bcfb2bd3759e6b1e86fc7a79585e1127dd357fc202893f9de241bc9e530", "§a§l1");
        key7 = ItemSkulls.getSkull("http://textures.minecraft.net/texture/6db6eb25d1faabe30cf444dc633b5832475e38096b7e2402a3ec476dd7b9", "§a§l7");
        key8 = ItemSkulls.getSkull("http://textures.minecraft.net/texture/59194973a3f17bda9978ed6273383997222774b454386c8319c04f1f4f74c2b5", "§a§l8");
        key2 = ItemSkulls.getSkull("http://textures.minecraft.net/texture/4cd9eeee883468881d83848a46bf3012485c23f75753b8fbe8487341419847", "§a§l2");
        key6 = ItemSkulls.getSkull("http://textures.minecraft.net/texture/334b36de7d679b8bbc725499adaef24dc518f5ae23e716981e1dcc6b2720ab", "§a§l6");
        key4 = ItemSkulls.getSkull("http://textures.minecraft.net/texture/d2e78fb22424232dc27b81fbcb47fd24c1acf76098753f2d9c28598287db5", "§a§l4");
        key5 = ItemSkulls.getSkull("http://textures.minecraft.net/texture/ef4ecf110b0acee4af1da343fb136f1f2c216857dfda6961defdbee7b9528", "§a§l5");
        key0 = ItemSkulls.getSkull("http://textures.minecraft.net/texture/d11de1cadb2ade61149e5ded1bd885edf0df6259255b33b587a96f983b2a1", "§a§l0");

        // ASCII
        keyArrowDown = ItemSkulls.getSkull("http://textures.minecraft.net/texture/2dadd755d08537352bf7a93e3bb7dd4d733121d39f2fb67073cd471f561194dd", "§a§l⬇");
        keyArrowUp = ItemSkulls.getSkull("http://textures.minecraft.net/texture/d48b768c623432dfb259fb3c3978e98dec111f79dbd6cd88f21155374b70b3c", "§a§l⬆");
        keyArrowLeft = ItemSkulls.getSkull("http://textures.minecraft.net/texture/3ebf907494a935e955bfcadab81beafb90fb9be49c7026ba97d798d5f1a23", "§a§l⬅");
        keyArrowRight = ItemSkulls.getSkull("http://textures.minecraft.net/texture/1b6f1a25b6bc199946472aedb370522584ff6f4e83221e5946bd2e41b5ca13b", "§a§l➡");

        keyGapOn = new ItemBuilder(Material.FLOWER_POT_ITEM)
                .setDisplayName("§a§l(")
                .setAmount(1)
                .build();

        keyGapOff = new ItemBuilder(Material.FLOWER_POT_ITEM)
                .setDisplayName("§a§l)")
                .setAmount(1)
                .build();

    }

    /**
     * Opens the alphabet inventory for a certain player.
     * @param player The player who should see the inventory.
     * @param language The language in which the interface should be.
     */
    public void openAlphabet(final Player player, final Language language) {
        Bukkit.getScheduler().runTaskAsynchronously(KeyboardPlugin.getInstance(), () -> {
            final Inventory inventory;
            switch (language) {
                default:
                case ENGLISH:
                    inventory = Bukkit.createInventory(null, 54, ALPHABET_TITLE_ENGLISH);
                    break;
                case FRENCH:
                    inventory = Bukkit.createInventory(null, 54, ALPHABET_TITLE_FRENCH);
                    break;
                case GERMAN:
                    inventory = Bukkit.createInventory(null, 54, ALPHABET_TITLE_GERMAN);
                    break;
            }
            final ItemBuilder resultItemTemplate = new ItemBuilder(Material.GLOWSTONE_DUST)
                    .setAmount(1)
                    .setGlow();
            final List<String> resultLore = new ArrayList<>();
            resultLore.add("§8➥ §7" + KeyboardAPI.getInstance().getKeyboardHandler().getMatchingKeyboard(player).getTypeResult());

            for (int i = 0; i < 54; i++)
                inventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setNoName().setAmount(1).build());

            final ItemBuilder spaceItemTemplate = new ItemBuilder(Material.STICK).setAmount(1);
            final ItemBuilder asciiItemTemplate = new ItemBuilder(Material.COAL).setAmount(1);
            final ItemBuilder symbolsItemTemplate = new ItemBuilder(Material.ITEM_FRAME).setAmount(1);
            final ItemBuilder doneItemTemplate = new ItemBuilder(Material.DIAMOND).setAmount(1);
            final ItemBuilder cancelItemTemplate = new ItemBuilder(Material.INK_SACK, (short) 1).setAmount(1);

            inventory.setItem(9, keyA);
            inventory.setItem(10, keyB);
            inventory.setItem(11, keyC);
            inventory.setItem(12, keyD);
            inventory.setItem(13, keyE);
            inventory.setItem(14, keyF);
            inventory.setItem(15, keyG);
            inventory.setItem(16, keyH);
            inventory.setItem(17, keyI);
            inventory.setItem(18, keyJ);
            inventory.setItem(19, keyK);
            inventory.setItem(20, keyL);
            inventory.setItem(21, keyM);
            inventory.setItem(22, keyN);
            inventory.setItem(23, keyO);
            inventory.setItem(24, keyP);
            inventory.setItem(25, keyQ);
            inventory.setItem(26, keyR);
            inventory.setItem(27, keyS);
            inventory.setItem(28, keyT);
            inventory.setItem(29, keyU);
            inventory.setItem(30, keyV);
            inventory.setItem(31, keyW);
            inventory.setItem(32, keyX);
            inventory.setItem(33, keyY);
            inventory.setItem(34, keyZ);
            switch (language) {
                case FRENCH:
                    inventory.setItem(35, resultItemTemplate.setDisplayName("§3Vos commentaires§8:").addLoreAll(resultLore).build());
                    inventory.setItem(45, symbolsItemTemplate.setDisplayName(ITEM_SYMBOLS_FRENCH).build());
                    inventory.setItem(46, asciiItemTemplate.setDisplayName(ITEM_ASCII_FRENCH).build());
                    inventory.setItem(48, spaceItemTemplate.setDisplayName(ITEM_SPACE_FRENCH).build());
                    inventory.setItem(49, spaceItemTemplate.setDisplayName(ITEM_SPACE_FRENCH).build());
                    inventory.setItem(50, spaceItemTemplate.setDisplayName(ITEM_SPACE_FRENCH).build());
                    inventory.setItem(53, doneItemTemplate.setDisplayName(ITEM_DONE_FRENCH).addLoreAll(LORE_FRENCH_DONE).build());
                    inventory.setItem(44, cancelItemTemplate.setDisplayName(ITEM_CANCEL_FRENCH).build());
                    break;
                case GERMAN:
                    inventory.setItem(35, resultItemTemplate.setDisplayName("§3Deine Eingabe§8:").addLoreAll(resultLore).build());
                    inventory.setItem(45, symbolsItemTemplate.setDisplayName(ITEM_SYMBOLS_GERMAN).build());
                    inventory.setItem(46, asciiItemTemplate.setDisplayName(ITEM_ASCII_GERMAN).build());
                    inventory.setItem(48, spaceItemTemplate.setDisplayName(ITEM_SPACE_GERMAN).build());
                    inventory.setItem(49, spaceItemTemplate.setDisplayName(ITEM_SPACE_GERMAN).build());
                    inventory.setItem(50, spaceItemTemplate.setDisplayName(ITEM_SPACE_GERMAN).build());
                    inventory.setItem(53, doneItemTemplate.setDisplayName(ITEM_DONE_GERMAN).addLoreAll(LORE_GERMAN_DONE).build());
                    inventory.setItem(44, cancelItemTemplate.setDisplayName(ITEM_CANCEL_GERMAN).build());
                    break;
                case ENGLISH:
                    inventory.setItem(35, resultItemTemplate.setDisplayName("§3Your input§8:").addLoreAll(resultLore).build());
                    inventory.setItem(45, symbolsItemTemplate.setDisplayName(ITEM_SYMBOLS_ENGLISH).build());
                    inventory.setItem(46, asciiItemTemplate.setDisplayName(ITEM_ASCII_ENGLISH).build());
                    inventory.setItem(48, spaceItemTemplate.setDisplayName(ITEM_SPACE_ENGLISH).build());
                    inventory.setItem(49, spaceItemTemplate.setDisplayName(ITEM_SPACE_ENGLISH).build());
                    inventory.setItem(50, spaceItemTemplate.setDisplayName(ITEM_SPACE_ENGLISH).build());
                    inventory.setItem(53, doneItemTemplate.setDisplayName(ITEM_DONE_ENGLISH).addLoreAll(LORE_ENGLISH_DONE).build());
                    inventory.setItem(44, cancelItemTemplate.setDisplayName(ITEM_CANCEL_ENGLISH).build());
                    break;
            }
            playerKeyboardInventories.remove(player.getUniqueId());
            player.openInventory(inventory);
            Bukkit.getScheduler().runTaskLater(KeyboardPlugin.getInstance(), () -> playerKeyboardInventories.put(player.getUniqueId(), inventory), 1L);
        });
    }

    /**
     * Opens the menu to select symbols from the ASCII
     * @param player The player who should see the inventory.
     * @param language In which language should the inventory be displayed?
     */
    public void openAsciiMenu(final Player player, final Language language) {
        Bukkit.getScheduler().runTaskAsynchronously(KeyboardPlugin.getInstance(), () -> {
            final Inventory inventory;
            switch (language) {
                default:
                case ENGLISH:
                    inventory = Bukkit.createInventory(null, 54, ASCII_TITLE_ENGLISH);
                    break;
                case GERMAN:
                    inventory = Bukkit.createInventory(null, 54, ASCII_TITLE_ENGLISH + "");
                    break;
                case FRENCH:
                    inventory = Bukkit.createInventory(null, 54, ASCII_TITLE_ENGLISH);
                    break;
            }

            final ItemBuilder resultItemTemplate = new ItemBuilder(Material.GLOWSTONE_DUST)
                    .setAmount(1)
                    .setGlow();
            final List<String> resultLore = new ArrayList<>();
            resultLore.add("§8➥ §7" + KeyboardAPI.getInstance().getKeyboardHandler().getMatchingKeyboard(player).getTypeResult());

            final ItemBuilder spaceItemTemplate = new ItemBuilder(Material.STICK).setAmount(1);
            final ItemBuilder alphabetItemTemplate = new ItemBuilder(Material.SKULL_ITEM).setAmount(1);
            final ItemBuilder symbolsItemTemplate = new ItemBuilder(Material.ITEM_FRAME).setAmount(1);
            final ItemBuilder doneItemTemplate = new ItemBuilder(Material.DIAMOND).setAmount(1);
            final ItemBuilder cancelItemTemplate = new ItemBuilder(Material.INK_SACK, (short) 1).setAmount(1);

            for (int i = 0; i < 54; i++)
                inventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7, 1).setNoName().build());

            inventory.setItem(10, keyArrowDown);
            inventory.setItem(11, keyArrowUp);
            inventory.setItem(12, keyArrowLeft);
            inventory.setItem(13, keyArrowRight);

            switch (language) {
                case FRENCH:
                    inventory.setItem(35, resultItemTemplate.setDisplayName("§3Vos commentaires§8: ").addLoreAll(resultLore).build());
                    inventory.setItem(45, symbolsItemTemplate.setDisplayName(ITEM_SYMBOLS_FRENCH).build());
                    inventory.setItem(46, alphabetItemTemplate.setDisplayName(ITEM_ALPHABET_FRENCH).build());
                    inventory.setItem(48, spaceItemTemplate.setDisplayName(ITEM_SPACE_FRENCH).build());
                    inventory.setItem(49, spaceItemTemplate.setDisplayName(ITEM_SPACE_FRENCH).build());
                    inventory.setItem(50, spaceItemTemplate.setDisplayName(ITEM_SPACE_FRENCH).build());
                    inventory.setItem(53, doneItemTemplate.setDisplayName(ITEM_DONE_FRENCH).addLoreAll(LORE_FRENCH_DONE).build());
                    inventory.setItem(44, cancelItemTemplate.setDisplayName(ITEM_CANCEL_FRENCH).build());
                    break;
                case GERMAN:
                    inventory.setItem(35, resultItemTemplate.setDisplayName("§3Deine Eingabe§8: ").addLoreAll(resultLore).build());
                    inventory.setItem(45, symbolsItemTemplate.setDisplayName(ITEM_SYMBOLS_GERMAN).build());
                    inventory.setItem(46, alphabetItemTemplate.setDisplayName(ITEM_ALPHABET_GERMAN).build());
                    inventory.setItem(48, spaceItemTemplate.setDisplayName(ITEM_SPACE_GERMAN).build());
                    inventory.setItem(49, spaceItemTemplate.setDisplayName(ITEM_SPACE_GERMAN).build());
                    inventory.setItem(50, spaceItemTemplate.setDisplayName(ITEM_SPACE_GERMAN).build());
                    inventory.setItem(53, doneItemTemplate.setDisplayName(ITEM_DONE_GERMAN).addLoreAll(LORE_GERMAN_DONE).build());
                    inventory.setItem(44, cancelItemTemplate.setDisplayName(ITEM_CANCEL_GERMAN).build());
                    break;
                case ENGLISH:
                    inventory.setItem(35, resultItemTemplate.setDisplayName("§3Your input§8:").addLoreAll(resultLore).build());
                    inventory.setItem(45, symbolsItemTemplate.setDisplayName(ITEM_SYMBOLS_ENGLISH).build());
                    inventory.setItem(46, alphabetItemTemplate.setDisplayName(ITEM_ALPHABET_ENGLISH).build());
                    inventory.setItem(48, spaceItemTemplate.setDisplayName(ITEM_SPACE_ENGLISH).build());
                    inventory.setItem(49, spaceItemTemplate.setDisplayName(ITEM_SPACE_ENGLISH).build());
                    inventory.setItem(50, spaceItemTemplate.setDisplayName(ITEM_SPACE_ENGLISH).build());
                    inventory.setItem(53, doneItemTemplate.setDisplayName(ITEM_DONE_ENGLISH).addLoreAll(LORE_ENGLISH_DONE).build());
                    inventory.setItem(44, cancelItemTemplate.setDisplayName(ITEM_CANCEL_ENGLISH).build());
                    break;
            }
            playerKeyboardInventories.remove(player.getUniqueId());
            player.openInventory(inventory);
            Bukkit.getScheduler().runTaskLater(KeyboardPlugin.getInstance(), () -> playerKeyboardInventories.put(player.getUniqueId(), inventory), 1L);
        });
    }

    /**
     * Opens the menu with a selection of many different symbols
     * and numbers (from 1-9).
     * @param player The player who should see the inventory.
     * @param language In which language should the inventory be displayed?
     */
    public void openSymbolsMenu(final Player player, final Language language) {
        Bukkit.getScheduler().runTaskAsynchronously(KeyboardPlugin.getInstance(), () -> {
            final Inventory inventory;
            switch (language) {
                default:
                case ENGLISH:
                    inventory = Bukkit.createInventory(null, 54, SYMBOLS_TITLE_ENGLISH + "");
                    break;
                case GERMAN:
                    inventory = Bukkit.createInventory(null, 54, SYMBOLS_TITLE_ENGLISH);
                    break;
                case FRENCH:
                    inventory = Bukkit.createInventory(null, 54, SYMBOLS_TITLE_ENGLISH);
                    break;
            }

            final ItemBuilder resultItemTemplate = new ItemBuilder(Material.GLOWSTONE_DUST)
                    .setAmount(1)
                    .setGlow();
            final List<String> resultLore = new ArrayList<>();
            resultLore.add("§8➥ §7" + KeyboardAPI.getInstance().getKeyboardHandler().getMatchingKeyboard(player).getTypeResult());

            final ItemBuilder spaceItemTemplate = new ItemBuilder(Material.STICK).setAmount(1);
            final ItemBuilder alphabetItemTemplate = new ItemBuilder(Material.SKULL_ITEM).setAmount(1);
            final ItemBuilder asciiItemTemplate = new ItemBuilder(Material.COAL).setAmount(1);
            final ItemBuilder doneItemTemplate = new ItemBuilder(Material.DIAMOND).setAmount(1);
            final ItemBuilder cancelItemTemplate = new ItemBuilder(Material.INK_SACK, (short) 1).setAmount(1);

            for (int i = 0; i < 54; i++)
                inventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7, 1).setNoName().build());

            inventory.setItem(10, key1);
            inventory.setItem(11, key2);
            inventory.setItem(12, key3);
            inventory.setItem(13, key4);
            inventory.setItem(14, key5);
            inventory.setItem(15, key6);
            inventory.setItem(16, key7);

            inventory.setItem(19, key8);
            inventory.setItem(20, key9);
            inventory.setItem(21, key0);
            inventory.setItem(22, keyDot);
            inventory.setItem(23, keyExclamation);
            inventory.setItem(24, keyQuestion);
            inventory.setItem(25, keySlash);

            inventory.setItem(28, keyDot2);
            inventory.setItem(29, keyGapOff);
            inventory.setItem(30, keyGapOn);


            switch (language) {
                case FRENCH:
                    inventory.setItem(35, resultItemTemplate.setDisplayName("§3Vos commentaires§8:").addLoreAll(resultLore).build());
                    inventory.setItem(45, asciiItemTemplate.setDisplayName(ITEM_ASCII_FRENCH).build());
                    inventory.setItem(46, alphabetItemTemplate.setDisplayName(ITEM_ALPHABET_FRENCH).build());
                    inventory.setItem(48, spaceItemTemplate.setDisplayName(ITEM_SPACE_FRENCH).build());
                    inventory.setItem(49, spaceItemTemplate.setDisplayName(ITEM_SPACE_FRENCH).build());
                    inventory.setItem(50, spaceItemTemplate.setDisplayName(ITEM_SPACE_FRENCH).build());
                    inventory.setItem(53, doneItemTemplate.setDisplayName(ITEM_DONE_FRENCH).addLoreAll(LORE_FRENCH_DONE).build());
                    inventory.setItem(44, cancelItemTemplate.setDisplayName(ITEM_CANCEL_FRENCH).build());
                    break;
                case GERMAN:
                    inventory.setItem(35, resultItemTemplate.setDisplayName("§3Deine Eingabe§8: ").addLoreAll(resultLore).build());
                    inventory.setItem(45, asciiItemTemplate.setDisplayName(ITEM_ASCII_GERMAN).build());
                    inventory.setItem(46, alphabetItemTemplate.setDisplayName(ITEM_ALPHABET_GERMAN).build());
                    inventory.setItem(48, spaceItemTemplate.setDisplayName(ITEM_SPACE_GERMAN).build());
                    inventory.setItem(49, spaceItemTemplate.setDisplayName(ITEM_SPACE_GERMAN).build());
                    inventory.setItem(50, spaceItemTemplate.setDisplayName(ITEM_SPACE_GERMAN).build());
                    inventory.setItem(53, doneItemTemplate.setDisplayName(ITEM_DONE_GERMAN).addLoreAll(LORE_GERMAN_DONE).build());
                    inventory.setItem(44, cancelItemTemplate.setDisplayName(ITEM_CANCEL_GERMAN).build());
                    break;
                case ENGLISH:
                    inventory.setItem(35, resultItemTemplate.setDisplayName("§3Your input§8:").addLoreAll(resultLore).build());
                    inventory.setItem(45, asciiItemTemplate.setDisplayName(ITEM_ASCII_ENGLISH).build());
                    inventory.setItem(46, alphabetItemTemplate.setDisplayName(ITEM_ALPHABET_ENGLISH).build());
                    inventory.setItem(48, spaceItemTemplate.setDisplayName(ITEM_SPACE_ENGLISH).build());
                    inventory.setItem(49, spaceItemTemplate.setDisplayName(ITEM_SPACE_ENGLISH).build());
                    inventory.setItem(50, spaceItemTemplate.setDisplayName(ITEM_SPACE_ENGLISH).build());
                    inventory.setItem(53, doneItemTemplate.setDisplayName(ITEM_DONE_ENGLISH).addLoreAll(LORE_ENGLISH_DONE).build());
                    inventory.setItem(44, cancelItemTemplate.setDisplayName(ITEM_CANCEL_ENGLISH).build());
                    break;
            }
            playerKeyboardInventories.remove(player.getUniqueId());
            player.openInventory(inventory);
            Bukkit.getScheduler().runTaskLater(KeyboardPlugin.getInstance(), () -> playerKeyboardInventories.put(player.getUniqueId(), inventory), 1L);
        });
    }

    /**
     * Updates the item with the lore which contains the type result.
     * @param player The player whose keyboard should be updated.
     * @param newContent The new letter or letters that should be appended to the result.
     */
    public void updateTypeResult(final Player player, final String newContent) {
        final Inventory inventory = playerKeyboardInventories.get(player.getUniqueId());
        final String inputBefore = inventory.getItem(35).getItemMeta().getLore().get(0);
        final String toUpdate = inputBefore.replace("§8➥ §7", "") + newContent;
        final Language language = KeyboardAPI.getInstance().getKeyboardHandler().getMatchingKeyboard(player).getLanguage();
        switch (language) {
            case ENGLISH:
                inventory.setItem(35, new ItemBuilder(Material.GLOWSTONE_DUST).addLoreAll(Collections.singletonList("§8➥ §7" + toUpdate)).setDisplayName("§3Your input").setGlow().build());
                break;
            case FRENCH:
                inventory.setItem(35, new ItemBuilder(Material.GLOWSTONE_DUST).addLoreAll(Collections.singletonList("§8➥ §7" + toUpdate)).setDisplayName("§3Vos commentaires§8:").setGlow().build());
                break;
            case GERMAN:
                inventory.setItem(35, new ItemBuilder(Material.GLOWSTONE_DUST).addLoreAll(Collections.singletonList("§8➥ §7" + toUpdate)).setDisplayName("§3Deine Eingabe§8:").setGlow().build());
                break;
        }
    }

}
