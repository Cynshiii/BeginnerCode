package me.cynshiii.beginnercode.commands.functional;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Fly implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("BeginnerCode.Commands.FlyCommand")){
				if (args.length == 0){
					if (player.getAllowFlight()){
						player.setAllowFlight(false);
						player.sendMessage(ChatColor.LIGHT_PURPLE + "Flight disabled");
					} else{
						player.setAllowFlight(true);
						player.sendMessage(ChatColor.LIGHT_PURPLE + "Flight enabled");
					}
				} else{
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);
					if (target == null){
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
					} else if (player.getAllowFlight()){
						target.setAllowFlight(false);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Flight disabled");
					} else{
						target.setAllowFlight(true);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Flight enabled");
					}
				}
			} else{
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to that command");
			}
		}

		return true;
	}
}
