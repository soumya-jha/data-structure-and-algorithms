package org.geeksforgeeks;

import java.util.HashMap;

//Not working
public class PairsDivisibleByK {

	public static void main(String[] args) {
		int[] arr = {5, 9, 36, 74, 52, 31, 42};
		System.out.println(countKdivPairs(arr, 7, 3));
		int[] arr1 = {2, 2, 1, 7, 5, 3};
		System.out.println(countKdivPairs(arr1, 6, 4));
	}
	//2 0 0 2 1 1 0
	
	//2 2 1 3 1 3
	
	
	private static int countKdivPairs(int[] arr, int n, int K) {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<n;i++) {
			arr[i] = arr[i]%K;
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 0);
			}else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		for(int i=0; i<n;i++) {
			if(map.containsKey(K-arr[i])) {
				count+=map.get(K-arr[i])-1;
			}
		}
		return count;
	}

}
