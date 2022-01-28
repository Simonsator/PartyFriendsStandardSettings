package de.simonsator.partyandfriends.extensions.listener;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.extensions.Splitter;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPAFAccountCreateListener {
	private final List<StandardSettings> standardSettingsList = new ArrayList<>();

	public AbstractPAFAccountCreateListener(ConfigurationCreator pConfig) {
		for (String standardSettings : pConfig.getStringList("StandardSettings")) {
			try {
				Splitter splitter = new Splitter(standardSettings, "|");
				standardSettingsList.add(new StandardSettings(splitter.next(), Integer.parseInt(splitter.next()), Integer.parseInt(splitter.next())));
			} catch (Exception ignored) {

			}
		}
	}

	protected void pafAccountCreateListener(OnlinePAFPlayer pPlayer) {
		for (StandardSettings standardSettings : standardSettingsList) {
			if (pPlayer.hasPermission(standardSettings.PERMISSION)) {
				pPlayer.setSetting(standardSettings.SETTING_ID, standardSettings.SETTING_DEFAULT_VALUE);
			}
		}
	}

	private static class StandardSettings {
		private final String PERMISSION;
		private final int SETTING_ID;
		private final int SETTING_DEFAULT_VALUE;

		private StandardSettings(String permission, int settingId, int settingDefaultValue) {
			PERMISSION = permission;
			SETTING_ID = settingId;
			SETTING_DEFAULT_VALUE = settingDefaultValue;
		}
	}
}
