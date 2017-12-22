package com.github.kisiel365.day18;

import java.util.ArrayList;
import java.util.List;

import com.github.kisiel365.day18.InstructionsParser.InstructionSet;

public final class Day18 {

	private Day18() {
	}

	public static long simple(String input) {
		List<Instruction> instructions = new InstructionsParser(InstructionSet.BASIC).parseInstructions(input);
		State state = new State(instructions);
		while (state.isRunning())
			state.applyNextInstruction();
		return state.getLastPlayed();
	}

	public static long advanced(String input) {
		List<Instruction> instructions = new InstructionsParser(InstructionSet.ADVANCED).parseInstructions(input);
		List<Long> programZeroToProgramOne = new ArrayList<>();
		List<Long> programOneToProgramZero = new ArrayList<>();
		State programZero = new State(instructions, 0, programZeroToProgramOne, programOneToProgramZero);
		State programOne = new State(instructions, 1, programOneToProgramZero, programZeroToProgramOne);
		while (programZero.isRunning() || programOne.isRunning()) {
			programZero.applyNextInstruction();
			programOne.applyNextInstruction();
		}
		return programOne.getTimesValueSent();
	}

}
