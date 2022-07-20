package me.cynshiii.beginnercode.listeners;

import me.cynshiii.beginnercode.BeginnerCode;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.net.http.WebSocket;

public class DeathListener implements WebSocket.Listener {

	private BeginnerCode beginnerCode = null;
	//setting beginnerCode variable here to use down below

	public DeathListener(){
		this.beginnerCode = beginnerCode;
		//accessing beginnerCode class within this class
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getPlayer();
		player.sendMessage(ChatColor.DARK_PURPLE + "You have died");
	}

}
