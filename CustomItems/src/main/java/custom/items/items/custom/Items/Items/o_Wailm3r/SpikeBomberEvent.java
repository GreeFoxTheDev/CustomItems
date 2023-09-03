package custom.items.items.custom.Items.Items.o_Wailm3r;

import custom.items.items.custom.Items.CustomItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SpikeBomberEvent implements Listener {
    CustomItems plugin;

    public SpikeBomberEvent(CustomItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Action action = event.getAction();
        if (item != null && item.hasItemMeta() && item.getItemMeta().hasLocalizedName() && item.getItemMeta().getLocalizedName().equals("cactus_bomber")) {
            if (action == Action.RIGHT_CLICK_AIR) {
                Player player = event.getPlayer();
                player.sendMessage("test1");
                FallingBlock bomb = player.getLocation().getWorld().spawnFallingBlock(player.getLocation(), Material.CACTUS.createBlockData());
                Location location = player.getLocation().clone(); // clone the location so we can modify it without issues
                Location hiroshima = null;
                for (int y = location.getBlockY(); y > -64; y--) { // get current Y coordinate, go down until we hit bedrock (0)
                    if (location.subtract(0, 1, 0).getBlock().getType() == Material.AIR)
                        continue; // if the block is air, go to next
                    hiroshima = location;
                    break; // stop the loop
                }
                assert hiroshima != null;
                double dist = player.getLocation().distance(hiroshima);
                double time = dist / 12.5;
                long timeInTicks = (long) time * 20;
                Location finalHiroshima = hiroshima;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        bomb.getWorld().createExplosion(finalHiroshima, 20, true);
                        bomb.getWorld().spawnParticle(Particle.SMOKE_LARGE, bomb.getLocation(), 50);
                        bomb.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, bomb.getLocation(), 50);
                        player.sendMessage("You landed a nuke!");
                        bomb.remove();
                    }
                }.runTaskLater(CustomItems.getInstance(), timeInTicks);
            }
        }
    }
}