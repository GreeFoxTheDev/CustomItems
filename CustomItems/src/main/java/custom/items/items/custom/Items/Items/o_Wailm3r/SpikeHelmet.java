package custom.items.items.custom.Items.Items.o_Wailm3r;

import custom.items.items.custom.Items.CustomItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class SpikeHelmet extends JavaPlugin {
    public static ItemStack compressedCactus;
    public static ItemStack compressedCactus1;
    public static ItemStack compressedCactus2;
    public static ItemStack compressedCactus3;
    public static ItemStack cactusHelmet;
    CustomItems plugin;
    public SpikeHelmet(CustomItems plugin) {
        this.plugin = plugin;
    }

    public static void init() {
        createCompressedCactus();
        createCompressedCactus1();
        createCompressedCactus2();
        createCompressedCactus3();
        createCactusBomber();
        createCactusHelmet();
    }

    private static void createCompressedCactus() {
        ItemStack item = new ItemStack(Material.CACTUS);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.DARK_PURPLE + "§lCompressed Cactus");
        im.setLocalizedName("compressed_cactus");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "This is your first compressed cacti!");
        lore.add("");
        lore.add(ChatColor.GREEN + "Usable to craft");
        lore.add(ChatColor.GOLD + String.valueOf(ChatColor.BOLD) + "More Compressed Cactus");
        im.setLore(lore);
        item.setItemMeta(im);
        compressedCactus = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_cactus"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', Material.CACTUS);
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedCactus1() {
        ItemStack item = new ItemStack(Material.CACTUS);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.GOLD + "§lMore Compressed Cactus");
        im.setLocalizedName("compressed_cactus1");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "You're taking is seriously?");
        lore.add("");
        lore.add(ChatColor.GREEN + "Usable to craft" + ChatColor.DARK_AQUA + ChatColor.BOLD + "Really");
        lore.add(ChatColor.GREEN + String.valueOf(ChatColor.DARK_AQUA) + ChatColor.BOLD + " Compressed Cactus");
        im.setLore(lore);
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedCactus1 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_sugar1"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedCactus));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedCactus2() {
        ItemStack item = new ItemStack(Material.CACTUS);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.DARK_AQUA + "§lReally Compressed Cactus");
        im.setLocalizedName("compressed_cactus2");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "Have a cactus farm?");
        lore.add("");
        lore.add(ChatColor.GREEN + "Usable to craft" + ChatColor.DARK_GREEN + ChatColor.BOLD + "FINAL");
        lore.add(ChatColor.GREEN + String.valueOf(ChatColor.DARK_GREEN) + ChatColor.BOLD + " CACTUS");
        im.setLore(lore);
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedCactus2 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_sugar2"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedCactus1));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedCactus3() {
        ItemStack item = new ItemStack(Material.CACTUS, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.DARK_GREEN + "§lFINAL CACTUS");
        im.setLocalizedName("compressed_cactus3");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "On a good way!");
        lore.add("");
        lore.add(ChatColor.GREEN + "Usable to craft" + ChatColor.DARK_GREEN + ChatColor.BOLD + " Spike Helmet!");
        im.setLore(lore);
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedCactus3 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_cactus3"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedCactus2));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }


    private static void createCactusHelmet() {
        ItemStack item = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta im = item.getItemMeta();
        im.setCustomModelData(1000879);
        im.setDisplayName(ChatColor.DARK_GREEN + "§lSpike Helmet");
        im.setLocalizedName("spike_helmet");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "Gives Strength I + Thorns V");
        lore.add("");
        im.setLore(lore);
        im.addEnchant(Enchantment.THORNS, 5, true);
        im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 20, true);
        item.setItemMeta(im);
        cactusHelmet = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("spike_helmet"), item);
        sr.shape("XXX", "XYX", "AZA");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedCactus3));
        sr.setIngredient('Y', Material.NETHERITE_INGOT);
        sr.setIngredient('Z', Material.MUSIC_DISC_OTHERSIDE);
        sr.setIngredient('A', Material.MUSIC_DISC_CAT);
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }
    public static ItemStack cactusBomber;
    private static void createCactusBomber() {
        ItemStack item = new ItemStack(Material.CACTUS);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.DARK_GREEN + "§lSpike Bomber");
        im.setLocalizedName("cactus_bomber");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "BOOM!!!");
        lore.add("");
        im.setLore(lore);
        im.addEnchant(Enchantment.THORNS, 5, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        cactusBomber = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("cactus_bomber"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedCactus3));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }
}

