package me.cynshiii.beginnercode.spawn.commands;

import me.cynshiii.beginnercode.BeginnerCode;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Spawn implements CommandExecutor{

	private BeginnerCode plugin = null;

	public Spawn(){ this.plugin = plugin; }

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			Location location = plugin.getConfig().getLocation("spawn");

			if (location != null){
				player.teleport(location);
				player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been teleported to spawn");

			}else {
				player.sendMessage(ChatColor.DARK_PURPLE + "There is no set spawnpoint");
			}

		}

		return true;
	}
}