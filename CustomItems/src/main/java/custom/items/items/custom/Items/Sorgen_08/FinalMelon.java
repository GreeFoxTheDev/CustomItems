package custom.items.items.custom.Items.Sorgen_08;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;

public class FinalMelon implements Listener {
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(Melons.compressedMelon4.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.getWorld().createExplosion(player.getLocation(), 27f);
                    player.sendMessage("That's a lot of damage!");
                    if (player.getInventory().contains(Melons.compressedMelon4)) {
                        player.getInventory().remove(Melons.compressedMelon4);
                    }
                }
            }
        }
    }

    @EventHandler
    public static void onMove(PlayerMoveEvent event) {
        if (event.getPlayer().getInventory().contains(Melons.compressedMelon4)) {
            Player player = event.getPlayer();
            Inventory inv = player.getInventory();
            if (event.getPlayer().getInventory().contains(Melons.compressedMelon4, 2)) {
                player.setWalkSpeed((float) 0.6);
                player.spawnParticle(Particle.CRIT_MAGIC, player.getLocation(), 100);
            }
            if (event.getPlayer().getInventory().contains(Melons.compressedMelon4)) {
                if (event.getPlayer().getInventory().containsAtLeast(Melons.compressedMelon4, 3)) {
                    player.setWalkSpeed((float) 0.3);
                    player.spawnParticle(Particle.CRIT_MAGIC, player.getLocation(), 150);
                }
            }
        }
    }
}
