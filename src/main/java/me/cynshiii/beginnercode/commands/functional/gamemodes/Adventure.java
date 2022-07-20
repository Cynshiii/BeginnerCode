package me.cynshiii.beginnercode.commands.functional.gamemodes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Adventure implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("BeginnerCode.Commands.Gamemode.Adventure")){
				// setting permission node
				if (args.length == 0){
					// if player provides no arguments (re: just does /gamemode adventure
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Set gamemode to Adventure");
					// set gamemode to adventure and send message above
				} else{
					//if player does provide argument (re: does /gamemode aventure [player name]
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);
					/*
					setting two variables- playerName being the first argument a player puts in the command
					re: /gamemode adventure [argument]
					this variable would take [argument]
					also setting target variable to be the variable we set just before that, for easy use below
					 */
					if (target == null){
						// if target is offline send message below
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
					} else{
						// if target is online, set gamemode to adventure and send message below
						target.setGameMode(GameMode.ADVENTURE);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Set gamemode to Adventure");
					}
				}
			} else {
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
				// send msg above if player sending cmd does not have access
			}
		}

		return true;
	}
}
