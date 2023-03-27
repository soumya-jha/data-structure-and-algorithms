package org.geeksforgeeks;

public class ProductOne {

	public static void main(String[] args) {
		int[] arr = { -2, 4, -1 ,-3};
		System.out.println(makeProductOne(4, arr));
		int[] arr1 = {-1, 1, -1} ;
		System.out.println(makeProductOne(3, arr1));
	}

	public static int makeProductOne(int n, int[] arr) {
		int steps = 0;
		int product = 1;
		int zeroCount = 0;
		for (int i = 0; i < n; i++) {
			if (product*arr[i] != 1 || product*arr[i]!=-1) {
				if (arr[i] < 0) {
					steps+=-1-arr[i];
					product*=-1;
				} else if (arr[i] > 0) {
					steps+=arr[i]-1;
				}else {
					steps+=1;
					zeroCount++;
				}
			}
		}
		if(product==-1 && zeroCount==0) {
			steps+=2;
		}
		return steps;

	}

}
