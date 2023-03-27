package com.leetcode;

import java.util.Arrays;

public class NonDecreasingArray {
	public static void main(String[] args) {

		NonDecreasingArray array = new NonDecreasingArray();
		boolean result = array.checkPossibility(new int[] { 2, 3, 3, 2, 4 });
		System.out.println(result);

	}

	public boolean checkPossibility(int[] nums) {
		boolean result = false;
		int j = 0;
		int[] numsOriginal = nums.clone();
		while (j < nums.length) {
			for (int i = j; i < nums.length-1; i++) {
				j = i+1;
				System.out.println("j : " + j);
				if (nums[i] > nums[i + 1]) {
					nums[i] = nums[i + 1];
					break;
				}
			}
			int[] numsCopy = nums.clone();
			Arrays.sort(numsCopy);

			System.out.println("New num : "+Arrays.toString(nums));
			System.out.println("Sorted num : " + Arrays.toString(numsCopy));

			if (Arrays.toString(numsCopy).equals(Arrays.toString(nums))) {
				return true;
			} else {
				nums=numsOriginal.clone();
			}
		}

		return result;
	}
}