package com.leetcode;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int maxArea = new ContainerWithMostWater().maxArea(height);
		System.out.println("Max Area is :: " + maxArea);
	}

	public int maxArea(int[] height) {
		int maxArea = 0;
		for (int i = 1; i <= height.length; i++) {
			int length = height.length;
			while (length > i) {
				maxArea = Math.max(maxArea, (Math.min(height[i - 1], height[length - 1])) * (length - i));
				length--;
			}
		}
		return maxArea;
	}
}
