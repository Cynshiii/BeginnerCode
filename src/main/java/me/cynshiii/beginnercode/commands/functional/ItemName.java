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

		if (sender instanceof Player player){
			if(player.hasPermission("BeginnerCode.Commands.ItemName")){
				// setting command permission
				if (args.length == 0){
					player.sendMessage(ChatColor.DARK_PURPLE + "No arguments given");
					// if player just runs the command (re: /itemname), send message above
				} else{
					ItemStack inhand = player.getItemInHand();
					//setting variable "inhand" to be the item in player's hand at the time of running command
					if (inhand != null){
						// if their hand is NOT empty, continue
						ItemMeta itemMeta = inhand.getItemMeta();
						//setting itemMeta variable to catch inhand item meta

						itemMeta.setDisplayName(args[0].replace("_", " "));
						//setting the itemmeta of inhand to given arguments, replacing any '_' with spaces
						inhand.setItemMeta(itemMeta);
						// setting itemmeta to current so it saves

						String itemName = player.getItemInHand().getItemMeta().getDisplayName();
						//setting itemName variable to use in message below

						player.sendMessage(ChatColor.LIGHT_PURPLE + "Your item has been renamed to " + itemName);
						//sending player message with new item name using itemName variable

					}
				}
			}
		}

		return true;
	}
}
