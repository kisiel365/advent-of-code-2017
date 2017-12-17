package util;

import java.io.InputStream;
import java.util.Scanner;

public class TestUtil {
	private TestUtil() {
	}

	public static String loadResourceAsString(String path) {
		InputStream inputStream = TestUtil.class.getClassLoader().getResourceAsStream(path);
		try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
			return scanner.useDelimiter("\\A").next();
		}
	}
}
