package com.github.kisiel365.day14;

import com.github.kisiel365.day10.Day10;

public final class Day14 {

	private Day14() {
	}

	public static int countPositiveBits(String input) {
		int positiveBits = 0;
		for (int i = 0; i < 128; i++) {
			String hash = Day10.produceHash(input + "-" + i);
			byte[] bytes = hashToByteArray(hash);
			positiveBits += countPositiveBitsInByteArray(bytes);
		}
		return positiveBits;
	}

	public static int countPositiveBitGroups(String input) {
		boolean[][] grid = new boolean[128][128];
		for (int i = 0; i < 128; i++) {
			String hash = Day10.produceHash(input + "-" + i);
			byte[] bytes = hashToByteArray(hash);
			grid[i] = byteArrayToBitArray(bytes);
		}
		return countGroups(grid);
	}

	private static int countGroups(boolean[][] grid) {
		int groups = 0;
		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 128; j++) {
				if (grid[i][j]) {
					cleanGrid(grid, i, j);
					groups++;
				}
			}
		}
		return groups;
	}

	private static void cleanGrid(boolean[][] grid, int i, int j) {
		if (isWithinGrid(i, j) && grid[i][j]) {
			grid[i][j] = false;
			cleanGrid(grid, i + 1, j);
			cleanGrid(grid, i, j + 1);
			cleanGrid(grid, i - 1, j);
			cleanGrid(grid, i, j - 1);
		}
	}

	private static boolean isWithinGrid(int i, int j) {
		return i > -1 && i < 128 && j > -1 && j < 128;
	}

	private static boolean[] byteArrayToBitArray(byte[] bytes) {
		boolean[] bits = new boolean[bytes.length * 4];
		for (int i = 0; i < bytes.length; i++) {
			byte oneByte = bytes[i];
			int div = 8;
			for (int j = 0; j < 4; j++) {
				if (oneByte >= div) {
					bits[(4 * i) + j] = true;
					oneByte -= div;
				}
				div /= 2;
			}
		}
		return bits;
	}

	private static byte[] hashToByteArray(String hash) {
		byte[] data = new byte[hash.length()];
		for (int i = 0; i < hash.length(); i++)
			data[i] = (byte) (Character.digit(hash.charAt(i), 16));
		return data;
	}

	private static int countPositiveBitsInByteArray(byte[] bytes) {
		int positiveBits = 0;
		for (byte oneByte : bytes)
			while (oneByte != 0) {
				oneByte &= (oneByte - 1);
				positiveBits++;
			}
		return positiveBits;
	}

}
