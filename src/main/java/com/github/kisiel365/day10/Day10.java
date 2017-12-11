package com.github.kisiel365.day10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.DatatypeConverter;

public final class Day10 {

	private Day10() {
	}

	public static int singleKnotHash(int size, String input) {
		List<Integer> lengths = Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
		int[] sparseHash = getSparseHash(size, 1, lengths);
		return sparseHash[0] * sparseHash[1];
	}

	public static String produceHash(String rawInput) {
		List<Integer> asciified = rawInput.chars().boxed().collect(Collectors.toList());
		asciified.addAll(Arrays.asList(17, 31, 73, 47, 23));
		int[] sparseHash = getSparseHash(256, 64, asciified);
		byte[] xored = xorBlocks(sparseHash);
		return DatatypeConverter.printHexBinary(xored).toLowerCase();
	}

	private static byte[] xorBlocks(int[] sparseHash) {
		byte[] xored = new byte[16];
		for (int block = 0; block < 16; block++) {
			byte value = (byte) sparseHash[block * 16];
			for (int numberInBlock = 1; numberInBlock < 16; numberInBlock++) {
				value ^= sparseHash[block * 16 + numberInBlock];
			}
			xored[block] = value;
		}
		return xored;
	}

	private static int[] getSparseHash(int size, int times, List<Integer> lengths) {
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++)
			numbers[i] = i;
		int currentPosition = 0;
		int skipSize = 0;
		for (int timesRun = 0; timesRun < times; timesRun++)
			for (int length : lengths) {
				reverse(numbers, currentPosition, length);
				currentPosition += length + skipSize++;
			}
		return numbers;
	}

	private static void reverse(int[] numbers, int currentPosition, int length) {
		int reverseStart = currentPosition;
		int reverseEnd = currentPosition + length - 1;
		for (int i = 0; i < length / 2; i++) {
			int position1 = (reverseStart + i + numbers.length) % numbers.length;
			int position2 = (reverseEnd - i + numbers.length) % numbers.length;
			int tmp = numbers[position1];
			numbers[position1] = numbers[position2];
			numbers[position2] = tmp;
		}
	}

}
