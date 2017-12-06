package com.github.kisiel365.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Day06 {

	private Day06() {
	}

	public static int loopEnd(String input) {
		Integer[] banks = parseInput(input);
		int reallocateSteps = 0;
		Set<String> previousStates = new HashSet<>();
		while (previousStates.add(Arrays.toString(banks))) {
			reallocate(banks);
			reallocateSteps++;
		}
		return reallocateSteps;
	}

	public static int loopSize(String input) {
		Integer[] banks = parseInput(input);
		int reallocateSteps = 0;
		List<String> previousStates = new ArrayList<>();
		while (!previousStates.contains(Arrays.toString(banks))) {
			previousStates.add(Arrays.toString(banks));
			reallocate(banks);
			reallocateSteps++;
		}
		int beginingOfCycle = previousStates.indexOf(Arrays.toString(banks));
		return reallocateSteps - beginingOfCycle;
	}

	private static Integer[] parseInput(String input) {
		String[] elements = input.split("\t");
		Integer[] banks = new Integer[elements.length];
		for (int i = 0; i < banks.length; i++)
			banks[i] = Integer.parseInt(elements[i]);
		return banks;
	}

	private static void reallocate(Integer[] banks) {
		int indexOfMax = indexOfMax(banks);
		int toRellocate = banks[indexOfMax];
		int targetRelocation = (indexOfMax + 1) % banks.length;
		banks[indexOfMax] = 0;
		while (toRellocate > 0) {
			banks[targetRelocation]++;
			targetRelocation = (targetRelocation + 1) % banks.length;
			toRellocate--;
		}
	}

	private static int indexOfMax(Integer[] banks) {
		int index = 0;
		for (int i = 1; i < banks.length; i++)
			if (banks[i] > banks[index])
				index = i;
		return index;
	}

}
