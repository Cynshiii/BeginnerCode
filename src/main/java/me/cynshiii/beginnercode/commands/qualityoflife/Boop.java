package me.cynshiii.beginnercode.commands.qualityoflife;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Boop implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player player)){
			return true;
		}
		if (!(player.hasPermission("beginnercode.commands.boop"))){
			player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
			return true;
		}

		String playerName = args[0];
		Player target = Bukkit.getServer().getPlayerExact(playerName);

		if (target == null){
			player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
			return true;
		}
		target.sendMessage(ChatColor.LIGHT_PURPLE + "Someone has booped you!");
		player.sendMessage(ChatColor.LIGHT_PURPLE + "You have booped " + playerName + "!");

		return true;
	}
}
