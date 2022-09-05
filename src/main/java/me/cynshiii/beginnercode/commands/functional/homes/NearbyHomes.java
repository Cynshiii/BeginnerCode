package me.cynshiii.beginnercode.commands.functional.homes;

import me.cynshiii.beginnercode.BeginnerCode;
import me.cynshiii.beginnercode.commands.functional.homes.HomesConfig.HomeOwner;
import me.cynshiii.beginnercode.commands.functional.homes.HomesConfig.HomeOwner.Home;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static me.cynshiii.beginnercode.BeginnerCode.homesConfig;

public class NearbyHomes implements CommandExecutor {

	BeginnerCode plugin;

	public NearbyHomes(BeginnerCode plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if(!(sender instanceof Player player))
			return true;
		if(!(player.hasPermission("homes.nearby"))){
			player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
			return true;
		}

		HomesConfig.HomeOwner homeOwner = homesConfig.getHomeOwner(player);
		String message = "Nearby Homes: ";

		List<Home> homes = homeOwner.getHomes();
		for (Home home : homes){
			int blocks = (int) player.getLocation().distance(home.getLocation());
			message += home.getName() + " (" + blocks + "m)" + ", ";
		}

		String finalMessage = message.substring(0, message.length()-2);
		player.sendMessage(ChatColor.LIGHT_PURPLE + finalMessage.trim());

		return true;
	}
}