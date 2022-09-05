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

		if (!(sender instanceof Player player)){
			return true;
		}
		if (!(player.hasPermission("beginnercode.commands.feed"))){
			player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
			return true;
		}
		if (args.length == 0){
			player.setSaturation(20);
			player.setFoodLevel(20);
			player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been fed");
		}
		String playerName = args[0];
		Player target = Bukkit.getServer().getPlayerExact(playerName);

		if (!(target == null)){
			target.setSaturation(20);
			target.setFoodLevel(20);
			target.sendMessage(ChatColor.LIGHT_PURPLE + "You have been fed");
			return true;
		} else{
			player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
		}
		return true;
		}
	}
