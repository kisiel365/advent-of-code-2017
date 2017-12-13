package com.github.kisiel365.day13;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day13Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day13/caseInput");
	private static final String EXAMPLE_INPUT = TestUtil.loadResourceAsString("day13/exampleInput");

	@Test
	public void simpleExample() {
		assertEquals(24, Day13.calculateSeverityOfImmediateRun(EXAMPLE_INPUT));
	}

	@Test
	public void simpleCase() {
		assertEquals(2164, Day13.calculateSeverityOfImmediateRun(CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(10, Day13.delayNecessaryToOmitFirewall(EXAMPLE_INPUT));
	}

	@Test
	public void advancedCase() {
		assertEquals(3861798, Day13.delayNecessaryToOmitFirewall(CASE_INPUT));
	}

}
