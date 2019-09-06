package de.simonsator.partyandfriends.extensions.listener;


import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.api.events.PAFAccountCreateEvent;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class BukkitPAFAccountCreateListener extends AbstractPAFAccountCreateListener implements Listener {
	public BukkitPAFAccountCreateListener(ConfigurationCreator pConfig, PAFExtension pafExtension) {
		super(pConfig);
		Bukkit.getServer().getPluginManager().registerEvents(this, (Plugin) pafExtension);
	}

	@EventHandler
	public void onPAFAccountCreateEvent(PAFAccountCreateEvent pEvent) {
		pafAccountCreateListener(pEvent.getCreatedAccount());
	}
}
