package com.github.kisiel365.day05;

import java.util.function.UnaryOperator;

public final class Day05 {

	private Day05() {
	}

	public static int countJumps(String input) {
		return countJumps(input, increment());
	}

	public static int countJumpsWithDecrease(String input) {
		return countJumps(input, incrementOrDecrementHigherThanTwo());
	}

	private static UnaryOperator<Integer> increment() {
		return offset -> offset + 1;
	}

	private static UnaryOperator<Integer> incrementOrDecrementHigherThanTwo() {
		return offset -> offset > 2 ? offset - 1 : offset + 1;
	}

	public static int countJumps(String simpleCaseInput, UnaryOperator<Integer> modifyOffset) {
		String[] split = simpleCaseInput.split("\r\n");
		Integer[] table = new Integer[split.length];
		for (int i = 0; i < split.length; i++)
			table[i] = Integer.parseInt(split[i]);
		int cursor = 0;
		int steps = 0;
		while (cursor < table.length && cursor > -1) {
			int delta = table[cursor];
			table[cursor] = modifyOffset.apply(table[cursor]);
			cursor += delta;
			steps++;
		}
		return steps;
	}
}
