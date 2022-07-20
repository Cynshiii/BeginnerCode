package me.cynshiii.beginnercode.spawn;

import me.cynshiii.beginnercode.BeginnerCode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

	private final BeginnerCode plugin;

	public SpawnListeners(BeginnerCode plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){

		Player player = event.getPlayer();

		if(!event.getPlayer().hasPlayedBefore()){
			Location location = plugin.getConfig().getLocation("spawn");

			if (location != null){
				player.teleport(location);

			}
		}

	}

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event){

		// when player dies, respawn at spawn if it is set

		Location location = plugin.getConfig().getLocation("spawn");
		if (location != null){
			event.setRespawnLocation(location);
		}

	}

}
