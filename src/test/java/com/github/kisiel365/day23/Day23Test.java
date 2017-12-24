package com.github.kisiel365.day23;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import util.TestUtil;

public class Day23Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day23/caseInput");

	@Test
	public void simpleCase() {
		assertEquals(6241, Day23.countMulInstructionInvoked(CASE_INPUT));
	}

	@Ignore
	@Test
	public void advancedCase() {
		assertEquals("", Day23.advanced(CASE_INPUT));
	}

}
