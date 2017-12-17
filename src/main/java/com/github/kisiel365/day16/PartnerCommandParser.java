package com.github.kisiel365.day16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartnerCommandParser implements CommandParser {
	private static final Pattern PATTERN = Pattern.compile("p([a-z]+)/([a-z]+)");

	@Override
	public Command parseCommand(String commandString) {
		Matcher matcher = PATTERN.matcher(commandString);
		if (matcher.matches()) {
			char progA = matcher.group(1).charAt(0);
			char progB = matcher.group(2).charAt(0);
			return new PartnerCommand(progA, progB);
		}
		return null;
	}

}
