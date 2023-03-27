package org.geeksforgeeks;

import java.util.HashMap;

/*
Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 

Example 1:

Input:
S = "aba", K = 2
Output:
3
Explanation:
The substrings are:
"ab", "ba" and "aba".*/

public class SubStrWithKDistinctChar {

	public static void main(String args[]) {
		System.out.println(substrCount("abaaca", 1));

		System.out.println(substrCount("aba", 2));

		System.out.println(substrCount("ircvsc", 4));

	}

	private static long substrCount(String s, int k) {
		long count = 0;
		for (int i = 0; i < s.length(); i++) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			int mapSize = 0;
			for (int j = i; j < s.length(); j++) {
				char ch = s.charAt(j);
				if (!map.containsKey(ch)) {
					if (mapSize == k) {
						break;
					}
					map.put(ch, 0);
					mapSize++;
					if (mapSize == k) {
						count++;
					}
				} else {
					map.put(ch, map.get(ch) + 1);
					if (mapSize == k) {
						count++;
					}
				}
			}
		}
		return count;
	}

}
