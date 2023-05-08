package custom.items.items.custom.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class WarAxe {
    public static void init() {
        createWarAxe();
        createLongStick();
    }

    public static ItemStack longStick;

    private static void createLongStick() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fLong Stick");
        im.setCustomModelData(1);
        item.setItemMeta(im);
        longStick = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("long_stick"), item);
        sr.shape(" X ", " X ", " X ");
        sr.setIngredient('X', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    public static ItemStack WarAxe;

    private static void createWarAxe() {
        ItemStack item = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c§lIron War Axe");
        //some lores;
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(),
                "generic.attackSpeed", -3.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(),
                "generic.attackDamage", 15, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        im.setCustomModelData(12345);
        item.setItemMeta(im);
        WarAxe = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("war_axe"), item);
        sr.shape("XYX", "XZX", " Z ");
        sr.setIngredient('X', new RecipeChoice.MaterialChoice(Material.IRON_BLOCK));
        sr.setIngredient('Y', new RecipeChoice.MaterialChoice(Material.IRON_INGOT));
        sr.setIngredient('Z', new RecipeChoice.ExactChoice(longStick));
        Bukkit.getServer().addRecipe(sr);
    }
}