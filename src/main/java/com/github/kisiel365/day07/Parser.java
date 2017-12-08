package com.github.kisiel365.day07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

	private static final Pattern LINE_PATTERN = Pattern.compile("([\\w]+) \\(([0-9]+)\\)( -> ([a-z, ]*))?");
	private static final Pattern CHILDREN_PATTERN = Pattern.compile("([a-z]+)");

	private Parser() {
	}

	static Map<String, Program> parseInput(String input) {
		Map<String, Program> programs = new HashMap<>();
		for (String line : input.split("\r\n")) {
			Program program = parseToProgram(line);
			programs.put(program.getName(), program);
		}
		return programs;
	}

	private static Program parseToProgram(String line) {
		Matcher matcher = LINE_PATTERN.matcher(line);
		matcher.find();
		String name = matcher.group(1);
		int weight = Integer.parseInt(matcher.group(2));
		Set<String> childProgramNames = parseChildren(matcher.group(4));
		return new Program(name, weight, childProgramNames);
	}

	private static Set<String> parseChildren(String childProgramNamesListed) {
		Set<String> childProgramNames = new HashSet<>();
		if (childProgramNamesListed != null) {
			Matcher matcher = CHILDREN_PATTERN.matcher(childProgramNamesListed);
			while (matcher.find()) {
				childProgramNames.add(matcher.group());
			}
		}
		return childProgramNames;
	}
}
