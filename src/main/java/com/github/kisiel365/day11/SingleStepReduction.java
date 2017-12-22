package com.github.kisiel365.day11;

import java.util.HashMap;
import java.util.Map;

public class SingleStepReduction implements Reduction {
	private String baseDirection1;
	private String baseDirection2;
	private String resultDirection;

	public SingleStepReduction(String baseDirection1, String baseDirection2, String resultDirection) {
		this.baseDirection1 = baseDirection1;
		this.baseDirection2 = baseDirection2;
		this.resultDirection = resultDirection;
	}

	public Map<String, Long> getModification(Map<String, Long> steps) {
		Long base1Value = steps.getOrDefault(baseDirection1, 0L);
		Long base2Value = steps.getOrDefault(baseDirection2, 0L);
		long min = Math.min(base1Value, base2Value);
		if (min > 0) {
			Map<String, Long> modMap = new HashMap<>();
			modMap.put(baseDirection1, min);
			modMap.put(baseDirection2, min);
			modMap.put(resultDirection, -min);
			return modMap;
		}
		return null;
	}
}
