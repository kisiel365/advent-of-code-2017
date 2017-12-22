package com.github.kisiel365.day18;

import java.util.function.Function;

public class SetInstruction implements Instruction {

	private char registry;
	private Function<State, Long> provideValue;

	public SetInstruction(char registry, long value) {
		this.registry = registry;
		provideValue = (State state) -> value;
	}

	public SetInstruction(char registry, char valueRegistry) {
		this.registry = registry;
		provideValue = (State state) -> state.getRegisters().getOrDefault(valueRegistry, 0L);
	}

	@Override
	public void apply(State state) {
		Long value = provideValue.apply(state);
		state.getRegisters().put(registry, value);
	}

}
