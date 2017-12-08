package com.github.kisiel365.day08;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day08Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day08/caseInput");
	private static final String EXAMPLE_INPUT = TestUtil.loadResourceAsString("day08/exampleInput");

	@Test
	public void simpleExample() {
		assertEquals(1, Day08.highestFinalValue(EXAMPLE_INPUT));
	}

	@Test
	public void simpleCase() {
		assertEquals(4416, Day08.highestFinalValue(CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(10, Day08.highestValueReached(EXAMPLE_INPUT));
	}

	@Test
	public void advancedCase() {
		assertEquals(5199, Day08.highestValueReached(CASE_INPUT));
	}

}
