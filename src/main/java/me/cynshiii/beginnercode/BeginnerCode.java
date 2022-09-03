package me.cynshiii.beginnercode;

import me.cynshiii.beginnercode.commands.functional.*;
import me.cynshiii.beginnercode.commands.functional.gamemodes.Adventure;
import me.cynshiii.beginnercode.commands.functional.gamemodes.Creative;
import me.cynshiii.beginnercode.commands.functional.gamemodes.Spectator;
import me.cynshiii.beginnercode.commands.functional.gamemodes.Survival;
import me.cynshiii.beginnercode.commands.functional.homes.*;
import me.cynshiii.beginnercode.commands.functional.homes.HomesConfig.HomeOwner;
import me.cynshiii.beginnercode.commands.functional.homes.HomesConfig.HomeOwner.Home;
import me.cynshiii.beginnercode.commands.qualityoflife.*;
import me.cynshiii.beginnercode.listeners.PlayerJoinLeave;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public final class BeginnerCode extends JavaPlugin {

	public static HomesConfig homesConfig;

	public void save() {
		getConfig().set("homesConfig", homesConfig);
		//save in config (duh)
		saveConfig();
	}

	@Override
	public void onEnable() {

		//config
		ConfigurationSerialization.registerClass(HomesConfig.class);
		ConfigurationSerialization.registerClass(HomeOwner.class);
		ConfigurationSerialization.registerClass(Home.class);

		//config.yml- saving default options
		getConfig().options().copyDefaults();
		saveDefaultConfig();

		/*
		setting commands into config:
		getCommand("command name").setExecutor(new CommandClass());

		getCommand("command name") is just letting you name your command.
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
		getCommand("sethome").setExecutor(new SetHome(this));
		getCommand("delhome").setExecutor(new DelHome(this));
		getCommand("home").setExecutor(new GoHome(this));
		getCommand("homes").setExecutor(new ListHomes(this));
		getCommand("nearbyhomes").setExecutor(new NearbyHomes(this));

		// qol commands
		getCommand("biome").setExecutor(new Biome());
		getCommand("plantable").setExecutor(new Plantable());
		getCommand("repeat").setExecutor(new Repeat());
		getCommand("wordsofencouragement").setExecutor(new WordsofEncouragement());
		getCommand("near").setExecutor(new Near());

		//register listener events
		getServer().getPluginManager().registerEvents(new PlayerJoinLeave(), this);

		//MAGIC BUKKIT SHIT GO BRRRRTTT
		homesConfig = (HomesConfig) getConfig().get("homesConfig");
		if (homesConfig == null)
			homesConfig = new HomesConfig();
		//if config no exist, make it exist

	}

}
