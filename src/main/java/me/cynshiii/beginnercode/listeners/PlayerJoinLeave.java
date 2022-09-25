package me.cynshiii.beginnercode.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinLeave implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		if (!(player.hasPlayedBefore()))
			event.setJoinMessage(ChatColor.LIGHT_PURPLE + "Welcome to the server, " + ChatColor.DARK_PURPLE + player.getName());
		else
			event.setJoinMessage(ChatColor.DARK_PURPLE + player.getName() + ChatColor.LIGHT_PURPLE + " has joined the server, what a NERD");
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		event.setQuitMessage(ChatColor.DARK_PURPLE + player.getName() + ChatColor.LIGHT_PURPLE + " has left, what a NERD");
	}

}
