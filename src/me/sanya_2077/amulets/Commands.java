package me.sanya_2077.amulets;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	private Config config;

	public Commands(Config config) {
		this.config = config;
	}

	@Override
	public boolean onCommand(CommandSender player, Command cmd, String label, String[] args) {
		if (player instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("amulets")) {
				new AmuletInventory((Player) player, this.config);
			}
		} else {
			Bukkit.getConsoleSender().sendMessage("Only player can execute this command!");
		}
		return true;
	}
}
