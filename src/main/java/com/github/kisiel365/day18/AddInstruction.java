package com.github.kisiel365.day18;

import java.util.function.Function;

public class AddInstruction implements Instruction {

	private char registry;
	private Function<State, Long> provideValue;

	public AddInstruction(char registry, long value) {
		this.registry = registry;
		provideValue = (State state) -> value;
	}

	public AddInstruction(char registry, char valueRegistry) {
		this.registry = registry;
		provideValue = (State state) -> state.getRegisters().getOrDefault(valueRegistry, 0L);
	}

	@Override
	public void apply(State state) {
		Long value = provideValue.apply(state);
		Long currentValue = state.getRegisters().getOrDefault(registry, 0L);
		state.getRegisters().put(registry, currentValue + value);
	}

}
