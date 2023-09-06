package custom.items.items.custom.Items.Items.o_Wailm3r;

import custom.items.items.custom.Items.CustomItems;
import org.bukkit.*;
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

                if (player.getGameMode().equals(GameMode.SURVIVAL) || player.getGameMode().equals(GameMode.ADVENTURE)) {
                    if (item.getAmount() == 1) {
                        item.setAmount(0);
                    } else {
                        item.setAmount(item.getAmount() - 1);
                    }
                }
                FallingBlock bomb = player.getLocation().getWorld().spawnFallingBlock(player.getLocation(), Material.CACTUS.createBlockData());
                bomb.setGlowing(true);
                bomb.setCustomName(ChatColor.DARK_GREEN + "§lSpike Bomber");
                bomb.setCustomNameVisible(true);
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
                        bomb.getWorld().createExplosion(finalHiroshima, 30f, true);
                        bomb.getWorld().spawnParticle(Particle.SMOKE_LARGE, bomb.getLocation(), 100);
                        bomb.getWorld().spawnParticle(Particle.ASH, bomb.getLocation(), 100);
                        bomb.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, bomb.getLocation(), 150);
                        player.sendMessage(ChatColor.YELLOW + "You just committed a war crime!");
                        bomb.remove();
                    }
                }.runTaskLater(CustomItems.getInstance(), timeInTicks);
            }
        }
    }
}