package com.test.interview;

public class SwapWordsInAString {

	//This is what I implemented in JPMC interview
	//better solution is to use the same approach with substring instead of replace
	public static void main(String[] args) {
		String s1="Soumya";
		String s2 = "Jha";
		System.out.println("Before Swap : " + s1+s2);
		
		s1=s1+s2;
		s2=s1.replace(s2,"");
		s1=s1.replace(s2,"");
		
		System.out.println("After Swap : " + s1+s2);

	}

}
