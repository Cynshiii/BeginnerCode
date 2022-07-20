package me.cynshiii.beginnercode.commands.functional;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class Disposal implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("BeginnerCode.Commands.Disposal")){

				Inventory inventory = Bukkit.createInventory(player, 54, ChatColor.LIGHT_PURPLE + "Disposal");

				player.openInventory(inventory);

			} else{
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
			}

		}

		return true;
	}
}
