package com.github.kisiel365.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Day12 {

	private static final Pattern PATTERN1 = Pattern.compile("([0-9]+) <-> ([0-9, ]+)");
	private static final Pattern PATTERN2 = Pattern.compile("([0-9]+)");

	private Day12() {
	}

	public static int sizeOfGroupContainingNodeZero(String input) {
		Map<Integer, List<Integer>> graph = parseInput(input);
		Set<Integer> primarySubgraph = getGroupContainingNode(graph, 0);
		return primarySubgraph.size();
	}

	public static int numberOfDisjunktiveGruops(String input) {
		Map<Integer, List<Integer>> graph = parseInput(input);
		Set<Integer> allNodes = graph.keySet();
		Integer currentPrimaryNode = 0;
		int groups = 0;
		while (currentPrimaryNode != null) {
			allNodes.removeAll(getGroupContainingNode(graph, currentPrimaryNode));
			currentPrimaryNode = allNodes.stream().findAny().orElse(null);
			groups++;
		}
		return groups;
	}

	private static Set<Integer> getGroupContainingNode(Map<Integer, List<Integer>> graph, int primaryNode) {
		Set<Integer> primarySubgraph = new HashSet<>();
		primarySubgraph.add(primaryNode);
		boolean addedNew = true;
		while (addedNew) {
			Set<Integer> newNodes = new HashSet<>();
			for (Integer node : primarySubgraph)
				newNodes.addAll(graph.get(node));
			boolean added = primarySubgraph.addAll(newNodes);
			addedNew &= added;
		}
		return primarySubgraph;
	}

	private static Map<Integer, List<Integer>> parseInput(String input) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (String line : input.split("\r\n")) {
			Matcher matcher = PATTERN1.matcher(line);
			matcher.find();
			int node = Integer.parseInt(matcher.group(1));
			List<Integer> nodes = parseNodes(matcher.group(2));
			graph.put(node, nodes);
		}
		return graph;
	}

	private static List<Integer> parseNodes(String group) {
		List<Integer> nodes = new ArrayList<>();
		Matcher matcher = PATTERN2.matcher(group);
		while (matcher.find())
			nodes.add(Integer.parseInt(matcher.group()));
		return nodes;
	}

}
