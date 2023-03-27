package com.hackerrank;

public class ApproximateMatching {

	public static void main(String[] args) {
		String result = calculateScore("nothing", "bruno", "ingenious");
		System.out.println(result);
	}
	
	 static String calculateScore(String text, String prefix, String suffix) {
		 int max = 0;
		 String maxStr = null;
		 int windowEnd=prefix.length()-1;
		 String preMax = "";
		 //loop for prefix
		 for(int windowStart = windowEnd; windowEnd>=0 ;windowEnd--) {
			 if((prefix.charAt(windowStart)+preMax).equals(text.substring(0, windowStart-windowEnd+1)))
			 preMax = prefix.charAt(windowStart)+preMax;
		 }
		 return maxStr;
	 }
}
