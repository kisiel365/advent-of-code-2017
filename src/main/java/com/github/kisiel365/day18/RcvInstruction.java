package com.github.kisiel365.day18;

public class RcvInstruction implements Instruction {

	private char registry;

	public RcvInstruction(char registry) {
		this.registry = registry;
	}

	@Override
	public void apply(State state) {
		Long value = state.getRegisters().getOrDefault(registry, 0L);
		if (value > 0) {
			state.setRunning(false);
		}
	}

}
