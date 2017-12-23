package com.github.kisiel365.day22;

public final class Day22 {

	private Day22() {
	}

	public static int infectedBusts(String input, int activity) {
		State[][] map = parseMap(input);
		Position position = new Position(map.length / 2, map.length / 2);
		Direction direction = Direction.NORTH;

		int count = 0;
		for (int i = 0; i < activity; i++) {
			if (isPositionOutOfTheMap(map, position)) {
				map = extendMap(map, map.length + 2);
				position = new Position(position.getX() + 1, position.getY() + 1);
			}
			switch (map[position.getX()][position.getY()]) {
			case CLEAN:
				count++;
				map[position.getX()][position.getY()] = State.INFECTED;
				direction = direction.directionToLeft();
				break;
			case INFECTED:
				map[position.getX()][position.getY()] = State.CLEAN;
				direction = direction.directionToRight();
				break;
			case FLAGGED:
			case WEAKEND:
			}
			position = position.makeStep(direction);
		}
		return count;
	}

	public static int infectedBustsWithMoreStates(String input, int activity) {
		State[][] map = parseMap(input);
		Position position = new Position(map.length / 2, map.length / 2);
		Direction direction = Direction.NORTH;

		int count = 0;
		for (int i = 0; i < activity; i++) {
			if (isPositionOutOfTheMap(map, position)) {
				map = extendMap(map, map.length + 2);
				position = new Position(position.getX() + 1, position.getY() + 1);
			}
			switch (map[position.getX()][position.getY()]) {
			case CLEAN:
				map[position.getX()][position.getY()] = State.WEAKEND;
				direction = direction.directionToLeft();
				break;
			case WEAKEND:
				count++;
				map[position.getX()][position.getY()] = State.INFECTED;
				break;
			case INFECTED:
				map[position.getX()][position.getY()] = State.FLAGGED;
				direction = direction.directionToRight();
				break;
			case FLAGGED:
				map[position.getX()][position.getY()] = State.CLEAN;
				direction = direction.directionToRight().directionToRight();
				break;
			}
			position = position.makeStep(direction);
		}
		return count;
	}

	private static State[][] extendMap(State[][] originalMap, int targetSize) {
		State[][] extendedMap = new State[targetSize][];
		for (int i = 0; i < targetSize; i++) {
			extendedMap[i] = new State[targetSize];
		}
		for (int i = 0; i < extendedMap.length; i++)
			for (int j = 0; j < extendedMap.length; j++)
				extendedMap[i][j] = State.CLEAN;
		int originalCenter = originalMap.length / 2;
		int extendedCenter = targetSize / 2;
		int dif = extendedCenter - originalCenter;
		for (int i = 0; i < originalMap.length; i++)
			for (int j = 0; j < originalMap.length; j++)
				extendedMap[i + dif][j + dif] = originalMap[i][j];
		return extendedMap;
	}

	private static State[][] parseMap(String input) {
		String[] split = input.split("\n");
		State[][] mapParsed = new State[split.length][];
		for (int j = 0; j < split.length; j++) {
			String line = split[j];
			State[] lineParsed = new State[line.length()];
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '#')
					lineParsed[i] = State.INFECTED;
				else
					lineParsed[i] = State.CLEAN;
			}
			mapParsed[j] = lineParsed;
		}
		return mapParsed;
	}

	private static boolean isPositionOutOfTheMap(State[][] map, Position position) {
		return position.getX() >= map.length || position.getX() < 0 || position.getY() >= map.length
				|| position.getY() < 0;
	}

}
