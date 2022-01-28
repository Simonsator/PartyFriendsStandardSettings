package de.simonsator.partyandfriends.extensions.listener;


import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.api.adapter.BukkitBungeeAdapter;
import de.simonsator.partyandfriends.api.events.PAFAccountCreateEvent;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BukkitPAFAccountCreateListener extends AbstractPAFAccountCreateListener implements Listener {
	public BukkitPAFAccountCreateListener(ConfigurationCreator pConfig, PAFExtension pafExtension) {
		super(pConfig);
		BukkitBungeeAdapter.getInstance().registerListener(this, pafExtension);
	}

	@EventHandler
	public void onPAFAccountCreateEvent(PAFAccountCreateEvent pEvent) {
		pafAccountCreateListener(pEvent.getCreatedAccount());
	}
}
