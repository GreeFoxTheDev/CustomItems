package custom.items.items.custom.Items.o_Wailm3r;

import custom.items.items.custom.Items.CustomItems;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpikeHelmetEvent implements Listener {
    CustomItems plugin;

    public SpikeHelmetEvent(CustomItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWearing(PlayerMoveEvent event) {
        if (event.getPlayer().getInventory().getHelmet() != null) {
            if (event.getPlayer().getInventory().getHelmet().hasItemMeta() && event.getPlayer().getInventory().getHelmet().getItemMeta().hasLocalizedName() && event.getPlayer().getInventory().getHelmet().getItemMeta().getLocalizedName().equalsIgnoreCase("spike_helmet")) {
                Player player = event.getPlayer();
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10, 0, false, false, false));
                if (event.getPlayer().isInWater()) {
                    Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(1, 140, 45), 1.0F);
                    player.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);
                }
            }
        }
    }

    @EventHandler
    public void onPlace(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Action action = event.getAction();
        if (item != null && item.hasItemMeta() && item.getItemMeta().hasLocalizedName() && item.getItemMeta().getLocalizedName().equals("spike_helmet")) {
            if (action == Action.RIGHT_CLICK_BLOCK) {
                event.setCancelled(true);
            }
        }
    }
}