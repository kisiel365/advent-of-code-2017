package com.github.kisiel365.day16;

public final class ExchangeCommand implements Command {
	private final int position1;
	private final int position2;

	public ExchangeCommand(int position1, int position2) {
		this.position1 = position1;
		this.position2 = position2;
	}

	@Override
	public void process(char[] state) {
		char tmp = state[position1];
		state[position1] = state[position2];
		state[position2] = tmp;
	}

}
