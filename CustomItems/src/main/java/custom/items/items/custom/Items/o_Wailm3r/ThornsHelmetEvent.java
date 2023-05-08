package custom.items.items.custom.Items.o_Wailm3r;

import custom.items.items.custom.Items.CustomItems;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ThornsHelmetEvent implements Listener {
    CustomItems plugin;

    public ThornsHelmetEvent(CustomItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWear(PlayerMoveEvent event) {
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
}
