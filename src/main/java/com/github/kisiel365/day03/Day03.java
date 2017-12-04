package com.github.kisiel365.day03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Day03 {

	public static int spiralManhattanDistance(int i) {
		Map<Position, Integer> spiral = generateSpiral(i);
		Position position = spiral.entrySet().stream().filter(x -> x.getValue().equals(i)).map(x -> x.getKey())
				.findFirst().orElse(null);
		return position.manhattanDistance();
	}

	public static int spiralManhattanNeighbourSumValueExceeding(int i) {
		Map<Position, Integer> generateSpiral2 = generateSummingSpiral(i);
		return generateSpiral2.values().stream().max(Comparator.naturalOrder()).orElse(null);
	}

	private static Map<Position, Integer> generateSpiral(long value) {
		Map<Position, Integer> map = new HashMap<>();
		map.put(new Position(0, 0), 1);
		int currentX = 0;
		int currentY = 0;
		Direction direction = Direction.EAST;
		boolean keepGoing = true;
		int sideLength = 1;
		int currentValue = 1;
		while (keepGoing) {
			for (int i = 0; i < sideLength; i++) {
				currentValue++;
				currentX += direction.getX();
				currentY += direction.getY();
				Position position = new Position(currentX, currentY);
				map.put(position, currentValue);
				if (currentValue >= value) {
					keepGoing = false;
					break;
				}
			}
			if (keepGoing) {
				direction = direction.getNextDirection();
				for (int i = 0; i < sideLength; i++) {
					currentValue++;
					currentX += direction.getX();
					currentY += direction.getY();
					Position position = new Position(currentX, currentY);
					map.put(position, currentValue);
					if (currentValue >= value) {
						keepGoing = false;
						break;
					}
				}
				direction = direction.getNextDirection();
				sideLength++;
			}
		}
		return map;
	}

	private static Map<Position, Integer> generateSummingSpiral(long value) {
		Map<Position, Integer> map = new HashMap<>();
		map.put(new Position(0, 0), 1);
		int currentX = 0;
		int currentY = 0;
		Direction direction = Direction.EAST;
		boolean keepGoing = true;
		int sideLength = 1;
		int currentValue = 1;
		while (keepGoing) {
			for (int i = 0; i < sideLength; i++) {
				currentX += direction.getX();
				currentY += direction.getY();
				currentValue = sumAlreadyCalculatedNeighbours(currentX, currentY, map);
				map.put(new Position(currentX, currentY), currentValue);
				if (currentValue >= value) {
					keepGoing = false;
					break;
				}
			}
			if (keepGoing) {
				direction = direction.getNextDirection();
				for (int i = 0; i < sideLength; i++) {
					currentX += direction.getX();
					currentY += direction.getY();
					currentValue = sumAlreadyCalculatedNeighbours(currentX, currentY, map);
					map.put(new Position(currentX, currentY), currentValue);
					if (currentValue >= value) {
						keepGoing = false;
						break;
					}
				}
				direction = direction.getNextDirection();
				sideLength++;
			}
		}
		return map;
	}

	private static int sumAlreadyCalculatedNeighbours(int currentX, int currentY, Map<Position, Integer> map) {
		Integer num1 = map.getOrDefault(new Position(currentX + 1, currentY + 1), 0);
		Integer num2 = map.getOrDefault(new Position(currentX + 1, currentY), 0);
		Integer num3 = map.getOrDefault(new Position(currentX + 1, currentY - 1), 0);
		Integer num4 = map.getOrDefault(new Position(currentX - 1, currentY + 1), 0);
		Integer num5 = map.getOrDefault(new Position(currentX - 1, currentY), 0);
		Integer num6 = map.getOrDefault(new Position(currentX - 1, currentY - 1), 0);
		Integer num7 = map.getOrDefault(new Position(currentX, currentY + 1), 0);
		Integer num8 = map.getOrDefault(new Position(currentX, currentY - 1), 0);
		return num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8;
	}
}
