package fr.raraph84.topluck.utils;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

	public static ItemStack getItem(Material material, String name, boolean brillant, int number, List<String> lore) {

		ItemStack item = new ItemStack(material, number);
		ItemMeta itemMeta = item.getItemMeta();

		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

		if (brillant == true) {

			itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		}

		if (name != null) {

			itemMeta.setDisplayName(name);
		}

		if (lore != null) {

			itemMeta.setLore(lore);
		}

		item.setItemMeta(itemMeta);

		return item;
	}

	@SuppressWarnings("deprecation")
	public static ItemStack getPlayerHead(String playerName, String name, List<String> lore) {

		ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);

		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(playerName);

		if (name != null)
			meta.setDisplayName(name);

		if (lore != null)
			meta.setLore(lore);

		item.setItemMeta(meta);

		return item;
	}
}