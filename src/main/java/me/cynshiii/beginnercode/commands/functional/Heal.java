package me.cynshiii.beginnercode.commands.functional;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Heal implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("BeginnerCode.Commands.Heal")){
				if (args.length == 0){

					player.setFoodLevel(20);
					player.setSaturation(20);
					player.setHealth(20);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been healed");
				} else{
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);

					if (target == null){
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
					} else {
						target.setFoodLevel(20);
						target.setSaturation(20);
						target.setHealth(20);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "You have been healed");
					}
				}
			} else{
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to that command");
			}
		}

		return true;
	}
}
