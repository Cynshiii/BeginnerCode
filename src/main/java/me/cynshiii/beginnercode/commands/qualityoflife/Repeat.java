package me.cynshiii.beginnercode.commands.qualityoflife;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Repeat implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player player){
			if (args.length == 0){
				//if player provides no arguments, send message below.
				player.sendMessage(ChatColor.DARK_PURPLE + "You did not provide any arguments");
			} else if (args.length == 1){
				//else, if player provides one argument, put it into 'word' variable to use easier
				String word = args[0];
				player.sendMessage("Message: " + word);
				//send player their argument back to them with Message: attached to the front
			} else {
				StringBuilder builder = new StringBuilder();
				//creating a new string builder variable to use below

				for(int i = 0; i < args.length; i++){
					//if player provides >1 argument
					builder.append(args[i]);
					builder.append(" ");
					//taking each argument from builder. appending them to add a space at the end of each one
					//this way you get "args args args" instead of "arg""arg""arg"
				}
				//convert final string builder into "finalMessage" variable for easy use on sendMessage
				String finalMessage = builder.toString();
				finalMessage = finalMessage.stripTrailing();
				//removing any whitespace at the end of the message before sending it to the player
				player.sendMessage("Final Message: " + finalMessage);
				//send the player their args back to them with "Final message:" attached to the front
			}
		}
		return true;
	}
}