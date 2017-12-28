package com.github.kisiel365.day25;

public class WriteValueCommand implements Command {

	private final boolean value;

	public WriteValueCommand(boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "WriteValueCommand [" + value + "]";
	}

	@Override
	public void applyCommand(State state) {
		state.setCurrentValue(value);
	}

}
