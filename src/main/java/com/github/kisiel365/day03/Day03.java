package com.github.kisiel365.day03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

public final class Day03 {

	private static final Set<Modifier> NEIGHBOUR_MODIFIERS = createNeighbourModifiers();

	private Day03() {
	}

	public static int spiralManhattanDistance(int targetValue) {
		return traverseSpiral(targetValue).manhattanDistance();
	}

	public static int spiralManhattanNeighbourSumValueExceeding(int targetValue) {
		return traverseSummingSpiral(targetValue);
	}

	private static Position traverseSpiral(long targetValue) {
		Position latestPosition = new Position(0, 0);
		Direction direction = Direction.EAST;
		int currentValue = 1;
		int targetSideLength = 1;
		int currentSideLength = 0;
		boolean targetSideLengthReached = false;
		boolean keepGoing = targetValue == 1 ? false : true;
		while (keepGoing) {
			latestPosition = latestPosition.go(direction);
			currentValue++;
			currentSideLength++;
			if (currentSideLength == targetSideLength) {
				direction = direction.getNextDirection();
				if (targetSideLengthReached) {
					targetSideLengthReached = false;
					targetSideLength++;
				} else {
					targetSideLengthReached = true;
				}
				currentSideLength = 0;
			}
			if (currentValue >= targetValue) {
				keepGoing = false;
			}
		}
		return latestPosition;
	}

	private static Integer traverseSummingSpiral(long targetValue) {
		Map<Position, Integer> map = new HashMap<>();
		Position latestPosition = new Position(0, 0);
		map.put(latestPosition, 1);
		boolean keepGoing = targetValue == 1 ? false : true;
		Direction direction = Direction.EAST;
		int targetSideLength = 1;
		int currentSideLength = 0;
		boolean targetSideLengthReached = false;
		int currentValue = 1;
		while (keepGoing) {
			latestPosition = latestPosition.go(direction);
			currentValue = sumAlreadyCalculatedNeighbours(latestPosition, map);
			map.put(latestPosition, currentValue);
			currentSideLength++;
			if (currentSideLength == targetSideLength) {
				direction = direction.getNextDirection();
				if (targetSideLengthReached) {
					targetSideLengthReached = false;
					targetSideLength++;
				} else {
					targetSideLengthReached = true;
				}
				currentSideLength = 0;
			}
			if (currentValue >= targetValue) {
				keepGoing = false;
			}
		}
		return currentValue;
	}

	private static int sumAlreadyCalculatedNeighbours(Position latestPosition, Map<Position, Integer> map) {
		int value = 0;
		for (Modifier modifier : NEIGHBOUR_MODIFIERS)
			value += map.getOrDefault(new Position(latestPosition.getX() + modifier.getDeltaX(),
					latestPosition.getY() + modifier.getDeltaY()), 0);
		return value;
	}

	private static Set<Modifier> createNeighbourModifiers() {
		ImmutableSet<Integer> range = ImmutableSet.of(1, 0, -1);
		Set<Modifier> modifiers = new HashSet<>();
		for (Integer i : range)
			for (Integer j : range)
				modifiers.add(new Modifier(i, j));
		modifiers.remove(new Modifier(0, 0));
		return modifiers;
	}
}