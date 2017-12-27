package com.github.kisiel365.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Day21 {

	private static final Pattern PATTERN = Pattern.compile("([#./]+) => ([#./]+)");

	// TODO improve performance, e.g. use boolean instead of char
	private Day21() {
	}

	public static long enchanceImageNTimes(String input, int iterations) {
		Map<Integer, List<Rule>> rules = parseRules(input);
		char[][] image = getStartingImage();
		for (int iteration = 0; iteration < iterations; iteration++) {
			int imagePatternSize = image.length % 2 == 0 ? 2 : 3;
			List<Rule> ruleSet = rules.get(imagePatternSize);
			int numberOfSplitedImages = (image.length / imagePatternSize) * (image.length / imagePatternSize);
			char[][] newImage = createBiggerImage(image, imagePatternSize);
			for (int imageNumber = 0; imageNumber < numberOfSplitedImages; imageNumber++) {
				char[][] splitedImage = obtainSplitedImage(image, imagePatternSize, imageNumber);
				Rule matchingRule = findMatchingRule(splitedImage, ruleSet);
				applyEnchancedImage(newImage, matchingRule, imageNumber, imagePatternSize + 1);
			}
			image = newImage;
		}
		return countHashes(image);
	}

	private static char[][] createBiggerImage(char[][] image, int imagePatternSize) {
		int imagesPerRow = image.length / imagePatternSize;
		int biggerSize = image.length + imagesPerRow;
		return new char[biggerSize][biggerSize];
	}

	private static char[][] obtainSplitedImage(char[][] image, int imagePatternSize, int imageNumber) {
		int imagesInRow = image.length / imagePatternSize;
		int startingX = (imageNumber % imagesInRow) * imagePatternSize;
		int startingY = (imageNumber / imagesInRow) * imagePatternSize;
		char[][] splitImage = new char[imagePatternSize][imagePatternSize];
		for (int i = 0; i < imagePatternSize; i++)
			for (int j = 0; j < imagePatternSize; j++)
				splitImage[i][j] = image[startingX + i][startingY + j];
		return splitImage;
	}

	private static void applyEnchancedImage(char[][] newImage, Rule matchingRule, int imageNumber,
			int imagePatternSize) {
		int imagesInRow = newImage.length / imagePatternSize;
		int startingX = imagePatternSize * (imageNumber % imagesInRow);
		int startingY = imagePatternSize * (imageNumber / imagesInRow);
		char[][] outputImage = matchingRule.getOutputImage();
		for (int i = 0; i < imagePatternSize; i++)
			for (int j = 0; j < imagePatternSize; j++)
				newImage[startingX + i][startingY + j] = outputImage[i][j];
	}

	private static Rule findMatchingRule(char[][] splitedImage, List<Rule> ruleSet) {
		for (Rule rule : ruleSet)
			if (rule.matches(splitedImage))
				return rule;
		throw new IllegalStateException("No matching rule found for: " + Arrays.deepToString(splitedImage));
	}

	private static char[][] getStartingImage() {
		return new char[][] { new char[] { '.', '#', '.' }, new char[] { '.', '.', '#' },
				new char[] { '#', '#', '#' } };
	}

	private static long countHashes(char[][] image) {
		int count = 0;
		for (int i = 0; i < image.length; i++)
			for (int j = 0; j < image.length; j++)
				if (image[i][j] == 35)
					count++;
		return count;
	}

	private static Map<Integer, List<Rule>> parseRules(String input) {
		List<Rule> rules = new ArrayList<>();
		for (String line : input.split("\r\n")) {
			Matcher matcher = PATTERN.matcher(line);
			if (matcher.matches()) {
				rules.add(new Rule(matcher.group(1), matcher.group(2)));
			} else {
				throw new IllegalArgumentException("Unparsable line: " + line);
			}
		}
		return rules.stream().collect(Collectors.groupingBy(Rule::getSize));
	}

}
