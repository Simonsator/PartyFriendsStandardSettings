package de.simonsator.partyandfriends.extensions;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

public class PAFStandardSettingsConfiguration extends ConfigurationCreator {
	public PAFStandardSettingsConfiguration(File file, PAFExtension pafExtension) throws IOException {
		super(file, pafExtension);
		readFile();
		loadDefaults();
		saveFile();
		process();
	}

	private void loadDefaults() {
		set("StandardSettings", "some.perm|SettingsID|SettingDefaultValue", "some.perm|SettingsID|SettingDefaultValue");
	}

}
