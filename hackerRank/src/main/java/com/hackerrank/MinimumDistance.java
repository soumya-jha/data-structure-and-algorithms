package com.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistance {

	public static void main(String[] args) {

		System.out.println(minimumDistances(Arrays.asList(3, 2, 1, 2, 3)));
		System.out.println(minimumDistances(Arrays.asList(7, 1, 3, 4, 1, 7)));
		System.out.println(minimumDistances(Arrays.asList(4, 7, 4, 7, 7)));
	}

	public static int minimumDistances(List<Integer> a) {
		int minDist = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.size(); i++) {
			if (map.containsKey(a.get(i))) {
				int diff = Math.abs(map.get(a.get(i)) - i);
				minDist = Math.min(minDist, diff);
				if (minDist == 1) {
					return minDist;
				}
			}
			map.put(a.get(i), i);
		}
		return (minDist == Integer.MAX_VALUE ? -1 : minDist);
	}

}
