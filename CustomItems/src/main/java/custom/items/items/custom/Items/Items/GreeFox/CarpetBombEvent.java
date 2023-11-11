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
                Location hiroshimaClone = hiroshima.clone().add(20, 0, 20);
                Location hiroshimaClone1 = hiroshima.clone().add(20, 0, -20);
                Location hiroshimaClone2 = hiroshima.clone().add(-20, 0, 20);
                Location hiroshimaClone3 = hiroshima.clone().add(-20, 0, -20);

                Location hiroshimaClone4 = hiroshima.clone().add(30, 0, 30);
                Location hiroshimaClone5 = hiroshima.clone().add(30, 0, -30);
                Location hiroshimaClone6 = hiroshima.clone().add(-30, 0, 30);
                Location hiroshimaClone7 = hiroshima.clone().add(-30, 0, -30);

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
        }
    }
    @EventHandler
    public void onRightClickSmall(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Action action = event.getAction();
        if (item != null && item.hasItemMeta() && item.getItemMeta().hasLocalizedName() && item.getItemMeta().getLocalizedName().equals("compressed_pumpkin_3")) {
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
                bomb.setCustomName(ChatColor.GOLD + "§lPumpkin Bomber");
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
