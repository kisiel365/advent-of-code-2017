package com.github.kisiel365.day18;

import java.util.function.Function;

public final class SendInstruction implements Instruction {

	private Function<State, Long> provideRegistry;

	public SendInstruction(char registry) {
		provideRegistry = (State state) -> state.getRegisters().getOrDefault(registry, 0L);
	}

	public SendInstruction(long registryValue) {
		provideRegistry = (State state) -> registryValue;
	}

	@Override
	public void apply(State state) {
		Long apply = provideRegistry.apply(state);
		state.sendValue(apply);
	}

}
