package com.leetcode.top50;

import java.util.Arrays;

public class ClosestThreeSum {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int currentSum = nums[i] + nums[start] + nums[end];
                if (currentSum == target) {
                    return currentSum;
                }
                int currDistance = Math.abs(target - currentSum);
                if (currDistance < minDistance) {
                    closest = currentSum;
                    minDistance = currDistance;
                }
                if (currentSum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        ClosestThreeSum sum = new ClosestThreeSum();
        System.out.println(sum.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

}
