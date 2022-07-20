package me.cynshiii.beginnercode;

import me.cynshiii.beginnercode.commands.functional.*;
import me.cynshiii.beginnercode.commands.qualityoflife.Biome;
import me.cynshiii.beginnercode.commands.qualityoflife.Plantable;
import me.cynshiii.beginnercode.commands.qualityoflife.Repeat;
import me.cynshiii.beginnercode.commands.qualityoflife.WordsofEncouragement;
import me.cynshiii.beginnercode.listeners.JoinAndLeave;
import me.cynshiii.beginnercode.spawn.commands.SetSpawn;
import me.cynshiii.beginnercode.spawn.commands.Spawn;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BeginnerCode extends JavaPlugin {

	@Override
	public void onEnable() {

		//config.yml
		getConfig().options().copyDefaults();
		saveDefaultConfig();

		// functional commands
		getCommand("god").setExecutor(new God());
		getCommand("feed").setExecutor(new Feed());
		getCommand("heal").setExecutor(new Heal());
		getCommand("itemname").setExecutor(new ItemName());
		getCommand("fly").setExecutor(new Fly());

		// qol commands
		getCommand("biome").setExecutor(new Biome());
		getCommand("plantable").setExecutor(new Plantable());
		getCommand("repeat").setExecutor(new Repeat());
		getCommand("wordsofencouragement").setExecutor(new WordsofEncouragement());
		// spawn commands
		getCommand("setspawn").setExecutor(new SetSpawn());
		getCommand("spawn").setExecutor(new Spawn());
		//registering commands in other classes. name in "" = command name

	}

}
