package com.hackerrank;

import java.util.Arrays;
import java.util.List;

public class ReverseIntArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReverseIntArray.reverseArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));

	}
	
	public static List<Integer> reverseArray(List<Integer> a) {
		//1 2 3 4 5 6
		//6 5 4 3 2 1
		int i=0, j=a.size()-1;
		while(i<j) {
			int temp = a.get(i);
			a.set(i, a.get(j));
			a.set(j, temp);
			i++;
			j--;
		}
		return a;

	}
	
}
