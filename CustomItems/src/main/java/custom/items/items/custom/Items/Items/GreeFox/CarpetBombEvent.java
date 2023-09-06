package custom.items.items.custom.Items.Items.GreeFox;

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

import javax.annotation.processing.SupportedSourceVersion;

public class CarpetBombEvent implements Listener {
    CustomItems plugin;
    public CarpetBombEvent(CustomItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Action action = event.getAction();
        if (item != null && item.hasItemMeta() && item.getItemMeta().hasLocalizedName() && item.getItemMeta().getLocalizedName().equals("compressed_pumpkin_4")) {
            if (action == Action.RIGHT_CLICK_AIR) {
                Player player = event.getPlayer();

                if (player.getGameMode().equals(GameMode.SURVIVAL) || player.getGameMode().equals(GameMode.ADVENTURE)) {
                    if (item.getAmount() == 1) {
                        item.setAmount(0);
                    } else {
                        item.setAmount(item.getAmount() - 1);
                    }
                }
                FallingBlock bomb = player.getLocation().getWorld().spawnFallingBlock(player.getLocation(), Material.PUMPKIN.createBlockData());
                bomb.setGlowing(true);
                bomb.setCustomName(ChatColor.GOLD + "§lPumpkin Carpet Bomb");
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
                Location hiroshimaClone = hiroshima.clone();
                Location hiroshimaClone1 = hiroshima.clone();
                Location hiroshimaClone2 = hiroshima.clone();
                Location hiroshimaClone3 = hiroshima.clone();
                Location hiroshimaClone4 = hiroshima.clone();
                Location hiroshimaClone5 = hiroshima.clone();
                Location hiroshimaClone6 = hiroshima.clone();
                Location hiroshimaClone7 = hiroshima.clone();

                Location small_0 = hiroshimaClone.add(20, 0, 20);
                Location small_1 = hiroshimaClone1.add(20, 0, -20);
                Location small_2 = hiroshimaClone2.add(-20, 0, 20);
                Location small_3 = hiroshimaClone3.add(-20, 0, -20);

                /* Location small_4 = hiroshimaClone4.add(60, 0, 60);
                Location small_5 = hiroshimaClone5.add(60, 0, -60);
                Location small_6 = hiroshimaClone6.add(-60, 0, 60);
                Location small_7 = hiroshimaClone7.add(-60, 0, -60); */

                Location small_4 = hiroshimaClone4.add(30, 0, 30);
                Location small_5 = hiroshimaClone5.add(30, 0, -30);
                Location small_6 = hiroshimaClone6.add(-30, 0, 30);
                Location small_7 = hiroshimaClone7.add(-30, 0, -30);

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
                new BukkitRunnable() {

                    @Override
                    public void run(){
                        bomb.getWorld().createExplosion(small_0, 20f);
                        bomb.getWorld().createExplosion(small_1, 20f);
                        bomb.getWorld().createExplosion(small_2, 20f);
                        bomb.getWorld().createExplosion(small_3, 20f);
                        bomb.getWorld().createExplosion(small_4, 20f);
                        bomb.getWorld().createExplosion(small_5, 20f);
                        bomb.getWorld().createExplosion(small_6, 20f);
                        bomb.getWorld().createExplosion(small_7, 20f);

                        /* bomb.getWorld().spawnParticle(Particle.SMOKE_LARGE, small_0, 50);
                        bomb.getWorld().spawnParticle(Particle.ASH, small_0, 50);
                        bomb.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, small_0, 60);

                        bomb.getWorld().spawnParticle(Particle.SMOKE_LARGE, small_1, 50);
                        bomb.getWorld().spawnParticle(Particle.ASH, small_1, 50);
                        bomb.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, small_1, 60);

                        bomb.getWorld().spawnParticle(Particle.SMOKE_LARGE, small_2, 50);
                        bomb.getWorld().spawnParticle(Particle.ASH, small_2, 50);
                        bomb.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, small_2, 60);

                        bomb.getWorld().spawnParticle(Particle.SMOKE_LARGE, small_3, 50);
                        bomb.getWorld().spawnParticle(Particle.ASH, small_3, 50);
                        bomb.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, small_3, 60); */ //too much lag
                    }
                }.runTaskLater(CustomItems.getInstance(), timeInTicks + 2 * 20);
                Location finalHiroshima1 = hiroshima;
                new BukkitRunnable(){
                    @Override
                    public void run(){
                        bomb.getWorld().createExplosion(finalHiroshima1, 40f, false);
                    }
                }.runTaskLater(CustomItems.getInstance(), timeInTicks + 4 * 20);
            }
        }
    }
}
