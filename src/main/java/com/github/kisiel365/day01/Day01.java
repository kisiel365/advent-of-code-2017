package com.github.kisiel365.day01;

import java.util.List;
import java.util.stream.Collectors;

public final class Day01 {

	private Day01() {
	}

	public static long captchaNext(String seq) {
		List<Integer> numberSeq = seq.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
		return captcha(numberSeq, 1);
	}

	public static long captchaHalfway(String seq) {
		List<Integer> numberSeq = seq.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
		return captcha(numberSeq, numberSeq.size() / 2);
	}

	private static long captcha(List<Integer> numberSeq, int shift) {
		final int length = numberSeq.size();
		long sum = 0;
		for (int i = 0; i < length; i++) {
			int current = numberSeq.get(i);
			int shifted = numberSeq.get((i + shift) % length);
			if (current == shifted)
				sum += current;
		}
		return sum;
	}

}
