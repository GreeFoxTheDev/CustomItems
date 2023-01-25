package custom.items.items.custom.Items;

import org.bukkit.Particle;
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
    public static void Move(PlayerMoveEvent event){
            if (event.getPlayer().getInventory().getBoots() != null) {
                if (event.getPlayer().getInventory().getBoots().getItemMeta().
                        equals(HoneyBoots.honeyBoots.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 0,
                            false, false, false));
                    //player.sendMessage("Hihihiha");
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 5,  0,
                            false, false, false ));
                    if (event.getPlayer().isSneaking()){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 3,false, false, false));
                        player.spawnParticle(Particle.WAX_ON, player.getLocation(), 20);
                        //player.setWalkSpeed(0);
                    }
                    if (player.isInWater()){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 2,
                                false, false, false));
                        player.spawnParticle(Particle.WAX_ON, player.getLocation(), 20);
                    }
                    //player.sendMessage("lol saturation");
                }
            }
    }
}
