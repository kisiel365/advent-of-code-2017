package com.github.kisiel365.day18;

public class ReceiveInstruction implements Instruction {

	private char registry;

	public ReceiveInstruction(char registry) {
		this.registry = registry;
	}

	@Override
	public void apply(State state) {
		if (state.getReceiveList().isEmpty()) {
			state.modifyCursor(-1);
			state.setRunning(false);
		} else {
			Long received = state.getReceiveList().remove(0);
			state.getRegisters().put(registry, received);
			state.setRunning(true);
		}
	}

}
