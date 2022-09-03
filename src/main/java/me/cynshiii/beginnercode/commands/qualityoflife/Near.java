package me.cynshiii.beginnercode.commands.qualityoflife;

import me.cynshiii.beginnercode.commands.functional.homes.HomesConfig.HomeOwner.Home;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class Near implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if(!(sender instanceof Player player))
			return true;
		if(!(player.hasPermission("beginnercode.commands.near"))){
			player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
			return true;
		}

		Collection<Player> nearbyPlayers = player.getLocation().getNearbyPlayers(300);

		String message = "Nearby Players: ";
		nearbyPlayers.remove(player);
		//remove sender of command from the command list
		for (Player target : nearbyPlayers) {
			// /near: <playerlist>
			int blocks = (int) player.getLocation().distance(target.getLocation());
			message += target.getName() + " (" + blocks + "m)" + ", ";
		}
		String finalMessage = message.substring(0, message.length()-2);
		//remove unneeded spaces and commas at the end of the message

		player.sendMessage(ChatColor.LIGHT_PURPLE + finalMessage.trim());

		return true;
	}
}
