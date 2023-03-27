package com.udemy.masterthecodinginterview.dataStructures.arrays;

import java.util.Arrays;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

 */
public class TwoSum {
    public static void main(String[] args) {
        //int[] nums = {-8, -2, -20, 7, -6, -15, 10, 11, 15, 2};
        int[] nums = {2, 5, 5, 11};
        //int target = -8;
        int target = 10;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.findTwoSum(nums, target);
        System.out.println("Result : " + Arrays.toString(result));
    }

    public int[] findTwoSum(int[] nums, int target) {
        int[] result = new int[2];
        int num1 = 0, num2 =0;
        int[] sortedArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArr);
        int startIdx = 0;
        int endIdx = nums.length - 1;
        while (startIdx < endIdx) {
            if (sortedArr[startIdx] + sortedArr[endIdx] > target) {
                endIdx--;
            } else if (sortedArr[startIdx] + sortedArr[endIdx] < target) {
                startIdx++;
            } else {
                num1 = sortedArr[startIdx];
                num2 = sortedArr[endIdx];
                break;
            }
        }
        int count=0;
        for (int i=0; i<nums.length;i++){
            if(nums[i]==num1 && count==0) {
                result[0] = i;
                count++;
            }else if(nums[i]==num2)
                result[1] = i;
        }
        return result;
    }
}
