package com.github.kisiel365.day11;

import java.util.HashMap;
import java.util.Map;

public class OpositeDirectionsReduction implements Reduction {
	private String baseDirection1;
	private String baseDirection2;

	public OpositeDirectionsReduction(String baseDirection1, String baseDirection2) {
		this.baseDirection1 = baseDirection1;
		this.baseDirection2 = baseDirection2;
	}

	public Map<String, Long> getModification(Map<String, Long> stepsCount) {
		Long base1Value = stepsCount.getOrDefault(baseDirection1, 0L);
		Long base2Value = stepsCount.getOrDefault(baseDirection2, 0L);
		long min = Math.min(base1Value, base2Value);
		if (min > 0) {
			Map<String, Long> modMap = new HashMap<>();
			modMap.put(baseDirection1, min);
			modMap.put(baseDirection2, min);
			return modMap;
		}
		return null;
	}
}
