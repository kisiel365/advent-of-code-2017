package com.github.kisiel365.day21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day21Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day21/caseInput");
	private static final String EXAMPLE_INPUT = TestUtil.loadResourceAsString("day21/exampleInput");

	@Test
	public void simpleExample() {
		assertEquals(12, Day21.enchanceImageNTimes(EXAMPLE_INPUT, 2));
	}

	@Test
	public void simpleCase() {
		assertEquals(158, Day21.enchanceImageNTimes(CASE_INPUT, 5));
	}

	@Test
	public void advancedCase() {
		assertEquals(2301762, Day21.enchanceImageNTimes(CASE_INPUT, 18));
	}

}
