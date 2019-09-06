package de.simonsator.partyandfriends.extensions.listener;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.api.events.PAFAccountCreateEvent;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class BungeePAFAccountCreateListener extends AbstractPAFAccountCreateListener implements Listener {
	public BungeePAFAccountCreateListener(ConfigurationCreator pConfig, PAFExtension pafExtension) {
		super(pConfig);
		ProxyServer.getInstance().getPluginManager().registerListener(pafExtension, this);
	}

	@EventHandler
	public void onPAFAccountCreateEvent(PAFAccountCreateEvent pEvent) {
		pafAccountCreateListener(pEvent.getCreatedAccount());
	}
}
