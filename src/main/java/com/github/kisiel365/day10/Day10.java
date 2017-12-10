package com.github.kisiel365.day10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.DatatypeConverter;

public final class Day10 {

	private Day10() {
	}

	public static int simple(int size, String input) {
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++)
			numbers[i] = i;
		int currentPosition = 0;
		int skipSize = 0;
		List<Integer> lengths = Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
		int timesMax = 1;
		for (int times = 0; times < timesMax; times++)
			for (int length : lengths) {
				int reverseStart = currentPosition;
				int reverseEnd = currentPosition + length - 1;
				for (int i = 0; i < length / 2; i++) {
					int tmp = numbers[(reverseStart + i + size) % size];
					numbers[(reverseStart + i + size) % size] = numbers[(reverseEnd - i + size) % size];
					numbers[(reverseEnd - i + size) % size] = tmp;
				}
				currentPosition += length + skipSize++;
			}

		return numbers[0] * numbers[1];
	}

	public static int toByte(int number) {
		int tmp = number & 0xff;
		return (tmp & 0x80) == 0 ? tmp : tmp - 256;
	}

	public static int advanced(String rawInput) {
		List<Integer> asciified = rawInput.chars().boxed().collect(Collectors.toList());
		asciified.addAll(Arrays.asList(17, 31, 73, 47, 23));
		System.out.println(asciified);
		int size = 256;
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++)
			numbers[i] = i;
		int currentPosition = 0;
		int skipSize = 0;
		int timesMax = 1;
		for (int times = 0; times < timesMax; times++)
			for (int length : asciified) {
				int reverseStart = currentPosition;
				int reverseEnd = currentPosition + length - 1;
				for (int i = 0; i < length / 2; i++) {
					int tmp = numbers[(reverseStart + i + size) % size];
					numbers[(reverseStart + i + size) % size] = numbers[(reverseEnd - i + size) % size];
					numbers[(reverseEnd - i + size) % size] = tmp;
				}
				currentPosition += length + skipSize++;
			}
		System.out.println(Arrays.toString(numbers));

		byte[] xored = new byte[16];
		for (int block = 0; block < 16; block++) {
			byte value = (byte) numbers[block * 16];
			for (int numberInBlock = 1; numberInBlock < 16; numberInBlock++) {
				value ^= numbers[block * 16 + numberInBlock];
			}
			xored[block] = value;
		}
		System.out.println(Arrays.toString(xored));

		String printHexBinary = DatatypeConverter.printHexBinary(xored);
		System.out.println(printHexBinary);

		return 0;
	}

}
