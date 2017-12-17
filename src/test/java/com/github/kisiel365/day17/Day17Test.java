package com.github.kisiel365.day17;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day17Test {

	@Test
	public void simpleExample() {
		assertEquals(638, Day17.firstValueAfter2017(3));
	}

	@Test
	public void simpleCase() {
		assertEquals(136, Day17.firstValueAfter2017(363));
	}

	@Test
	public void advancedCase() {
		assertEquals(1080289, Day17.firstValueAfterZero(363));
	}

}
