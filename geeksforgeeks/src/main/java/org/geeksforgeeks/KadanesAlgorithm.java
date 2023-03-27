package org.geeksforgeeks;

public class KadanesAlgorithm {

	public static void main(String[] args) {
		int[] arr = {1,2,3,-2,5};
		System.out.println(maxSubarraySum(5, arr));

	}
	
	private static int maxSubarraySum(int n, int[] arr){
		int currBest = arr[0];
		int maxSum = arr[0];
		for(int i=1; i<n; i++) {
			currBest = Math.max(arr[i], currBest+arr[i]);
			maxSum=Math.max(maxSum, currBest);
		}
		return maxSum;
		
	}

}
