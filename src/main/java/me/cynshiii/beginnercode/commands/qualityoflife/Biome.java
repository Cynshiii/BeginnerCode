package me.cynshiii.beginnercode.commands.qualityoflife;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Biome implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){

			World world = player.getWorld();
			org.bukkit.block.@NotNull Biome biome = player.getLocation().getBlock().getBiome();

			player.sendMessage(ChatColor.LIGHT_PURPLE + "You are currently in a " + biome.toString().toLowerCase() + " biome");
		}

		return true;
	}
}
