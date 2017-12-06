package com.github.kisiel365.day06;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day06Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day06/caseInput");

	@Test
	public void simpleExample() {
		assertEquals(5, Day06.loopEnd("0\t2\t7\t0"));
	}

	@Test
	public void simpleCase() {
		assertEquals(6681, Day06.loopEnd(CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(4, Day06.loopSize("0\t2\t7\t0"));
	}

	@Test
	public void advancedCase() {
		assertEquals(2392, Day06.loopSize(CASE_INPUT));
	}

}
