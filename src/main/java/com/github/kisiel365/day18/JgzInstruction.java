package com.github.kisiel365.day18;

import java.util.function.Function;

public class JgzInstruction implements Instruction {

	private Function<State, Long> provideValue;
	private Function<State, Long> provideRegistry;

	public JgzInstruction(char registry, long value) {
		provideRegistry = (State state) -> state.getRegisters().getOrDefault(registry, 0L);
		provideValue = (State state) -> value;
	}

	public JgzInstruction(char registry, char valueRegistry) {
		provideRegistry = (State state) -> state.getRegisters().getOrDefault(registry, 0L);
		provideValue = (State state) -> state.getRegisters().getOrDefault(valueRegistry, 0L);
	}

	public JgzInstruction(long registryValue, long value) {
		provideRegistry = (State state) -> registryValue;
		provideValue = (State state) -> value;
	}

	@Override
	public void apply(State state) {
		Long currentValue = provideRegistry.apply(state);
		if (currentValue > 0) {
			Long value = provideValue.apply(state) - 1;
			state.modifyCursor(value);
		}
	}

}
