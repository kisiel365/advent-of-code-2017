package com.github.kisiel365.day25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriteValueParser implements CommandParser {

	private static final Pattern PATTERN = Pattern.compile("    - Write the value (1|0).");

	@Override
	public boolean parse(String line, State state) {
		Matcher matcher = PATTERN.matcher(line);
		if (matcher.matches()) {
			state.addCommand(new WriteValueCommand(Integer.parseInt(matcher.group(1)) > 0 ? true : false));
			return true;
		}
		return false;
	}

}
