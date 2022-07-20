package me.cynshiii.beginnercode.spawn.commands;

import me.cynshiii.beginnercode.BeginnerCode;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawn implements CommandExecutor {

	private BeginnerCode plugin = null;

	public SetSpawn() {this.plugin = plugin;}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player) {

			Location location = player.getLocation();

			/*
			1. Save each value of the location, x, y, z worldname etc
			plugin.getConfig().set("spawn.x", location.getX());
			plugin.getConfig().set("spawn.y", location.getY());
			plugin.getConfig().set("spawn.z", location.getZ());
			plugin.getConfig().set("spawn.worldName", location.getWorld());
			 */

			// 2. Save the location object directly
			plugin.getConfig().set("spawn", location);
			plugin.saveConfig();
			player.sendMessage(ChatColor.LIGHT_PURPLE + "Spawn location set");

		}else {
			System.out.println(ChatColor.DARK_PURPLE + "Error: Online player not found");
		}

		return true;
	}
}