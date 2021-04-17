package fr.raraph84.topluck.managers;

import org.bukkit.Bukkit;

import fr.raraph84.topluck.Main;
import fr.raraph84.topluck.events.BlockBreakListener;
import fr.raraph84.topluck.events.InventoryClickListener;
import fr.raraph84.topluck.events.PlayerJoinListener;
import fr.raraph84.topluck.events.PlayerQuitListener;

public class EventsManager {

	public void registers() {

		Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), Main.getInstance());
	}
}
