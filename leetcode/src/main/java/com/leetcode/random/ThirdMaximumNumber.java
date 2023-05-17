package com.leetcode.random;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

Example 1:
Input: nums = [3,3,2,1]Output: 1Explanation:The first distinct maximum is 3.The second distinct maximum is 2.The third distinct maximum is 1.
Example 2:
Input: nums = [1,2]Output: 2Explanation:The first distinct maximum is 2.The second distinct maximum is 1.The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: nums = [2,2,3,1]Output: 1Explanation:The first distinct maximum is 3.The second distinct maximum is 2 (both 2's are counted together since they have the same value).The third distinct maximum is 1.
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        System.out.println(ThirdMaximumNumber.thirdMax(new int[]{3, 3, 2, 1}));
        System.out.println(ThirdMaximumNumber.thirdMax(new int[]{3, 2, 1}));
        System.out.println(ThirdMaximumNumber.thirdMax(new int[]{1, 2}));
        System.out.println(ThirdMaximumNumber.thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(ThirdMaximumNumber.thirdMax(new int[]{1, 2, Integer.MIN_VALUE}));
        System.out.println(ThirdMaximumNumber.thirdMax(new int[]{-2147483648, -2147483648, -2147483648, -2147483648, 1, 1, 1}));
        System.out.println(ThirdMaximumNumber.thirdMax(new int[]{1,2,2,5,3,5}));

        System.out.println("Third Max using set");
        System.out.println(ThirdMaximumNumber.thirdMaxUsingSet(new int[]{3, 3, 2, 1}));
        System.out.println(ThirdMaximumNumber.thirdMaxUsingSet(new int[]{3, 2, 1}));
        System.out.println(ThirdMaximumNumber.thirdMaxUsingSet(new int[]{1, 2}));
        System.out.println(ThirdMaximumNumber.thirdMaxUsingSet(new int[]{2, 2, 3, 1}));
        System.out.println(ThirdMaximumNumber.thirdMaxUsingSet(new int[]{1, 2, Integer.MIN_VALUE}));
        System.out.println(ThirdMaximumNumber.thirdMaxUsingSet(new int[]{-2147483648, -2147483648, -2147483648, -2147483648, 1, 1, 1}));
        System.out.println(ThirdMaximumNumber.thirdMaxUsingSet(new int[]{1,2,2,5,3,5}));
    }

    public static int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Integer first = null, second = null, third = null;

        for (Integer num : nums) {
            if (num.equals(first) || num.equals(second) || num.equals(third)) {
                continue;
            }
            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }
        return third == null ? first : third;
    }

    public static int thirdMaxUsingSet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() < 3) {
            return set.stream()
                    .max(Integer::compare).get();
        } else {
            return set.stream()
                    .sorted(Collections.reverseOrder())
                    .limit(3)
                    .skip(2)
                    .reduce(0, Integer::sum);
        }
    }
}
