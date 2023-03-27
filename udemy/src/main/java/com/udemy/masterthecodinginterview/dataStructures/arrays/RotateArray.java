package com.udemy.masterthecodinginterview.dataStructures.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        //output = {5,6,7,1,2,3,4}
        int k = 3;
        RotateArray ra = new RotateArray();
        ra.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int last;
        for (int i = 0; i < k; i++) {
            last = nums[nums.length-1];

        }
    }
}
