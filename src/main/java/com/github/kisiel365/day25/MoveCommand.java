package com.github.kisiel365.day25;

public final class MoveCommand implements Command {

	private final int cursorDelta;

	public MoveCommand(String state) {
		if ("left".equals(state)) {
			cursorDelta = -1;
		} else if ("right".equals(state)) {
			cursorDelta = 1;
		} else
			throw new IllegalStateException();
	}

	@Override
	public String toString() {
		return "MoveCommand [" + cursorDelta + "]";
	}

	@Override
	public void applyCommand(State state) {
		state.move(cursorDelta);
	}

}
