package org.magneato;

import java.util.UUID;
import java.util.prefs.Preferences;

/**
 * Central repository for program information
 * 
 * @author David George
 * (c) 2013
 *
 */
public enum Registry {
	INSTANCE;
	private Preferences prefs;

	Registry() {
		String homeDir = System.getProperty("user.dir");
		// .java/.systemPrefs must exist and be writeable
		System.setProperty("java.util.prefs.systemRoot", homeDir + "/.java");

		prefs = Preferences.systemRoot().node(this.getClass().getName());
	}

	public String getSerial() {
		String id = prefs.get("id", null);

		if (id == null) {
			// not yet initialized
			id = UUID.randomUUID().toString();
			prefs.put("id", id);

		}
		return id;
	}

	public void setRegistrationKey(String key) {
		prefs.put("key", key);

	}

	public String getRegistrationKey() {
		return prefs.get("key", null);
	}
}
