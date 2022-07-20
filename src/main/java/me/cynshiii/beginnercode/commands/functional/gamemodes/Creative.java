package me.cynshiii.beginnercode.commands.functional.gamemodes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Creative implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("BeginnerCode.Commands.Gamemode.Creative")){
				//setting permission node
				if (args.length == 0){
					// if no arguments are provided (re: /gamemode creative) set player to creative and send msg below
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Set gamemode to Creative");
				} else{
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);
					/*
					setting two variables- playerName being the first argument a player puts in the command
					re: /gamemode creative [argument]
					this variable would take [argument]
					also setting target variable to be the variable we set just before that, for easy use below
					 */
					if (target == null){
						// if target is offline send msg below
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
					} else{
						// if target is online, set gamemode to creative and send them msg below
						target.setGameMode(GameMode.CREATIVE);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Set gamemode to Creative");
					}
				}
			} else {
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
				// send msg above if player has no access to the command
			}
		}

		return true;
	}
}
