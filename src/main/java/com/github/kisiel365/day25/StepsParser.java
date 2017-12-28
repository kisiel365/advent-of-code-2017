package com.github.kisiel365.day25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepsParser implements CommandParser {

	private static final Pattern PATTERN = Pattern.compile("Perform a diagnostic checksum after ([0-9]+) steps.");

	@Override
	public boolean parse(String line, State state) {
		Matcher matcher = PATTERN.matcher(line);
		if (matcher.matches()) {
			state.setTotalSteps(Integer.parseInt(matcher.group(1)));
			return true;
		}
		return false;
	}

}
