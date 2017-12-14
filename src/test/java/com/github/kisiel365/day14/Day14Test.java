package com.github.kisiel365.day14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day14Test {

	@Test
	public void simpleExample() {
		assertEquals(8108, Day14.countPositiveBits("flqrgnkx"));
	}

	@Test
	public void simpleCase() {
		assertEquals(8230, Day14.countPositiveBits("hfdlxzhv"));
	}

	
	@Test
	public void advancedExample() {
		assertEquals(1242, Day14.countPositiveBitGroups("flqrgnkx"));
	}

	@Test
	public void advancedCase() {
		assertEquals(1103, Day14.countPositiveBitGroups("hfdlxzhv"));
	}

}
