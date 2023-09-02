package custom.items.items.custom.Items.Sorgen_08;

import custom.items.items.custom.Items.CustomItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MelonSliceEvent implements Listener {
    CustomItems plugin;
    public MelonSliceEvent(CustomItems plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (item != null && item.hasItemMeta() && item.getItemMeta().hasLocalizedName() && item.getItemMeta().getLocalizedName().equals("melon_slice")) {
                    Player player = event.getPlayer();
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1, 50, false, false, false));
                    player.getWorld().createExplosion(player.getLocation(), 4.7f);
                    player.sendMessage("That's a lot of damage!");
            }
        }
    }


}
