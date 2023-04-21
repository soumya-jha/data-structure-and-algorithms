package com.leetcode.top50;

public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int mid;
        if (m == 0 && n == 0) {
            return 0;
        }
        double median = 0;
        int[] mergedArr = new int[m + n];
        mid = (m + n) / 2;
        int p1 = 0, p2 = 0, idx = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                mergedArr[idx++] = nums1[p1++];
            } else {
                mergedArr[idx++] = nums2[p2++];
            }
        }
        if (p1 != m) {
            while (p1 < m) {
                mergedArr[idx++] = nums1[p1++];
            }
        } else if (p2 != n) {
            while (p2 < n) {
                mergedArr[idx++] = nums2[p2++];
            }
        }
        if ((m+n) % 2 == 0) {
            median = (double) (mergedArr[mid - 1] + mergedArr[mid]) / 2;
        } else {
            median = mergedArr[mid];
        }
        return median;
    }

    public static void main(String[] args) {
        MedianOfSortedArrays m = new MedianOfSortedArrays();
        System.out.println(m.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(m.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(m.findMedianSortedArrays(new int[]{}, new int[]{1}));
    }
}
