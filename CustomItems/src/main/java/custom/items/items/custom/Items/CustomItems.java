package custom.items.items.custom.Items;

import custom.items.items.custom.Items.GreeFox.Iluminium;
import custom.items.items.custom.Items.GreeFox.IluminiumEvent;
import custom.items.items.custom.Items.Grufflyer.HoneyBoots;
import custom.items.items.custom.Items.Grufflyer.HoneyBootsEvent;
import custom.items.items.custom.Items.Sorgen_08.FinalMelon;
import custom.items.items.custom.Items.Sorgen_08.MelonSlice;
import custom.items.items.custom.Items.Sorgen_08.Melons;
import custom.items.items.custom.Items.o_Wailm3r.ThornsHelmet;
import custom.items.items.custom.Items.o_Wailm3r.ThornsHelmetEvent;
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
        Melons.init();
        HoneyBoots.init();
        Iluminium.init();
        getServer().getPluginManager().registerEvents(new IluminiumEvent(this), this);
        //WarAxe.init();
        getServer().getPluginManager().registerEvents(new FinalMelon(), this); //registers the event for FinalMelon
        getServer().getPluginManager().registerEvents(new MelonSlice(), this); //registers the event fot MelonSlice
        //getServer().getPluginManager().registerEvents(new WarAxeEvent(), this);
        getServer().getPluginManager().registerEvents(new HoneyBootsEvent(), this);
        ThornsHelmet.init();
        getServer().getPluginManager().registerEvents(new ThornsHelmetEvent(this), this);
    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.DARK_RED + "**********************************");
        console.sendMessage(ChatColor.DARK_RED + "| CustomItems have been enabled! |");
        console.sendMessage(ChatColor.DARK_RED + "**********************************");
    }
}
