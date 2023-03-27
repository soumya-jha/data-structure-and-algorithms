package com.udemy.masterthecodinginterview.dataStructures.arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4};
        //Expected Output: 5, nums = [0,1,2,3,4,_,_,_,_,_,_]
        System.out.println(rd.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] < nums[right]) {
              //  left++;
                nums[++left] = nums[right];
            }
            right++;
        }
        return left+1;
    }
}
