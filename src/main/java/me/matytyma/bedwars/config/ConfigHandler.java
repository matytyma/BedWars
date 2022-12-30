package me.matytyma.bedwars.config;

import me.matytyma.bedwars.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHandler {
	public static final String PLUGIN_VERSION = "1.0.0";
	private static String pluginPrefix;

	/**
	 * Loads all the plugin configuration from config.yml
	 */
	public static void loadConfig() {
		FileConfiguration config = Main.getPlugin(Main.class).getConfig();
		pluginPrefix = config.getString("plugin-prefix");

	}

	/**
	 * Returns the prefix of the plugin which will be displayed in chat and console
	 * @return Prefix of the plugin
	 */
	public static String getPluginPrefix() {
		return pluginPrefix;
	}
}
