package com.github.kisiel365.day25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoveParser implements CommandParser {

	private static final Pattern PATTERN = Pattern.compile("    - Move one slot to the (left|right).");
	
	@Override
	public boolean parse(String line, State state) {
		Matcher matcher = PATTERN.matcher(line);
		if (matcher.matches()) {
			state.addCommand(new MoveCommand(matcher.group(1)));
			return true;
		}
		return false;
	}
}
