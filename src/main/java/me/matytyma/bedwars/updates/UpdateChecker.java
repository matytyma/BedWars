package me.matytyma.bedwars.updates;

import com.google.gson.Gson;
import me.matytyma.bedwars.config.ConfigHandler;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class UpdateChecker implements Runnable {
	@Override
	public void run() {
		try {
			LatestRelease latestRelease = getLatestRelease();
			Bukkit.getLogger().info(String.format("%s Checking for updates...", ConfigHandler.getPluginPrefix()));
			if (!latestRelease.getName().equals(ConfigHandler.PLUGIN_VERSION)) {
				Bukkit.getLogger().warning("");
				Bukkit.getLogger().warning("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫  BedWars  ┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
				Bukkit.getLogger().warning("┃ You are not running the latest plugin version.");
				Bukkit.getLogger().warning("┃ You're on version " + ConfigHandler.PLUGIN_VERSION + ", but the latest version is " + latestRelease.getName() + ".");
				Bukkit.getLogger().warning("┃ Please download the latest version from link below.");
				Bukkit.getLogger().warning("┃ " + latestRelease.getDownloadUrl());
				Bukkit.getLogger().warning("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
				Bukkit.getLogger().warning("");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	static LatestRelease getLatestRelease() throws IOException {
		URL url = new URL("https://api.github.com/repos/matytyma/BedWars/releases/latest");
		Scanner scanner = new Scanner(url.openStream()).useDelimiter("\\A");
		return new Gson().fromJson(scanner.hasNext() ? scanner.next() : "{\n  \"name\": " + ConfigHandler.PLUGIN_VERSION + "\n}", LatestRelease.class);
	}


}

class LatestRelease {
	@SuppressWarnings("unused")
	private String name;

	public String getDownloadUrl() {
		return "https://github.com/matytyma/BedWars/releases/download/" + name + "/BedWars.jar";
	}

	public String getName() {
		return name;
	}
}
