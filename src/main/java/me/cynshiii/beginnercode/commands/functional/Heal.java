package me.cynshiii.beginnercode.commands.functional;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Heal implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("beginnercode.commands.heal")){
				//setting command permissions
				if (args.length == 0){
					//if player gives no arguments to command (re: /heal)

					player.setFoodLevel(20);
					player.setSaturation(20);
					player.setHealth(20);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been healed");
					// set player health, food, and saturation to 20, and send msg above
				} else{
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);
					/*
					setting two variables- playerName being the first argument a player puts in the command
					re: /heal [argument]
					this variable would take [argument]
					also setting target variable to be the variable we set just before that, for easy use below
					 */

					if (target == null){
						// if target is not online send msg below
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
					} else {
						target.setFoodLevel(20);
						target.setSaturation(20);
						target.setHealth(20);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "You have been healed");
						//if target is online, set health, hunger, and saturation to 20 and send msg above
					}
				}
			} else{
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to that command");
				//send message above if player doesnt have the correct permission
			}
		}

		return true;
	}
}
