package net.toxiic.enchants;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import net.toxiic.enchants.commands.Commands;
import net.toxiic.enchants.util.files.Config;

public class Main extends JavaPlugin {
	private static final Logger log = Logger.getLogger("Minecraft");
	public static Main plugin;
	
	public void onEnable() {
		Bukkit.getLogger().info("[ToXiiCxEnchants] Is developed and supported by the ToXiiC Community");
		Bukkit.getLogger().info("[ToXiiCxEnchants] Join us at discord.toxiic.net");
		
		plugin=this;
		Config.setup(plugin);
		registerCommands();
	}
	
	public void onDisable() {
		PluginDescriptionFile pdf = getDescription();
		Logger logger = Logger.getLogger("Minecraft");
		
		logger.info(pdf.getName() + "has been disabled");
	}
	
	public void registerCommands() {
		Bukkit.getPluginCommand("toxiicenchants").setExecutor(new Commands());
	}
}
