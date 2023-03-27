package com.test.interview;

public class EvenNumber {

	public static void main(String[] args) {
		if(EvenNumber.isEven(11)==0){
			System.out.println("Even Number");
		}else {
			System.out.println("Odd Number");
		}
	}
	
	private static int isEven(int n){
		System.out.println(n & 1);
		return (n & 1);
	}

}
