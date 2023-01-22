package custom.items.items.custom.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class HoneyBoots extends JavaPlugin {
    public static void init(){
        createCompressedSugar();
        createCompressedSugar1();
        createCompressedSugar2();
        createCompressedHoney();
        createCompressedHoney1();
        createCompressedHoney2();
        createHoneyBoots();
    }
    public static ItemStack compressedSugar; //compressed sugar 2 should make nausea effect (LSD)
    private static void createCompressedSugar(){
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fSlightly Compressed Sugar");
        item.setItemMeta(im);
        compressedSugar = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_sugar"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', Material.SUGAR);
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack compressedSugar1;
    private static void createCompressedSugar1(){
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§6§lMore Compressed Sugar");
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedSugar1 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_sugar1"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedSugar));
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack compressedHoney;
    private static void createCompressedHoney() {
        ItemStack item = new ItemStack(Material.HONEYCOMB);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fSlightly Compressed Honeycomb");
        item.setItemMeta(im);
        compressedHoney = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_honey"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', Material.HONEYCOMB);
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack compressedHoney1;
    private static void createCompressedHoney1() {
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§f§lMore Compressed Honeycomb");
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedHoney1 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_honey1"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedHoney));
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack compressedHoney2;
    private static void createCompressedHoney2() {
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§6§lCompressed Honeycomb");
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedHoney1 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_honey2"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedHoney1));
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack compressedSugar2;
    private static void createCompressedSugar2() {
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§f§lCompressed Sugar");
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedSugar2 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_sugar2"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedSugar1));
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack honeyBoots;
    private static void createHoneyBoots(){
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§b§lHoney Boots");
        List<String> lores = new ArrayList<String>();
        lores.add("§6Boots made of compressed sugar");
        lores.add("§5Gives you speed 1 and no fall damage");
        lores.add("§5and also"+"§f§l NO HUNGER");
        im.setLore(lores);
        im.addEnchant(Enchantment.PROTECTION_FALL, 50, true);
        im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.setUnbreakable(true);
        item.setItemMeta(im);
        honeyBoots = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("honey_boots"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', Material.SUGAR);
        //sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedSugar2));
        //sr.setIngredient('Y', Material.GOLDEN_BOOTS);
        //sr.setIngredient('Z', new RecipeChoice.ExactChoice(compressedHoney2));
        //sr.setIngredient('A', Material.SUGAR);
        Bukkit.getServer().addRecipe(sr);
    }
}
