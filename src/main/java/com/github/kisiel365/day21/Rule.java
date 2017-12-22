package com.github.kisiel365.day21;

public final class Rule {

	private final String input;
	private final String output;

	public Rule(String input, String output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public String toString() {
		return "Rule [" + input + " => " + output + "]";
	}

}
