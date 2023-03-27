package com.educative.grokking.cyclicsort;

import java.util.Arrays;

public class CorruptPair {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findCorruptPair(new int[]{4, 1, 2, 1, 6, 3})));
        //1,1,2,4,6,3 -> 1,2,1,4,6,3 -> 1,2,3,4,1,6
    }

    public static int[] findCorruptPair(int[] nums) {
        int idx = 0;
        while (idx < nums.length) {
            //check if the number is not in correct idx
            if (nums[idx] != idx + 1) {
                int temp = nums[nums[idx] - 1];
                //check if the number to be swapped is not the same as the current idx number
                //if yes, skip swap and increment idx
                if (temp != nums[idx]) {
                    nums[nums[idx] - 1] = nums[idx];
                    nums[idx] = temp;
                }else{
                    idx++;
                }
            }else{
                //do nothing, increment idx
                idx++;
            }
        }
        //Now, the array is sorted, and all numbers except one is in the incorrect index
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                //the missing number is index+1, duplicate number is the number in incorrect index
                return new int[]{i+1,nums[i]};
            }
        }
        return new int[]{-1,-1};
    }
}
