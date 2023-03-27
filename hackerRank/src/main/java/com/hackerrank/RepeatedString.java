package com.hackerrank;

public class RepeatedString {

	public static void main(String args[]) {

		long noOfA = repeatedString("abcac", 12);
		System.out.println("No of A :: " + noOfA);

	}

	static long repeatedString(String s, long n) {
		if(null==s || "".equals(s) || !s.contains("a") || n==0)
			return 0;
		long noOfA = 0L;
		int stringLength = s.length();
		if(stringLength==1)
			return n;
		if (n > stringLength) {
			for (int i = 0; i < stringLength; i++) {
				if (String.valueOf(s.charAt(i)).equals("a")) {
					noOfA++;
				}
			}
			long concatCount = n / stringLength;
			noOfA = noOfA * concatCount;
			if (n % stringLength > 0) {
				long remainStringLength = n % stringLength;
				long extraCount = 0L;
				for (int i = 0; i < remainStringLength; i++) {
					if (String.valueOf(s.charAt(i)).equals("a")) {
						extraCount++;
					}
				}
				noOfA = noOfA + extraCount;
			}
		}else{
			for (int i = 0; i < n; i++) {
				if (String.valueOf(s.charAt(i)).equals("a")) {
					noOfA++;
				}
			}
		}
		return noOfA;
	}
}
