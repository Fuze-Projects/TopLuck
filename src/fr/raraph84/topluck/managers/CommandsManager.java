package fr.raraph84.topluck.managers;

import fr.raraph84.topluck.Main;
import fr.raraph84.topluck.commands.CmdTopluck;

public class CommandsManager {

	public void registers() {

		Main.getInstance().getCommand("topluck").setExecutor(new CmdTopluck());
	}
}
