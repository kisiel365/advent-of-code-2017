package com.github.kisiel365.day18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MulInstructionParser implements InstructionParser {

	private static final Pattern PATTERN = Pattern.compile("mul ([a-z]+) ([a-z]+)");
	private static final Pattern PATTERN2 = Pattern.compile("mul ([a-z]+) ([-0-9]+)");

	@Override
	public Instruction parse(String line) {
		Matcher matcher = PATTERN.matcher(line);
		if (matcher.matches()) {
			return new MulInstruction(matcher.group(1).charAt(0), matcher.group(2).charAt(0));
		}
		matcher = PATTERN2.matcher(line);
		if (matcher.matches()) {
			return new MulInstruction(matcher.group(1).charAt(0), Integer.parseInt(matcher.group(2)));
		}
		return null;
	}

}
