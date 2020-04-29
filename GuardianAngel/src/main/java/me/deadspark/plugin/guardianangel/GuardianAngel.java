package me.deadspark.plugin.guardianangel;

import me.deadspark.plugin.guardianangel.commands.Feed;
import me.deadspark.plugin.guardianangel.commands.Fly;
import me.deadspark.plugin.guardianangel.commands.God;
import me.deadspark.plugin.guardianangel.commands.Heal;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public final class GuardianAngel extends JavaPlugin {

    public static final String RESET = "\033[0m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String CYAN = "\033[0;36m";
    public static final String GREEN = "\033[0;32m";

    @Override
    public void onEnable() {

        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        String pversion = getConfig().getString("Version");

        System.out.println(YELLOW_BOLD+"["+CYAN+"GuardianAngel"+YELLOW_BOLD+"] "+GREEN+"Plugin made by DeadSpark"+RESET);
        System.out.println(YELLOW_BOLD+"["+CYAN+"GuardianAngel"+YELLOW_BOLD+"] "+GREEN+"Version "+pversion+" has been Enabled"+RESET);

        // Registering command
        
        Objects.requireNonNull(getCommand("fly")).setExecutor(new Fly());
        Objects.requireNonNull(getCommand("god")).setExecutor(new God());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new Heal());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new Feed());

    }

    @Override
    public void onDisable() {

        // Plugin shutdown logic

        String pversion = getConfig().getString("Version");
        System.out.println(YELLOW_BOLD+"["+CYAN+"GuardianAngel"+YELLOW_BOLD+"] "+GREEN+"Version "+pversion+" has been Disabled"+RESET);

    }

}
