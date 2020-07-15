package me.deadspark.plugin.guardianangel.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.Objects;

public class Fly implements CommandExecutor {

    ArrayList<Player> player_list = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            if (args.length == 0) {

                Player player = (Player) sender;

                if (!player_list.contains(player)) {

                    player.setAllowFlight(true);
                    player_list.add(player);
                    player.sendMessage(ChatColor.AQUA + "Flight mode has been Enabled for " + player.getDisplayName());

                }else if (player_list.contains(player)) {

                    player.setAllowFlight(false);
                    player_list.remove(player);
                    player.sendMessage(ChatColor.AQUA + "Flight mode has been Disabled for " + player.getDisplayName());

                }

            }else if (args.length == 1) {

                Player target = Bukkit.getPlayer(args[0]);
                if (!player_list.contains(target)) {

                    Objects.requireNonNull(target).setAllowFlight(true);
                    player_list.add(target);
                    target.sendMessage(ChatColor.AQUA + "Flight mode has been Enabled for " + target.getDisplayName());

                }else if (player_list.contains(target)) {

                    Objects.requireNonNull(target).setAllowFlight(false);
                    player_list.remove(target);
                    target.sendMessage(ChatColor.AQUA + "Flight mode has been Disabled for " + target.getDisplayName());

                }

            }

        }else {

            if (args.length == 0) {

                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Please provide a player name");

            }

            if (args.length > 0) {

                Player ctarget = Bukkit.getPlayer(args[0]);

                if (player_list.contains(ctarget)) {

                    Objects.requireNonNull(ctarget).setAllowFlight(false);
                    player_list.remove(ctarget);
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Flight mode for target has been disabled");
                    ctarget.sendMessage(ChatColor.AQUA + "Flight mode has been Disabled for " + ctarget.getDisplayName());

                }else if (!player_list.contains(ctarget)) {

                    Objects.requireNonNull(ctarget).setAllowFlight(true);
                    player_list.add(ctarget);
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Flight mode for target has been enabled");
                    ctarget.sendMessage(ChatColor.AQUA + "Flight mode has been Enabled for " + ctarget.getDisplayName());

                }

            }

        }

    return false;
    }

}
