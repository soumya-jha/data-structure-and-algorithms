package com.educative.grokking.cyclicsort;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println("{1,1} " + firstMissingPositiveInteger(new int[] {1,1}));
        System.out.println("{1,2,3} " + firstMissingPositiveInteger(new int[] {1,2,3}));
        System.out.println("{-1,-2,-3,-4} " + firstMissingPositiveInteger(new int[] {-1,-2,-3,-4}));
        System.out.println("{1,2,3,5} " + firstMissingPositiveInteger(new int[] {1,2,3,5}));
        System.out.println("{55,22,52,100,1,3,-5} " + firstMissingPositiveInteger(new int[] {55,22,52,100,1,3,-5}));
        System.out.println("{0,-1,-2,-3,5} " + firstMissingPositiveInteger(new int[] {0,-1,-2,-3,5}));
    }

    public static int firstMissingPositiveInteger(int[] nums) {
        int idx = 0;
        while(idx<nums.length){
            if(nums[idx]!=idx+1 && nums[idx]>0 && nums[idx]<nums.length && nums[idx]!=nums[nums[idx]-1]) {
                //swap to correct position
                int temp = nums[nums[idx]-1];
                nums[nums[idx]-1] = nums[idx];
                nums[idx] = temp;
            }else{
                idx++;
            }
        }
        for(int i=0; i< nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
