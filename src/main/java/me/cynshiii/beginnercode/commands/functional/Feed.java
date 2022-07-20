package me.cynshiii.beginnercode.commands.functional;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Feed implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("BeginnerCode.Commands.FeedCommand")){
				//setting permission node
				if(args.length == 0){
					//if player provides no arguments, do below
					player.setFoodLevel(20);
					player.setSaturation(20);
					//set player's food and saturation to 20
					player.sendMessage(ChatColor.LIGHT_PURPLE + "You no longer feel hungry");
					//send player message
				} else{
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);
					/*
					setting two variables- playerName being the first argument a player puts in the command
					re: /feed [argument]
					this variable would take [argument]
					also setting target variable to be the variable we set just before that, for easy use below
					 */

					if(target == null){
						// if target variable (set above) is not online, send message below
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
					} else{
						target.setFoodLevel(20);
						target.setSaturation(20);
						// if target variable IS online, set food and saturation to 20
						target.sendMessage(ChatColor.LIGHT_PURPLE + "You no longer feel hungry");
						//after setting food/saturation to 20, send message above
					}
				}
			} else{
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to that command");
				// if player doesnt have access to command, send message above
			}
		}

		return true;
	}
}
