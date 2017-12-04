package com.github.kisiel365.day04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.TestUtil;

public class Day04Test {
	private static final String INPUT = TestUtil.loadResourceAsString("day04/caseInput");

	@Test
	public void simpleExample() {
		assertEquals(true, Day04.containsNoDuplicates("aa bb cc dd ee"));
		assertEquals(false, Day04.containsNoDuplicates("aa bb cc dd aa"));
		assertEquals(true, Day04.containsNoDuplicates("aa bb cc dd aaa"));
	}
	
	@Test
	public void simpleCase() {
		assertEquals(337, Day04.countNoDuplicates(INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(true, Day04.containsNoAnagrams("abcde fghij"));
		assertEquals(false, Day04.containsNoAnagrams("abcde xyz ecdab"));
		assertEquals(true, Day04.containsNoAnagrams("a ab abc abd abf abj"));
		assertEquals(true, Day04.containsNoAnagrams("iiii oiii ooii oooi oooo"));
		assertEquals(false, Day04.containsNoAnagrams("oiii ioii iioi iiio"));
	}
	
	@Test
	public void advancedCase() {
		assertEquals(231, Day04.countNoDuplicatesNorAnagrams(INPUT));
	}

}
