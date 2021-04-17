package fr.raraph84.topluck.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import fr.raraph84.topluck.utils.TopLuckDisplay;

public class InventoryCloseListener implements Listener {

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {

		Player player = (Player) event.getPlayer();

		if (TopLuckDisplay.getToplucks().containsKey(player.getUniqueId()))
			TopLuckDisplay.getToplucks().remove(player.getUniqueId());
	}
}
