package me.cynshiii.beginnercode.commands.functional;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class ItemName implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


		if (!(sender instanceof Player player)){
			return true;
		}
		if (!(player.hasPermission("beginnercode.commands.itemname"))){
			player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
		}
		if (args.length == 0){
			player.sendMessage(ChatColor.DARK_PURPLE + "No arguments given");
		} else{
			ItemStack inhand = player.getItemInHand();
			if (inhand != null){
				ItemMeta itemMeta = inhand.getItemMeta();
				itemMeta.setDisplayName(args[0].replace("_", " "));
				inhand.setItemMeta(itemMeta);
				String itemName = player.getItemInHand().getItemMeta().getDisplayName();
				player.sendMessage(ChatColor.LIGHT_PURPLE + "Your item has been renamed to " + itemName);
			}
		}
		return true;
	}
}
