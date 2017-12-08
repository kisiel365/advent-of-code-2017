package com.github.kisiel365.day07;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class Day07 {

	private Day07() {
	}

	public static String nameOfRoot(String input) {
		Map<String, Program> programs = Parser.parseInput(input);
		Program root = findRootProgram(programs.values());
		return root.getName();
	}

	public static int weightDifferenceToProgramSibblings(String input) {
		Map<String, Program> nodes = Parser.parseInput(input);
		buildTree(nodes);
		Program root = findRootProgram(nodes.values());
		Program unbalancedProgram = root.findDeepestUnbalanced();
		return calculateWeightDifferenceToSibblings(unbalancedProgram);
	}

	private static void buildTree(Map<String, Program> nodes) {
		for (Program program : nodes.values()) {
			for (String aboveNodeName : program.getChildrenProgramNames())
				program.getChildrenPrograms().add(nodes.get(aboveNodeName));
		}
	}

	private static Program findRootProgram(Collection<Program> programs) {
		Set<String> childrenProgramNames = programs.stream().map(Program::getChildrenProgramNames).flatMap(Set::stream)
				.collect(Collectors.toSet());
		return programs.stream().filter(isNotChildrenProgram(childrenProgramNames)).findFirst().orElse(null);
	}

	private static Predicate<? super Program> isNotChildrenProgram(Set<String> childrenProgramNames) {
		return program -> !childrenProgramNames.contains(program.getName());
	}

	private static int calculateWeightDifferenceToSibblings(Program unbalanced) {
		Map<Integer, Long> weightsCount = unbalanced.getChildrenPrograms().stream()
				.collect(Collectors.groupingBy(Program::getWeightWithChildren, Collectors.counting()));
		int oddWeight = weightsCount.entrySet().stream().filter(occursOnce()).map(Entry::getKey).findAny().orElse(null);
		Program bastardProgram = unbalanced.getChildProgramOfWeight(oddWeight);
		int normalWeight = weightsCount.entrySet().stream().filter(occursManyTimes()).map(Entry::getKey).findAny()
				.orElse(null);
		int havierThanSibblings = bastardProgram.getWeightWithChildren() - normalWeight;
		return bastardProgram.getWeight() - havierThanSibblings;
	}

	private static Predicate<? super Entry<Integer, Long>> occursManyTimes() {
		return entry -> entry.getValue() != 1;
	}

	private static Predicate<? super Entry<Integer, Long>> occursOnce() {
		return entry -> entry.getValue() == 1;
	}
}
