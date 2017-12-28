package com.github.kisiel365.day25;

public class ChangeStateCommand implements Command {

	private final String state;

	public ChangeStateCommand(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ChangeStateCommand [" + state + "]";
	}

	@Override
	public void applyCommand(State state) {
		state.setCurrentState(this.state);
	}

}
