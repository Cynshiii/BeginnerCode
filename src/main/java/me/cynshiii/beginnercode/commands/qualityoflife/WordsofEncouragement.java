package me.cynshiii.beginnercode.commands.qualityoflife;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WordsofEncouragement implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			String playerName = player.getName();
			//setting playerName variable to the player's name and sending the msg below
			player.sendMessage(ChatColor.LIGHT_PURPLE + "You're doing amazing, " + playerName + "!");
		}

		return true;
	}
}