package custom.items.items.custom.Items.Commands;

import custom.items.items.custom.Items.CustomItems;
import custom.items.items.custom.Items.Items.Grufflyer.HoneyBoots;
import custom.items.items.custom.Items.Items.Sorgen_08.Melons;
import custom.items.items.custom.Items.Items.o_Wailm3r.SpikeHelmet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Give implements CommandExecutor, TabCompleter {
    private static final String[] ARGS = {"GruffItems", "SorItems", "WailItems"};
    private static final String[] SORGEN_ARGS = {"compressed_melon", "compressed_melon_1", "compressed_melon_2", "final_slice", "final_melon", "melon_ax", "compressed_cactus", "compressed_cactus_1", "compressed_cactus_2", "compressed_cactus_3", "spike_helmet"};
    private static final String[] WAIL_ARGS = {"compressed_cactus", "compressed_cactus_1", "compressed_cactus_2", "compressed_cactus_3", "spike_bomb", "spike_helmet"};
    private static final String[] GRUFF_ARGS = {"compressed_sugar", "compressed_sugar_1", "compressed_sugar_2", "compressed_honey", "compressed_honey_1", "compressed_honey_2", "honey_boots" };
    CustomItems plugin;

    public Give(CustomItems plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("givecustomitem")) {
            if (args.length == 2) {
                if (sender instanceof BlockCommandSender) {
                    Location loc = ((BlockCommandSender) sender).getBlock().getLocation();
                    Entity closestEntity = null;
                    double lowestDistSoFar = Double.MAX_VALUE;
                    for (Entity entity : Objects.requireNonNull(loc.getWorld()).getNearbyEntities(loc, 100, 100, 100)) {
                        if (entity instanceof Player) {
                            double distance = entity.getLocation().distance(loc);
                            if (distance < lowestDistSoFar) {
                                lowestDistSoFar = distance;
                                closestEntity = entity;

                            }
                        }
                    }
                    if (closestEntity != null) {
                        if (args[0].equalsIgnoreCase("SorItems")) {
                            if (args[1].equalsIgnoreCase("final_melon")){
                                ((Player) closestEntity).getInventory().addItem(Melons.compressedMelon3);
                            }
                            if (args[1].equalsIgnoreCase("compressed_melon")){
                                ((Player) closestEntity).getInventory().addItem(Melons.compressedMelon);
                            }
                            if (args[1].equalsIgnoreCase("compressed_melon_1")){
                                ((Player) closestEntity).getInventory().addItem(Melons.compressedMelon1);
                            }
                            if (args[1].equalsIgnoreCase("compressed_melon_2")){
                                ((Player) closestEntity).getInventory().addItem(Melons.compressedMelon2);
                            }
                            if (args[1].equalsIgnoreCase("compressed_melon_3")){
                                ((Player) closestEntity).getInventory().addItem(Melons.compressedMelon3);
                            }
                            if (args[1].equalsIgnoreCase("melon_ax")){
                                ((Player) closestEntity).getInventory().addItem(Melons.melonAx);
                            }
                            if (args[1].equalsIgnoreCase("final_slice")){
                                ((Player) closestEntity).getInventory().addItem(Melons.melonSlice);
                            }
                        }
                        if (args[0].equalsIgnoreCase("WailItems")) {
                            if (args[1].equalsIgnoreCase("compressed_cactus")){
                                ((Player) closestEntity).getInventory().addItem(SpikeHelmet.compressedCactus);
                            }
                            if (args[1].equalsIgnoreCase("compressed_cactus_1")){
                                ((Player) closestEntity).getInventory().addItem(SpikeHelmet.compressedCactus1);
                            }
                            if (args[1].equalsIgnoreCase("compressed_cactus_2")){
                                ((Player) closestEntity).getInventory().addItem(SpikeHelmet.compressedCactus2);
                            }
                            if (args[1].equalsIgnoreCase("compressed_cactus_3")){
                                ((Player) closestEntity).getInventory().addItem(SpikeHelmet.compressedCactus3);
                            }
                            if (args[1].equalsIgnoreCase("spike_helmet")){
                                ((Player) closestEntity).getInventory().addItem(SpikeHelmet.cactusHelmet);
                            }
                            if (args[1].equalsIgnoreCase("spike_bomb")){
                                ((Player) closestEntity).getInventory().addItem(SpikeHelmet.cactusBomber);
                            }
                        }
                        if (args[0].equalsIgnoreCase("GruffItems")) {
                            if (args[1].equalsIgnoreCase("compressed_honey")){
                                ((Player) closestEntity).getInventory().addItem(HoneyBoots.compressedHoney);
                            }
                            if (args[1].equalsIgnoreCase("compressed_honey_1")){
                                ((Player) closestEntity).getInventory().addItem(HoneyBoots.compressedHoney1);
                            }
                            if (args[1].equalsIgnoreCase("compressed_honey_2")){
                                ((Player) closestEntity).getInventory().addItem(HoneyBoots.compressedHoney2);
                            }
                            if (args[1].equalsIgnoreCase("compressed_sugar")){
                                ((Player) closestEntity).getInventory().addItem(HoneyBoots.compressedSugar);
                            }
                            if (args[1].equalsIgnoreCase("compressed_sugar_1")){
                                ((Player) closestEntity).getInventory().addItem(HoneyBoots.compressedSugar1);
                            }
                            if (args[1].equalsIgnoreCase("compressed_sugar_2")){
                                ((Player) closestEntity).getInventory().addItem(HoneyBoots.compressedSugar2);
                            }
                            if (args[1].equalsIgnoreCase("honey_boots")){
                                ((Player) closestEntity).getInventory().addItem(HoneyBoots.honeyBoots);
                            }
                        }
                    }
                } else if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.isOp()) {
                        sender.sendMessage("Gave 1 [" + args[1] + "] to player " + sender.getName());
                        if (args[0].equalsIgnoreCase("SorItems")) {
                            if (args[1].equalsIgnoreCase("final_melon")){
                                player.getInventory().addItem(Melons.compressedMelon3);
                            }
                            if (args[1].equalsIgnoreCase("compressed_melon")){
                                player.getInventory().addItem(Melons.compressedMelon);
                            }
                            if (args[1].equalsIgnoreCase("compressed_melon_1")){
                                player.getInventory().addItem(Melons.compressedMelon1);
                            }
                            if (args[1].equalsIgnoreCase("compressed_melon_2")){
                                player.getInventory().addItem(Melons.compressedMelon2);
                            }
                            if (args[1].equalsIgnoreCase("compressed_melon_3")){
                                player.getInventory().addItem(Melons.compressedMelon3);
                            }
                            if (args[1].equalsIgnoreCase("melon_ax")){
                                player.getInventory().addItem(Melons.melonAx);
                            }
                            if (args[1].equalsIgnoreCase("final_slice")){
                                player.getInventory().addItem(Melons.melonSlice);
                            }
                        }
                        if (args[0].equalsIgnoreCase("WailItems")) {
                            if (args[1].equalsIgnoreCase("compressed_cactus")){
                                player.getInventory().addItem(SpikeHelmet.compressedCactus);
                            }
                            if (args[1].equalsIgnoreCase("compressed_cactus_1")){
                                player.getInventory().addItem(SpikeHelmet.compressedCactus1);
                            }
                            if (args[1].equalsIgnoreCase("compressed_cactus_2")){
                                player.getInventory().addItem(SpikeHelmet.compressedCactus2);
                            }
                            if (args[1].equalsIgnoreCase("compressed_cactus_3")){
                                player.getInventory().addItem(SpikeHelmet.compressedCactus3);
                            }
                            if (args[1].equalsIgnoreCase("spike_helmet")){
                                player.getInventory().addItem(SpikeHelmet.cactusHelmet);
                            }
                            if (args[1].equalsIgnoreCase("spike_bomb")){
                                player.getInventory().addItem(SpikeHelmet.cactusBomber);
                            }
                        }
                        if (args[0].equalsIgnoreCase("GruffItems")) {
                            if (args[1].equalsIgnoreCase("compressed_honey")){
                                player.getInventory().addItem(HoneyBoots.compressedHoney);
                            }
                            if (args[1].equalsIgnoreCase("compressed_honey_1")){
                                player.getInventory().addItem(HoneyBoots.compressedHoney1);
                            }
                            if (args[1].equalsIgnoreCase("compressed_honey_2")){
                                player.getInventory().addItem(HoneyBoots.compressedHoney2);
                            }
                            if (args[1].equalsIgnoreCase("compressed_sugar")){
                                player.getInventory().addItem(HoneyBoots.compressedSugar);
                            }
                            if (args[1].equalsIgnoreCase("compressed_sugar_1")){
                                player.getInventory().addItem(HoneyBoots.compressedSugar1);
                            }
                            if (args[1].equalsIgnoreCase("compressed_sugar_2")){
                                player.getInventory().addItem(HoneyBoots.compressedSugar2);
                            }
                            if (args[1].equalsIgnoreCase("honey_boots")){
                                player.getInventory().addItem(HoneyBoots.honeyBoots);
                            }
                        }
                    } else sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                }
            } else if (args.length == 3) {
                String playerName = args[2];
                Player chosenPlayer = Bukkit.getPlayer(playerName);
                assert chosenPlayer != null;
                if (Arrays.toString(Bukkit.getOnlinePlayers().toArray()).contains(playerName)) {
                    if (sender instanceof Player || sender instanceof BlockCommandSender) {
                        if (sender.isOp()) {
                            sender.sendMessage("Gave 1 [" + args[1] + "] to player " + args[2]);
                            if (!(chosenPlayer.getInventory().firstEmpty() == -1)) {
                                if (args[0].equalsIgnoreCase("SorItems")) {
                                    if (args[1].equalsIgnoreCase("final_melon")){
                                        chosenPlayer.getInventory().addItem(Melons.compressedMelon3);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon")){
                                        chosenPlayer.getInventory().addItem(Melons.compressedMelon);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_1")){
                                        chosenPlayer.getInventory().addItem(Melons.compressedMelon1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_2")){
                                        chosenPlayer.getInventory().addItem(Melons.compressedMelon2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_3")){
                                        chosenPlayer.getInventory().addItem(Melons.compressedMelon3);
                                    }
                                    if (args[1].equalsIgnoreCase("melon_ax")){
                                        chosenPlayer.getInventory().addItem(Melons.melonAx);
                                    }
                                    if (args[1].equalsIgnoreCase("final_slice")){
                                        chosenPlayer.getInventory().addItem(Melons.melonSlice);
                                    }
                                }
                                if (args[0].equalsIgnoreCase("WailItems")) {
                                    if (args[1].equalsIgnoreCase("compressed_cactus")){
                                        chosenPlayer.getInventory().addItem(SpikeHelmet.compressedCactus);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_1")){
                                        chosenPlayer.getInventory().addItem(SpikeHelmet.compressedCactus1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_2")){
                                        chosenPlayer.getInventory().addItem(SpikeHelmet.compressedCactus2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_3")){
                                        chosenPlayer.getInventory().addItem(SpikeHelmet.compressedCactus3);
                                    }
                                    if (args[1].equalsIgnoreCase("spike_helmet")){
                                        chosenPlayer.getInventory().addItem(SpikeHelmet.cactusHelmet);
                                    }
                                    if (args[1].equalsIgnoreCase("spike_bomb")){
                                        chosenPlayer.getInventory().addItem(SpikeHelmet.cactusBomber);
                                    }
                                }
                                if (args[0].equalsIgnoreCase("GruffItems")) {
                                    if (args[1].equalsIgnoreCase("compressed_honey")){
                                        chosenPlayer.getInventory().addItem(HoneyBoots.compressedHoney);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_honey_1")){
                                        chosenPlayer.getInventory().addItem(HoneyBoots.compressedHoney1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_honey_2")){
                                        chosenPlayer.getInventory().addItem(HoneyBoots.compressedHoney2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar")){
                                        chosenPlayer.getInventory().addItem(HoneyBoots.compressedSugar);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar_1")){
                                        chosenPlayer.getInventory().addItem(HoneyBoots.compressedSugar1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar_2")){
                                        chosenPlayer.getInventory().addItem(HoneyBoots.compressedSugar2);
                                    }
                                    if (args[1].equalsIgnoreCase("honey_boots")){
                                        chosenPlayer.getInventory().addItem(HoneyBoots.honeyBoots);
                                    }
                                }
                            } else if (chosenPlayer.getInventory().firstEmpty() == -1) {
                                if (args[0].equalsIgnoreCase("SorItems")) {
                                    if (args[1].equalsIgnoreCase("final_melon")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), Melons.compressedMelon3);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), Melons.compressedMelon);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_1")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), Melons.compressedMelon2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_2")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), Melons.compressedMelon2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_3")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), Melons.compressedMelon3);
                                    }
                                    if (args[1].equalsIgnoreCase("melon_ax")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), Melons.melonAx);
                                    }
                                    if (args[1].equalsIgnoreCase("final_slice")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), Melons.melonSlice);
                                    }
                                }
                                if (args[0].equalsIgnoreCase("WailItems")) {
                                    if (args[1].equalsIgnoreCase("compressed_cactus")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), SpikeHelmet.compressedCactus);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_1")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), SpikeHelmet.compressedCactus1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_2")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), SpikeHelmet.compressedCactus2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_3")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), SpikeHelmet.compressedCactus3);
                                    }
                                    if (args[1].equalsIgnoreCase("spike_helmet")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), SpikeHelmet.cactusHelmet);
                                    }
                                    if (args[1].equalsIgnoreCase("spike_bomb")){
                                        chosenPlayer.getInventory().addItem(SpikeHelmet.cactusBomber);
                                    }
                                }
                                if (args[0].equalsIgnoreCase("GruffItems")) {
                                    if (args[1].equalsIgnoreCase("compressed_honey")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), HoneyBoots.compressedHoney);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_honey_1")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), HoneyBoots.compressedHoney1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_honey_2")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), HoneyBoots.compressedHoney2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), HoneyBoots.compressedSugar);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar_1")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), HoneyBoots.compressedSugar1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar_2")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), HoneyBoots.compressedSugar2);
                                    }
                                    if (args[1].equalsIgnoreCase("honey_boots")){
                                        chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), HoneyBoots.honeyBoots);
                                    }
                                }
                            }
                        } else sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                    } else if (sender instanceof ConsoleCommandSender) {
                        sender.sendMessage("Player only command!");
                    }
                } else if (!(args[2].equals("@a"))) {
                    sender.sendMessage(ChatColor.RED + "Unable to find player " + args[2]);
                }
                if ((sender instanceof Player || sender instanceof BlockCommandSender) && args[2].equalsIgnoreCase("@a")) {
                    if (sender.isOp()) {
                        sender.sendMessage("Gave [" + args[1] + "] to all players.");
                        for (Player allOnlinePlayers : Bukkit.getOnlinePlayers()) {
                            if (!(allOnlinePlayers.getInventory().firstEmpty() == -1)) {
                                if (args[0].equalsIgnoreCase("SorItems")) {
                                    if (args[1].equalsIgnoreCase("final_melon")){
                                        allOnlinePlayers.getInventory().addItem(Melons.compressedMelon3);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon")){
                                        allOnlinePlayers.getInventory().addItem(Melons.compressedMelon);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_1")){
                                        allOnlinePlayers.getInventory().addItem(Melons.compressedMelon1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_2")){
                                        allOnlinePlayers.getInventory().addItem(Melons.compressedMelon2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_3")){
                                        allOnlinePlayers.getInventory().addItem(Melons.compressedMelon3);
                                    }
                                    if (args[1].equalsIgnoreCase("melon_ax")){
                                        allOnlinePlayers.getInventory().addItem(Melons.melonAx);
                                    }
                                    if (args[1].equalsIgnoreCase("final_slice")){
                                        allOnlinePlayers.getInventory().addItem(Melons.melonSlice);
                                    }
                                }
                                if (args[0].equalsIgnoreCase("WailItems")) {
                                    if (args[1].equalsIgnoreCase("compressed_cactus")){
                                        allOnlinePlayers.getInventory().addItem(SpikeHelmet.compressedCactus);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_1")){
                                        allOnlinePlayers.getInventory().addItem(SpikeHelmet.compressedCactus1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_2")){
                                        allOnlinePlayers.getInventory().addItem(SpikeHelmet.compressedCactus2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_3")){
                                        allOnlinePlayers.getInventory().addItem(SpikeHelmet.compressedCactus3);
                                    }
                                    if (args[1].equalsIgnoreCase("spike_helmet")){
                                        allOnlinePlayers.getInventory().addItem(SpikeHelmet.cactusHelmet);
                                    }
                                    if (args[1].equalsIgnoreCase("spike_bomb")){
                                        allOnlinePlayers.getInventory().addItem(SpikeHelmet.cactusBomber);
                                    }
                                }
                                if (args[0].equalsIgnoreCase("GruffItems")) {
                                    if (args[1].equalsIgnoreCase("compressed_honey")){
                                        allOnlinePlayers.getInventory().addItem(HoneyBoots.compressedHoney);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_honey_1")){
                                        allOnlinePlayers.getInventory().addItem(HoneyBoots.compressedHoney1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_honey_2")){
                                        allOnlinePlayers.getInventory().addItem(HoneyBoots.compressedHoney2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar")){
                                        allOnlinePlayers.getInventory().addItem(HoneyBoots.compressedSugar);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar_1")){
                                        allOnlinePlayers.getInventory().addItem(HoneyBoots.compressedSugar1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar_2")){
                                        allOnlinePlayers.getInventory().addItem(HoneyBoots.compressedSugar2);
                                    }
                                    if (args[1].equalsIgnoreCase("honey_boots")){
                                        allOnlinePlayers.getInventory().addItem(HoneyBoots.honeyBoots);
                                    }
                                }
                            } else if (allOnlinePlayers.getInventory().firstEmpty() == -1) {
                                if (args[0].equalsIgnoreCase("SorItems")) {
                                    if (args[1].equalsIgnoreCase("final_melon")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), Melons.compressedMelon3);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), Melons.compressedMelon);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_1")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), Melons.compressedMelon1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_2")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), Melons.compressedMelon2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_melon_3")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), Melons.compressedMelon3);
                                    }
                                    if (args[1].equalsIgnoreCase("melon_ax")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), Melons.melonAx);
                                    }
                                    if (args[1].equalsIgnoreCase("final_slice")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), Melons.melonSlice);
                                    }
                                }
                                if (args[0].equalsIgnoreCase("WailItems")) {
                                    if (args[1].equalsIgnoreCase("compressed_cactus")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), SpikeHelmet.compressedCactus);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_1")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), SpikeHelmet.compressedCactus1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_2")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), SpikeHelmet.compressedCactus2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_cactus_3")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), SpikeHelmet.compressedCactus3);
                                    }
                                    if (args[1].equalsIgnoreCase("spike_helmet")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), SpikeHelmet.cactusHelmet);
                                    }
                                    if (args[1].equalsIgnoreCase("spike_bomb")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), SpikeHelmet.cactusBomber);
                                    }
                                }
                                if (args[0].equalsIgnoreCase("GruffItems")) {
                                    if (args[1].equalsIgnoreCase("compressed_honey")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), HoneyBoots.compressedHoney);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_honey_1")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), HoneyBoots.compressedHoney1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_honey_2")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), HoneyBoots.compressedHoney2);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), HoneyBoots.compressedSugar);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar_1")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), HoneyBoots.compressedSugar1);
                                    }
                                    if (args[1].equalsIgnoreCase("compressed_sugar_2")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), HoneyBoots.compressedSugar2);
                                    }
                                    if (args[1].equalsIgnoreCase("honey_boots")){
                                        allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), HoneyBoots.honeyBoots);
                                    }
                                }
                            }
                        }
                    } else sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                }
            }
        }
        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final List<String> Cnames = new ArrayList<>();
        StringUtil.copyPartialMatches(args[0], Arrays.asList(ARGS), Cnames);
        Collections.sort(Cnames);
        if (args.length == 1) {
            return Cnames;
        }
        if (args[0].equals("SorItems")) {
            final List<String> SorItems = new ArrayList<>();
            StringUtil.copyPartialMatches(args[1], Arrays.asList(SORGEN_ARGS), SorItems);
            Collections.sort(SorItems);
            if (args.length == 2) {
                return SorItems;
            }
        }
        if (args[0].equals("GruffItems")) {
            final List<String> GruffItems = new ArrayList<>();
            StringUtil.copyPartialMatches(args[1], Arrays.asList(GRUFF_ARGS), GruffItems);
            Collections.sort(GruffItems);
            if (args.length == 2) {
                return GruffItems;
            }
        }
        if (args[0].equals("WailItems")) {
            final List<String> WailItems = new ArrayList<>();
            StringUtil.copyPartialMatches(args[1], Arrays.asList(WAIL_ARGS), WailItems);
            Collections.sort(WailItems);
            if (args.length == 2) {
                return WailItems;
            }
        }

        final ArrayList<String> finalNames = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        names.add("@a");

        String[] ARGS10 = new String[names.size()];
        for (Player p : Bukkit.getOnlinePlayers()) {
            String name = p.getName();
            names.add(name);
        }
        ARGS10 = names.toArray(ARGS10);
        StringUtil.copyPartialMatches(args[2], Arrays.asList(ARGS10), finalNames);
        if (args.length == 3) {
            return finalNames;
        }
        return new ArrayList<>();
    }
}
