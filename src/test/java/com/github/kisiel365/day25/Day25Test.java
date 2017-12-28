package com.github.kisiel365.day25;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import util.TestUtil;

public class Day25Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day25/caseInput");
	private static final String EXAMPLE_INPUT = TestUtil.loadResourceAsString("day25/exampleInput");

	@Test
	public void simpleExample() {
		assertEquals(3, Day25.simple(EXAMPLE_INPUT));
	}

	@Test
	public void simpleCase() {
		assertEquals(2870, Day25.simple(CASE_INPUT));
	}

	@Ignore
	@Test
	public void advancedExample() {
		assertEquals(0, Day25.advanced(""));
	}

	@Ignore
	@Test
	public void advancedCase() {
		assertEquals(0, Day25.advanced(CASE_INPUT));
	}

}
