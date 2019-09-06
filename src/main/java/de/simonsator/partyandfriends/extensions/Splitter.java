package de.simonsator.partyandfriends.extensions;

/**
 * @author Simonsator
 * @version 22.01.2017
 */
public class Splitter {
	private final String CUTTER;
	private String text;

	public Splitter(String pToSplit, String pCutter) {
		CUTTER = pCutter;
		text = pToSplit;
	}

	public boolean hasNext() {
		return text.length() != 0;
	}

	public String next() {
		int occurrence = text.indexOf(CUTTER);
		if (occurrence == -1) {
			try {
				return text;
			} finally {
				text = "";
			}
		}
		try {
			return text.substring(0, occurrence);
		} finally {
			text = text.substring(occurrence + CUTTER.length());
		}

	}
}
