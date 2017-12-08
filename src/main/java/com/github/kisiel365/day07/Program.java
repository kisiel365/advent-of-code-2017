package com.github.kisiel365.day07;

import java.util.HashSet;
import java.util.Set;

public class Program {

	private String name;
	private int weight;
	private Integer weightWithChildren;
	private Set<String> childrenProgramNames;
	private Set<Program> childrenPrograms;

	public Program(String name, int weight, Set<String> childrenProgramNames) {
		this.name = name;
		this.weight = weight;
		this.childrenProgramNames = childrenProgramNames;
		this.childrenPrograms = new HashSet<>();
	}

	public Integer getWeightWithChildren() {
		return weightWithChildren;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public Set<String> getChildrenProgramNames() {
		return childrenProgramNames;
	}

	public Set<Program> getChildrenPrograms() {
		return childrenPrograms;
	}

	Program getChildProgramOfWeight(int weight) {
		return getChildrenPrograms().stream()
				.filter(childProgram -> childProgram.getWeightWithChildren().equals(weight)).findAny().orElse(null);
	}

	int calculateWeightWithChildren() {
		if (weightWithChildren == null) {
			if (childrenPrograms.isEmpty()) { // leaf
				weightWithChildren = weight;
			} else {
				int weightOfChildren = 0;
				for (Program childProgram : childrenPrograms)
					weightOfChildren += childProgram.calculateWeightWithChildren();
				weightWithChildren = weight + weightOfChildren;
			}
		}
		return weightWithChildren;
	}

	Program findDeepestUnbalanced() {
		for (Program childProgram : childrenPrograms) {
			Program unbalancedProgram = childProgram.findDeepestUnbalanced();
			if (unbalancedProgram != null)
				return unbalancedProgram;
		}
		if (weightWithChildren == null) {
			calculateWeightWithChildren();
		}
		Integer childProgramWeight = null;
		for (Program childProgram : childrenPrograms) {
			if (childProgramWeight == null) {
				childProgramWeight = childProgram.calculateWeightWithChildren();
			} else {
				if (childProgramWeight != childProgram.calculateWeightWithChildren()) {
					return this;
				}
			}
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((childrenProgramNames == null) ? 0 : childrenProgramNames.hashCode());
		result = prime * result + ((childrenPrograms == null) ? 0 : childrenPrograms.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		result = prime * result + ((weightWithChildren == null) ? 0 : weightWithChildren.hashCode());
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
		Program other = (Program) obj;
		if (childrenProgramNames == null) {
			if (other.childrenProgramNames != null)
				return false;
		} else if (!childrenProgramNames.equals(other.childrenProgramNames))
			return false;
		if (childrenPrograms == null) {
			if (other.childrenPrograms != null)
				return false;
		} else if (!childrenPrograms.equals(other.childrenPrograms))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		if (weightWithChildren == null) {
			if (other.weightWithChildren != null)
				return false;
		} else if (!weightWithChildren.equals(other.weightWithChildren))
			return false;
		return true;
	}
}
