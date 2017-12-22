package com.github.kisiel365.day19;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day19Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day19/caseInput");
	private static final String EXAMPLE_INPUT = TestUtil.loadResourceAsString("day19/exampleInput");

	@Test
	public void simpleExample() {
		assertEquals("ABCDEF", Day19.simple(EXAMPLE_INPUT));
	}

	@Test
	public void simpleCase() {
		assertEquals("VEBTPXCHLI", Day19.simple(CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(38, Day19.advanced(EXAMPLE_INPUT));
	}

	@Test
	public void advancedCase() {
		assertEquals(18702, Day19.advanced(CASE_INPUT));
	}

}
