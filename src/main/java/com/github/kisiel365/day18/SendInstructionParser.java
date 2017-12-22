package com.github.kisiel365.day18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SendInstructionParser implements InstructionParser {

	private static final Pattern PATTERN = Pattern.compile("snd ([a-z]+)");
	private static final Pattern PATTERN2 = Pattern.compile("snd ([0-9]+)");

	@Override
	public Instruction parse(String line) {
		Matcher matcher = PATTERN.matcher(line);
		if (matcher.matches()) {
			return new SendInstruction(matcher.group(1).charAt(0));
		}
		matcher = PATTERN2.matcher(line);
		if (matcher.matches()) {
			return new SendInstruction(Integer.parseInt(matcher.group(1)));
		}
		return null;
	}

}
