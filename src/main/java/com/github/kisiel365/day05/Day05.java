package com.github.kisiel365.day05;

public class Day05 {

	public static int countJumps(String simpleCaseInput) {
		String[] split = simpleCaseInput.split("\r\n");
		Integer[] table = new Integer[split.length];
		for (int i = 0; i < split.length; i++)
			table[i] = Integer.parseInt(split[i]);
		int cursor = 0;
		int steps = 0;
		while (cursor < table.length && cursor > -1) {
			int delta = table[cursor];
			table[cursor]++;
			cursor += delta;
			steps++;
		}
		return steps;
	}

	public static int countJumpsWithDecrease(String simpleCaseInput) {
		String[] split = simpleCaseInput.split("\r\n");
		Integer[] table = new Integer[split.length];
		for (int i = 0; i < split.length; i++)
			table[i] = Integer.parseInt(split[i]);
		int cursor = 0;
		int steps = 0;
		while (cursor < table.length && cursor > -1) {
			int delta = table[cursor];
			if (table[cursor] > 2) {
				table[cursor]--;
			} else
				table[cursor]++;
			cursor += delta;
			steps++;
		}
		return steps;
	}
}
