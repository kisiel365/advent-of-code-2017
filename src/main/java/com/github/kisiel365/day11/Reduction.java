package com.github.kisiel365.day11;

import java.util.Map;

@FunctionalInterface
public interface Reduction {
	Map<String, Long> getModification(Map<String, Long> stepsCount);
}
