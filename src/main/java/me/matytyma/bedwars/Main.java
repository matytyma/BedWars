package me.matytyma.bedwars;

import me.matytyma.bedwars.config.ConfigHandler;
import me.matytyma.bedwars.updates.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		ConfigHandler.loadConfig();
		getServer().getScheduler().runTaskTimer(this, new UpdateChecker(), 0, 36000);
	}
}
