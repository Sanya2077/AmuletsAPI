package me.sanya_2077.amulets;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class Amulets extends JavaPlugin {
	private Amulets instance;
	private Config config;
	private API api;

	@Override
	public void onEnable() {
		this.instance = this;
		this.config = new Config(this.instance);
		this.api = new API(this.config);
		this.instance.getServer().getPluginManager().registerEvents(new Listener_(this.instance, this.config), this.instance);
		this.instance.getCommand("amulets").setExecutor(new Commands(this.config));
	}

	@Override
	public void onDisable() {
		HandlerList.unregisterAll(this.instance);
	}

	public static API getApi() {
		return JavaPlugin.getPlugin(Amulets.class).api;
	}
}
