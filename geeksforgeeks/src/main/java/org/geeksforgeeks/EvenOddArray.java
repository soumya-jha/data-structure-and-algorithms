package org.geeksforgeeks;

public class EvenOddArray {

	public static void main(String[] args) {
		int[] arr = {3, 6, 12, 8, 5, 1};
		reArrange(6, arr);

	}
	
	public static void reArrange(int n, int[] arr) {
		int evenIdx = 0, oddIdx = 1;
		while(evenIdx<n && oddIdx<=n) {
			if(arr[evenIdx]%2==0) {
				evenIdx+=2;
			}else if(arr[oddIdx]%2==1) {
				oddIdx+=2;
			}else {
				int temp = arr[evenIdx];
				arr[evenIdx] = arr[oddIdx];
				arr[oddIdx] = temp;
				evenIdx+=2;
				oddIdx+=2;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

}
