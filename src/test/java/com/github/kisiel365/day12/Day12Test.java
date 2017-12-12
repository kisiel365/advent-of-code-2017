package com.github.kisiel365.day12;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day12Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day12/caseInput");
	private static final String EXAMPLE_INPUT = TestUtil.loadResourceAsString("day12/exampleInput");

	@Test
	public void simpleExample() {
		assertEquals(6, Day12.sizeOfGroupContainingNodeZero(EXAMPLE_INPUT));
	}

	@Test
	public void simpleCase() {
		assertEquals(283, Day12.sizeOfGroupContainingNodeZero(CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(2, Day12.numberOfDisjunktiveGruops(EXAMPLE_INPUT));
	}

	@Test
	public void advancedCase() {
		assertEquals(195, Day12.numberOfDisjunktiveGruops(CASE_INPUT));
	}

}
