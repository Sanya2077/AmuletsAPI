package me.sanya_2077.amulets;

import java.io.File;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
public class Config {
	private Amulets instance;
	private FileConfiguration config;

	public Config(Amulets instance) {
		this.instance = instance;
		CheckConfig();
	}

	private void CheckConfig() {
		File pluginFolder = new File(instance.getDataFolder().toString());
		File configPath = new File(instance.getDataFolder() + "/config.yml");
		if (!pluginFolder.exists()) {
			pluginFolder.mkdirs();
		}
		if (!configPath.exists()) {
			try {
				configPath.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			updateConfig();
			config.addDefault("Amulets.players." + "null" + ".backpack", "null");
			config.options().copyDefaults(true);
			saveConfig();
		}
		updateConfig();
		return;
	}

	private void updateConfig() {
		File file = new File(instance.getDataFolder() + "/config.yml");
		this.config = YamlConfiguration.loadConfiguration(file);
		return;
	}

	private void saveConfig() {
		File file = new File(instance.getDataFolder() + "/config.yml");
		try {
			config.options().copyDefaults(true);
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	private boolean isPlayerInConfig(final Player pl) {
		updateConfig();
		if (config.get("Amulets.players." + pl.getName()) != null) {
			return true;
		}
		return false;
	}

	private void updatePlayerParts(final Player pl) {
		updateConfig();
		final ItemStack air = new ItemStack(Material.AIR);
		if (config.get("Amulets.players." + pl.getName() + ".backpack." + "Head") == null)
			config.set("Amulets.players." + pl.getName() + ".backpack." + "Head", air);
		if (config.get("Amulets.players." + pl.getName() + ".backpack." + "LeftH") == null)
			config.set("Amulets.players." + pl.getName() + ".backpack." + "LeftH", air);
		if (config.get("Amulets.players." + pl.getName() + ".backpack." + "Chest") == null)
			config.set("Amulets.players." + pl.getName() + ".backpack." + "Chest", air);
		if (config.get("Amulets.players." + pl.getName() + ".backpack." + "RightH") == null)
			config.set("Amulets.players." + pl.getName() + ".backpack." + "RightH", air);
		if (config.get("Amulets.players." + pl.getName() + ".backpack." + "Pelvis") == null)
			config.set("Amulets.players." + pl.getName() + ".backpack." + "Pelvis", air);
		if (config.get("Amulets.players." + pl.getName() + ".backpack." + "RightL") == null)
			config.set("Amulets.players." + pl.getName() + ".backpack." + "RightL", air);
		if (config.get("Amulets.players." + pl.getName() + ".backpack." + "LeftL") == null)
			config.set("Amulets.players." + pl.getName() + ".backpack." + "LeftL", air);
		saveConfig();
		return;
	}

	protected ItemStack getPlayerAmulet(final Player pl, final String slot) {
		if (isPlayerInConfig(pl)) {
			return (ItemStack) config.get("Amulets.players." + pl.getName() + ".backpack." + slot);
		}
		return null;
	}

	protected void removePlayerFromConfig(final Player pl) {
		if (isPlayerInConfig(pl)) {
			config.set("Amulets.players." + pl.getName(), null);
			saveConfig();
		}
		return;
	}

	protected void updatePlayerAmuletInConfig(final Player pl, final ItemStack item, final String slot) {
		if (isPlayerInConfig(pl)) {
			if (item == null) {
				config.set("Amulets.players." + pl.getName() + ".backpack." + slot, new ItemStack(Material.AIR));
			} else {
				config.set("Amulets.players." + pl.getName() + ".backpack." + slot, item);
			}
			saveConfig();
		} else {
			updatePlayerParts(pl);

			if (item == null) {
				config.set("Amulets.players." + pl.getName() + ".backpack." + slot, new ItemStack(Material.AIR));
			} else {
				config.set("Amulets.players." + pl.getName() + ".backpack." + slot, item);
			}
			saveConfig();
		}
		return;
	}
}