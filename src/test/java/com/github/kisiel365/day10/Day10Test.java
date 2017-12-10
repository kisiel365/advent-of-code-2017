package com.github.kisiel365.day10;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import util.TestUtil;

public class Day10Test {
	private static final String CASE_INPUT = TestUtil.loadResourceAsString("day10/caseInput");

	@Test
	public void simpleExample() {
		assertEquals(12, Day10.simple(5, "3,4,1,5"));
	}

	@Test
	public void simpleCase() {
		assertEquals(23715, Day10.simple(256, CASE_INPUT));
	}

	@Ignore
	@Test
	public void advancedExample() {
		assertEquals("a2582a3a0e66e6e86e3812dcb672a272", Day10.advanced(""));
		assertEquals("33efeb34ea91902bb2f59c9920caa6cd", Day10.advanced("AoC 2017"));
		assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", Day10.advanced("1,2,3"));
		assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", Day10.advanced("1,2,4"));
	}

	@Ignore
	@Test
	public void advancedCase() {
		assertEquals(0, Day10.advanced(CASE_INPUT));
	}

}
