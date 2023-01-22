package custom.items.items.custom.Items;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HoneyBootsEvent implements Listener {
    @EventHandler
    public static void onRightClick(PlayerMoveEvent event){
            if (event.getPlayer().getInventory().getBoots() != null) {
                if (event.getPlayer().getInventory().getBoots().getItemMeta().
                        equals(HoneyBoots.honeyBoots.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 0,
                            false, false, false));
                    //player.sendMessage("Hihihiha");
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1,  0,
                            false, false, false ));
                    //player.sendMessage("lol saturation");
                }
            }

    }


}
