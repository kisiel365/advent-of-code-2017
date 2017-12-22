package com.github.kisiel365.day11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Day11 {

	private static final List<Reduction> REDUCTIONS = Arrays.asList(new SingleStepReduction("s", "ne", "se"),
			new SingleStepReduction("s", "nw", "sw"), new SingleStepReduction("n", "se", "ne"),
			new SingleStepReduction("n", "sw", "nw"), new SingleStepReduction("se", "sw", "s"),
			new SingleStepReduction("nw", "ne", "n"), new OpositeDirectionsReduction("n", "s"),
			new OpositeDirectionsReduction("nw", "se"), new OpositeDirectionsReduction("ne", "sw"));

	private Day11() {
	}

	public static int stepsAwayAtTheEnd(String input) {
		Map<String, Long> stepsCount = Arrays.stream(input.split(","))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<String, Long> reducedStepsCount = reduce(stepsCount);
		return countSteps(reducedStepsCount);
	}

	public static int stepsAwayEverReached(String input) {
		List<String> steps = Arrays.asList(input.split(","));
		int maxStepsAwayFromCenter = 0;
		Map<String, Long> stepsTaken = new HashMap<>();
		for (String step : steps) {
			stepsTaken.put(step, stepsTaken.getOrDefault(step, 0L) + 1);
			Map<String, Long> reducedStepsCountAfterNextStepTaken = reduce(stepsTaken);
			int stepsAwayFromCenter = countSteps(reducedStepsCountAfterNextStepTaken);
			if (stepsAwayFromCenter > maxStepsAwayFromCenter)
				maxStepsAwayFromCenter = stepsAwayFromCenter;
		}
		return maxStepsAwayFromCenter;
	}

	private static int countSteps(Map<String, Long> stepsCount) {
		int steps = 0;
		for (Entry<String, Long> stepCount : stepsCount.entrySet())
			steps += stepCount.getValue();
		return steps;
	}

	private static Map<String, Long> reduce(Map<String, Long> collect) {
		for (Reduction reduction : REDUCTIONS) {
			applyModification(collect, reduction.getModification(collect));
		}
		return collect;
	}

	private static void applyModification(Map<String, Long> collect, Map<String, Long> modMap) {
		if (modMap != null)
			for (Entry<String, Long> singleModification : modMap.entrySet()) {
				long previousValue = collect.getOrDefault(singleModification.getKey(), 0L);
				long newValue = previousValue - singleModification.getValue();
				if (newValue > 0)
					collect.put(singleModification.getKey(), newValue);
				else
					collect.remove(singleModification.getKey());
			}
	}

}
