package net.toxiic.enchants.util.files;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import net.toxiic.enchants.Main;
import net.toxiic.enchants.util.Util;

public class Messages {
	private Messages() {
	}

	static Messages instance = new Messages();
	static Plugin p;
	static FileConfiguration messages;
	static File mfile;

	public static void setup(Plugin p) {
		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();
		}
		mfile = new File(p.getDataFolder(), "messages.yml");
		if (!mfile.exists()) {
			try {
				mfile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(Util.color("&cCould not create messages.yml!"));
			}
		}
		messages = YamlConfiguration.loadConfiguration(mfile);
		newDefault();
	}

	public static FileConfiguration getData() {
		return messages;
	}

	public static void saveData() {
		try {
			messages.save(mfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(Util.color("&cCould not save messages.yml!"));
		}
	}

	public static void reloadData() {
		messages = YamlConfiguration.loadConfiguration(mfile);
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
		if (getData().get("Messages") == null) {
			setData("Messages.Enchant.List.Header", "&7-----&aEnchants&7-----");
			setData("Messages.Enchant.List.Name", Config.getString(".Name"));
		}
	}
	public static String getMessage(String path, Player player, String target) {
		if (target != null) {
			return Util.color(getString(path)
			.replaceAll("%player", player.getName()))
			;
		} else {
			return Util.color(getString(path)
					.replaceAll("%player", player.getName()))
					;
		}
	}
}
