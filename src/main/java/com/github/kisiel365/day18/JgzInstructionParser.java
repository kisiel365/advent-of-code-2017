package com.github.kisiel365.day18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JgzInstructionParser implements InstructionParser {

	private static final Pattern PATTERN = Pattern.compile("jgz ([a-z]+) ([-0-9]+)");
	private static final Pattern PATTERN2 = Pattern.compile("jgz ([a-z]+) ([a-z]+)");
	private static final Pattern PATTERN3 = Pattern.compile("jgz ([0-9]+) ([0-9]+)");

	@Override
	public Instruction parse(String line) {
		Matcher matcher = PATTERN.matcher(line);
		if (matcher.matches()) {
			return new JgzInstruction(matcher.group(1).charAt(0), Integer.parseInt(matcher.group(2)));
		}
		matcher = PATTERN2.matcher(line);
		if (matcher.matches()) {
			return new JgzInstruction(matcher.group(1).charAt(0), matcher.group(2).charAt(0));
		}
		matcher = PATTERN3.matcher(line);
		if (matcher.matches()) {
			return new JgzInstruction(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
		}
		return null;
	}

}
