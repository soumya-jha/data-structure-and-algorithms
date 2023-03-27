package com.test.interview;

public class SecondLargestNumber {
	
	public static void main(String[] args) {
		
		Integer[] arr = {20, 78, 64, 89, 92, 34};
		Integer largest = Integer.MIN_VALUE;
		Integer secondLargest = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>largest) {
				secondLargest = largest;
				largest = arr[i];
			}
			if(arr[i]>secondLargest && arr[i]<largest) {
				secondLargest = arr[i];
			}
			
		}
		System.out.println("The second largest number in the array is : " + secondLargest);
	}
	
}
