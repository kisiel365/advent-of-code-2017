package com.github.kisiel365.day18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddInstructionParser implements InstructionParser {

	private static final Pattern PATTERN = Pattern.compile("add ([a-z]+) ([-0-9]+)");
	private static final Pattern PATTERN2 = Pattern.compile("add ([a-z]+) ([a-z]+)");

	@Override
	public Instruction parse(String line) {
		// TODO parse with single pattern
		Matcher matcher = PATTERN.matcher(line);
		if (matcher.matches()) {
			return new AddInstruction(matcher.group(1).charAt(0), Integer.parseInt(matcher.group(2)));
		}
		matcher = PATTERN2.matcher(line);
		if (matcher.matches()) {
			return new AddInstruction(matcher.group(1).charAt(0), matcher.group(2).charAt(0));
		}
		return null;
	}

}
