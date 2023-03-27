package com.test.interview;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sum = " + SumOfDigits.calculateSum(12345));

	}
	
	private static Integer calculateSum(Integer number) {
		Integer sum = 0;
		while(number > 0) {
			sum += number%10;
			return calculateSum(number/10) + sum;
		}
		return sum;
	}

}
