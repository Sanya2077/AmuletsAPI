package me.sanya_2077.amulets;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Listener_ implements Listener {
	private Config config;

	public Listener_(Amulets instance, Config config) {
		this.config = config;
	}

	@EventHandler
	private void onClickInventory(final InventoryClickEvent e) {
		if (e.getView().getTopInventory().getHolder() instanceof AmuletInventory && e.getClickedInventory().getHolder() instanceof AmuletInventory) {
			if (getSlot(e.getRawSlot()) != null) {
				switch (getSlot(e.getRawSlot())) {
					default : {
						e.setCancelled(true);
					}

					case "Head" : {
						return;
					}
					case "LeftH" : {
						return;
					}
					case "Chest" : {
						return;
					}
					case "RightH" : {
						return;
					}
					case "Pelvis" : {
						return;
					}
					case "LeftL" : {
						return;
					}
					case "RightL" : {
						return;
					}
				}
			} else {
				e.setCancelled(true);
			}
		}
		return;
	}

	@EventHandler
	private void onInventoryClose(final InventoryCloseEvent e) {
		if (e.getView().getTopInventory().getHolder() instanceof AmuletInventory) {
			config.updatePlayerAmuletInConfig((Player) e.getPlayer(), e.getInventory().getItem(9), "LeftH");
			config.updatePlayerAmuletInConfig((Player) e.getPlayer(), e.getInventory().getItem(10), "Chest");
			config.updatePlayerAmuletInConfig((Player) e.getPlayer(), e.getInventory().getItem(11), "RightH");
			config.updatePlayerAmuletInConfig((Player) e.getPlayer(), e.getInventory().getItem(19), "Pelvis");
			config.updatePlayerAmuletInConfig((Player) e.getPlayer(), e.getInventory().getItem(27), "LeftL");
			config.updatePlayerAmuletInConfig((Player) e.getPlayer(), e.getInventory().getItem(29), "RightL");
		}
		return;
	}

	@SuppressWarnings("unused")
	private void sendActionBar(final Player player, final String message) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
		return;
	}

	private String getSlot(final int rawslot) {
		switch (rawslot) {
			case 1 :
				return "Head";
			case 9 :
				return "LeftH";
			case 10 :
				return "Chest";
			case 11 :
				return "RightH";
			case 19 :
				return "Pelvis";
			case 27 :
				return "LeftL";
			case 29 :
				return "RightL";
			default :
				return null;
		}
	}
}
