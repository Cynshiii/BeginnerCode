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
			// setting variable world to the player's current world
			org.bukkit.block.@NotNull Biome biome = world.getBiome(player.getLocation());
			//setting variable biome, using world variable to get the current biome of the player's current location

			player.sendMessage(ChatColor.LIGHT_PURPLE + "You are currently in a " + biome.toString().toLowerCase() + " biome");
			//send player above message, using biome variable to say what biome they are in
		}

		return true;
	}
}
