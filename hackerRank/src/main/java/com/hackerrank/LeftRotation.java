package com.hackerrank;

import java.util.Arrays;

public class LeftRotation {
	
	public static void main(String args[]) {
		int[] a = {1,2,3,4,5};  // {4,5,1,2,3}
		int[] newArray = rotLeft(a, 3);
		System.out.println(Arrays.toString(newArray));
		int[] b = {1,2,3,4,5};
		newArray = rotLeft1(b, 3);
		System.out.println(Arrays.toString(newArray));
	}
	
	 static int[] rotLeft(int[] a, int d) {
		 if(d==a.length)
			 return a;
		 for(int i=1;i<=d;i++) {
			 int temp = a[0];
			 for(int j=0;j<a.length-1;j++) {
				 a[j] = a[j+1];
			 }
			 a[a.length-1] = temp;
		 }
		 return a;
	 }
	 
	 static int[] rotLeft1(int[] a, int d) {
		 if(d==a.length)
			 return a;
		 int[] newArray = new int[a.length];
		 for(int i=0;i<a.length;i++) {
			 int newPosition = i-d;
			 if(newPosition<0)
				 newPosition = a.length+newPosition;
			 newArray[newPosition] = a[i];
		 }
		 return newArray;
	 }

}
