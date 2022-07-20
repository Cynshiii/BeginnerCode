package me.cynshiii.beginnercode;

import me.cynshiii.beginnercode.commands.functional.*;
import me.cynshiii.beginnercode.commands.functional.gamemodes.Adventure;
import me.cynshiii.beginnercode.commands.functional.gamemodes.Creative;
import me.cynshiii.beginnercode.commands.functional.gamemodes.Spectator;
import me.cynshiii.beginnercode.commands.functional.gamemodes.Survival;
import me.cynshiii.beginnercode.commands.qualityoflife.Biome;
import me.cynshiii.beginnercode.commands.qualityoflife.Plantable;
import me.cynshiii.beginnercode.commands.qualityoflife.Repeat;
import me.cynshiii.beginnercode.commands.qualityoflife.WordsofEncouragement;
import org.bukkit.plugin.java.JavaPlugin;

public final class BeginnerCode extends JavaPlugin {

	@Override
	public void onEnable() {

		//config.yml- saving default options
		getConfig().options().copyDefaults();
		saveDefaultConfig();

		/*
		setting commands into config:
		getCommand("command name").setExecutor(new CommandClass());

		getCommand("command name" is just letting you name your command.
		.setExecutor(new CommandClass()); is letting the command name you set above execute the code for the class you coded the actual command in-
		making a new instance of the command's class so that it can actually run
		 */

		// functional commands
		getCommand("god").setExecutor(new God());
		getCommand("feed").setExecutor(new Feed());
		getCommand("heal").setExecutor(new Heal());
		getCommand("itemname").setExecutor(new ItemName());
		getCommand("fly").setExecutor(new Fly());
		getCommand("clearinventory").setExecutor(new ClearInventory());
		getCommand("disposal").setExecutor(new Disposal());
		getCommand("gamemode adventure").setExecutor(new Adventure());
		getCommand("gamemode creative").setExecutor(new Creative());
		getCommand("gamemode spectator").setExecutor(new Spectator());
		getCommand("gamemode survival").setExecutor(new Survival());

		// qol commands
		getCommand("biome").setExecutor(new Biome());
		getCommand("plantable").setExecutor(new Plantable());
		getCommand("repeat").setExecutor(new Repeat());
		getCommand("wordsofencouragement").setExecutor(new WordsofEncouragement());

	}

}
