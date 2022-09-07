package me.cynshiii.beginnercode.commands.qualityoflife;

import net.kyori.adventure.sound.Sound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Boop implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player player))
			return true;

		if (!(player.hasPermission("beginnercode.commands.boop"))){
			player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");
			return true;
		}

		String targetName = args[0];
		Player target = Bukkit.getServer().getPlayerExact(targetName);

		if (target == null){
			player.sendMessage(ChatColor.DARK_PURPLE + "That player is not online");
			return true;
		}

		if (args.length > 2){
			player.sendMessage(ChatColor.DARK_PURPLE + "Error: Too many arguments");
			return true;
		}
		if (args.length == 2){
			if (!(args[1].equals("-a"))){
				player.sendMessage(ChatColor.DARK_PURPLE + "Error: Unexpected arguments");
				return true;
			} else{
				target.sendMessage( ChatColor.LIGHT_PURPLE + "Someone has anonymously booped you!");
				target.playSound(target.getLocation(), org.bukkit.Sound.BLOCK_NOTE_BLOCK_XYLOPHONE, 0.5F, 1F);
				player.sendMessage(ChatColor.LIGHT_PURPLE + "You have booped " + targetName + "!");
			}
		} else if (args.length == 1){
			target.sendMessage(ChatColor.DARK_PURPLE + player.getName() + ChatColor.LIGHT_PURPLE + " has booped you!");
			target.playSound(target.getLocation(), org.bukkit.Sound.BLOCK_NOTE_BLOCK_XYLOPHONE, 0.5F, 1F);
			player.sendMessage(ChatColor.LIGHT_PURPLE + "You have booped " + targetName + "!");
		} else{
			player.sendMessage(ChatColor.DARK_PURPLE + "You cannot boop yourself!");
		}
		return true;
	}
}