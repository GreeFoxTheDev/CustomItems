package custom.items.items.custom.Items;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItems extends JavaPlugin {

    @Override
    public void onEnable() {
        Melons.init();
        HoneyBoots.init();
        WarAxe.init();
        getServer().getPluginManager().registerEvents(new FinalMelon(), this); //registers the event for FinalMelon
        getServer().getPluginManager().registerEvents(new MelonSlice(), this); //registers the event fot MelonSlice
        getServer().getPluginManager().registerEvents(new HoneyBootsEvent(), this);
        getServer().getPluginManager().registerEvents(new WarAxeEvent(), this);


        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
