package com.github.kisiel365.day23;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InstructionsParser {

	private List<InstructionParser> parsers;

	public InstructionsParser() {
		parsers = getSimpleParsers();
	}

	public List<Instruction> parseInstructions(String input) {
		return Arrays.stream(input.split("\n")).map(this::parseInstruction).collect(Collectors.toList());
	}

	private Instruction parseInstruction(String instructionString) {
		return parsers.stream().map(parser -> parser.parse(instructionString)).filter(Objects::nonNull).findAny()
				.orElseThrow(() -> new IllegalArgumentException("Unparsable: " + instructionString));
	}

	private static List<InstructionParser> getSimpleParsers() {
		return Arrays.asList(new SubInstructionParser(), new SetInstructionParser(), new MulInstructionParser(),
				new JnzInstructionParser());
	}

}
