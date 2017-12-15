package com.github.kisiel365.day15;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Day15Test {

	@Test
	public void simpleExample() {
		assertEquals(588, Day15.simple(65, 8921));
	}

	@Test
	public void simpleCase() {
		assertEquals(594, Day15.simple(703, 516));
	}

	@Test
	public void judgeTest() {
		assertTrue(Day15.judge(0, 0));
		assertTrue(Day15.judge(65535, 65535));
		assertFalse(Day15.judge(65535, 65534));
		assertFalse(Day15.judge(65535, 32767));
		assertTrue(Day15.judge(131071, 65535));
	}

	@Test
	public void advancedExample() {
		assertEquals(309, Day15.advanced(65, 8921));
	}

	@Test
	public void advancedCase() {
		assertEquals(328, Day15.advanced(703, 516));
	}

}
