package custom.items.items.custom.Items.Grufflyer;

import custom.items.items.custom.Items.CustomItems;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HoneyBootsEvent implements Listener {
    CustomItems plugin;
    public HoneyBootsEvent(CustomItems plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public static void Move(PlayerMoveEvent event) {
        if (event.getPlayer().getInventory().getBoots() != null) {
            if (event.getPlayer().getInventory().getBoots().hasItemMeta() && event.getPlayer().getInventory().getBoots().getItemMeta().hasLocalizedName() && event.getPlayer().getInventory().getBoots().getItemMeta().getLocalizedName().equals("honey_boots")) {
                Player player = event.getPlayer();
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10, 0, false, false, false));

                player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1, 0,
                        false, false, false));

                Location location = event.getPlayer().getLocation();
                if (player.isSneaking()){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 4, true, false, false));
                    player.spawnParticle(Particle.WAX_ON, location, 30);
                }
                if (player.isInWater()){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 2, true, false, false));
                    player.spawnParticle(Particle.WAX_ON, location, 30);
                }
            }
        }
    }
}