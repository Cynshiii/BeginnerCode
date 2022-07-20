package me.cynshiii.beginnercode;

import me.cynshiii.beginnercode.commands.functional.Feed;
import me.cynshiii.beginnercode.commands.functional.God;
import me.cynshiii.beginnercode.commands.functional.Heal;
import me.cynshiii.beginnercode.commands.functional.ItemName;
import me.cynshiii.beginnercode.commands.qualityoflife.Biome;
import me.cynshiii.beginnercode.commands.qualityoflife.Plantable;
import me.cynshiii.beginnercode.commands.qualityoflife.Repeat;
import me.cynshiii.beginnercode.commands.qualityoflife.WordsofEncouragement;
import org.bukkit.plugin.java.JavaPlugin;

public final class BeginnerCode extends JavaPlugin {

	@Override
	public void onEnable() {
		// Plugin startup logic
		getCommand("god").setExecutor(new God());
		getCommand("feed").setExecutor(new Feed());
		getCommand("heal").setExecutor(new Heal());
		getCommand("itemname").setExecutor(new ItemName());
		getCommand("biome").setExecutor(new Biome());
		getCommand("plantable").setExecutor(new Plantable());
		getCommand("repeat").setExecutor(new Repeat());
		getCommand("wordsofencouragement").setExecutor(new WordsofEncouragement());
		//registering commands in other classes. name in "" = command name

	}

}
