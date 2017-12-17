package com.github.kisiel365.day16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExchangeCommandParser implements CommandParser {
	private static final Pattern PATTERN = Pattern.compile("x([0-9]+)/([0-9]+)");

	int position1;
	int position2;

	@Override
	public Command parseCommand(String commandString) {
		Matcher matcher = PATTERN.matcher(commandString);
		if (matcher.matches()) {
			int position1 = Integer.parseInt(matcher.group(1));
			int position2 = Integer.parseInt(matcher.group(2));
			return new ExchangeCommand(position1, position2);
		}
		return null;
	}

}
