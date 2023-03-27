package com.leetcode;

import java.util.Arrays;

public class MedianOfSortedArrays {

	public static void main(String[] args) {

		int[] nums1 = {};
		int[] nums2 = {1};
		double median = new MedianOfSortedArrays().findMedianSortedArrays(nums1, nums2);
		System.out.println("Median is : " + median);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0;
		int m = nums1.length;
		int n = nums2.length;
		int[] mergeArray = new int[m + n];
		System.arraycopy(nums1, 0, mergeArray, 0, m);
		System.arraycopy(nums2, 0, mergeArray, m, n);
		Arrays.sort(mergeArray);
		int mid = (m + n) / 2;
		if ((m + n) % 2 == 0) {
			median = (Double.valueOf(mergeArray[mid-1]) + mergeArray[mid]) / 2;
		} else {
			median = mergeArray[mid];
		}
		return median;
	}
}
