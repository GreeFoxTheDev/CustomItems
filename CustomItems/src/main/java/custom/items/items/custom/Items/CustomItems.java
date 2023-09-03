package custom.items.items.custom.Items;

import custom.items.items.custom.Items.Commands.Give;
import custom.items.items.custom.Items.Items.GreeFox.Iluminium;
import custom.items.items.custom.Items.Items.GreeFox.IluminiumEvent;
import custom.items.items.custom.Items.Items.Grufflyer.HoneyBoots;
import custom.items.items.custom.Items.Items.Grufflyer.HoneyBootsEvent;
import custom.items.items.custom.Items.Items.Sorgen_08.FinalMelonEvent;
import custom.items.items.custom.Items.Items.Sorgen_08.MelonSliceEvent;
import custom.items.items.custom.Items.Items.Sorgen_08.Melons;
import custom.items.items.custom.Items.Items.o_Wailm3r.SpikeBomberEvent;
import custom.items.items.custom.Items.Items.o_Wailm3r.SpikeHelmet;
import custom.items.items.custom.Items.Items.o_Wailm3r.SpikeHelmetEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CustomItems extends JavaPlugin {
    private static CustomItems instance;

    public static CustomItems getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.AQUA + "**********************************");
        console.sendMessage(ChatColor.AQUA + "| CustomItems have been enabled! |");
        console.sendMessage(ChatColor.AQUA + "**********************************");
        SpikeHelmet.init();
        Melons.init();
        HoneyBoots.init();
        Iluminium.init();
        getServer().getPluginManager().registerEvents(new SpikeHelmetEvent(this), this);
        getServer().getPluginManager().registerEvents(new IluminiumEvent(this), this);
        getServer().getPluginManager().registerEvents(new FinalMelonEvent(this), this);
        getServer().getPluginManager().registerEvents(new MelonSliceEvent(this), this);
        getServer().getPluginManager().registerEvents(new HoneyBootsEvent(this), this);
        getServer().getPluginManager().registerEvents(new SpikeBomberEvent(this), this);
        SpikeHelmet.init();
        getServer().getPluginManager().registerEvents(new SpikeHelmetEvent(this), this);
        Objects.requireNonNull(this.getCommand("givecustomitem")).setExecutor(new Give(this));
        Objects.requireNonNull(this.getCommand("givecustomitem")).setTabCompleter(new Give(this));
    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.DARK_RED + "***********************************");
        console.sendMessage(ChatColor.DARK_RED + "| CustomItems have been disabled! |");
        console.sendMessage(ChatColor.DARK_RED + "***********************************");
    }
}
