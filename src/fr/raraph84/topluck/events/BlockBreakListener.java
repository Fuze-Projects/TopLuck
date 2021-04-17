package fr.raraph84.topluck.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import fr.raraph84.topluck.utils.TopLuck;

public class BlockBreakListener implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {

		Player player = event.getPlayer();

		TopLuck topluck = TopLuck.getToplucks().get(player.getUniqueId());

		if (topluck != null)
			topluck.addBlock(event.getBlock().getType());
	}
}
