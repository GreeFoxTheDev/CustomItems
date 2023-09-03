package custom.items.items.custom.Items.Items.GreeFox;

import custom.items.items.custom.Items.CustomItems;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class IluminiumEvent implements Listener {
    CustomItems plugin;
    public IluminiumEvent(CustomItems plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            if (((Player) event.getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName()
                    .equalsIgnoreCase("§f§lIluminium")) {
                if (event.getEntity() instanceof LivingEntity) {
                    Player player = ((Player) event.getDamager());
                    Entity entity = event.getEntity();

                    Location entityLocation = event.getEntity().getLocation();
                    Location loc = entity.getLocation().add(-2, 0, 0);
                    Location loc2 = entity.getLocation().add(2, 0, 0);
                    Location loc3 = entity.getLocation().add(0, 0, 2);
                    Location loc4 = entity.getLocation().add(0, 0, -2);
                    //particles
                    entityLocation.getWorld().spawnParticle(Particle.GLOW_SQUID_INK, loc, 100);
                    entityLocation.getWorld().spawnParticle(Particle.GLOW_SQUID_INK, loc2, 100);
                    entityLocation.getWorld().spawnParticle(Particle.GLOW_SQUID_INK, loc3, 100);
                    entityLocation.getWorld().spawnParticle(Particle.GLOW_SQUID_INK, loc4, 100);
                    //explosion
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            entity.getWorld().createExplosion(entityLocation, 3, true, false);
                            player.sendMessage("§l§bIluminium has spoken.");
                        }
                    }.runTaskLater(plugin, 20*2);
                }
            }
        }
    }
}
//int red = 255;
//int green = 0;
//int blue = 0;
//Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 1);
//player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().getX(), player.getLocation().getY() + 2, player.getLocation().getZ(), 0, 0.001, 1, 0, 1, dustOptions);
//event.getEntity().getWorld().spawnParticle(Particle.PORTAL, loc, 100, new Particle.DustOptions(Color.fromBGR(red, green, blue), 1));
//event.getEntity().getWorld().spawnParticle(Particle.REDSTONE, loc2, 100, new Particle.DustOptions(Color.fromBGR(red, green, blue), 1));
//event.getEntity().getWorld().spawnParticle(Particle.REDSTONE, loc3, 100, new Particle.DustOptions(Color.fromBGR(red, green, blue), 1));
//event.getEntity().getWorld().spawnParticle(Particle.REDSTONE, loc4, 100, new Particle.DustOptions(Color.fromBGR(red, green, blue), 1));
