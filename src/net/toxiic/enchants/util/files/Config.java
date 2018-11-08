package net.toxiic.enchants.util.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import net.toxiic.enchants.util.Util;

public class Config {
	private Config() {}	
	static Config instance = new Config();
	static Plugin p;
	public static FileConfiguration config;
	static File cfile;
	
	public static void setup(Plugin p) {
		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();
		}
		cfile = new File(p.getDataFolder(), "config.yml");
		if (!cfile.exists()) {
			try {
				cfile.createNewFile();
			} catch(IOException e) {
				Bukkit.getServer().getLogger().severe(Util.color("&cCould not create config.yml!"));
			}
		}
		config = YamlConfiguration.loadConfiguration(cfile);
		newDefault();
	}
	
	public static FileConfiguration getData() {
		return config;
	}
	
	public static void saveData() {
		try {
			config.save(cfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(Util.color("&cCould not save config.yml!"));
		}
	}
	
	public static void reloadData() {
		config = YamlConfiguration.loadConfiguration(cfile);
	}
	
	public static PluginDescriptionFile getDesc() {
		return p.getDescription();
	}

	public static int getInt(String path) {
		return Integer.valueOf(getString(path));
	}

	public static double getDouble(String path) {
		return Double.valueOf(getString(path));
	}
	
	public static boolean getBoolean(String path) {
		return getData().getBoolean(path);
	}

	public static long getLong(String path) {
		return getData().getLong(path);
	}

	public static List<String> getList(String path) {
		return getData().getStringList(path);
	}

	public static String getString(String path) {
		return getData().getString(path);
	}

	public static Object get(String path) {
		return getData().get(path);
	}

	public static ItemStack getItemStack(String path) {
		return getData().getItemStack(path);
	}

	public static void setData(String path, Object obj) {
		getData().set(path, obj);
		saveData();
		reloadData();
	}
	
	public static void newDefault() {
		if (getData().getString("Config.Build") == null || !getData().getString("Config.Build").equals("0.1")) {
			ArrayList<String> effects = new ArrayList<String>();
			
			setData("Config.Build", "0.1");
			
			setData("Config.Enchants.Test.Name", "Test");
			setData("Config.Enchants.Test.Enchant ID", "101");
			setData("Config.Enchants.Test.Is Enabled", "true");
			setData("Config.Enchants.Test.Max Enchant Level","3");
			setData("Config.Enchants.Test.Effects", effects);
			
			setData("Config.Enchants.Test2.Name", "Test2");
			setData("Config.Enchants.Test2.Enchant ID", "102");
			setData("Config.Enchants.Test2.Is Enabled", "true");
			setData("Config.Enchants.Test2.Max Enchant Level","3");
			setData("Config.Enchants.Test2.Effects", effects);
			
		}
	}

}
