package com.github.kisiel365.day16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpinCommandParser implements CommandParser {
	private static final Pattern PATTERN = Pattern.compile("s([0-9]+)");

	@Override
	public Command parseCommand(String commandString) {
		Matcher matcher = PATTERN.matcher(commandString);
		if (matcher.matches()) {
			int spinTimes = Integer.parseInt(matcher.group(1));
			return new SpinCommand(spinTimes);
		}
		return null;
	}

}
