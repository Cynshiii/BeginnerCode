package me.cynshiii.beginnercode.commands.functional.homes;

import me.cynshiii.beginnercode.BeginnerCode;
import me.cynshiii.beginnercode.commands.functional.homes.HomesConfig.HomeOwner.Home;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static me.cynshiii.beginnercode.BeginnerCode.homesConfig;


public class DelHome implements CommandExecutor {

	BeginnerCode plugin;

	public DelHome(BeginnerCode plugin){this.plugin = plugin;}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player player))
			return true;

		if (!(player.hasPermission("homes.delhome")))
			player.sendMessage(ChatColor.DARK_PURPLE + "You do not have access to this command");

		HomesConfig.HomeOwner homeOwner = homesConfig.getHomeOwner(player);

		if (!(plugin.getConfig().getBoolean("enable")))
			return true;

		if (args.length == 1){
			Home home = homeOwner.getHome(args[0]);
			if (home == null){
				player.sendMessage(ChatColor.DARK_PURPLE + "You do not have a home called " + args[0]);
				return true;
			}
			homeOwner.getHomes().remove(home);
			plugin.save();
			player.sendMessage(ChatColor.LIGHT_PURPLE + "Home " + args[0] + " removed");
		}
		return true;
	}
}
