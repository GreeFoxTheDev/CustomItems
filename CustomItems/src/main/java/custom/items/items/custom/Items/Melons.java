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

public class Melons extends JavaPlugin {

    public static void init() {
        createCompressedMelon();
        createCompressedMelon1();
        createCompressedMelon2();
        createCompressedMelon3();
        createCompressedMelon4();
        createMelonAx();
        createSlice();
    }
    public static ItemStack compressedMelon;
    //first compression
    private static void createCompressedMelon(){
        ItemStack item = new ItemStack(Material.MELON, 1); //material
        ItemMeta im = item.getItemMeta(); //sets itemmeta for later purposes
        im.setDisplayName("§fA little compressed melon"); //sets the name
        List<String> lores = new ArrayList<String>(); //sets string for lores
        lores.add("§5Little bit compressed melon."); //the actual lore
        im.setLore(lores); //sets the lore
        item.setItemMeta(im); //sets the Meta
        compressedMelon = item; //says that compressedMelon is item I define before
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("compressed_melon0"), item); //recipe
        sr.shape("XXX", "XXX", "XXX"); //shape of recipe, in rows
        sr.setIngredient('X', Material.MELON); //Ingredient
        Bukkit.getServer().addRecipe(sr); //of course adds the recipe to plugin
    }
    public static ItemStack compressedMelon1;
    //second compression
    private static void createCompressedMelon1(){
        ItemStack item = new ItemStack(Material.MELON, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§b§lMore Compressed Melon");
        List<String> lores = new ArrayList<String>();
        lores.add("§5More compressed melon!");
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
    public static ItemStack compressedMelon2;
    //third compression
    private static void createCompressedMelon2(){
        ItemStack item = new ItemStack(Material.MELON, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§a§lKinda goodly compressed melon.");
        List<String> lores = new ArrayList<String>();
        lores.add("§5You are taking MelonAx seriously");
        lores.add("§5and making kinda good progress!");
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
    public static ItemStack compressedMelon3;
    private static void createCompressedMelon3(){
        ItemStack item = new ItemStack(Material.MELON, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§e§lVery Compressed Melon");
        List<String> lores = new ArrayList<String>();
        lores.add("§5You are NoLife,");
        lores.add("§5change my mind");
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
    public static ItemStack compressedMelon4;
    private static void createCompressedMelon4(){
        ItemStack item = new ItemStack(Material.MELON, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§f§lFINAL MELON");
        List<String>lores = new ArrayList<String>();
        lores.add("§6I CAN FELL THE");
        lores.add("§l§4POWER!!!");
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
    public static ItemStack melonSlice;
    private static void createSlice(){
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
    public static ItemStack melonAx;
    private static void createMelonAx(){
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

        //im.addEnchant(Enchantment.LUCK, 1, false);
        item.setItemMeta(im);
        melonAx = item;
        /*SmithingRecipe smr = new SmithingRecipe(NamespacedKey.minecraft("melon_ax"), item,
                new RecipeChoice.MaterialChoice(Material.NETHERITE_AXE), new RecipeChoice.ExactChoice(compressedMelon4));
        Bukkit.getServer().addRecipe(smr);*/ //doesn't work for some reason
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("melon_ax_craft"), item);
        sr.shape("XXX", "XYX", " Z ");
        sr.setIngredient('X', new RecipeChoice.ExactChoice(compressedMelon4));
        sr.setIngredient('Y', Material.STICK);
        sr.setIngredient('Z', Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(sr);
    }
}