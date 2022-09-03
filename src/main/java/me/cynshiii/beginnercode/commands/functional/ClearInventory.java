package me.cynshiii.beginnercode.commands.functional;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearInventory implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("beginnercode.commands.clear")){
				// setting permission node
				player.getInventory().clear();
				//getting the players inventory and clearing it
				player.sendMessage(ChatColor.LIGHT_PURPLE + "Inventory Cleared");
				//sending the player a message about clearing inv
			} else{
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to that command");
				//sending player no access message if they dont have the above permission node
			}
		}

		return true;
	}
}
