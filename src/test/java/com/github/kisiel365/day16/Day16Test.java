package com.github.kisiel365.day16;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day16Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day16/caseInput");

	@Test
	public void simpleExample() {
		assertEquals("baedc", Day16.orderAfterDancingOnce("abcde", "s1,x3/4,pe/b"));
	}

	@Test
	public void simpleCase() {
		assertEquals("fgmobeaijhdpkcln", Day16.orderAfterDancingOnce("abcdefghijklmnop", CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals("ceadb", Day16.orderAfterDancingNTimes("abcde", "s1,x3/4,pe/b", 2));
	}

	@Test
	public void advancedCase() {
		assertEquals("lgmkacfjbopednhi", Day16.orderAfterDancingNTimes("abcdefghijklmnop", CASE_INPUT, 1000000000));
	}

}
