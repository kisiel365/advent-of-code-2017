package com.github.kisiel365.day01;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import util.TestUtil;

public class Day01Test {
	private static final String INPUT = TestUtil.loadResourceAsString("day01/caseInput");

	@Test
	public void simpleExample() {
		assertEquals(3, Day01.captchaNext("1122"));
		assertEquals(4, Day01.captchaNext("1111"));
		assertEquals(0, Day01.captchaNext("1234"));
		assertEquals(9, Day01.captchaNext("91212129"));
	}

	@Test
	public void simpleCase() throws IOException {
		assertEquals(1047, Day01.captchaNext(INPUT));
	}

	@Test
	public void advancedExample() {
		assertEquals(6, Day01.captchaHalfway("1212"));
		assertEquals(0, Day01.captchaHalfway("1221"));
		assertEquals(4, Day01.captchaHalfway("123425"));
		assertEquals(12, Day01.captchaHalfway("123123"));
		assertEquals(4, Day01.captchaHalfway("12131415"));
	}

	@Test
	public void advancedCase() throws IOException {
		assertEquals(982, Day01.captchaHalfway(INPUT));
	}

}
