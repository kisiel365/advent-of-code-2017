package com.github.kisiel365.day23;

import java.util.function.Function;

public class JnzInstruction implements Instruction {

	private Function<State, Long> provideValue;
	private Function<State, Long> provideRegistry;

	public JnzInstruction(char registry, long value) {
		provideRegistry = (State state) -> state.getRegisters().getOrDefault(registry, 0L);
		provideValue = (State state) -> value;
	}

	public JnzInstruction(char registry, char valueRegistry) {
		provideRegistry = (State state) -> state.getRegisters().getOrDefault(registry, 0L);
		provideValue = (State state) -> state.getRegisters().getOrDefault(valueRegistry, 0L);
	}

	public JnzInstruction(long registryValue, long value) {
		provideRegistry = (State state) -> registryValue;
		provideValue = (State state) -> value;
	}

	@Override
	public void apply(State state) {
		Long currentValue = provideRegistry.apply(state);
		if (currentValue != 0) {
			Long value = provideValue.apply(state) - 1;
			state.modifyCursor(value);
		}
	}

}
