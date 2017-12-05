package com.github.kisiel365.day03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

public final class Day03 {

	private static final Set<Modifier> NEIGHBOUR_MODIFIERS = createNeighbourModifiers();

	private static class SpiralTraverser {
		private int targetSideLength = 1;
		private int currentSideLength = 0;
		private boolean targetSideLengthReached = false;
		private Direction direction = Direction.EAST;

		Direction getDirection() {
			return direction;
		}

		void step() {
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
		}

	}

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
		int currentValue = 1;
		SpiralTraverser spiralTraverser = new SpiralTraverser();
		boolean keepGoing = targetValue == 1 ? false : true;
		while (keepGoing) {
			latestPosition = latestPosition.go(spiralTraverser.getDirection());
			currentValue++;
			spiralTraverser.step();
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
		SpiralTraverser spiralTraverser = new SpiralTraverser();
		boolean keepGoing = targetValue == 1 ? false : true;
		int currentValue = 1;
		while (keepGoing) {
			latestPosition = latestPosition.go(spiralTraverser.getDirection());
			currentValue = sumAlreadyCalculatedNeighbours(latestPosition, map);
			map.put(latestPosition, currentValue);
			spiralTraverser.step();
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