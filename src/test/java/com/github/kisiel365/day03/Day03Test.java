package com.github.kisiel365.day03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day03Test {

	@Test
	public void simpleExample() {
		assertEquals(0, Day03.spiralManhattanDistance(1));
		assertEquals(3, Day03.spiralManhattanDistance(12));
		assertEquals(2, Day03.spiralManhattanDistance(23));
		assertEquals(31, Day03.spiralManhattanDistance(1024));
	}

	@Test
	public void simpleCase() {
		assertEquals(430, Day03.spiralManhattanDistance(312051));
	}

	@Test
	public void advancedExample() {
		assertEquals(10, Day03.spiralManhattanNeighbourSumValueExceeding(7));
		assertEquals(806, Day03.spiralManhattanNeighbourSumValueExceeding(805));
	}

	@Test
	public void advancedCase() {
		assertEquals(312453, Day03.spiralManhattanNeighbourSumValueExceeding(312051));
	}

}
