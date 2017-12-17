package com.github.kisiel365.day16;

import java.util.Arrays;

public class SpinCommand implements Command {

	private final int spinTimes;

	public SpinCommand(int spinTimes) {
		this.spinTimes = spinTimes;
	}

	@Override
	public void process(char[] state) {
		char[] copyState = Arrays.copyOf(state, state.length);
		for (int i = 0; i < state.length; i++) {
			state[i] = copyState[(i + state.length - spinTimes) % state.length];
		}
	}

}
