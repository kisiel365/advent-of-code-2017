package com.github.kisiel365.day02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class Day02 {

	private Day02() {
	}

	public static long checksum(String input) {
		long sum = 0;
		String[] rows = input.split("\r\n");
		for (String row : rows) {
			List<Integer> elements = Arrays.stream(row.split("\t")).map(Integer::parseInt).collect(Collectors.toList());
			Integer max = elements.stream().max(Comparator.naturalOrder()).orElse(null);
			Integer min = elements.stream().min(Comparator.naturalOrder()).orElse(null);
			sum += max - min;
		}
		return sum;
	}

	public static long checksumEvenlyDivisible(String input) {
		long sum = 0;
		String[] rows = input.split("\r\n");
		for (String row : rows) {
			List<Integer> elements = Arrays.stream(row.split("\t")).map(Integer::parseInt).collect(Collectors.toList());
			Integer quotient = elements.stream().map(element -> {
				return elements.stream().filter(isEvenlyDivisibleBy(element)).map(divideBy(element)).findFirst()
						.orElse(null);
			}).filter(Objects::nonNull).findFirst().orElse(null);
			sum += quotient;
		}
		return sum;
	}

	private static Function<? super Integer, ? extends Integer> divideBy(Integer divident) {
		return divisor -> divident / divisor;
	}

	private static Predicate<? super Integer> isEvenlyDivisibleBy(Integer divisor) {
		return divident -> divident != divisor && divisor % divident == 0;
	}

}
