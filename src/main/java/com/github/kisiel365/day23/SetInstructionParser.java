package com.github.kisiel365.day23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetInstructionParser implements InstructionParser {

	private static final Pattern PATTERN = Pattern.compile("set ([a-z]+) ([0-9]+)");
	private static final Pattern PATTERN2 = Pattern.compile("set ([a-z]+) ([a-z]+)");

	@Override
	public Instruction parse(String line) {
		Matcher matcher = PATTERN.matcher(line);
		if (matcher.matches()) {
			return new SetInstruction(matcher.group(1).charAt(0), Integer.parseInt(matcher.group(2)));
		}
		matcher = PATTERN2.matcher(line);
		if (matcher.matches()) {
			return new SetInstruction(matcher.group(1).charAt(0), matcher.group(2).charAt(0));
		}
		return null;
	}

}
