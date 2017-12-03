package com.github.kisiel365.day02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day02Test {

	@Test
	public void simpleExample() {
		final String simpleExampleInput = TestUtil.loadResourceAsString("day02/simpleExampleInput");
		assertEquals(18, Day02.checksum(simpleExampleInput));
	}

	@Test
	public void simpleCase() {
		final String caseInput = TestUtil.loadResourceAsString("day02/caseInput");
		assertEquals(37923, Day02.checksum(caseInput));
	}

	@Test
	public void advancedExample() {
		final String advancedExampleInput = TestUtil.loadResourceAsString("day02/advancedExampleInput");
		assertEquals(9, Day02.checksumEvenlyDivisible(advancedExampleInput));
	}
	
	@Test
	public void advancedCase() {
		final String caseInput = TestUtil.loadResourceAsString("day02/caseInput");
		assertEquals(263, Day02.checksumEvenlyDivisible(caseInput));
	}

}
