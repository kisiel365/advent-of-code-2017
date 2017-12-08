package com.github.kisiel365.day08;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.regex.Matcher;

public class Command {
	private String registerToModify;
	private int modificationValue;
	private String registerForCondition;
	private BiPredicate<Integer, Integer> predicate;
	private int valueToCompare;

	private static final Map<String, BiPredicate<Integer, Integer>> predicates = possiblePredicates();

	Command(Matcher matcher) {
		registerToModify = matcher.group(1);
		modificationValue = "inc".equals(matcher.group(2)) ? Integer.parseInt(matcher.group(3))
				: Integer.parseInt(matcher.group(3)) * -1;
		registerForCondition = matcher.group(4);
		predicate = predicates.get(matcher.group(5));
		valueToCompare = Integer.parseInt(matcher.group(6));
	}

	private static final Map<String, BiPredicate<Integer, Integer>> possiblePredicates() {
		Map<String, BiPredicate<Integer, Integer>> operators = new HashMap<>();
		operators.put(">", (a, b) -> a > b);
		operators.put("<", (a, b) -> a < b);
		operators.put(">=", (a, b) -> a >= b);
		operators.put("<=", (a, b) -> a <= b);
		operators.put("==", (a, b) -> a.equals(b));
		operators.put("!=", (a, b) -> !a.equals(b));
		return operators;
	}

	public boolean fulfillsCondition(Map<String, Integer> registers) {
		Integer registerForConditionValue = registers.getOrDefault(registerForCondition, 0);
		return predicate.test(registerForConditionValue, valueToCompare);
	}

	public void execute(Map<String, Integer> registers) {
		Integer currentValue = registers.getOrDefault(registerToModify, 0);
		currentValue += modificationValue;
		registers.put(registerToModify, currentValue);
	}

}
