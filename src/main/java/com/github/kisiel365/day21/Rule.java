package com.github.kisiel365.day21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Rule {

	private final char[][] outputImage;
	private final char[][] inputImage;
	private final Set<char[][]> inputImageVariants;

	public Rule(String input, String output) {
		outputImage = parseToImage(output);
		inputImage = parseToImage(input);
		inputImageVariants = getVariants(inputImage);
	}

	public int getSize() {
		return inputImage.length;
	}

	public boolean matches(char[][] splitedImage) {
		for (char[][] variant : inputImageVariants)
			if (Arrays.deepEquals(splitedImage, variant))
				return true;
		return false;
	}

	public char[][] getOutputImage() {
		return outputImage;
	}

	private char[][] rotate(char[][] image) {
		final int size = image.length;
		char[][] rotated = new char[size][size];
		for (int rotation = 0; rotation < size; rotation++)
			for (int shift = 0; shift < size; shift++)
				rotated[shift][size - 1 - rotation] = image[rotation][shift];
		return rotated;
	}

	private char[][] flipVertically(char[][] image) {
		final int size = image.length;
		char[][] flipped = new char[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				flipped[j][size - i - 1] = image[j][i];
		return flipped;
	}

	private char[][] flipHorizontally(char[][] image) {
		final int size = image.length;
		char[][] flipped = new char[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				flipped[i][size - j - 1] = image[i][j];
		return flipped;
	}

	private Set<char[][]> getRotatedVariants(char[][] image) {
		Set<char[][]> variants = new HashSet<>();
		variants.add(image);
		char[][] imageRotated = rotate(image);
		variants.add(imageRotated);
		imageRotated = rotate(imageRotated);
		variants.add(imageRotated);
		imageRotated = rotate(imageRotated);
		variants.add(imageRotated);
		return variants;
	}

	private Set<char[][]> getVariants(char[][] image) {
		Set<char[][]> variants = new HashSet<>();
		variants.addAll(getRotatedVariants(image));
		variants.addAll(getRotatedVariants(flipVertically(image)));
		variants.addAll(getRotatedVariants(flipHorizontally(image)));
		return variants;
	}

	private char[][] parseToImage(String output) {
		String[] lines = output.split("/");
		char[][] image = new char[lines.length][];
		for (int i = 0; i < lines.length; i++)
			image[i] = lines[i].toCharArray();
		return image;
	}

}
