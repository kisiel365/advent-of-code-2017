package com.github.kisiel365.day18;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {

	private Map<Character, Long> registers = new HashMap<>();
	private List<Instruction> instructions;
	private int cursor = 0;
	private Long lastPlayed = null;
	private boolean running = true;
	private List<Long> receiveList;
	private List<Long> sendList;
	private long timesValueSent = 0;

	public State(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public State(List<Instruction> instructions, long programId, List<Long> sendList, List<Long> receiveList) {
		this.instructions = instructions;
		registers.put('p', programId);
		this.sendList = sendList;
		this.receiveList = receiveList;
	}

	public void sendValue(long value) {
		sendList.add(value);
		timesValueSent++;
	}

	public long getTimesValueSent() {
		return timesValueSent;
	}

	public Long getLastPlayed() {
		return lastPlayed;
	}

	public void modifyCursor(long cursorModification) {
		cursor += cursorModification;
	}

	public void setLastPlayed(Long lastPlayed) {
		this.lastPlayed = lastPlayed;
	}

	public Map<Character, Long> getRegisters() {
		return registers;
	}

	public List<Long> getReceiveList() {
		return receiveList;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void applyNextInstruction() {
		Instruction instruction = instructions.get(cursor);
		instruction.apply(this);
		cursor++;
	}

}
