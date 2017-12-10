package com.github.kisiel365.day09;

public final class Day09 {

	private Day09() {
	}

	public static int scoreGroups(String input) {
		String escaped = escapeExclamationWithinGarbage(input);
		String garbageSkipped = skipGarbage(escaped);
		return scoreFilteredGroups(garbageSkipped);
	}

	public static int countGarbage(String input) {
		String escaped = escapeExclamationWithinGarbage(input);
		return countGarbageWithinGroups(escaped);
	}

	private static int scoreFilteredGroups(String input) {
		int score = 0;
		int deepness = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '{') {
				score += ++deepness;
			} else if (c == '}') {
				deepness--;
			}
		}
		return score;
	}

	private static String skipGarbage(String input) {
		StringBuilder sb = new StringBuilder();
		boolean withinGarbage = false;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (!withinGarbage && c == '<')
				withinGarbage = true;
			else if (withinGarbage && c == '>')
				withinGarbage = false;
			else if (!withinGarbage)
				sb.append(c);
		}
		return sb.toString();
	}

	private static String escapeExclamationWithinGarbage(String input) {
		StringBuilder sb = new StringBuilder();
		boolean withinGarbage = false;
		boolean ignoreNext = false;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (!ignoreNext) {
				if (withinGarbage && c == '!') {
					ignoreNext = true;
				} else if (!withinGarbage && c == '<') {
					withinGarbage = true;
				} else if (withinGarbage && c == '>') {
					withinGarbage = false;
				}
				if (!withinGarbage || c != '!')
					sb.append(c);
			} else {
				ignoreNext = false;
			}
		}
		return sb.toString();
	}

	private static int countGarbageWithinGroups(String input) {
		boolean withinGarbage = false;
		int garbageCount = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (!withinGarbage && c == '<')
				withinGarbage = true;
			else if (withinGarbage && c == '>')
				withinGarbage = false;
			else if (withinGarbage) {
				garbageCount++;
			}
		}
		return garbageCount;
	}

}
