package com.github.kisiel365.day16;

public final class PartnerCommand implements Command {

	private char letterA;
	private char letterB;

	public PartnerCommand(char letterA, char letterB) {
		this.letterA = letterA;
		this.letterB = letterB;
	}

	@Override
	public void process(char[] state) {
		int posA = -1;
		int posB = -1;
		for (int i = 0; i < state.length; i++) {
			if (state[i] == letterA)
				posA = i;
			if (state[i] == letterB)
				posB = i;
		}
		char tmp = state[posA];
		state[posA] = state[posB];
		state[posB] = tmp;
	}

}
