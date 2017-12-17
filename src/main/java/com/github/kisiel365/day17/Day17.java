package com.github.kisiel365.day17;

import java.util.ArrayList;
import java.util.List;

public final class Day17 {

	private Day17() {
	}

	public static int firstValueAfter2017(int step) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		int current = 0;
		for (int i = 1; i <= 2017; i++) {
			current = (current + step) % (list.size());
			list.add(++current, i);
		}
		return list.get(list.indexOf(2017) + 1);
	}

	public static int firstValueAfterZero(int step) {
		int current = 0;
		int zeroPosition = 0;
		int listSize = 1;
		int lastValueAfterZero = -1;
		for (int i = 1; i <= 50000000; i++) {
			current = (current + step) % (listSize) + 1;
			listSize++;
			if (current == zeroPosition + 1)
				lastValueAfterZero = i;
			if (current <= zeroPosition)
				zeroPosition++;
		}
		return lastValueAfterZero;
	}

}
