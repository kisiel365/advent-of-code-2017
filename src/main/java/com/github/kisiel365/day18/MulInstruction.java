package com.github.kisiel365.day18;

import java.util.function.Function;

public class MulInstruction implements Instruction {

	private char registry;
	private Function<State, Long> provideValue;

	public MulInstruction(char registry, char valueRegistry) {
		this.registry = registry;
		provideValue = (State state) -> state.getRegisters().getOrDefault(valueRegistry, 0L);
	}

	public MulInstruction(char registry, long value) {
		this.registry = registry;
		provideValue = (State state) -> value;
	}

	@Override
	public void apply(State state) {
		Long currentValue = state.getRegisters().getOrDefault(registry, 0L);
		Long value = provideValue.apply(state);
		state.getRegisters().put(registry, value * currentValue);
	}

}
