package com.github.kisiel365.day08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Day08 {

	private static final Pattern PATTERN = Pattern
			.compile("([\\w]+) (inc|dec) (-?[\\d]+) if ([\\w]+) (>|<|<=|>=|==|!=) (-?[\\d]+)");

	private Day08() {
	}

	public static int highestFinalValue(String input) {
		List<Command> commands = parseInputToCommands(input);
		Map<String, Integer> registers = new HashMap<>();
		for (Command command : commands) {
			if (command.fulfillsCondition(registers))
				command.execute(registers);
		}
		return registers.values().stream().max(Comparator.naturalOrder()).orElse(null);
	}

	public static int highestValueReached(String input) {
		List<Command> commands = parseInputToCommands(input);
		Map<String, Integer> registers = new HashMap<>();
		int highestEver = Integer.MIN_VALUE;
		for (Command command : commands) {
			if (command.fulfillsCondition(registers)) {
				command.execute(registers);
				Integer highestNow = registers.values().stream().max(Comparator.naturalOrder()).orElse(null);
				if (highestNow > highestEver)
					highestEver = highestNow;
			}
		}
		return highestEver;
	}

	private static List<Command> parseInputToCommands(String input) {
		String[] lines = input.split("\r\n");
		List<Command> commands = new ArrayList<>();
		for (String line : lines) {
			Matcher matcher = PATTERN.matcher(line);
			matcher.find();
			commands.add(new Command(matcher));
		}
		return commands;
	}
}
