package fr.raraph84.topluck.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import fr.raraph84.topluck.utils.Callback;
import fr.raraph84.topluck.utils.TopLuckDisplay;

public class InventoryClickListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {

		Player player = (Player) event.getWhoClicked();

		if (!event.getView().getTitle().equals("§8TopLuck"))
			return;

		event.setCancelled(true);

		ItemStack item = event.getCurrentItem();

		if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName())
			return;

		Callback callback = TopLuckDisplay.getToplucks().get(player.getUniqueId())
				.getCallback(item.getItemMeta().getDisplayName());

		if (callback != null)
			callback.doCallback();
	}
}
