package com.github.kisiel365.day09;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day09Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day09/caseInput");

	@Test
	public void simpleExample() {
		assertEquals(1, Day09.scoreGroups("{}"));
		assertEquals(6, Day09.scoreGroups("{{{}}}"));
		assertEquals(5, Day09.scoreGroups("{{},{}}"));
		assertEquals(16, Day09.scoreGroups("{{{},{},{{}}}}"));
		assertEquals(1, Day09.scoreGroups("{<a>,<a>,<a>,<a>}"));
		assertEquals(9, Day09.scoreGroups("{{<ab>},{<ab>},{<ab>},{<ab>}}"));
		assertEquals(9, Day09.scoreGroups("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
		assertEquals(3, Day09.scoreGroups("{{<a!>},{<a!>},{<a!>},{<ab>}}"));
	}

	@Test
	public void simpleCase() {
		assertEquals(17390, Day09.scoreGroups(CASE_INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(0, Day09.countGarbage("<>"));
		assertEquals(17, Day09.countGarbage("<random characters>"));
		assertEquals(3, Day09.countGarbage("<<<<>"));
		assertEquals(2, Day09.countGarbage("<{!>}>"));
		assertEquals(0, Day09.countGarbage("<!!>"));
		assertEquals(0, Day09.countGarbage("<!!!>>"));
		assertEquals(10, Day09.countGarbage("<{o\"i!a,<{i<a>"));
	}

	@Test
	public void advancedCase() {
		assertEquals(7825, Day09.countGarbage(CASE_INPUT));
	}

}
