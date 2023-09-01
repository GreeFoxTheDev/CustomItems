package custom.items.items.custom.Items.GreeFox;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Iluminium extends JavaPlugin {
    public static void init(){
        createIluminium();
    }
    public static ItemStack Iluminium;
    private static void createIluminium(){
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§f§lIluminium");
        im.setLocalizedName("iluminium");

        item.setItemMeta(im);
        Iluminium = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("iluminium"), item);
        sr.shape("XXX", "XXX", "XXX");
        sr.setIngredient('X', Material.BEACON);
        Bukkit.getServer().addRecipe(sr);
    }
}
