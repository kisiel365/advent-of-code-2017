package com.github.kisiel365.day25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {

	private static final int TAPE_SIZE = 20000;
	private Map<StateValuePair, List<Command>> instructions = new HashMap<>();
	private int totalSteps;
	private String currentState;

	private String readState = null;
	private Boolean readValue = null;

	private int cursor = TAPE_SIZE / 2;
	private boolean[] tape = new boolean[TAPE_SIZE];

	public State() {
	}

	public void setBeginState(String startState) {
		currentState = startState;
	}

	public void setTotalSteps(int totalSteps) {
		this.totalSteps = totalSteps;
	}

	public void setReadState(String readState) {
		this.readState = readState;
	}

	public void setReadValue(Boolean readValue) {
		this.readValue = readValue;
	}

	public void addCommand(Command command) {
		if (readValue == null || readState == null)
			throw new IllegalStateException();
		StateValuePair key = new StateValuePair(readState, readValue);
		if (!instructions.containsKey(key))
			instructions.put(key, new ArrayList<>());
		instructions.get(key).add(command);
	}

	public int checksum() {
		int checksum = 0;
		for (int i = 0; i < TAPE_SIZE; i++)
			if (tape[i])
				checksum++;
		return checksum;
	}

	public void move(int cursorDelta) {
		cursor += cursorDelta;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public void setCurrentValue(boolean value) {
		tape[cursor] = value;
	}

	public void run() {
		for (int i = 0; i < totalSteps; i++) {
			StateValuePair key = new StateValuePair(currentState, tape[cursor]);
			for (Command command : instructions.get(key))
				command.applyCommand(this);
		}
	}

}
