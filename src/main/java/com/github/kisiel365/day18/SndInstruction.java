package com.github.kisiel365.day18;

public final class SndInstruction implements Instruction {

	private char registry;

	public SndInstruction(char registry) {
		this.registry = registry;
	}

	@Override
	public String toString() {
		return "SndInstruction [registry=" + registry + "]";
	}

	@Override
	public void apply(State state) {
		Long registryValue = state.getRegisters().getOrDefault(registry, 0L);
		if (registryValue > 0)
			state.setLastPlayed(registryValue);
	}

}
