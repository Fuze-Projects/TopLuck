package fr.raraph84.topluck.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.raraph84.topluck.utils.TopLuckDisplay;;

public class CmdTopluck implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVous devez être un joueur !");
			return true;
		}

		if (!sender.hasPermission("topluck.command")) {
			sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande !");
			return true;
		}

		Player player = (Player) sender;

		new TopLuckDisplay(player.getUniqueId());

		return true;
	}
}
