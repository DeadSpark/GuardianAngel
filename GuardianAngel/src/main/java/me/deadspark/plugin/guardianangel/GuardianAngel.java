package me.deadspark.plugin.guardianangel;

import me.deadspark.plugin.guardianangel.commands.Feed;
import me.deadspark.plugin.guardianangel.commands.Fly;
import me.deadspark.plugin.guardianangel.commands.God;
import me.deadspark.plugin.guardianangel.commands.Heal;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;
import org.bukkit.Bukkit;

public final class GuardianAngel extends JavaPlugin {

    @Override
    public void onEnable() {

        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Plugin made by DeadSpark");
        // Registering command
        
        getCommand("fly").setExecutor(new Fly());
        getCommand("god").setExecutor(new God());
        getCommand("heal").setExecutor(new Heal());
        getCommand("feed").setExecutor(new Feed());

    }

    @Override
    public void onDisable() {

        // Plugin shutdown logic

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Disabling plugin....");

    }

}
