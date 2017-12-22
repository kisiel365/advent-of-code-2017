package com.github.kisiel365.day20;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day20Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day20/caseInput");
	private static final String SIMPLE_EXAMPLE_INPUT = TestUtil.loadResourceAsString("day20/simpleExampleInput");
	private static final String ADVANCED_EXAMPLE_INPUT = TestUtil.loadResourceAsString("day20/advancedExampleInput");

	@Test
	public void simpleExample() {
		assertEquals(0, Day20.idOfParticleClosestToCenterInInfinity(SIMPLE_EXAMPLE_INPUT));
	}

	@Test
	public void simpleCase() {
		assertEquals(91, Day20.idOfParticleClosestToCenterInInfinity(CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(1, Day20.countUncolidedParticles(ADVANCED_EXAMPLE_INPUT));
	}

	@Test
	public void advancedCase() {
		assertEquals(567, Day20.countUncolidedParticles(CASE_INPUT));
	}

}
