package me.cynshiii.beginnercode.commands.functional;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeSpectator implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("BeginnerCode.Commands.Gamemode.Spectator")){
				// setting command permissions
				if (args.length == 0){
					// if player provides no arguments (re: /gamemode spectator) set gamemode to spectator and send msg below)
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Set gamemode to Spectator");
				} else{
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);
					/*
					setting two variables- playerName being the first argument a player puts in the command
					re: /gamemode spectator [argument]
					this variable would take [argument]
					also setting target variable to be the variable we set just before that, for easy use below
					 */
					if (target == null){
						// if target is not online send message below to player
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
					} else{
						// if target is online, set gamemode to spectator and send msg below
						target.setGameMode(GameMode.SPECTATOR);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Set gamemode to Spectator");
					}
				}
			} else {
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
				//send to player if they have no permission for the command
			}
		}

		return true;
	}
}
