package com.leetcode.random;

public class ConsecutiveNumSum {

	public static void main(String[] args) {
		ConsecutiveNumSum obj = new ConsecutiveNumSum();
		System.out.println(obj.consecutiveNumbersSum(15));
		System.out.println(obj.consecutiveNumbersSum1(15));

	}

	public int consecutiveNumbersSum(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		int noOfWays = 0;
		for (int i = 1; i <= (n / 2); i++) {
			int sum = 0;
			for (int j = i; j <= (n / 2) + 1; j++) {
				sum = sum + j;
				if (sum == n) {
					noOfWays++;
				} else if (sum > n) {
					break;
				}
			}
		}
		return noOfWays + 1;
	}

	public int consecutiveNumbersSum1(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		int noOfWays = 0;
		int pointer = 1;
		int currNum = 1;
		int sum = 0;
		while (pointer <= n / 2) {
			if (sum == n) {
				noOfWays++;
				sum = 0;
				pointer++;
				currNum = pointer;
			} else if (sum < n) {
				sum = sum + currNum;
				currNum++;
			} else {
				sum = 0;
				pointer++;
				currNum = pointer;
			}

		}
		return noOfWays + 1;
	}

}
