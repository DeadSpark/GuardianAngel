package me.deadspark.plugin.guardianangel.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Objects;

public class Heal implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            if (args.length == 0) {

                Player player = (Player) sender;

                player.setHealth(20.00);
                player.sendMessage(ChatColor.AQUA + player.getDisplayName() + " You have been healed");

            }

            if (args.length > 0) {

                Player target = Bukkit.getPlayer(args[0]);
                Player player = (Player) sender;

                Objects.requireNonNull(target).sendMessage(ChatColor.AQUA + target.getDisplayName() + " You have been healed by an Angel");
                player.sendMessage(ChatColor.GREEN + "Successfully healed " + target.getDisplayName());
                target.setHealth(20.00);

            }

        }else {

            if (args.length == 0) {

                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "please provide a player name");

            }

            if (args.length > 0) {

                Player ctarget = Bukkit.getPlayer(args[0]);

                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Successfully healed target");
                ctarget.sendMessage(ChatColor.AQUA + "You have been healed by an Angel");
                ctarget.setHealth(20.00);

            }

        }

        return false;
    }

}
