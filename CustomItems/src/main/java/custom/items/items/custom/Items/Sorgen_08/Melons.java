package custom.items.items.custom.Items.Sorgen_08;

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

public class Melons extends JavaPlugin {

    public static ItemStack compressedMelon;
    public static ItemStack compressedMelon1;
    public static ItemStack compressedMelon2;
    public static ItemStack compressedMelon3;
    public static ItemStack compressedMelon4;
    public static ItemStack melonSlice;
    public static ItemStack melonAx;

    public static void init() {
        createCompressedMelon();
        createCompressedMelon1();
        createCompressedMelon2();
        createCompressedMelon3();
        createCompressedMelon4();
        createMelonAx();
        createSlice();
    }

    private static void createCompressedMelon() {
        ItemStack item = new ItemStack(Material.MELON, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fA little compressed melon");
        im.setLocalizedName("compressedMelon");
        List<String> lores = new ArrayList<String>();
        lores.add("§5Little bit compressed melon.");
        lores.add("");
        lores.add(ChatColor.GREEN + "Usable to craft" + "§b§lMore");
        lores.add("§b§lCompressed Melon!");
        im.setLore(lores);
        item.setItemMeta(im);
        compressedMelon = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_melon"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', Material.MELON);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createCompressedMelon1() {
        ItemStack item = new ItemStack(Material.MELON, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§b§lMore Compressed Melon");
        im.setLocalizedName("compressedMelon1");
        List<String> lores = new ArrayList<String>();
        lores.add("§5More compressed melon!");
        lores.add("");
        lores.add(ChatColor.GREEN + "Usable to craft" + "§a§lKinda");
        lores.add("§a§lGoodly Compressed Melon!");
        im.setLore(lores);
        im.addEnchant(Enchantment.LUCK, 1, false);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedMelon1 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_melon1"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedMelon));
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createCompressedMelon2() {
        ItemStack item = new ItemStack(Material.MELON, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§a§lKinda goodly compressed melon.");
        im.setLocalizedName("compressedMelon2");
        List<String> lores = new ArrayList<String>();
        lores.add("§5You are taking MelonAx seriously");
        lores.add("§5and making kinda good progress!");
        lores.add("");
        lores.add(ChatColor.GREEN + "Usable to craft" + "§e§lVery");
        lores.add("§e§lCompressed Melon!");
        im.setLore(lores);
        im.addEnchant(Enchantment.LUCK, 1, false);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedMelon2 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_melon2"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedMelon1));
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createCompressedMelon3() {
        ItemStack item = new ItemStack(Material.MELON, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§e§lVery Compressed Melon");
        List<String> lores = new ArrayList<String>();
        lores.add("§5You are NoLife,");
        lores.add("§5change my mind");
        lores.add("");
        lores.add(ChatColor.GREEN + "Usable to craft" + ChatColor.BOLD + ChatColor.WHITE + "FINAL MELON");
        lores.add(ChatColor.GREEN + "or" + "§lMelonAx");
        im.setLore(lores);
        im.addEnchant(Enchantment.LUCK, 1, false);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedMelon3 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_melon3"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedMelon2));
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createCompressedMelon4() {
        ItemStack item = new ItemStack(Material.MELON, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§f§lFINAL MELON");
        List<String> lores = new ArrayList<String>();
        lores.add("§6I CAN FEEL THE");
        lores.add("§l§4POWER!!!");
        lores.add("");
        lores.add(ChatColor.GRAY + "Carry only 1 at the time,");
        lores.add(ChatColor.GRAY + "they're really heavy!");
        im.setLore(lores);
        im.addEnchant(Enchantment.LUCK, 1, false);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        compressedMelon4 = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_melon_final"), item);
        sr.shape("XXX", "XYX", "XXX");
        sr.setIngredient('Y', Material.NETHERITE_INGOT);
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedMelon3));
        Bukkit.addRecipe(sr);
    }

    private static void createSlice() {
        ItemStack item = new ItemStack(Material.GLISTERING_MELON_SLICE, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§f§lFINAL SLICE");
        List<String> lores = new ArrayList<String>();
        lores.add("§5Right Click to see it c:");
        im.setLore(lores);

        im.addEnchant(Enchantment.LUCK, 1, true);
        im.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        im.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        im.addEnchant(Enchantment.KNOCKBACK, 5, true);
        //im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        melonSlice = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("melon_slice"), item);
        sr.shape("   ", " X ", "   ");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedMelon4));
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createMelonAx() {
        ItemStack item = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§lMelonAx");
        List<String> lores = new ArrayList<String>();
        lores.add("§3This axe is made of"); //lore, line 1
        lores.add("§3REALLY compressed melons!"); //lore, line 2
        im.setLore(lores); //add the lores of course
        im.setUnbreakable(true);
        im.setCustomModelData(1);
        im.addEnchant(Enchantment.ARROW_INFINITE, 10, true);
        im.addEnchant(Enchantment.DIG_SPEED, 10, true);
        im.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        im.addEnchant(Enchantment.SILK_TOUCH, 10, true);

        item.setItemMeta(im);
        melonAx = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("melon_ax"), item);
        sr.shape("XXX", "XYX", " Z ");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedMelon3));
        sr.setIngredient('Y', Material.STICK);
        sr.setIngredient('Z', Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(sr);
    }
}