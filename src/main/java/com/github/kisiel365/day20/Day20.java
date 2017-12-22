package com.github.kisiel365.day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Day20 {

	private static final Pattern PATTERN = Pattern.compile(
			"p=<([0-9-]+),([0-9-]+),([0-9-]+)>, v=<([0-9-]+),([0-9-]+),([0-9-]+)>, a=<([0-9-]+),([0-9-]+),([0-9-]+)>");

	private Day20() {
	}

	public static int idOfParticleClosestToCenterInInfinity(String input) {
		// lowest value of highest level of derivative
		List<Particle> particles = parseInput(input);
		return particles.stream().sorted((a, b) -> (int) (a.getAcceleration().getAbsoluteManhattanDistance()
				- b.getAcceleration().getAbsoluteManhattanDistance())).findFirst().orElse(null).getId();
	}

	public static int countUncolidedParticles(String input) {
		List<Particle> particles = parseInput(input);
		for (int i = 0; i < 50; i++) {
			particles = eliminateColided(particles);
			particles.forEach(Particle::tick);
		}
		return particles.size();
	}

	private static List<Particle> eliminateColided(List<Particle> particles) {
		Map<Vector, List<Particle>> collect = particles.stream().collect(Collectors.groupingBy(Particle::getPosition));
		List<Particle> uncolidedParticles = new ArrayList<>();
		for (List<Particle> particlesInOnePlace : collect.values())
			if (particlesInOnePlace.size() == 1)
				uncolidedParticles.addAll(particlesInOnePlace);
		return uncolidedParticles;
	}

	private static List<Particle> parseInput(String input) {
		List<Particle> particles = new ArrayList<>();
		int particleCount = 0;
		for (String line : input.split("\r\n")) {
			Matcher matcher = PATTERN.matcher(line);
			if (matcher.matches()) {
				Vector position = new Vector(Long.parseLong(matcher.group(1)), Long.parseLong(matcher.group(2)),
						Long.parseLong(matcher.group(3)));
				Vector velocity = new Vector(Long.parseLong(matcher.group(4)), Long.parseLong(matcher.group(5)),
						Long.parseLong(matcher.group(6)));
				Vector acceleration = new Vector(Long.parseLong(matcher.group(7)), Long.parseLong(matcher.group(8)),
						Long.parseLong(matcher.group(9)));
				particles.add(new Particle(particleCount++, position, velocity, acceleration));
			} else
				throw new IllegalArgumentException("Unparsable line: " + line);
		}
		return particles;
	}

}
