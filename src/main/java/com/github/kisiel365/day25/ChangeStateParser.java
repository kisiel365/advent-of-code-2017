package com.github.kisiel365.day25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeStateParser implements CommandParser {

	private static final Pattern PATTERN = Pattern.compile("    - Continue with state ([A-Z]).");

	@Override
	public boolean parse(String line, State state) {
		Matcher matcher = PATTERN.matcher(line);
		if (matcher.matches()) {
			state.addCommand(new ChangeStateCommand(matcher.group(1)));
			return true;
		}
		return false;
	}
}
