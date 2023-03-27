/**
Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.

The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.

For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.

Example 1:

Input: 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
Example 2:

Input: 7
Output: 0
Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
Example 3:

Input: 10
Output: 5
Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.

*/
package com.leetcode.oct2020challenge;

public class ComplementofBase10 {

	public static void main(String[] args) {
		ComplementofBase10 obj = new ComplementofBase10();
		int base10 = obj.bitwiseComplement(0);
		System.out.println("Base10 :" + base10);

	}

	public int bitwiseComplement(int N) {
		int base10 = 0;
		String binaryValue = "";
		while (N > 1) {
			binaryValue = String.valueOf(N % 2) + binaryValue;
			N = N / 2;
		}
		if (N == 0) {
			binaryValue = "0";
		} else {
			binaryValue = "1" + binaryValue;
		}
		char[] binArray = binaryValue.toCharArray();
		for (int i = 0; i < binArray.length; i++) {
			if (binArray[i] == '0') {
				binArray[i] = '1';
			} else {
				binArray[i] = '0';
			}
		}
		for (int i = 0; i < binArray.length; i++) {
			base10 = base10 * 2 + Character.getNumericValue(binArray[i]);
		}
		return base10;
	}
}
