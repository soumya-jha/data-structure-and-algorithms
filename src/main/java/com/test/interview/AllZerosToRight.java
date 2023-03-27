package com.test.interview;

import java.util.Arrays;

public class AllZerosToRight {

	public static void main(String[] args) {
		Integer[] a = { 1, 3, 0, 0, 4, 2, 0, 8, 0 };
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			if(a[i]==0 && a[j]!=0) {
				a[i] = a[j];
				a[j] = 0;
				i++;
				j--;
			}else if(a[i]==0 && a[j]==0) {
				j--;
			}else if(a[i]!=0) {
				i++;
			}
		}
		System.out.println(Arrays.asList(a));
	}
}

