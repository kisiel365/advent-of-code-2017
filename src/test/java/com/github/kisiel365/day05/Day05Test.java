package com.github.kisiel365.day05;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day05Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day05/caseInput");
	private static final String EXAMPLE_INPUT = TestUtil.loadResourceAsString("day05/exampleInput");

	@Test
	public void simpleExample() {
		assertEquals(5, Day05.countJumps(EXAMPLE_INPUT));
	}

	@Test
	public void simpleCase() {
		assertEquals(318883, Day05.countJumps(CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(10, Day05.countJumpsWithDecrease(EXAMPLE_INPUT));
	}

	@Test
	public void advancedCase() {
		assertEquals(23948711, Day05.countJumpsWithDecrease(CASE_INPUT));
	}

}
