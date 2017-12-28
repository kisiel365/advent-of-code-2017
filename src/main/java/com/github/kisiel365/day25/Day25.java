package com.github.kisiel365.day25;

import java.util.HashSet;
import java.util.Set;

public final class Day25 {

	private static final Set<CommandParser> PARSERS = getParsers();

	private Day25() {
	}

	public static int simple(String input) {
		State state = parseInput(input);
		state.run();
		return state.checksum();
	}

	private static Set<CommandParser> getParsers() {
		Set<CommandParser> parsers = new HashSet<>();
		parsers.add(new BeginParser());
		parsers.add(new StepsParser());
		parsers.add(new StateParser());
		parsers.add(new IfValueParser());
		parsers.add(new WriteValueParser());
		parsers.add(new MoveParser());
		parsers.add(new ChangeStateParser());
		return parsers;
	}

	private static State parseInput(String input) {
		State state = new State();
		for (String line : input.split("\r\n")) {
			for (CommandParser parser : PARSERS) {
				if (parser.parse(line, state))
					break;
			}
		}
		return state;
	}

	public static int advanced(String input) {
		return 0;
	}

}
