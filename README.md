# AmuletsAPI
## Easy to use API for Amulets in Minecraft 1.18.2! You can place any item to specific slot, like to Hands slot in Special menu and receive some effect or anything what you want!

So at starting, you need to compile my API, next you need put Amulets.jar (plugin) to your plugins folder of server. After this, you need to call a API, simply
you can do this by `new API();`, this will be like `api = new API();`, well done you initialized API, then you can call two functions what you need, that is
`getPlayerAmuletAtSlot()` and `updatePlayerAmuletAtSlot()`, so `getPlayerAmuletAtSlot()` uses to getting ItemStack at specific slot, allowed slots is: `Head, LeftH, Chest, RightH, Pelvis, LeftL, RightL`, then do like this `getPlayerAmuletSlot(player, slot);` and you will get ItemStack or null if slot is empty, obviosly this
function needed for checking player item, next function is `updatePlayerAmuletAtSlot()`, you can update players item in slot, sets damage maybe to item
or something like this! You can remove item, why not? Do what you want, example of usage `updatePlayerAmuletAtSlot(player, slot, item);`.

To open menu you need use command `/amulets`.
![javaw_4gxL46hk8w](https://user-images.githubusercontent.com/114426025/192331927-36e8191d-613c-4c53-b1e3-80f364baa181.png)


You can also use this as example of using:

```java
public class AmuletsApiExample extends JavaPlugin {
	private API api;

	@Override
	public void onEnable() {
		this.api = Amulets.getApi();
		EnableTask();
	}

	@Override
	public void onDisable() {
		HandlerList.unregisterAll(this);
	}

	private void EnableTask() {
		for (Player player : Bukkit.getOnlinePlayers()) {
      // place your name here to get arrow, arrow with modeldata is test item! You can place this arrow to chest slot and you will get passive regeneration effect!
			if (player.getName().equals("Sanya_2077")) {
				ItemStack arrow = new ItemStack(Material.ARROW);
				ItemMeta arrow_m = arrow.getItemMeta();
				arrow_m.setCustomModelData(789);
				arrow.setItemMeta(arrow_m);

				player.getInventory().addItem(arrow);
				break;
			}
		}
		this.getServer().getScheduler().runTaskTimer(this, task -> {
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (!player.isDead() && api.getPlayerAmuletAtSlot(player, "Chest") != null) {
					final ItemStack amulet = api.getPlayerAmuletAtSlot(player, "Chest");
					if (amulet.getType().equals(Material.ARROW) && amulet.hasItemMeta() && amulet.getItemMeta().hasCustomModelData() && amulet.getItemMeta().getCustomModelData() == 789) {
						player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 15 * 20, 1));
					}
				}
			}
		}, 0, (long) 10 * 20);
		return;
	}
}
```


Still have questions? Add me to discord `Alexandro Bogach#6885` or add me in VK `https://vk.com/the_sanya_2077`, maybe i will help! 


