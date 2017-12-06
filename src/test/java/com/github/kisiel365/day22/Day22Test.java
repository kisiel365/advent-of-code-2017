package com.github.kisiel365.day22;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import util.TestUtil;

public class Day22Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day22/caseInput");

	@Ignore
	@Test
	public void simpleExample() {
		assertEquals(0, Day22.simple(""));
	}

	@Ignore
	@Test
	public void simpleCase() {
		assertEquals(0, Day22.simple(CASE_INPUT));
	}

	@Ignore
	@Test
	public void advancedExample() {
		assertEquals(0, Day22.advanced(""));
	}

	@Ignore
	@Test
	public void advancedCase() {
		assertEquals(0, Day22.advanced(CASE_INPUT));
	}

}
