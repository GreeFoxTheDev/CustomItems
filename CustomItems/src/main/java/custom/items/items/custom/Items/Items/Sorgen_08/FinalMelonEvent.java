package custom.items.items.custom.Items.Items.Sorgen_08;

import custom.items.items.custom.Items.CustomItems;
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

public class FinalMelonEvent implements Listener {
    CustomItems plugin;
    public FinalMelonEvent(CustomItems plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (item != null && item.hasItemMeta() && item.getItemMeta().hasLocalizedName() && item.getItemMeta().getLocalizedName().equals("melon_final")) {
                    player.getWorld().createExplosion(player.getLocation(), 70f);
                    player.sendMessage("That's a lot of damage!");
                    if (player.getInventory().contains(Melons.compressedMelon3)) {
                        player.getInventory().remove(Melons.compressedMelon3);
                }
            }
        }
    }

    @EventHandler
    public static void onMove(PlayerMoveEvent event) {
        if (event.getPlayer().getInventory().contains(Melons.compressedMelon3)) {
            Player player = event.getPlayer();
            if (event.getPlayer().getInventory().contains(Melons.compressedMelon3, 2)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 6, false, false, false));
                player.spawnParticle(Particle.CRIT_MAGIC, player.getLocation(), 100);
            }
            if (event.getPlayer().getInventory().contains(Melons.compressedMelon3)) {
                if (event.getPlayer().getInventory().containsAtLeast(Melons.compressedMelon3, 3)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 10, false, false, false));
                    player.spawnParticle(Particle.CRIT_MAGIC, player.getLocation(), 150);
                }
            }
        }
    }
}
