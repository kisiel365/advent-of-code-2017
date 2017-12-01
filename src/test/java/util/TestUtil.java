package util;

import java.io.IOException;
import java.net.URL;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class TestUtil {
	private TestUtil() {
	}

	public static String loadResourceAsString(String path) {
		final URL url = Resources.getResource(path);
		try {
			return Resources.toString(url, Charsets.UTF_8);
		} catch (IOException ex) {
			return null;
		}
	}
}
