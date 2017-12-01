package com.github.kisiel365.day01;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import util.TestUtil;

public class Day01AlternativeTest {
	private static final String INPUT = TestUtil.loadResourceAsString("day01/caseInput");

	@Test
	public void simpleExample() {
		assertEquals(3, Day01Alternative.captchaNext("1122"));
		assertEquals(4, Day01Alternative.captchaNext("1111"));
		assertEquals(0, Day01Alternative.captchaNext("1234"));
		assertEquals(9, Day01Alternative.captchaNext("91212129"));
	}

	@Test
	public void simpleCase() throws IOException {
		assertEquals(1047, Day01Alternative.captchaNext(INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(6, Day01Alternative.captchaHalfway("1212"));
		assertEquals(0, Day01Alternative.captchaHalfway("1221"));
		assertEquals(4, Day01Alternative.captchaHalfway("123425"));
		assertEquals(12, Day01Alternative.captchaHalfway("123123"));
		assertEquals(4, Day01Alternative.captchaHalfway("12131415"));
	}

	@Test
	public void advancedCase() throws IOException {
		assertEquals(982, Day01Alternative.captchaHalfway(INPUT));
	}

}
