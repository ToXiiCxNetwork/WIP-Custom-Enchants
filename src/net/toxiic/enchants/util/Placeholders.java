package net.toxiic.enchants.util;

import org.bukkit.entity.Player;

import net.toxiic.enchants.Main;
import me.clip.placeholderapi.external.EZPlaceholderHook;

@SuppressWarnings("deprecation")
public class Placeholders extends EZPlaceholderHook {
	
	public Placeholders(Main plugin) {
		super(plugin, "toxiicranks");
	}
	
	@Override
	public String onPlaceholderRequest(Player p, String identifier) {
		
		if (p == null) {
			return "";
		}
		
		if (identifier.equals("name")) {
			return Util.getEnchName(p);
		}
		
		return null;
	}
}
