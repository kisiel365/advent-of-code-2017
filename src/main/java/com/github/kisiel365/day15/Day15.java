package com.github.kisiel365.day15;

public final class Day15 {

	private static final long GEN_A_FACTOR = 16807;
	private static final long GEN_B_FACTOR = 48271;
	private static final long DIVIDER = 2147483647;

	private Day15() {
	}

	public static int simple(int generatorAStartingValue, int generatorBStartingValue) {
		long genAvalue = generatorAStartingValue;
		long genBvalue = generatorBStartingValue;
		int ticks = 40000000;
		int counter = 0;
		for (int i = 0; i < ticks; i++) {
			genAvalue = getNextValue(genAvalue, GEN_A_FACTOR);
			genBvalue = getNextValue(genBvalue, GEN_B_FACTOR);
			if (judge(genAvalue, genBvalue))
				counter++;
		}
		return counter;
	}

	private static long getNextValue(long genAvalue, long genAFactor) {
		return (genAvalue * genAFactor) % DIVIDER;
	}

	public static boolean judge(long valueA, long valueB) {
		return (valueA & 0xFFFF) == (valueB & 0xFFFF);
	}

	public static int advanced(int generatorAStartingValue, int generatorBStartingValue) {
		long genAvalue = generatorAStartingValue;
		long genBvalue = generatorBStartingValue;
		int ticks = 5000000;
		int counter = 0;
		for (int i = 0; i < ticks; i++) {
			do {
				genAvalue = getNextValue(genAvalue, GEN_A_FACTOR);
			} while ((genAvalue & 3) != 0); // modulo 4
			do {
				genBvalue = getNextValue(genBvalue, GEN_B_FACTOR);
			} while ((genBvalue & 7) != 0); // modulo 8
			if (judge(genAvalue, genBvalue))
				counter++;
		}
		return counter;
	}

}
