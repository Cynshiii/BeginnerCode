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
				//setting permission node
				if (args.length == 0){
					//if they provide no arguments, do for sender
					if (player.getAllowFlight()){
						//seeing if theyre already flying, if they are already flying, do below
						player.setAllowFlight(false);
						player.sendMessage(ChatColor.LIGHT_PURPLE + "Flight disabled");
						// setting their flight to false and sending them the above message
					} else{
						player.setAllowFlight(true);
						player.sendMessage(ChatColor.LIGHT_PURPLE + "Flight enabled");
						// if player ISNT already flying, set flight to true and send message above
					}
				} else{
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);
					/*
					setting two variables- playerName being the first argument a player puts in the command
					re: /fly [argument]
					this variable would take [argument]
					also setting target variable to be the variable we set just before that, for easy use below
					 */
					if (target == null){
						// if target is offline, send player msg below
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
					} else if (player.getAllowFlight()){
						target.setAllowFlight(false);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Flight disabled");
						// checking if player is already flying. if they are, set flight to false and send msg above
					} else{
						target.setAllowFlight(true);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Flight enabled");
						// if not flying, set flight to true and send msg above
					}
				}
			} else{
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to that command");
				// if sender of command doesnt have access, send message above
			}
		}

		return true;
	}
}
