package com.leetcode.top50;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> tripletSet = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            int targetSum = -nums[i];
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == targetSum) {
                    tripletSet.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if (nums[start] + nums[end] < targetSum) {
                    start++;
                } else if (nums[start] + nums[end] > targetSum) {
                    end--;
                }
            }
        }
        return new ArrayList<>(tripletSet);
    }

    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();
        System.out.println(sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(sum.threeSum(new int[]{0, 1, 1}));
        System.out.println(sum.threeSum(new int[]{0, 0, 0}));
    }
}
