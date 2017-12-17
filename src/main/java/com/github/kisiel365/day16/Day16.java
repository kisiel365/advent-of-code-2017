package com.github.kisiel365.day16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Day16 {

	private static final List<CommandParser> PARSERS = Arrays.asList(new ExchangeCommandParser(),
			new SpinCommandParser(), new PartnerCommandParser());

	private Day16() {
	}

	public static String orderAfterDancingOnce(String startingState, String input) {
		char[] state = startingState.toCharArray();
		List<Command> commands = Arrays.stream(input.split(",")).map(Day16::parseCommands).collect(Collectors.toList());
		for (Command command : commands)
			command.process(state);
		return String.valueOf(state);
	}

	public static String orderAfterDancingNTimes(String startingPositions, String input, int times) {
		char[] state = startingPositions.toCharArray();
		List<Command> commands = Arrays.stream(input.split(",")).map(Day16::parseCommands).collect(Collectors.toList());
		times = times % 24; // due to cycle detected
		for (int i = 0; i < times; i++) {
			for (Command command : commands)
				command.process(state);
		}
		return String.valueOf(state);
	}

	private static Command parseCommands(String commandString) {
		for (CommandParser parser : PARSERS) {
			Command command = parser.parseCommand(commandString);
			if (command != null)
				return command;
		}
		return null;
	}

}
