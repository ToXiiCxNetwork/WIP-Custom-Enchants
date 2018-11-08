package net.toxiic.enchants.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandUnbreakable implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length > 0) {
				ItemStack item = player.getItemInHand();
				ItemMeta meta = item.getItemMeta();
				meta.setUnbreakable(true);
				meta.spigot().setUnbreakable(true);
				meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				item.setItemMeta(meta);
				player.setItemInHand(item);
				return true;
			} else {
				ItemStack item = player.getItemInHand();
				ItemMeta meta = item.getItemMeta();
				meta.setUnbreakable(true);
				if (meta.hasItemFlag(ItemFlag.HIDE_UNBREAKABLE)) {
					meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				}
				item.setItemMeta(meta);
				player.setItemInHand(item);
				return true;
			}
		}
		return false;
	}
}
