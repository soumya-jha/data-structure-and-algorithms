package org.geeksforgeeks;

import java.util.Arrays;

/*Given and int array arr[], with length l, find three numbers in array which sums up to X*/
public class TripletSum {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 4, 3, 6};
		find3Numbers(arr, 5, 10);
		int[] arr1 = {1, 4, 45, 6, 10, 8};
		find3Numbers(arr1, 6, 13);
	}

	public static void find3Numbers(int[] arr, int l, int X) {
		Arrays.sort(arr); //{1, 2, 3, 4, 6}
		for (int i = 0; i < l - 2; i++) {
			int j = i + 1;
			int k = l - 1;
			while (j < k) {
				int sum = arr[i] + arr[j] + arr[k];
				if (sum == X) {
					System.out.println("{" + arr[i] + "," + arr[j] + "," + arr[k] + "}");
					j++; k--;
				} else if (sum < X) {
					j++;
				} else if (sum > X) {
					k--;
				}
			}
		}

	}

}
