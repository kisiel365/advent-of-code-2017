package com.github.kisiel365.day12;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import util.TestUtil;

public class Day12Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day12/caseInput");

	@Ignore
	@Test
	public void simpleExample() {
		assertEquals(0, Day12.simple(""));
	}

	@Ignore
	@Test
	public void simpleCase() {
		assertEquals(0, Day12.simple(CASE_INPUT));
	}

	@Ignore
	@Test
	public void advancedExample() {
		assertEquals(0, Day12.advanced(""));
	}

	@Ignore
	@Test
	public void advancedCase() {
		assertEquals(0, Day12.advanced(CASE_INPUT));
	}

}
