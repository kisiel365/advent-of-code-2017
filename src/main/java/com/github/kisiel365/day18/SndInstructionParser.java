package com.github.kisiel365.day18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SndInstructionParser implements InstructionParser {

	private static final Pattern PATTERN = Pattern.compile("snd ([a-z]+)");

	@Override
	public Instruction parse(String line) {
		Matcher matcher = PATTERN.matcher(line);
		if (matcher.matches()) {
			return new SndInstruction(matcher.group(1).charAt(0));
		}
		return null;
	}

}
