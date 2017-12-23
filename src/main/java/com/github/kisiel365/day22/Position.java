package com.github.kisiel365.day22;

public final class Position {

	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Position makeStep(Direction direction) {
		return new Position(x + direction.getX(), y + direction.getY());
	}
}
