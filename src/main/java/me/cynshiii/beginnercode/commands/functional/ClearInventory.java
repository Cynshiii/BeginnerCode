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
			if (player.hasPermission("BeginnerCode.Commands.Clear")){
				player.getInventory().clear();
				player.sendMessage(ChatColor.LIGHT_PURPLE + "Inventory Cleared");
			} else{
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to that command");
			}
		}

		return true;
	}
}
