package net.toxiic.enchants;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;

import net.toxiic.enchants.util.files.Config;

public class Basic {
	  
	public static enum Trigger{
	    INTERACT,  INTERACT_ENTITY,  INTERACT_LEFT,  INTERACT_RIGHT,  MOVE,  DAMAGE_GIVEN,  DAMAGE_TAKEN,  DAMAGE_NATURE,  BLOCK_PLACED,  BLOCK_BROKEN,  SHOOT_BOW,  PROJECTILE_THROWN,  PROJECTILE_HIT,  WEAR_ITEM,  DEATH;
	}
	
	protected Plugin main = Main.plugin;
	protected String displayName;
	protected String originalName;
	protected String permissionName;
	protected String typeString;
	@SuppressWarnings("unchecked")
	protected HashMap<PotionEffectType, Integer> potionsOnWear = new HashMap();
	@SuppressWarnings("rawtypes")
	protected Map<String, Object> configEntries = new LinkedHashMap();
	
	public Plugin getPlugin() {
		return this.main;	
	}
	
	public String getDisplayName() {
		return this.displayName;
	}
	
	public String getOriginalName() {
		return this.originalName;
	}
	
	public String getPermissionName() {
		return this.permissionName;
	}
	
	public HashSet<Trigger> getTriggers(){
		return this.getTriggers();
	}
	
	public FileConfiguration getConfig() {
		return Config.config;
	}
	
	public String getType() {
		return this.typeString;
	}
	
	public HashMap<PotionEffectType, Integer> getPotionEffectsOnWear(){
		return this.potionsOnWear;
		
	}
}
