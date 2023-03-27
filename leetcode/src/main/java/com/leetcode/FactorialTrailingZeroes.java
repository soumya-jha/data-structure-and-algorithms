package com.leetcode;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		FactorialTrailingZeroes obj = new FactorialTrailingZeroes();
		System.out.println(obj.trailingZeroes(6040));

	}

	public int trailingZeroes(int n) {
		int count = 0;
		while (n / 5 >= 1) {
			count += n / 5;
			n /= 5;
		}
		return count;

	}

}
