package custom.items.items.custom.Items;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WarAxeEvent implements Listener {
    @EventHandler
    public static void Move(PlayerMoveEvent event){
        if (event.getPlayer().getInventory().getBoots() != null) {
            if (event.getPlayer().getInventory().getBoots().getItemMeta().
                    equals(WarAxe.WarAxe.getItemMeta())) {
                Player player = event.getPlayer();
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1, 1,
                        false, false, false));
                //player.sendMessage("Hihihiha");
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 1,  0,
                        false, false, false ));
                //player.sendMessage("lol saturation");
            }
        }
    }
}
