package com.test.interview;

public class ReverseWithSpace {
	public static void main(String[] args) {
		/*
		 * Write a java program to reverse a string with preserving the position of
		 * spaces. For example, if �I Am Not String� is the given string then the
		 * reverse of this string with preserving the position of spaces is �g ni rtS
		 * toNmAI�.
		 */
		String str = "I Am Not String";
		char[] arr = str.toCharArray();
		str = str.replace(" ", "");
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		for (int i = 0, idx = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				continue;
			} else {
				arr[i] = sb.charAt(idx);
				idx++;
			}
		}
		System.out.println("Output : " + String.valueOf(arr));
	}
}
