package me.cynshiii.beginnercode.commands.qualityoflife;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Plantable implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){

			byte light = player.getLocation().getBlock().getLightLevel();
			// setting a byte variable called 'light' that gets the light level of the block the player is standing on

			if (light < 9){
				// if variable light is less than 9, send message below
				player.sendMessage(ChatColor.DARK_PURPLE + "You cannot plant here, it is too dark");
			} else{
				player.sendMessage(ChatColor.LIGHT_PURPLE + "It is bright enough to plant here");
				// if variable light is greater than or equal to 9, send message above
			}
		}

		return true;
	}
}
