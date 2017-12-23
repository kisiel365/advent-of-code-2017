package com.github.kisiel365.day22;

public enum Direction {
	NORTH(-1, 0), EAST(0, 1), SOUTH(1, 0), WEST(0, -1);
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

	public Direction directionToLeft() {
		switch (this) {
		case EAST:
			return Direction.NORTH;
		case NORTH:
			return Direction.WEST;
		case WEST:
			return Direction.SOUTH;
		case SOUTH:
			return Direction.EAST;
		default:
			return null;
		}
	}

	public Direction directionToRight() {
		switch (this) {
		case EAST:
			return Direction.SOUTH;
		case NORTH:
			return Direction.EAST;
		case WEST:
			return Direction.NORTH;
		case SOUTH:
			return Direction.WEST;
		default:
			return null;
		}
	}
}
