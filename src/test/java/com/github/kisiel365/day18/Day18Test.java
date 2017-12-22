package com.github.kisiel365.day18;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day18Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day18/caseInput");
	private static final String SIMPLE_EXAMPLE_INPUT = TestUtil.loadResourceAsString("day18/simpleExampleInput");
	private static final String ADVANCED_EXAMPLE_INPUT = TestUtil.loadResourceAsString("day18/advancedExampleInput");

	@Test
	public void simpleExample() {
		assertEquals(4, Day18.simple(SIMPLE_EXAMPLE_INPUT));
	}

	@Test
	public void simpleCase() {
		assertEquals(9423, Day18.simple(CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(3, Day18.advanced(ADVANCED_EXAMPLE_INPUT));
	}

	@Test
	public void advancedCase() {
		assertEquals(7620, Day18.advanced(CASE_INPUT));
	}

}
