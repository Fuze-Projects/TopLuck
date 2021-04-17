package fr.raraph84.topluck.utils;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {

	public static void setGlassInventory(Inventory inv) {

		int number = 0;

		for (ItemStack currentItem : inv.getContents()) {

			if (currentItem == null)
				inv.setItem(number, getGlassItem());

			number++;
		}
	}

	public static ItemStack getGlassItem() {
		return ItemBuilder.getItem(Material.BLACK_STAINED_GLASS_PANE, " ", false, 1, null);
	}

	public static void fill(Inventory inventory, ItemStack item, int start, int end) {

		for (int i = start; i <= end; i++) {

			inventory.setItem(i, item);
		}
	}
}