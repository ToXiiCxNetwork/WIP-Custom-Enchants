package net.toxiic.enchants.enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import net.toxiic.enchants.util.files.Config;

public class GlowEnchant extends Enchantment {

	int lvl = Config.getInt(".enchantlvl");
	
	public GlowEnchant(NamespacedKey key) {
		super(key);
	}
	
	public int getId() {
			return Config.getInt("Enchant ID");
	}

	@Override
	public boolean canEnchantItem(ItemStack arg0) {
		return false;
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return null;
	}

	@Override
	public int getMaxLevel() {
		return lvl;
	}

	@Override
	public String getName() {
		return (String) (Config.get(".name")) ;
	}

	@Override
	public int getStartLevel() {
		return 1;
	}

	@Override
	public boolean isCursed() {
		return false;
	}

	@Override
	public boolean isTreasure() {
		return false;
	}

}
