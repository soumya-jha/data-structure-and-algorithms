package com.test.interview;

public class ReverseAndAddTillPalindrome {

	public static void main(String[] args) {

		/*
		 * Write a java program to take input number from the user, reverse it and add
		 * it to itself. If the sum is not a palindrome then repeat the procedure until
		 * you get a palindrome For example, If 7325 is input number, then
		 * 
		 * 7325 (Input Number) + 5237 (Reverse Of Input Number) = 12562
		 * 
		 * 12562 + 26521 = 39083
		 * 
		 * 39083 + 38093 = 77176
		 * 
		 * 77176 + 67177 = 144353
		 * 
		 * 144353 + 353441 = 497794 (Palindrome)
		 */

		System.out.println("Palindrome number : " + ReverseAndAddTillPalindrome.getPalindrome(7325));
	}

	private static int getPalindrome(int number) {
		int reverse = 0;
		int copyOfNumber = number;
		String sum = "";
		while (copyOfNumber > 0) {
			sum += copyOfNumber % 10;
			copyOfNumber = copyOfNumber / 10;
		}
		reverse = Integer.parseInt(sum);
		if (number == reverse) {
			return reverse;
		} else {
			return getPalindrome(number + reverse);
		}
	}

}
