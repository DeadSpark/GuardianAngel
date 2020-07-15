package me.deadspark.plugin.guardianangel.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Objects;

public class Feed implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            if (args.length == 0) {

                Player player = (Player) sender;

                player.setFoodLevel(20);
                player.sendMessage(ChatColor.AQUA + player.getDisplayName() + " You have been fed");

            }

            if (args.length > 0) {

                Player target = Bukkit.getPlayer(args[0]);
                Player player = (Player) sender;

                Objects.requireNonNull(target).sendMessage(ChatColor.AQUA + target.getDisplayName() + " You have been fed by an Angel");
                player.sendMessage(ChatColor.GREEN + "Successfully fed " + target.getDisplayName());
                target.setFoodLevel(20);

            }

        }else {

            if (args.length == 0) {

                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Please provide a player name");

            }

            if (args.length > 0) {

                Player ctarget = Bukkit.getPlayer(args[0]);

                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Successfully fed " + ctarger.getDisplayName());
                ctarget.sendMessage(ChatColor.AQUA + "You have been fed by an Angel");
                ctarget.setFoodLevel(20);

            }

        }

        return false;
    }

}
