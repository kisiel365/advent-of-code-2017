package com.github.kisiel365.day23;

import java.util.List;

import com.github.kisiel365.day23.InstructionsParser.InstructionSet;

public final class Day23 {

	private Day23() {
	}

	public static int countMulInstructionInvoked(String input) {
		List<Instruction> instructions = new InstructionsParser(InstructionSet.BASIC).parseInstructions(input);
		State state = new State(instructions);
		while (state.isRunning())
			state.applyNextInstruction();
		return state.mulInstructionInvoked();
	}

	public static int advanced(String input) {
		return 0;
	}

}
