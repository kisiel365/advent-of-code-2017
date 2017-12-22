package com.github.kisiel365.day18;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InstructionsParser {

	public enum InstructionSet {
		BASIC, ADVANCED;
	}

	private List<InstructionParser> parsers;

	public InstructionsParser(InstructionSet instructionSet) {
		if (InstructionSet.BASIC == instructionSet)
			parsers = getSimpleParsers();
		else if (InstructionSet.ADVANCED == instructionSet)
			parsers = getAdvancedParsers();
	}

	public List<Instruction> parseInstructions(String input) {
		return Arrays.stream(input.split("\r\n")).map(this::parseInstruction).collect(Collectors.toList());
	}

	private Instruction parseInstruction(String instructionString) {
		return parsers.stream().map(parser -> parser.parse(instructionString)).filter(Objects::nonNull).findAny()
				.orElseThrow(() -> new IllegalArgumentException("Unparsable: " + instructionString));
	}

	private static List<InstructionParser> getSimpleParsers() {
		return Arrays.asList(new SndInstructionParser(), new RcvInstructionParser(), new SetInstructionParser(),
				new AddInstructionParser(), new MulInstructionParser(), new ModInstructionParser(),
				new JgzInstructionParser());
	}

	private static List<InstructionParser> getAdvancedParsers() {
		return Arrays.asList(new SendInstructionParser(), new ReceiveInstructionParser(), new SetInstructionParser(),
				new AddInstructionParser(), new MulInstructionParser(), new ModInstructionParser(),
				new JgzInstructionParser());
	}

}
