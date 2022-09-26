package me.sanya_2077.amulets;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class API {
	private Config config;
	public API(Config config) {
		this.config = config;
	}
	
	/**
	* Returns ItemStack from selected slot!
	* Accepts slots: Head, LeftH, Chest, RightH, Pelvis, LeftL, RightL
	*
	* @param  pl the player, lol
	* @param  slot slot, write as writed in Accepts slots
	* @return ItemStack or null
	*/
	public ItemStack getPlayerAmuletAtSlot(final Player pl, final String slot) {
		return config.getPlayerAmulet(pl, slot);
	}
	
	/**
	* Returns void! Settings amulet at specified slot! For none item you can use null!
	* Accepts slots: Head, LeftH, Chest, RightH, Pelvis, LeftL, RightL
	*
	* @param  pl the player, lol
	* @param  slot, write slots as writed in Accepts slots
	* @param  item, ItemStack needed
	* @return void
	*/
	public void updatePlayerAmuletAtSlot(final Player pl, final String slot, final ItemStack item) {
		config.updatePlayerAmuletInConfig(pl, item, slot);
		return;
	}
}
