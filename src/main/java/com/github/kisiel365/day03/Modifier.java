package com.github.kisiel365.day03;

final class Modifier {
	private final int deltaX;
	private final int deltaY;

	Modifier(int x, int y) {
		this.deltaX = x;
		this.deltaY = y;
	}

	int getDeltaX() {
		return deltaX;
	}

	int getDeltaY() {
		return deltaY;
	}

	@Override
	public String toString() {
		return "[" + deltaX + "," + deltaY + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deltaX;
		result = prime * result + deltaY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modifier other = (Modifier) obj;
		if (deltaX != other.deltaX)
			return false;
		if (deltaY != other.deltaY)
			return false;
		return true;
	}

}
