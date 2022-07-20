package me.cynshiii.beginnercode.commands.functional;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeSurvival implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("BeginnerCode.Commands.Gamemode.Survival")){
				// setting command permissions
				if (args.length == 0){
					//if player only provides the command with no args (re: /gamemode survival) set gamemode to survival and send msg below
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Set gamemode to Survival");
				} else{
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);
					/*
					setting two variables- playerName being the first argument a player puts in the command
					re: /gamemode survival [argument]
					this variable would take [argument]
					also setting target variable to be the variable we set just before that, for easy use below
					 */
					if (target == null){
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
						// if target is offline, send message above
					} else{
						target.setGameMode(GameMode.SURVIVAL);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Set gamemode to Survival");
						// if target is online, set gamemode to survival and send them msg above
					}
				}
			} else {
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
				// if player doesnt have access to cmd, send msg above
			}
		}

		return true;
	}
}
