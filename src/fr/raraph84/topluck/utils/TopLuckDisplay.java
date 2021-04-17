package fr.raraph84.topluck.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TopLuckDisplay {

	private static HashMap<UUID, TopLuckDisplay> toplucks = new HashMap<>();

	private UUID playerUuid;
	private Inventory inventory;
	private int displayedPage = 0;
	private ArrayList<ArrayList<ItemStack>> pages = new ArrayList<>();
	private HashMap<String, Callback> items = new HashMap<>();

	public TopLuckDisplay(UUID playerUuid) {

		this.playerUuid = playerUuid;
		this.inventory = Bukkit.createInventory(null, 6 * 9, "§8TopLuck");

		setBottomBar();
		initPages();
		setDisplayedPage(0);

		Bukkit.getPlayer(playerUuid).openInventory(inventory);
		toplucks.put(playerUuid, this);
	}

	private void setBottomBar() {

		InventoryUtils.fill(inventory, InventoryUtils.getGlassItem(), 45, 53);

		ItemStack pageBack = ItemBuilder.getPlayerHead("MHF_ArrowLeft", "§2Arrière",
				Arrays.asList("§5Clic pour reculer d'une page"));
		items.put(pageBack.getItemMeta().getDisplayName(), new Callback() {
			@Override
			public void doCallback() {
				setDisplayedPage(getDisplayedPage() - 1);
			}
		});
		inventory.setItem(48, pageBack);

		ItemStack pageForwards = ItemBuilder.getPlayerHead("MHF_ArrowRight", "§2Avant",
				Arrays.asList("§5Clic pour avancer d'une page"));
		items.put(pageForwards.getItemMeta().getDisplayName(), new Callback() {
			@Override
			public void doCallback() {
				setDisplayedPage(getDisplayedPage() + 1);
			}
		});
		inventory.setItem(50, pageForwards);

		ItemStack quit = ItemBuilder.getItem(Material.BARRIER, "§c§lQuitter", false, 1,
				Arrays.asList("§5Clic pour quitter"));
		items.put(quit.getItemMeta().getDisplayName(), new Callback() {
			@Override
			public void doCallback() {
				Bukkit.getPlayer(playerUuid).closeInventory();
				toplucks.remove(playerUuid);
			}
		});
		inventory.setItem(53, quit);
	}

	private void initPages() {

		pages.clear();

		for (Player currentPlayer : Bukkit.getOnlinePlayers()) {

			if (pages.size() < 1 || pages.get(pages.size() - 1).size() >= 44)
				pages.add(new ArrayList<>());

			TopLuck topluck = TopLuck.getToplucks().get(currentPlayer.getUniqueId());

			ArrayList<String> lore = new ArrayList<>();
			lore.add("§2Diamant : " + topluck.getPercentage(Material.DIAMOND_ORE) + "%");
			lore.add("§2Or : " + topluck.getPercentage(Material.GOLD_ORE) + "%");
			lore.add("§2Fer : " + topluck.getPercentage(Material.IRON_ORE) + "%");
			lore.add("");
			lore.add("§5Clic pour se téléporter");

			ItemStack item = ItemBuilder.getPlayerHead(currentPlayer.getName(), "§6" + currentPlayer.getName(), lore);
			items.put(item.getItemMeta().getDisplayName(), new Callback() {
				@Override
				public void doCallback() {
					Bukkit.getPlayer(playerUuid).teleport(Bukkit.getPlayer(currentPlayer.getUniqueId()));
				}
			});
			pages.get(pages.size() - 1).add(item);
		}
	}

	public Inventory getInventory() {
		return inventory;
	}

	public int getDisplayedPage() {
		return displayedPage;
	}

	public void setDisplayedPage(int newPage) {

		if (newPage < 0 || newPage > pages.size() - 1)
			return;

		this.displayedPage = newPage;

		InventoryUtils.fill(inventory, null, 0, 44);
		for (ItemStack currentItem : pages.get(newPage))
			inventory.addItem(currentItem);
	}

	public Callback getCallback(String itemName) {
		return items.get(itemName);
	}

	public static HashMap<UUID, TopLuckDisplay> getToplucks() {
		return toplucks;
	}
}
