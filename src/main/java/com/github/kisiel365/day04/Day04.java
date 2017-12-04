package com.github.kisiel365.day04;

import java.util.Arrays;

public class Day04 {

	public static boolean containsNoDuplicates(String line) {
		String[] words = line.split(" ");
		Arrays.sort(words);
		for (int i = 0; i < words.length - 1; i++) {
			if (words[i].equals(words[i + 1]))
				return false;
		}
		return true;
	}

	public static boolean containsNoAnagrams(String line) {
		String[] words = line.split(" ");
		for (int i = 0; i < words.length; i++) {
			char[] chars = words[i].toCharArray();
			Arrays.sort(chars);
			words[i] = String.valueOf(chars);
		}
		Arrays.sort(words);
		for (int i = 0; i < words.length - 1; i++) {
			if (words[i].equals(words[i + 1]))
				return false;
		}
		return true;
	}

	public static long countNoDuplicates(String input) {
		return Arrays.stream(input.split("\r\n")).filter(Day04::containsNoDuplicates).count();
	}

	public static long countNoDuplicatesNorAnagrams(String input) {
		return Arrays.stream(input.split("\r\n")).filter(Day04::containsNoAnagrams).filter(Day04::containsNoDuplicates)
				.count();
	}

}
