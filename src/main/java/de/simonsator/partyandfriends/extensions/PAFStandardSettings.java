package de.simonsator.partyandfriends.extensions;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.extensions.listener.BukkitPAFAccountCreateListener;
import de.simonsator.partyandfriends.extensions.listener.BungeePAFAccountCreateListener;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

public class PAFStandardSettings extends PAFExtension {
	@Override
	public void onEnable() {
		try {
			ConfigurationCreator config = new PAFStandardSettingsConfiguration(new File(getDataFolder(), "config.yml"), this);
			try {
				Class.forName("org.bukkit.Bukkit");
				new BukkitPAFAccountCreateListener(config, this);
			} catch (ClassNotFoundException e) {
				new BungeePAFAccountCreateListener(config, this);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
