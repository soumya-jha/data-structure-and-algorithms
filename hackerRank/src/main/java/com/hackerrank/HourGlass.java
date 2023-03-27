package com.hackerrank;

public class HourGlass {

	public static void main(String[] args) {
		
		int[][] arr = {{-9, -9, -9, 1, 1, 1}, 
					{0, -9, 0, 4, 3, 2}, 
					{-9, -9, -9, 1, 2, 3}, 
					{0, 0, 8, 6, 6, 0}, 
					{0, 0, 0, -2, 0, 0},
					{0, 0, 1, 2, 4, 0}};
		
		int[][] arr1 = {{-1,-1,0,-9,-2,-2},
						{-2,-1,-6,-8,-2,-5}, 
						{-1,-1,-1,-2,-3,-4}, 
						{-1,-9,-2,-4,-4,-5}, 
						{-7,-3,-3,-2,-9,-9}, 
						{-1,-3,-1,-2,-4,-5}};
		
		int[][] arr2 = {{-1,1,-1,0,0,0},
						{0,-1,0,0,0,0},
						{-1,-1,-1,0,0,0},
						{0,-9,2,-4,-4,0},
						{-7, 0, 0, -2, 0, 0},
						{0, 0, -1, -2, -4, 0}};

		int maxhourGlassSum = hourglassSum(arr1);
		System.out.println("Max hour glass sum :: " + maxhourGlassSum);
	}

	static int hourglassSum(int[][] arr) {
		int maxHourGlassSum = 0;
		boolean firstCheck = true;
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
				System.out.println("Sum " + ++count + " : " + sum);
				if (sum < 0 && maxHourGlassSum == 0 && firstCheck)
					maxHourGlassSum = sum;
				else {
					maxHourGlassSum = Math.max(maxHourGlassSum, sum);
					firstCheck = false;
				}
			}
		}
		return maxHourGlassSum;
	}
}
