package com.github.kisiel365.day08;

import java.util.Map;
import java.util.regex.Matcher;

public class Command {
	String registerToModify;
	String modification;
	int modificationValue;
	String registerForCondition;
	String operator;
	int valueToCompare;

	Command(Matcher matcher) {
		registerToModify = matcher.group(1);
		modification = matcher.group(2);
		modificationValue = Integer.parseInt(matcher.group(3));
		registerForCondition = matcher.group(4);
		operator = matcher.group(5);
		valueToCompare = Integer.parseInt(matcher.group(6));
	}

	@Override
	public String toString() {
		return "Command [registerToModify=" + registerToModify + ", modification=" + modification
				+ ", modificationValue=" + modificationValue + ", registerForCondition=" + registerForCondition
				+ ", operator=" + operator + ", valueToCompare=" + valueToCompare + "]";
	}

	public boolean fulfillsCondition(Map<String, Integer> registers) {
		// too lazy for strategy / command pattern
		Integer registerForConditionValue = registers.getOrDefault(registerForCondition, 0);
		if (">".equals(operator)) {
			return registerForConditionValue > valueToCompare ? true : false;
		} else if ("<".equals(operator)) {
			return registerForConditionValue < valueToCompare ? true : false;
		} else if (">=".equals(operator)) {
			return registerForConditionValue >= valueToCompare ? true : false;
		} else if ("<=".equals(operator)) {
			return registerForConditionValue <= valueToCompare ? true : false;
		} else if ("==".equals(operator)) {
			return registerForConditionValue == valueToCompare ? true : false;
		} else if ("!=".equals(operator)) {
			return registerForConditionValue != valueToCompare ? true : false;
		}
		throw new RuntimeException("Unknown operator: " + operator);
	}

	public void execute(Map<String, Integer> registers) {
		Integer currentValue = registers.getOrDefault(registerToModify, 0);
		if ("dec".equals(modification)) {
			currentValue -= modificationValue;
		} else if ("inc".equals(modification)) {
			currentValue += modificationValue;
		} else
			throw new RuntimeException("Unknown modification: " + modification);
		registers.put(registerToModify, currentValue);
	}

}
