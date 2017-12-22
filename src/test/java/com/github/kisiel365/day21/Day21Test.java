package com.github.kisiel365.day21;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import util.TestUtil;

public class Day21Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day21/caseInput");
	private static final String EXAMPLE_INPUT = TestUtil.loadResourceAsString("day21/exampleInput");

	@Ignore
	@Test
	public void simpleExample() {
		assertEquals(12, Day21.simple(EXAMPLE_INPUT, 2));
	}

	@Ignore
	@Test
	public void simpleCase() {
		assertEquals(-1, Day21.simple(CASE_INPUT, 5));
	}

	@Ignore
	@Test
	public void advancedExample() {
		assertEquals(0, Day21.advanced(""));
	}

	@Ignore
	@Test
	public void advancedCase() {
		assertEquals(0, Day21.advanced(CASE_INPUT));
	}

}
