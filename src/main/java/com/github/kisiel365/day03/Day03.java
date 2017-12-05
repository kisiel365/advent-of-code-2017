package com.github.kisiel365.day03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Day03 {

	private static final Set<Modifier> NEIGHBOUR_MODIFIERS = createNeighbourModifiers();

	private static class SpiralTraverser {
		private int targetSideLength = 1;
		private int currentSideLength = 0;
		private boolean targetSideLengthReached = false;
		private Direction direction = Direction.EAST;

		Position traverse(Position currentPosition) {
			Position nextPosition = currentPosition.go(direction);
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
			return nextPosition;
		}
	}

	private Day03() {
	}

	public static int spiralManhattanDistance(int targetValue) {
		Position currentPosition = new Position(0, 0);
		int currentValue = 1;
		SpiralTraverser spiralTraverser = new SpiralTraverser();
		boolean keepGoing = targetValue == 1 ? false : true;
		while (keepGoing) {
			currentPosition = spiralTraverser.traverse(currentPosition);
			currentValue++;
			if (currentValue >= targetValue) {
				keepGoing = false;
			}
		}
		return currentPosition.manhattanDistance();
	}

	public static int spiralManhattanNeighbourSumValueExceeding(int targetValue) {
		Map<Position, Integer> map = new HashMap<>();
		Position currentPosition = new Position(0, 0);
		map.put(currentPosition, 1);
		SpiralTraverser spiralTraverser = new SpiralTraverser();
		boolean keepGoing = targetValue == 1 ? false : true;
		int currentValue = 1;
		while (keepGoing) {
			currentPosition = spiralTraverser.traverse(currentPosition);
			currentValue = sumAlreadyCalculatedNeighbours(currentPosition, map);
			map.put(currentPosition, currentValue);
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
		Set<Integer> range = new HashSet<>(Arrays.asList(1, 0, -1));
		Set<Modifier> modifiers = new HashSet<>();
		for (Integer i : range)
			for (Integer j : range)
				modifiers.add(new Modifier(i, j));
		modifiers.remove(new Modifier(0, 0));
		return modifiers;
	}
}