package com.github.kisiel365.day19;

public final class Day19 {

	private Day19() {
	}

	public static String simple(String input) {
		char[][] map = parseMap(input);
		Position startingPosition = new Position(findStartingX(map), 0);
		Direction startingDirection = Direction.SOUTH;
		MapTraverser mapTraverser = new MapTraverser(map, startingPosition, startingDirection);
		LettersCollector lettersCollector = new LettersCollector(map);
		while (mapTraverser.hasPathAvailable()) {
			lettersCollector.check(mapTraverser.getPosition());
			mapTraverser.moveNextStep();
		}
		return lettersCollector.getCollectedLetters();
	}

	public static long advanced(String input) {
		char[][] map = parseMap(input);
		Position startingPosition = new Position(findStartingX(map), 0);
		Direction startingDirection = Direction.SOUTH;
		MapTraverser mapTraverser = new MapTraverser(map, startingPosition, startingDirection);
		long steps = 0;
		while (mapTraverser.hasPathAvailable()) {
			steps++;
			mapTraverser.moveNextStep();
		}
		return steps;
	}

	private static int findStartingX(char[][] map) {
		char[] firstLine = map[0];
		for (int i = 0; i < firstLine.length; i++)
			if ('|' == firstLine[i])
				return i;
		return -1;
	}

	private static char[][] parseMap(String input) {
		String[] lines = input.split("\r\n");
		char[][] map = new char[lines.length][];
		for (int i = 0; i < lines.length; i++)
			map[i] = lines[i].toCharArray();
		return map;
	}

}
