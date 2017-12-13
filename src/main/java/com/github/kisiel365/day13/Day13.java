package com.github.kisiel365.day13;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Day13 {

	private static final Pattern PATTERN = Pattern.compile("([0-9]+): ([0-9]+)");

	private Day13() {
	}

	public static int calculateSeverityOfImmediateRun(String input) {
		Map<Integer, Integer> scanners = parseInput(input);
		Integer maxLayer = scanners.keySet().stream().max(Comparator.naturalOrder()).orElse(null);
		int severity = 0;
		for (int currentLayer = 0; currentLayer <= maxLayer; currentLayer++) {
			Integer scannerPosition = getScannerPositionInTick(scanners, currentLayer, currentLayer);
			if (scannerPosition != null && scannerPosition == 0) {
				Integer range = scanners.get(currentLayer);
				severity += range * currentLayer;
			}
		}
		return severity;
	}

	public static int delayNecessaryToOmitFirewall(String input) {
		Map<Integer, Integer> scanners = parseInput(input);
		Integer maxLayer = scanners.keySet().stream().max(Comparator.naturalOrder()).orElse(null);
		int delay = -1;
		boolean isCaught = true;
		while (isCaught)
			isCaught = isCaught(scanners, maxLayer, ++delay);
		return delay;
	}

	private static boolean isCaught(Map<Integer, Integer> scanners, Integer maxLayer, int delay) {
		for (int currentLayer = 0; currentLayer <= maxLayer; currentLayer++) {
			Integer scannerPosition = getScannerPositionInTick(scanners, currentLayer, currentLayer + delay);
			if (scannerPosition != null && scannerPosition == 0) {
				return true;
			}
		}
		return false;
	}

	private static Integer getScannerPositionInTick(Map<Integer, Integer> scanners, int layer, int tick) {
		Integer range = scanners.get(layer);
		if (range == null)
			return null;
		int cycleLength = range * 2 - 2;
		int rest = tick % cycleLength;
		return rest >= range ? cycleLength - rest : rest;
	}

	private static Map<Integer, Integer> parseInput(String input) {
		Map<Integer, Integer> scanners = new HashMap<>();
		for (String line : input.split(System.lineSeparator())) {
			Matcher matcher = PATTERN.matcher(line);
			matcher.find();
			scanners.put(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
		}
		return scanners;
	}

}
