package com.github.kisiel365.day23;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {

	private Map<Character, Long> registers = new HashMap<>();
	private List<Instruction> instructions;
	private int cursor = 0;
	private int mulInvoked = 0;
	private boolean running = true;

	public State(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public State(List<Instruction> instructions, long i) {
		this.instructions = instructions;
		registers.put(Character.valueOf('a'), i);
	}

	public void modifyCursor(long cursorModification) {
		cursor += cursorModification;
	}

	public Map<Character, Long> getRegisters() {
		return registers;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void applyNextInstruction() {
		if (cursor >= instructions.size()) {
			running = false;
			return;
		}
		Instruction instruction = instructions.get(cursor);
		if (instruction instanceof MulInstruction)
			mulInvoked++;
		instruction.apply(this);
		cursor++;
	}

	public int mulInstructionInvoked() {
		return mulInvoked;
	}

}
