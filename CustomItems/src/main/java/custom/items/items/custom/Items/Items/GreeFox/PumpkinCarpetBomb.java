package custom.items.items.custom.Items.Items.GreeFox;

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

public class PumpkinCarpetBomb extends JavaPlugin {
    public static ItemStack compressedPumpkin;
    public static ItemStack compressedPumpkin1;
    public static ItemStack compressedPumpkin2;
    public static ItemStack compressedPumpkin3;
    public static ItemStack compressedPumpkin4;

    public static void init() {
        createCompressedPumpkin();
        createCompressedPumpkin1();
        createCompressedPumpkin2();
        createCompressedPumpkin3();
        createCompressedPumpkin4();
    }

    private static void createCompressedPumpkin() {
        ItemStack item = new ItemStack(Material.PUMPKIN);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + "Compressed Pumpkin");
        im.setLocalizedName("compressed_pumpkin");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GOLD + "First one! Only " + ChatColor.YELLOW + "§l3" + " to go!");
        lore.add("");
        im.setLore(lore);
        item.setItemMeta(im);
        compressedPumpkin = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_pumpkin"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', Material.PUMPKIN);
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedPumpkin1() {
        ItemStack item = new ItemStack(Material.PUMPKIN);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + "More Compressed Pumpkin");
        im.setLocalizedName("compressed_pumpkin_1");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GOLD + "Woah, you really want to");
        lore.add(ChatColor.GOLD + "create " + ChatColor.WHITE + "Really Compressed Pumpkin");
        lore.add("");
        im.setLore(lore);
        item.setItemMeta(im);
        compressedPumpkin1 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_pumpkin1"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedPumpkin));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedPumpkin2() {
        ItemStack item = new ItemStack(Material.PUMPKIN);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + "Really Compressed Pumpkin");
        im.setLocalizedName("compressed_pumpkin_2");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GOLD + "Now you can craft " + ChatColor.WHITE + "Really Really Compressed Pumpkin!");
        lore.add("");
        im.setLore(lore);
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedPumpkin2 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_pumpkin2"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedPumpkin1));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedPumpkin3() {
        ItemStack item = new ItemStack(Material.PUMPKIN);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + "Really Really Compressed Pumpkin");
        im.setLocalizedName("compressed_pumpkin_3");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GOLD + "Use to create " + ChatColor.GOLD + "§lFINAL PUMPKIN");
        lore.add("");
        im.setLore(lore);
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedPumpkin3 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_pumpkin3"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedPumpkin2));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }

    private static void createCompressedPumpkin4() {
        ItemStack item = new ItemStack(Material.PUMPKIN);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.GOLD + "§lFINAL PUMPKIN");
        im.setLocalizedName("compressed_pumpkin_4");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GOLD + "This is a carpet bomb!");
        lore.add("");
        lore.add(ChatColor.GOLD + "Proceed with caution!!!");
        lore.add("");
        im.setLore(lore);
        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedPumpkin4 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_pumpkin4"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedPumpkin3));
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {
        }
    }
}
