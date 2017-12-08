package com.github.kisiel365.day07;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day07Test {
	private static final String EXAMPLE_INPUT = TestUtil.loadResourceAsString("day07/exampleInput");
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day07/caseInput");

	@Test
	public void simpleExample() {
		assertEquals("tknk", Day07.nameOfRoot(EXAMPLE_INPUT));
	}

	@Test
	public void simpleCase() {
		assertEquals("qibuqqg", Day07.nameOfRoot(CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(60, Day07.weightDifferenceToProgramSibblings(EXAMPLE_INPUT));
	}

	@Test
	public void advancedCase() {
		assertEquals(1079, Day07.weightDifferenceToProgramSibblings(CASE_INPUT));
	}

}
