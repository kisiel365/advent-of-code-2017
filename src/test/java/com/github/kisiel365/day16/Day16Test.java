package com.github.kisiel365.day16;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import util.TestUtil;

public class Day16Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day16/caseInput");

	@Ignore
	@Test
	public void simpleExample() {
		assertEquals(0, Day16.simple(""));
	}

	@Ignore
	@Test
	public void simpleCase() {
		assertEquals(0, Day16.simple(CASE_INPUT));
	}

	@Ignore
	@Test
	public void advancedExample() {
		assertEquals(0, Day16.advanced(""));
	}

	@Ignore
	@Test
	public void advancedCase() {
		assertEquals(0, Day16.advanced(CASE_INPUT));
	}

}
