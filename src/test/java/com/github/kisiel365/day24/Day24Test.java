package com.github.kisiel365.day24;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day24Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day24/caseInput");
	private static final String EXAMPLE_INPUT = TestUtil.loadResourceAsString("day24/exampleInput");

	@Test
	public void simpleExample() {
		assertEquals(31, Day24.strengthOfStrongestBridge(EXAMPLE_INPUT));
	}

	@Test
	public void simpleCase() {
		assertEquals(1906, Day24.strengthOfStrongestBridge(CASE_INPUT));
	}

	@Test
	public void advancedCase() {
		assertEquals(1824, Day24.strengthOfLongestThenStrongestBridge(CASE_INPUT));
	}

}
