package custom.items.items.custom.Items;

import custom.items.items.custom.Items.GreeFox.Iluminium;
import custom.items.items.custom.Items.GreeFox.IluminiumEvent;
import custom.items.items.custom.Items.Grufflyer.HoneyBoots;
import custom.items.items.custom.Items.Grufflyer.HoneyBootsEvent;
import custom.items.items.custom.Items.Sorgen_08.FinalMelonEvent;
import custom.items.items.custom.Items.Sorgen_08.MelonSliceEvent;
import custom.items.items.custom.Items.Sorgen_08.Melons;
import custom.items.items.custom.Items.o_Wailm3r.SpikeHelmet;
import custom.items.items.custom.Items.o_Wailm3r.SpikeHelmetEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItems extends JavaPlugin {

    @Override
    public void onEnable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.AQUA + "**********************************");
        console.sendMessage(ChatColor.AQUA + "| CustomItems have been enabled! |");
        console.sendMessage(ChatColor.AQUA + "**********************************");
        SpikeHelmet.init();
        //Melons.init();
        HoneyBoots.init();
        Iluminium.init();
        getServer().getPluginManager().registerEvents(new SpikeHelmetEvent(this), this);
        getServer().getPluginManager().registerEvents(new IluminiumEvent(this), this);
        getServer().getPluginManager().registerEvents(new FinalMelonEvent(this), this);
        getServer().getPluginManager().registerEvents(new MelonSliceEvent(this), this);
        getServer().getPluginManager().registerEvents(new HoneyBootsEvent(this), this);
        SpikeHelmet.init();
        getServer().getPluginManager().registerEvents(new SpikeHelmetEvent(this), this);
    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.DARK_RED + "***********************************");
        console.sendMessage(ChatColor.DARK_RED + "| CustomItems have been disabled! |");
        console.sendMessage(ChatColor.DARK_RED + "***********************************");
    }
}
