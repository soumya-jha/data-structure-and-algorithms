package com.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {

	public static void main(String[] args) {
		// List<Integer> a = Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5);
		// List<Integer> a = Arrays.asList(4, 6, 5, 3, 3, 1);
		List<Integer> a = Arrays.asList(1, 2, 2, 3, 1, 2);
		int result = PickingNumbers.pickingNumbers(a);
		System.out.println(result);
	}

	public static int pickingNumbers(List<Integer> a) {
		Collections.sort(a);
		int windowStart = 0;
		int windowEnd = 1;
		int maxSize = 0;
		while (windowEnd <= a.size() - 1 && a.size() - windowStart > maxSize) {
			if (Math.abs(a.get(windowEnd) - a.get(windowStart)) > 1) {
				windowStart++;
				windowEnd = windowStart + 1;
				continue;
			}
			int windowSize = windowEnd - windowStart + 1;
			maxSize = Math.max(maxSize, windowSize);
			windowEnd++;
		}
		return maxSize;
	}
}
