package me.cynshiii.beginnercode.commands.functional;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCreative implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("BeginnerCode.Commands.Gamemode.Creative")){
				if (args.length == 0){
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Set gamemode to Creative");
				} else{
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);
					if (target == null){
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
					} else{
						target.setGameMode(GameMode.CREATIVE);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Set gamemode to Creative");
					}
				}
			} else {
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
			}
		}

		return true;
	}
}