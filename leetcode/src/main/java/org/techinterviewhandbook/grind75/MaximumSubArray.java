package org.techinterviewhandbook.grind75;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = currentSum;
        int idx = 1;
        while (idx < nums.length) {
            if (currentSum <= 0 && nums[idx] > currentSum) {
                currentSum = 0;
            }
            currentSum += nums[idx];
            maxSum = Math.max(currentSum, maxSum);
            idx++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new MaximumSubArray().maxSubArray(new int[]{1}));
        System.out.println(new MaximumSubArray().maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
