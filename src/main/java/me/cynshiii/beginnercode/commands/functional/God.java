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
				//setting cmd permissions
				if (args.length == 0){
					//if player only gives command (re: /god)

					if (player.isInvulnerable()){
						//checking to see if theyre already invulnerable
						player.setInvulnerable(false);
						player.sendMessage(ChatColor.LIGHT_PURPLE + "Godmode disabled");
						//if invulnerable, set to false and send message above
					} else{
						player.setInvulnerable(true);
						player.sendMessage(ChatColor.LIGHT_PURPLE + "Godmode enabled");
						//if not invulnerable, set to true and send msg above
					}

				} else{
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayerExact(playerName);
					/*
					setting two variables- playerName being the first argument a player puts in the command
					re: /god [argument]
					this variable would take [argument]
					also setting target variable to be the variable we set just before that, for easy use below
					 */
					if (target == null){
						//if target is offline, send message below to player
						player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
					} else if (target.isInvulnerable()){
						//checking invulnerability status of target
						target.setInvulnerable(false);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Godmode disabled");
						// if target is invulnerable, set false and send msg above
					} else{
						target.setInvulnerable(true);
						target.sendMessage(ChatColor.LIGHT_PURPLE + "Godmode enabled");
						// if target is not invulnerable, set to true and send msg above
					}
				}
			} else{
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to that command");
				// if player has no access to command, send message above
			}
		}

		return true;
	}
}
