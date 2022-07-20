package me.cynshiii.beginnercode.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinAndLeave implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {

		Player player = event.getPlayer();
		//setting player variable to player

		if(player.hasPlayedBefore()){
			event.setJoinMessage(player.getName() + ChatColor.LIGHT_PURPLE + " has joined the server. Nerd!");
			// if the player HAS joined the server before, send message above when they join
		}
		else{
			event.setJoinMessage(ChatColor.LIGHT_PURPLE + "Welcome to the server, " + ChatColor.LIGHT_PURPLE + player.getName());
			//else, welcome player to the server using player.getName
		}
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent event) {

		Player player = event.getPlayer();

		event.setQuitMessage(player.getName() + ChatColor.LIGHT_PURPLE + " has left, what a nerd!");
		//set player variable to the player and send message above when they leave
	}

}
