package fr.raraph84.topluck;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.raraph84.topluck.managers.CommandsManager;
import fr.raraph84.topluck.managers.EventsManager;
import fr.raraph84.topluck.utils.TopLuck;

public class Main extends JavaPlugin {

	private static Main instance;

	public void onEnable() {

		instance = this;

		Bukkit.getLogger().info("Démarrage de TopLuck_Plugin !");

		for (Player currentPlayer : Bukkit.getOnlinePlayers())
			new TopLuck(currentPlayer.getUniqueId());

		new EventsManager().registers();
		new CommandsManager().registers();
	}

	public void onDisable() {

		Bukkit.getLogger().info("Arrêt de TopLuck_Plugin !");
	}

	public static Main getInstance() {
		return instance;
	}
}
