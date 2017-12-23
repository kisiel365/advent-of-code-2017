package com.github.kisiel365.day22;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day22Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day22/caseInput");
	private static final String EXAMPLE_INPUT = TestUtil.loadResourceAsString("day22/exampleInput");

	@Test
	public void simpleExample() {
		assertEquals(41, Day22.infectedBusts(EXAMPLE_INPUT, 70));
		assertEquals(5587, Day22.infectedBusts(EXAMPLE_INPUT, 10000));
	}

	@Test
	public void simpleCase() {
		assertEquals(5223, Day22.infectedBusts(CASE_INPUT, 10000));
	}

	@Test
	public void advancedExample() {
		assertEquals(26, Day22.infectedBustsWithMoreStates(EXAMPLE_INPUT, 100));
		assertEquals(2511944, Day22.infectedBustsWithMoreStates(EXAMPLE_INPUT, 10000000));
	}

	@Test
	public void advancedCase() {
		assertEquals(2511456, Day22.infectedBustsWithMoreStates(CASE_INPUT, 10000000));
	}

}
