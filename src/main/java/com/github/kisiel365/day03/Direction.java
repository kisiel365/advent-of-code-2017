package com.github.kisiel365.day03;

enum Direction {
	EAST(new Modifier(1, 0)), NORTH(new Modifier(0, 1)), WEST(new Modifier(-1, 0)), SOUTH(new Modifier(0, -1));

	private Modifier modifier;

	Direction(Modifier modifier) {
		this.modifier = modifier;
	}

	Modifier getModifier() {
		return modifier;
	}

	Direction getNextDirection() {
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
