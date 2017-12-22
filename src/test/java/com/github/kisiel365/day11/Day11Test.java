package com.github.kisiel365.day11;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day11Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day11/caseInput");

	@Test
	public void simpleExample() {
		assertEquals(3, Day11.stepsAwayAtTheEnd("ne,ne,ne"));
		assertEquals(0, Day11.stepsAwayAtTheEnd("ne,ne,sw,sw"));
		assertEquals(2, Day11.stepsAwayAtTheEnd("ne,ne,s,s"));
		assertEquals(3, Day11.stepsAwayAtTheEnd("se,sw,se,sw,sw"));
	}

	@Test
	public void simpleCase() {
		assertEquals(834, Day11.stepsAwayAtTheEnd(CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(3, Day11.stepsAwayEverReached("ne,ne,ne"));
		assertEquals(2, Day11.stepsAwayEverReached("ne,ne,sw,sw"));
		assertEquals(2, Day11.stepsAwayEverReached("ne,ne,s,s"));
		assertEquals(3, Day11.stepsAwayEverReached("se,sw,se,sw,sw"));
	}

	@Test
	public void advancedCase() {
		assertEquals(1569, Day11.stepsAwayEverReached(CASE_INPUT));
	}

}
