package com.github.kisiel365.day25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeginParser implements CommandParser {

	private static final Pattern PATTERN = Pattern.compile("Begin in state ([A-Z]).");
	
	@Override
	public boolean parse(String line, State state) {
		Matcher matcher = PATTERN.matcher(line);
		if (matcher.matches()) {
			state.setBeginState(matcher.group(1));
			return true;
		}
		return false;
	}

}
