package com.github.kisiel365.day20;

import java.util.Objects;

public class Vector {

	private long x;
	private long y;
	private long z;

	public Vector(long x, long y, long z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public long getAbsoluteManhattanDistance() {
		return Math.abs(x) + Math.abs(y) + Math.abs(z);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Vector)) {
			return false;
		}
		Vector vector = (Vector) o;
		return x == vector.x && y == vector.y && z == vector.z;
	}

	public void apply(Vector anotherVector) {
		x += anotherVector.x;
		y += anotherVector.y;
		z += anotherVector.z;
	}

}
