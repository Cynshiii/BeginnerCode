package me.cynshiii.beginnercode.commands.functional.homes;

import me.cynshiii.beginnercode.BeginnerCode;
import me.cynshiii.beginnercode.commands.functional.homes.HomesConfig.HomeOwner.Home;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static me.cynshiii.beginnercode.BeginnerCode.homesConfig;

public class ListHomes implements CommandExecutor {

	BeginnerCode plugin;

	public ListHomes(BeginnerCode plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player player))
			return true;

		if (!player.hasPermission("homes.list")) {
			player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
			return true;
		}

		HomesConfig.HomeOwner homeOwner = homesConfig.getHomeOwner(player);

		String message = "Homes: ";
		for (Home home : homeOwner.getHomes()) {
			// Homes: <homes>
			message += home.getName() + " ";
		}
		player.sendMessage(ChatColor.LIGHT_PURPLE + message.trim());

		return true;
	}
}
