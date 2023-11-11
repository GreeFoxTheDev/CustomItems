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
        if (item != null && item.hasItemMeta() && item.getItemMeta().hasLocalizedName() && item.getItemMeta().getLocalizedName().equals("cactus_bomber") || item.getItemMeta().getLocalizedName().equals("drill_bomber") || item.getItemMeta().getLocalizedName().equals("surface_bomber")) {
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
                Location hiroshimaD = hiroshima.clone().add(0, -5, 0);
                Location hiroshimaD1 = hiroshima.clone().add(0, -10, 0);
                Location hiroshimaD2 = hiroshima.clone().add(0, -15, 0);
                Location hiroshimaD3 = hiroshima.clone().add(0, -17, 0);
                Location hiroshimaD4 = hiroshima.clone().add(0, -20, 0);
                Location hiroshimaD5 = hiroshima.clone().add(0, -22, 0);
                Location hiroshimaD6 = hiroshima.clone().add(0, -25, 0);
                Location hiroshimaD7 = hiroshima.clone().add(0, -27, 0);
                Location hiroshimaD8 = hiroshima.clone().add(0, -30, 0);

                Location hiroshimaS = hiroshima.clone().add(5, 0, 0);
                Location hiroshimaS1 = hiroshima.clone().add(5, 0, 5);
                Location hiroshimaS2 = hiroshima.clone().add(0, 0, 5);
                Location hiroshimaS3 = hiroshima.clone().add(-5, 0, 0);
                Location hiroshimaS4 = hiroshima.clone().add(-5, 0, -5);
                Location hiroshimaS5 = hiroshima.clone().add(5, 0, -5);

                Location hiroshimaClone = hiroshima.clone().add(20, 0, 20);
                Location hiroshimaClone1 = hiroshima.clone().add(20, 0, -20);
                Location hiroshimaClone2 = hiroshima.clone().add(-20, 0, 20);
                Location hiroshimaClone3 = hiroshima.clone().add(-20, 0, -20);

                Location hiroshimaClone4 = hiroshima.clone().add(30, 0, 30);
                Location hiroshimaClone5 = hiroshima.clone().add(30, 0, -30);
                Location hiroshimaClone6 = hiroshima.clone().add(-30, 0, 30);
                Location hiroshimaClone7 = hiroshima.clone().add(-30, 0, -30);
                if (item.getItemMeta().getLocalizedName().equals("cactus_bomber")) {
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
                            bomb.getWorld().createExplosion(hiroshimaClone, 20f);
                            bomb.getWorld().createExplosion(hiroshimaClone1, 20f);
                            bomb.getWorld().createExplosion(hiroshimaClone2, 20f);
                            bomb.getWorld().createExplosion(hiroshimaClone3, 20f);
                            bomb.getWorld().createExplosion(hiroshimaClone4, 20f);
                            bomb.getWorld().createExplosion(hiroshimaClone5, 20f);
                            bomb.getWorld().createExplosion(hiroshimaClone6, 20f);
                            bomb.getWorld().createExplosion(hiroshimaClone7, 20f);

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
                if (item.getItemMeta().getLocalizedName().equals("drill_bomber")) {
                    Location finalHiroshima1 = hiroshima;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            bomb.getWorld().createExplosion(finalHiroshima1, 20f, true);
                            bomb.getWorld().createExplosion(hiroshimaD, 20f, true);
                            bomb.getWorld().createExplosion(hiroshimaD1, 20f, true);

                            bomb.getWorld().spawnParticle(Particle.SMOKE_LARGE, bomb.getLocation(), 100);
                            bomb.getWorld().spawnParticle(Particle.ASH, bomb.getLocation(), 100);
                            bomb.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, bomb.getLocation(), 150);
                            player.sendMessage(ChatColor.YELLOW + "You just committed a war crime!");
                            bomb.remove();
                        }
                    }.runTaskLater(CustomItems.getInstance(), timeInTicks);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            bomb.getWorld().createExplosion(hiroshimaD2, 20f, true);
                            bomb.getWorld().createExplosion(hiroshimaD3, 20f, true);

                        }
                    }.runTaskLater(CustomItems.getInstance(), timeInTicks + 20);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            bomb.getWorld().createExplosion(hiroshimaD4, 20f, true);
                            bomb.getWorld().createExplosion(hiroshimaD5, 20f, true);

                        }
                    }.runTaskLater(CustomItems.getInstance(), timeInTicks + 2 * 20);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            bomb.getWorld().createExplosion(hiroshimaD6, 20f, true);
                            bomb.getWorld().createExplosion(hiroshimaD7, 20f, true);

                        }
                    }.runTaskLater(CustomItems.getInstance(), timeInTicks + 3 * 20);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            bomb.getWorld().createExplosion(hiroshimaD8, 30f, true);

                        }
                    }.runTaskLater(CustomItems.getInstance(), timeInTicks + 5 * 20);
                }
                if (item.getItemMeta().getLocalizedName().equals("surface_bomber")) {
                    Location finalHiroshima2 = hiroshima;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            bomb.getWorld().createExplosion(finalHiroshima2, 20f, true);


                            bomb.getWorld().spawnParticle(Particle.SMOKE_LARGE, bomb.getLocation(), 100);
                            bomb.getWorld().spawnParticle(Particle.ASH, bomb.getLocation(), 100);
                            bomb.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, bomb.getLocation(), 150);
                            player.sendMessage(ChatColor.YELLOW + "You just committed a war crime!");
                            bomb.remove();
                        }
                    }.runTaskLater(CustomItems.getInstance(), timeInTicks);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            bomb.getWorld().createExplosion(hiroshimaS1, 20f, true);
                            bomb.getWorld().createExplosion(hiroshimaS4, 20f, true);
                        }
                    }.runTaskLater(CustomItems.getInstance(), timeInTicks + 20);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            bomb.getWorld().createExplosion(hiroshimaS, 20f, true);
                            bomb.getWorld().createExplosion(hiroshimaS2, 20f, true);
                            bomb.getWorld().createExplosion(hiroshimaS3, 20f, true);
                            bomb.getWorld().createExplosion(hiroshimaS5, 20f, true);
                        }
                    }.runTaskLater(CustomItems.getInstance(), timeInTicks + 2 * 20);
                }
            }
        }
    }
}