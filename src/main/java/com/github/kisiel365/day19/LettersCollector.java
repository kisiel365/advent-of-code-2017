package com.github.kisiel365.day19;

import java.util.Arrays;
import java.util.List;

public class LettersCollector {

	private static final List<Character> EXCLUDED = Arrays.asList(' ', '+', '-', '|');

	private final char[][] map;
	private final StringBuilder sb = new StringBuilder();

	public LettersCollector(char[][] map) {
		this.map = map;
	}

	public void check(Position position) {
		char currentTile = map[position.getY()][position.getX()];
		if (!EXCLUDED.contains(currentTile))
			sb.append(currentTile);
	}

	public String getCollectedLetters() {
		return sb.toString();
	}

}
