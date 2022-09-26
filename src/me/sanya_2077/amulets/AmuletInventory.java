package me.sanya_2077.amulets;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class AmuletInventory implements InventoryHolder {
	@SuppressWarnings("unused")
	private Config config;
	private Inventory inventory = Bukkit.createInventory(this, 36, "Amulets by Sanya_2077");

	public AmuletInventory(final Player player, Config config) {
		this.config = config;
		ItemStack glasspane = new ItemStack(Material.CYAN_STAINED_GLASS_PANE, 1);
		ItemMeta glasspane_m = glasspane.getItemMeta();
		glasspane_m.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + "Closed slot!");
		glasspane.setItemMeta(glasspane_m);

		for (int i = 0; i <= 35; i++) {
			inventory.setItem(i, glasspane);
		}

		inventory.setItem(1, config.getPlayerAmulet(player, "Head")); // head
		inventory.setItem(9, config.getPlayerAmulet(player, "LeftH")); // left
																		// hand
		inventory.setItem(10, config.getPlayerAmulet(player, "Chest")); // chest
		inventory.setItem(11, config.getPlayerAmulet(player, "RightH")); // right
																			// hand
		inventory.setItem(19, config.getPlayerAmulet(player, "Pelvis")); // pelvis
		inventory.setItem(27, config.getPlayerAmulet(player, "LeftL")); // left
																		// leg
		inventory.setItem(29, config.getPlayerAmulet(player, "RightL")); // right
																			// leg

		player.openInventory(inventory);
	}

	@Override
	public Inventory getInventory() {
		return this.inventory;
	}
}