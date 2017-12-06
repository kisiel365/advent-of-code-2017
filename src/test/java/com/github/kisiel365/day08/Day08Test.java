package com.github.kisiel365.day08;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import util.TestUtil;

public class Day08Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day08/caseInput");

	@Ignore
	@Test
	public void simpleExample() {
		assertEquals(0, Day08.simple(""));
	}

	@Ignore
	@Test
	public void simpleCase() {
		assertEquals(0, Day08.simple(CASE_INPUT));
	}

	@Ignore
	@Test
	public void advancedExample() {
		assertEquals(0, Day08.advanced(""));
	}

	@Ignore
	@Test
	public void advancedCase() {
		assertEquals(0, Day08.advanced(CASE_INPUT));
	}

}
