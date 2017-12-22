package com.github.kisiel365.day21;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Day21 {

	private static final Pattern PATTERN = Pattern.compile("([#./]+) => ([#./]+)");

	private Day21() {
	}

	public static long simple(String input, int iterations) {
		List<Rule> parseRules = parseRules(input);
		String image = ".#...####";
		return countStars(image);
	}

	private static long countStars(String image) {
		return image.chars().filter(x -> x == 35).count();
	}

	private static List<Rule> parseRules(String input) {
		List<Rule> rules = new ArrayList<>();
		for (String line : input.split("\r\n")) {
			Matcher matcher = PATTERN.matcher(line);
			if (matcher.matches()) {
				rules.add(new Rule(matcher.group(1), matcher.group(2)));
			} else {
				throw new IllegalArgumentException("Unparsable line: " + line);
			}
		}
		return rules;
	}

	public static int advanced(String input) {
		return 0;
	}

}
