package com.github.kisiel365.day03;

public enum Direction {
	EAST(1, 0), NORTH(0, 1), WEST(-1, 0), SOUTH(0, -1);

	private int x;
	private int y;

	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getNextDirection() {
		if (this == Direction.EAST)
			return Direction.NORTH;
		else if (this == Direction.NORTH)
			return Direction.WEST;
		else if (this == Direction.WEST)
			return Direction.SOUTH;
		else if (this == Direction.SOUTH)
			return Direction.EAST;
		return null;
	}

}
