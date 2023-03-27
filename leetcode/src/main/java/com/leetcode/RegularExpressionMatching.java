package com.leetcode;

//incomplete
public class RegularExpressionMatching {

	public static void main(String args[]) {

		String s = "aab";
		String p = "c*a*b";
		boolean match = new RegularExpressionMatching().isMatch(s, p);
		System.out.println("Match :: " + match);
	}

	public boolean isMatch(String s, String p) {
		boolean match = false;
		boolean outBreak = false;
		char[] stringArray = s.toCharArray();
		char[] patternArray = p.toCharArray();
		for (int i = 0; i < stringArray.length; i++) {
			char tempChar;
			for (int j = 0; j < patternArray.length; j++) {
				if (stringArray[i] == patternArray[j]) {
					outBreak= true;
					break;
				}else if(j<patternArray.length-1 && patternArray[j+1]=='*') {
					tempChar = patternArray[j];
				}
			}
			if(outBreak) {
				outBreak=false;
				break;
			}
		}
		return match;
	}
}
