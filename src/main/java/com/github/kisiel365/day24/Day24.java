package com.github.kisiel365.day24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Day24 {

	private final static Pattern PATTERN = Pattern.compile("([0-9]+)/([0-9]+)");

	private Day24() {
	}

	private static final class Port {
		int portOne;
		int portTwo;

		public Port(int portOne, int portTwo) {
			this.portOne = portOne;
			this.portTwo = portTwo;
		}

		@Override
		public String toString() {
			return "Port [" + portOne + ", " + portTwo + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + portOne;
			result = prime * result + portTwo;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Port other = (Port) obj;
			if (portOne != other.portOne)
				return false;
			if (portTwo != other.portTwo)
				return false;
			return true;
		}

	}

	private enum Side {
		FRONT, REAR;
	}

	private static class Node {
		static int maxStrength = 0;
		static int maxLength = 0;
		static int maxStrengthWithinMaxLength = 0;

		Set<Port> remainingPorts;
		List<Port> choosenPorts;
		int strength;
		int currentEnding;
		int length;
		Set<Node> children = new HashSet<>();

		public Node(Set<Port> ports) {
			this.remainingPorts = new HashSet<>(ports);
			this.strength = 0;
			this.choosenPorts = new ArrayList<>();
			this.length = 0;
			this.currentEnding = 0;
			maxStrength = 0;
			maxLength = 0;
			maxStrengthWithinMaxLength = 0;
		}

		public Node(Node parentNode, Port nextPort, Side side) {
			this.strength = parentNode.strength;
			this.remainingPorts = new HashSet<>(parentNode.remainingPorts);
			this.choosenPorts = new ArrayList<>(parentNode.choosenPorts);
			this.length = parentNode.length;
			if (this.remainingPorts.remove(nextPort)) {
				this.choosenPorts.add(nextPort);
				switch (side) {
				case FRONT:
					currentEnding = nextPort.portTwo;
					break;
				case REAR:
					currentEnding = nextPort.portOne;
					break;
				}
				this.length++;
				this.strength += nextPort.portOne + nextPort.portTwo;
			} else
				throw new IllegalStateException();
		}

		Map<Side, List<Port>> getMatchingPorts() {
			Map<Side, List<Port>> matching = new HashMap<>();
			List<Port> frontMatching = remainingPorts.stream().filter(x -> currentEnding == x.portOne)
					.collect(Collectors.toList());
			List<Port> rearMatching = remainingPorts.stream().filter(x -> currentEnding == x.portTwo)
					.collect(Collectors.toList());
			matching.put(Side.FRONT, frontMatching);
			matching.put(Side.REAR, rearMatching);
			return matching;
		}

		boolean createChildren(Map<Side, List<Port>> matchingPorts) {
			boolean createdAnyChildren = false;
			for (Port frontMatchingPort : matchingPorts.get(Side.FRONT)) {
				Node newFrontNode = new Node(this, frontMatchingPort, Side.FRONT);
				children.add(newFrontNode);
				createdAnyChildren = true;
			}
			for (Port rearMatchingPort : matchingPorts.get(Side.REAR)) {
				Node newRearNode = new Node(this, rearMatchingPort, Side.REAR);
				children.add(newRearNode);
				createdAnyChildren = true;
			}
			return createdAnyChildren;
		}

		public void spawnChildren() {
			Map<Side, List<Port>> matchingPorts = getMatchingPorts();
			if (createChildren(matchingPorts)) {
				for (Node child : children) {
					child.spawnChildren();
				}
				children.clear(); // no need to store it after checking
			} else {
				if (maxStrength < strength)
					maxStrength = strength;
				if (length > maxLength) {
					maxLength = length;
					maxStrengthWithinMaxLength = 0;
				}
				if (length == maxLength && maxStrengthWithinMaxLength < strength) {
					maxStrengthWithinMaxLength = strength;
				}
			}
		}

		@Override
		public String toString() {
			return "Node [choosenPorts=" + choosenPorts + ", strength=" + strength + ", currentEnding=" + currentEnding
					+ "]";
		}

	}

	public static int strengthOfStrongestBridge(String input) {
		// TODO optimize execution time
		Set<Port> ports = parseInput(input);
		Node start = new Node(ports);
		start.spawnChildren();
		return Node.maxStrength;
	}

	private static Set<Port> parseInput(String input) {
		Set<Port> ports = new HashSet<>();
		for (String line : input.split("\n")) {
			Matcher matcher = PATTERN.matcher(line);
			if (matcher.matches()) {
				ports.add(new Port(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
			}
		}
		return ports;
	}

	public static int strengthOfLongestThenStrongestBridge(String input) {
		Set<Port> ports = parseInput(input);
		Node start = new Node(ports);
		start.spawnChildren();
		return Node.maxStrengthWithinMaxLength;
	}

}
