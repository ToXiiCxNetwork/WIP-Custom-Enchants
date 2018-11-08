package net.toxiic.enchants.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.toxiic.enchants.util.files.Messages;

public class Commands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) { // So console can't access command.
			sender.sendMessage("You must be a player to do this command!");

			return false;
		} else {
		Player p = (Player) sender;
	    if (args.length == 0) {//  /toxiicenchants 
	       p.sendMessage("Try Using /te help");
	       return true;
	      } else 
	    	  	if (args.length == 1){
	    	  		if (args[0].equalsIgnoreCase("list") && p.hasPermission("toxiicxenchant.list")) {
	                    p.sendMessage(Messages.getMessage("Message.Enchant.List.Header", p, null));
	                    p.sendMessage(Messages.getMessage("Message.Enchant.List.Name", p, null).replaceAll("%name", "test"));
	                }
	    	  	}
		}
		return false;
	}
}
