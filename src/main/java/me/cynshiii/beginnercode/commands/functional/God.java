package me.cynshiii.beginnercode.commands.functional;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class God implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (player.hasPermission("BeginnerCode.Commands.GodCommand")){
				if (args.length == 0){

					if (player.isInvulnerable()){
						player.setInvulnerable(false);
						player.sendMessage(ChatColor.LIGHT_PURPLE + "Godmode disabled");
					} else{
						player.setInvulnerable(true);
						player.sendMessage(ChatColor.LIGHT_PURPLE + "Godmode enabled");
					}

				} else{
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);

					if (target == null){
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
					} else if (target.isInvulnerable()){
						target.setInvulnerable(false);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Godmode disabled");
					} else{
						target.setInvulnerable(true);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Godmode enabled");
					}
				}
			}
		}

		return true;
	}
}
