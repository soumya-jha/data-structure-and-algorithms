package com.udemy.masterthecodinginterview.dataStructures.arrays;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes mZ = new MoveZeroes();
        mZ.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void moveZeroes(int[] nums) {
        int currZeroIdx = -1;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroCount == 0) {
                    currZeroIdx = i;
                }
                zeroCount++;
                continue;
            } else {
                if (zeroCount > 0) {
                    nums[currZeroIdx] = nums[i];
                    nums[i] = 0;
                    currZeroIdx++;
                }
            }
        }
    }
}
