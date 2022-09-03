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

		if(!(sender instanceof Player player))
			return true;
		if(!(player.hasPermission("beginnercode.commands.trash"))){
			player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
			return true;
		}

		Inventory inventory = Bukkit.createInventory(player, 54, ChatColor.LIGHT_PURPLE + "Disposal");
		// setting inventory variable for use below, making the inventory being opened 54 spaces (double chest) and naming it "Disposal"
		player.openInventory(inventory);
		//make player open the inventory we made above

		return true;
		}
	}
