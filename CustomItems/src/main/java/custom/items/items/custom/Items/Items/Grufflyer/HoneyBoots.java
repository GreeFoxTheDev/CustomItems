package custom.items.items.custom.Items.Items.Grufflyer;

import org.bukkit.Bukkit;
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

public class HoneyBoots extends JavaPlugin {
    public static ItemStack compressedSugar; //compressed sugar 2 should make nausea effect (LSD)
    public static ItemStack compressedSugar1;
    public static ItemStack compressedSugar2;
    public static ItemStack compressedHoney;
    public static ItemStack compressedHoney1;
    public static ItemStack compressedHoney2;
    public static ItemStack honeyBoots;

    public static void init() {
        createCompressedSugar();
        createCompressedSugar1();
        createCompressedSugar2();
        createCompressedHoney();
        createCompressedHoney1();
        createCompressedHoney2();
        createHoneyBoots();
    }

    private static void createCompressedSugar() {
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fSlightly Compressed Sugar");
        im.setLocalizedName("sugar_0");
        item.setItemMeta(im);
        compressedSugar = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_sugar"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', Material.SUGAR);
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedSugar1() {
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§6§lMore Compressed Sugar");
        im.setLocalizedName("sugar_1");
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedSugar1 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_sugar1"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedSugar));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedSugar2() {
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§f§lCompressed Sugar");
        im.setLocalizedName("sugar_2");
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedSugar2 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_sugar2"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedSugar1));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedHoney() {
        ItemStack item = new ItemStack(Material.HONEYCOMB);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fSlightly Compressed Honeycomb");
        im.setLocalizedName("honey");
        item.setItemMeta(im);
        compressedHoney = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_honey"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', Material.HONEYCOMB);
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedHoney1() {
        ItemStack item = new ItemStack(Material.HONEYCOMB);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§f§lMore Compressed Honeycomb");
        im.setLocalizedName("honey_1");
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedHoney1 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_honey1"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedHoney));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedHoney2() {
        ItemStack item = new ItemStack(Material.HONEYCOMB);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§6§lCompressed Honeycomb");
        im.setLocalizedName("honey_2");
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedHoney2 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_honey2"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedHoney1));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createHoneyBoots() {
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§b§lHoney Boots");
        im.setLocalizedName("honey_boots");
        List<String> lores = new ArrayList<>();
        lores.add("§6Boots made of compressed sugar");
        lores.add("§5Gives you speed 1 and no fall damage");
        lores.add("§5and also" + "§f§l NO HUNGER");
        im.setLore(lores);
        im.addEnchant(Enchantment.PROTECTION_FALL, 50, true);
        im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.setUnbreakable(true);
        item.setItemMeta(im);
        honeyBoots = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("honey_boots"), item);
        sr.shape("XZX", "ZYZ", "XZX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedSugar2));
        sr.setIngredient('Y', new RecipeChoice.MaterialChoice(Material.GOLDEN_BOOTS));
        sr.setIngredient('Z', new RecipeChoice.ExactChoice(compressedHoney2));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }
}
