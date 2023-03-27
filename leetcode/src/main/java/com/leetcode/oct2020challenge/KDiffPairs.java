/**
 Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
a <= b
b - a == k

Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:

Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:

Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Example 4:

Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
Output: 2
Example 5:

Input: nums = [-1,-2,-3], k = 1
Output: 2
 

Constraints:

1 <= nums.length <= 104
-107 <= nums[i] <= 107
0 <= k <= 107

*/

package com.leetcode.oct2020challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairs {

	public static void main(String[] args) {
		KDiffPairs obj = new KDiffPairs();
		int[] nums = { 3, 1, 4, 1, 5 };
		int noOfPairs = obj.findPairs(nums, 2);
		System.out.println("No of pairs : " + noOfPairs);

	}

	public int findPairs(int[] nums, int k) {
		int noOfPairs = 0;
		if (k > 0) {
			ArrayList<Integer> diffList = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				if (!diffList.contains(nums[i])) {
					diffList.add(nums[i]);
				}
			}
			Collections.sort(diffList);
			for (int i = 0; i < diffList.size() - 1; i++) {
				for (int j = i + 1; j < diffList.size(); j++) {
					if (diffList.get(j) - diffList.get(i) == k) {
						noOfPairs++;
						break;
					}
				}
			}
		} else if (k == 0) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(nums[i])) {
					map.put(nums[i], map.get(nums[i]) + 1);
				} else {
					map.put(nums[i], 1);
				}
			}
			for (Map.Entry<Integer, Integer> entryMap : map.entrySet()) {
				if (entryMap.getValue() > 1) {
					noOfPairs++;
				}
			}
		}

		return noOfPairs;
	}
}
