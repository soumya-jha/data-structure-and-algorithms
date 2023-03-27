package com.test.interview;

import java.util.LinkedList;

public class ArrayRotation {

	public static void main(String[] args) {
		
		//Rotation to left, anti clock wise
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7} ; //{4,5,6,7,1,2,3}
		int n = 3; //rotation number
		
		LinkedList<Integer> leftLinkList = new LinkedList<>();
		for(int i=n;i<arr.length;i++) {
			leftLinkList.offer(arr[i]);
		}
		for(int i=0;i<=n-1;i++) {
			leftLinkList.offer(arr[i]);
		}
		
		System.out.println(leftLinkList);
		
		LinkedList<Integer> rightLinkList = new LinkedList<>();
		for(int i=0;i<arr.length-n;i++) {
			rightLinkList.offer(arr[i]);
		}
		for(int i=arr.length-1; i>= arr.length-n ;i--) {
			rightLinkList.offerFirst(arr[i]);
		}
		
		System.out.println(rightLinkList);
		
		
		
		

	}

}
