package com.github.kisiel365.day14;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import util.TestUtil;

public class Day14Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day14/caseInput");

	@Ignore
	@Test
	public void simpleExample() {
		assertEquals(0, Day14.simple(""));
	}

	@Ignore
	@Test
	public void simpleCase() {
		assertEquals(0, Day14.simple(CASE_INPUT));
	}

	@Ignore
	@Test
	public void advancedExample() {
		assertEquals(0, Day14.advanced(""));
	}

	@Ignore
	@Test
	public void advancedCase() {
		assertEquals(0, Day14.advanced(CASE_INPUT));
	}

}
